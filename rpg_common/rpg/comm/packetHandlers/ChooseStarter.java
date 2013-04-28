package rpg.comm.packetHandlers;

import java.io.DataInputStream;
import java.io.IOException;

import rpg.comm.EnumPackets;
import cpw.mods.fml.common.network.Player;

public class ChooseStarter extends PacketHandlerBase {

	public ChooseStarter() {
		packetsHandled.add(EnumPackets.ChooseStarter);
	}

	@Override
	public void handlePacket(int index, Player play, DataInputStream dataStream) throws IOException {
	}
}
