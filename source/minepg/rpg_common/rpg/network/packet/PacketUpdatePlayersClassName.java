package rpg.network.packet;

import rpg.playerinfo.PlayerInformation;
import net.minecraft.entity.player.EntityPlayer;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

import cpw.mods.fml.relauncher.Side;


public class PacketUpdatePlayersClassName extends MinePGPacket {
    
    public static String playersClassName;
    String playersClass;
    
    public PacketUpdatePlayersClassName() {}
    
    @Override
    protected void writeData(ByteArrayDataOutput out) {
        out.writeUTF(playersClass);
        out.writeUTF(playersClassName);
    }
    
    @Override
    protected void readData(ByteArrayDataInput in) {
        playersClass = in.readUTF();
        playersClassName = in.readUTF();
    }
    
    @Override
    protected void execute(EntityPlayer player, Side side) {
        if(side.isClient()) {
            PlayerInformation playerInfo = PlayerInformation.forPlayer(player);
            playersClass = playerInfo.getPlayersClass();
            playersClassName = playersClass;
        }
    }
}
