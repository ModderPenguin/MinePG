package rpg.comm.packetHandlers;

import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayerMP;
import rpg.RPG;
import rpg.comm.EnumPackets;
import rpg.enums.EnumGui;
import rpg.storage.RPGStorage;
import cpw.mods.fml.common.network.Player;

public class RegisterPlayer extends PacketHandlerBase {

	public RegisterPlayer() {
		packetsHandled.add(EnumPackets.RegisterPlayer);
	}

	@Override
	public void handlePacket(int index, Player pl, DataInputStream dataStream) throws IOException {
		EntityPlayerMP player = (EntityPlayerMP)pl;
		if (RPGStorage.RandomManager.getPlayerStorage(player).count() == 0) {
			player.openGui(RPG.instance, EnumGui.ChooseStarter.getIndex(), player.worldObj, 0, 0, 0);
		}
	}

}
