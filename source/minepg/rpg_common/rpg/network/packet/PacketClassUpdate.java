package rpg.network.packet;

import net.minecraft.entity.player.EntityPlayer;
import rpg.playerinfo.PlayerInfoFake;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

import cpw.mods.fml.relauncher.Side;

public class PacketClassUpdate extends MinePGPacket {

	private String newClass;

	public PacketClassUpdate() { }

	public PacketClassUpdate(String newClass) {
		this.newClass = newClass;
	}

	@Override
	protected void writeData(ByteArrayDataOutput out) {
		out.writeUTF(newClass);
	}

	@Override
	protected void readData(ByteArrayDataInput in) {
		newClass = in.readUTF();
	}

	@Override
	protected void execute(EntityPlayer player, Side side) {
		PlayerInfoFake.setPlayersClass(newClass);
	}

}
