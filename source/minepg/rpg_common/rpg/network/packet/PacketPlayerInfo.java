package rpg.network.packet;

import net.minecraft.entity.player.EntityPlayer;
import rpg.playerinfo.PlayerInformation;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

import cpw.mods.fml.relauncher.Side;

public class PacketPlayerInfo extends MinePGPacket {

    private String playersClass;
    private float karma;
    private int danris;

    public PacketPlayerInfo() {
    }

    @Override
    protected void writeData(ByteArrayDataOutput out) {
        out.writeUTF(playersClass);
        out.writeFloat(karma);
        out.writeInt(danris);
    }

    @Override
    protected void readData(ByteArrayDataInput in) {
        playersClass = in.readUTF();
        karma = in.readFloat();
        danris = in.readInt();
    }

    public PacketPlayerInfo(PlayerInformation playerInformation) {
        playersClass = playerInformation.getPlayersClass();
        karma = playerInformation.getKarma();
        danris = playerInformation.getCurrency();
    }

    @Override
    protected void execute(EntityPlayer player, Side side) {
        if (side.isClient()) {
            PlayerInformation info = PlayerInformation.forPlayer(player);
            info.setPlayersClass(playersClass);
            info.setKarma(karma);
            info.setCurrency(danris);
        }
    }
}