package rpg.comm;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.server.MinecraftServer;
import rpg.RPG;
import rpg.enums.EnumGui;
import rpg.network.packet.PacketPlayerInfo;
import rpg.playerinfo.PlayerInformation;
import rpg.sounds.SoundLoader;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.Player;

public class ConnectionHandler implements IConnectionHandler {

    @Override
    public void clientLoggedIn(NetHandler clientHandler, INetworkManager manager, Packet1Login login) {
    }

    @Override
    public void connectionClosed(INetworkManager manager) {
    }

    @Override
    public void connectionOpened(NetHandler netClientHandler, MinecraftServer server, INetworkManager manager) {
    }

    @Override
    public void connectionOpened(NetHandler netClientHandler, String server, int port, INetworkManager manager) {
    }

    @Override
    public String connectionReceived(NetLoginHandler netHandler, INetworkManager manager) {
        return null;
    }

    @Override
    public void playerLoggedIn(Player player, NetHandler netHandler, INetworkManager manager) {
        PlayerInformation playerInfo = PlayerInformation.forPlayer((EntityPlayerMP) player);
        if (playerInfo.getPlayersClass().equals("")) {
            ((EntityPlayerMP) player).openGui(RPG.instance, EnumGui.LoreStartingPage.getIndex(), ((EntityPlayerMP) player).worldObj, 0, 0, 0);
            playerInfo.setMana(100);
        } else {
            if (playerInfo.getShouldUseMysteriousVoice()) {
                ((EntityPlayerMP) player).sendChatToPlayer("<Mysterious Voice> Welcome back master " + playerInfo.getPlayersClass());

            } else {
                ((EntityPlayerMP) player).sendChatToPlayer("<Dagon> Welcome back master " + playerInfo.getPlayersClass());
            }
            if (playerInfo.getMana() == 0) {
                ((EntityPlayerMP) player).sendChatToPlayer("Your Mana is: \u00a74" + playerInfo.getMana());
            } else {
                ((EntityPlayerMP) player).sendChatToPlayer("Your Mana is: \u00a71" + playerInfo.getMana());
            }
            new PacketPlayerInfo(playerInfo).sendToPlayer((EntityPlayerMP) player);
        }

        if (SoundLoader.didSoundsLoad == true) {
            System.out.println("[MinePG Sound Loader] Loaded Sounds Successfully");
        } else if (SoundLoader.didSoundsLoad == false) {
            System.out.println("[MinePG Sound Loader] Failed to load one or more sounds");
        }
    }
}
