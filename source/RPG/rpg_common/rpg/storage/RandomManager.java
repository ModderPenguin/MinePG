package rpg.storage;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.world.WorldEvent;

public class RandomManager {
	private ArrayList<PlayerStorage> playerPokemonList = new ArrayList<PlayerStorage>();

	public enum PokeballManagerMode {
		Player
	}

	public RandomManager() {
	}

	public PlayerStorage getPlayerStorage(EntityPlayerMP owner) {
		for (PlayerStorage p : playerPokemonList) {
			if (p.player != null && owner != null && p.player.username.equals(owner.username))
				return p;
		}
			return null;
	}

	public EntityPlayerMP getPlayerFromName(String name) {
		for (PlayerStorage p : playerPokemonList)
			if (p.player.username.equals(name))
				return p.player;
		return null;
	}

	public void save() {
		try {
			for (int i = 0; i < playerPokemonList.size(); i++) {
				String userName = playerPokemonList.get(i).userName;
				File playerSaveFile = new File(playerPokemonList.get(i).saveFile);
				FileOutputStream f = new FileOutputStream(playerSaveFile);
				DataOutputStream s = new DataOutputStream(f);
				NBTTagCompound nbt = new NBTTagCompound();
				CompressedStreamTools.write(nbt, s);
				s.close();
				f.close();
				if (playerPokemonList.get(i).player == null || playerPokemonList.get(i).player.playerNetServerHandler.connectionClosed) {
					playerPokemonList.remove(i);
					System.out.println("Saved dc'd player's data - " + userName);
					i--;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ForgeSubscribe
	public void onWorldLoad(WorldEvent.Load event) {
		ArrayList<EntityPlayerMP> playerList = new ArrayList<EntityPlayerMP>();
		for (int i = 0; i < playerPokemonList.size(); i++) {
			playerList.add(playerPokemonList.get(i).player);
		}
		playerPokemonList.clear();
	}

	@ForgeSubscribe
	public void onWorldSave(WorldEvent.Save event) {
		save();
	}

	public void unloadDCPlayers() {
		save();
	}
}
