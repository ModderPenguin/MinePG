package rpg.network.packet;

import net.minecraft.entity.player.EntityPlayer;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

import cpw.mods.fml.relauncher.Side;

public class PacketDeleteItem extends MinePGPacket {

    int itemID;

    public PacketDeleteItem() {
    }

    public PacketDeleteItem(int itemID) {
        this.itemID = itemID;
    }

    @Override
    protected void execute(EntityPlayer player, Side side) {
        if (side.isServer()) {
            player.inventory.consumeInventoryItem(this.itemID);
        }
    }

    @Override
    protected void writeData(ByteArrayDataOutput out) {
        out.writeInt(this.itemID);
    }

    @Override
    protected void readData(ByteArrayDataInput in) {
        this.itemID = in.readInt();
    }
}
