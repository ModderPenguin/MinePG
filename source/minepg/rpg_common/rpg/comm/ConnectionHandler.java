package rpg.comm;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.Player;

public class ConnectionHandler implements IConnectionHandler {
	
	@Override
	public void playerLoggedIn(Player player, NetHandler netHandler, INetworkManager manager) {
	    /*
	    PlayerInformation info = PlayerInformation.forPlayer((EntityPlayerMP)player);
	    if(info.hasPlayerChosenClass() == false) {
			((EntityPlayerMP) player).openGui(RPG.instance, EnumGui.ChooseStarter.getIndex(), ((EntityPlayerMP) player).worldObj, 0, 0, 0);
		} else {
			System.out.println("[PLAYER CLASS] Class: " + PlayerClassHandler.getPlayersClass());
		}
		*/
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
