package rpg.playerinfo;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import rpg.network.packet.PacketPlayerInfo;

public final class PlayerInformation implements IExtendedEntityProperties {

    public static final String IDENTIFIER = "minepg_playerinfo";
    
    private String playersClass;
    private boolean hasClassBeenChosen = false;

    public static PlayerInformation forPlayer(Entity player) {
        return (PlayerInformation)player.getExtendedProperties(IDENTIFIER);
    }

    @SuppressWarnings("unused")
    private boolean dirty = true;

    private final EntityPlayer player;

    public PlayerInformation(EntityPlayer player) {
        this.player = player;
    }

    @Override
    public void init(Entity entity, World world) {
        // nothing for now
    }

    @Override
    public void saveNBTData(NBTTagCompound nbtPlayer) { 
        NBTTagCompound nbt = new NBTTagCompound();
        
        nbt.setString("playersClass", playersClass);
        nbt.setBoolean("hasClassBeenChosen", hasClassBeenChosen);
        
        nbtPlayer.setCompoundTag(IDENTIFIER, nbt);
    }
    
    @Override
    public void loadNBTData(NBTTagCompound playerNbt) {
        NBTTagCompound nbt = playerNbt.getCompoundTag(IDENTIFIER);
        
        playersClass = nbt.getString("playersClass");
        hasClassBeenChosen = nbt.getBoolean("hasClassBeenChosen");
    }
    
    public boolean hasPlayerChosenClass() {
        if(getPlayersClass() == null) {
            hasClassBeenChosen = false;
            return hasClassBeenChosen;
        } else {
            hasClassBeenChosen = true;
            return hasClassBeenChosen;
        }
    }
    
    public boolean setHasClassChosen(boolean hasClassBeenChosen) {
        if(this.hasClassBeenChosen != hasClassBeenChosen) {
            this.hasClassBeenChosen = hasClassBeenChosen;
            setDirty();
        }
        return this.hasClassBeenChosen;
    }
    
    public boolean getHasClassBeenChosen() {
        return hasClassBeenChosen;
    }
    
    public String getPlayersClass() {
        return playersClass;
    }
    
    public String setPlayersClass(String playersClass) {
        if(this.playersClass != playersClass) {
            this.playersClass = playersClass;
            setDirty();
        }
        return this.playersClass;
    }

    @SuppressWarnings("unused")
    private void updateClient() {
        new PacketPlayerInfo(this).sendToPlayer(player);
    }

    /**
     * marks that this needs to be resend to the client
     */
    public void setDirty() {
        dirty = true;
    }
}