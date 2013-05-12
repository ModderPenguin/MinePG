package rpg.network.packet;

import net.minecraft.entity.player.EntityPlayer;
import rpg.playerinfo.PlayerInformation;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

import cpw.mods.fml.relauncher.Side;

public class PacketPlayerInfo extends MinePGPacket {

    private String playersClass;
    private float karma;

    public PacketPlayerInfo() {
    }

    public PacketPlayerInfo(PlayerInformation playerInformation) {
        playersClass = playerInformation.getPlayersClass();
        karma = playerInformation.getKarma();
    }

    @Override
    protected void execute(EntityPlayer player, Side side) {
        if (side.isClient()) {
            PlayerInformation info = PlayerInformation.forPlayer(player);
            info.setPlayersClass(playersClass);
            info.setKarma(karma);
        }
    }

    @Override
    protected void readData(ByteArrayDataInput in) {
        playersClass = in.readUTF();
        karma = in.readFloat();
    }

    @Override
    protected void writeData(ByteArrayDataOutput out) {
        out.writeUTF(playersClass);
        out.writeFloat(karma);
    }
}