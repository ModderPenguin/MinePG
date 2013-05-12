package rpg.comm;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.server.MinecraftServer;
import rpg.RPG;
import rpg.enums.EnumGui;
import rpg.playerinfo.PlayerInformation;
import rpg.sounds.SoundLoader;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.Player;

public class ConnectionHandler implements IConnectionHandler {

    @Override
    public void clientLoggedIn(NetHandler clientHandler,
            INetworkManager manager, Packet1Login login) {
    }

    @Override
    public void connectionClosed(INetworkManager manager) {
    }

    @Override
    public void connectionOpened(NetHandler netClientHandler,
            MinecraftServer server, INetworkManager manager) {
    }

    @Override
    public void connectionOpened(NetHandler netClientHandler, String server,
            int port, INetworkManager manager) {
    }

    @Override
    public String connectionReceived(NetLoginHandler netHandler,
            INetworkManager manager) {
        return null;
    }

    @Override
    public void playerLoggedIn(Player player, NetHandler netHandler,
            INetworkManager manager) {
        PlayerInformation playerInfo = PlayerInformation
                .forPlayer((EntityPlayerMP) player);
        if (playerInfo.getPlayersClass() == "") {
            ((EntityPlayerMP) player).openGui(RPG.instance,
                    EnumGui.LoreStartingPage.getIndex(),
                    ((EntityPlayerMP) player).worldObj, 0, 0, 0);
        } else {
            ((EntityPlayerMP) player)
                    .sendChatToPlayer("<Mysterious Voice> Welcome back master "
                            + playerInfo.getPlayersClass());
        }

        if (SoundLoader.didSoundsLoad == true) {
            ((EntityPlayerMP) player)
                    .sendChatToPlayer("[MinePG Sound Loader] Loaded Sounds Successfully");
        } else if (SoundLoader.didSoundsLoad == false) {
            ((EntityPlayerMP) player)
                    .sendChatToPlayer("[MinePG Sound Loader] Failed to load one or more sounds");
        }
    }
}
