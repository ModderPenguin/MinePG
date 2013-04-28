package rpg.comm;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.server.MinecraftServer;
import rpg.comm.packetHandlers.ChooseStarter;
import rpg.comm.packetHandlers.PacketHandlerBase;
import rpg.comm.packetHandlers.RegisterPlayer;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IConnectionHandler, IPacketHandler {
	private static ArrayList<PacketHandlerBase> handlers = new ArrayList<PacketHandlerBase>();
	static {
		handlers.add(new ChooseStarter());
		handlers.add(new RegisterPlayer());

	}

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		DataInputStream dataStream = new DataInputStream(new ByteArrayInputStream(packet.data));
		try {
			int packetID = dataStream.readInt();
			for (PacketHandlerBase p : handlers) {
				if (p.handlesPacket(packetID)) {
					p.handlePacket(packetID, player, dataStream);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void playerLoggedIn(Player player, NetHandler netHandler, INetworkManager manager) {
	}

	@Override
	public String connectionReceived(NetLoginHandler netHandler, INetworkManager manager) {
		return null;
	}

	@Override
	public void connectionOpened(NetHandler netClientHandler, String server, int port, INetworkManager manager) {
	}

	@Override
	public void connectionOpened(NetHandler netClientHandler, MinecraftServer server, INetworkManager manager) {
	}

	@Override
	public void connectionClosed(INetworkManager manager) {
	}

	@Override
	public void clientLoggedIn(NetHandler clientHandler, INetworkManager manager, Packet1Login login) {
	}

}
