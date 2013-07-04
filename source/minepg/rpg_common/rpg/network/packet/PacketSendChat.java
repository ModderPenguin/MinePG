package rpg.network.packet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

import cpw.mods.fml.relauncher.Side;

public class PacketSendChat extends MinePGPacket {

    String message;

    public PacketSendChat() {
    }

    public PacketSendChat(String message) {
        this.message = message;
    }

    @Override
    protected void execute(EntityPlayer player, Side side) {
        if (side.isServer()) {
            EntityPlayerMP playerMP = (EntityPlayerMP) player;
            playerMP.sendChatToPlayer(this.message);
        }
    }

    @Override
    protected void writeData(ByteArrayDataOutput out) {
        out.writeUTF(this.message);
    }

    @Override
    protected void readData(ByteArrayDataInput in) {
        this.message = in.readUTF();
    }
}
