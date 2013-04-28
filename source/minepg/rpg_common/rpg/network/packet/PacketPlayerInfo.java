package rpg.network.packet;

import net.minecraft.entity.player.EntityPlayer;
import rpg.playerinfo.PlayerInformation;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

import cpw.mods.fml.relauncher.Side;

public class PacketPlayerInfo extends MinePGPacket {
    
    private String playersClass;
    private boolean hasClassChosen;
    

    public PacketPlayerInfo() {}

    public PacketPlayerInfo(PlayerInformation playerInformation) {
        playersClass = playerInformation.getPlayersClass();
    }

    @Override
    protected void writeData(ByteArrayDataOutput out) {
        out.writeChars(playersClass);
        out.writeBoolean(hasClassChosen);
    }

    @Override
    protected void readData(ByteArrayDataInput in) {
        playersClass = in.readLine();
        hasClassChosen = in.readBoolean();
    }

    @Override
    protected void execute(EntityPlayer player, Side side) {
        if (side.isClient()) {
            PlayerInformation info = PlayerInformation.forPlayer(player);
            info.setPlayersClass(playersClass);
            info.setHasClassChosen(hasClassChosen);
        }
    }
}