package rpg.network.packet;

import static rpg.RPG.logger;

import java.util.List;
import java.util.Set;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.WorldServer;
import rpg.RPG;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;

public abstract class MinePGPacket {

    private static BiMap<Integer, Class<? extends MinePGPacket>> idMapping = HashBiMap.create();

    static {
        addMapping(0, PacketPlayerInfo.class);
        addMapping(1, PacketClassChosen.class);
        addMapping(2, PacketDeleteItem.class);
        addMapping(3, PacketSendChat.class);
        addMapping(4, PacketSpawnPet.class);

        idMapping = ImmutableBiMap.copyOf(idMapping);
    }

    private static void addMapping(int id, Class<? extends MinePGPacket> clazz) {
        idMapping.put(Integer.valueOf(id), clazz);
    }

    protected static final <E extends Enum<E>> E readEnum(Class<? extends E> clazz, ByteArrayDataInput in) {
        E[] enums = clazz.getEnumConstants();
        int id = in.readUnsignedByte();
        if (id >= enums.length)
            return enums[0];
        else
            return enums[id];
    }

    protected static final void writeEnum(Enum<?> e, ByteArrayDataOutput out) {
        out.writeByte(e.ordinal());
    }

    protected abstract void execute(EntityPlayer player, Side side);

    public final Packet generatePacket() {
        ByteArrayDataOutput output = ByteStreams.newDataOutput();
        if (!idMapping.containsValue(this.getClass())) {
            logger.warning("Packet " + this.getClass() + " is missing a Mapping!");
            return null;
        }

        int packetId = idMapping.inverse().get(this.getClass()).intValue();

        this.writeData(output);
        return PacketDispatcher.getTinyPacket(RPG.instance, (short) packetId, output.toByteArray());
    }

    public final void sendToAll() {
        MinecraftServer.getServer().getConfigurationManager().sendPacketToAllPlayers(this.generatePacket());
    }

    public final void sendToAllNear(double x, double y, double z, int dimension, double radius) {
        MinecraftServer.getServer().getConfigurationManager().sendToAllNear(x, y, z, radius, dimension, this.generatePacket());
    }

    public final void sendToAllNear(Entity entity, double radius) {
        this.sendToAllNear(entity.posX, entity.posY, entity.posZ, entity.dimension, radius);
    }

    public final void sendToAllNear(TileEntity tileEntity, double radius) {
        this.sendToAllNear(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord, tileEntity.worldObj.provider.dimensionId, radius);
    }

    public final void sendToAllTracking(Entity entity) {
        if (entity.worldObj instanceof WorldServer) {
            ((WorldServer) entity.worldObj).getEntityTracker().sendPacketToAllPlayersTrackingEntity(entity, this.generatePacket());
        }
    }

    @SuppressWarnings("unchecked")
    public final void sendToOps() {
        MinecraftServer server = MinecraftServer.getServer();
        if (server == null)
            return;
        ServerConfigurationManager manager = server.getConfigurationManager();
        if (manager == null)
            return;
        Packet packet = this.generatePacket();
        Set<String> ops = manager.getOps();
        for (EntityPlayer player : (List<EntityPlayer>) manager.playerEntityList) {
            if (ops.contains(player.username.toLowerCase())) {
                PacketDispatcher.sendPacketToPlayer(packet, (Player) player);
            }
        }
    }

    public final void sendToPlayer(EntityPlayer player) {
        PacketDispatcher.sendPacketToPlayer(this.generatePacket(), (Player) player);
    }

    public final void sendToServer() {
        PacketDispatcher.sendPacketToServer(this.generatePacket());
    }

    protected abstract void writeData(ByteArrayDataOutput out);

    protected abstract void readData(ByteArrayDataInput in);

    public static void execute(ByteArrayDataInput input, int packetId, EntityPlayer player) {
        Class<? extends MinePGPacket> packetClass = idMapping.get(Integer.valueOf(packetId));
        if (packetClass == null) {
            logger.warning("Recieved unknown Packet-Id " + packetId);
        } else {
            try {
                MinePGPacket parsedPacket = packetClass.newInstance();
                parsedPacket.readData(input);
                parsedPacket.execute(player, player.worldObj.isRemote ? Side.CLIENT : Side.SERVER);
            } catch (Exception e) {
                logger.warning("Exception during packet handling: " + e.getClass().getSimpleName() + " (" + e.getMessage() + ")");
                e.printStackTrace();
            }
        }
    }
}