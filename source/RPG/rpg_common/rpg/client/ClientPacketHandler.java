package rpg.client;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class ClientPacketHandler implements IPacketHandler {

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		DataInputStream dataStream = new DataInputStream(new ByteArrayInputStream(packet.data));

		try {
		    @SuppressWarnings("unused")
			int packetID = dataStream.readInt();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
