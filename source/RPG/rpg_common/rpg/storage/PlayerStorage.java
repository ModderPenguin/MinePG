package rpg.storage;

import java.util.Iterator;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class PlayerStorage {
	public NBTTagCompound[] partyPokemon = new NBTTagCompound[6];
	private static final int carryLimit = 6;
	public EntityPlayerMP player;
	public String userName;
	public String saveFile;
	public boolean guiOpened = false;

	public PlayerStorage(EntityPlayerMP player) {
		this.player = player;
		this.userName = player.username;
	}

	public boolean hasSpace() {
		for (int i = 0; i < partyPokemon.length; i++) {
			NBTTagCompound nbt = partyPokemon[i];
			if (nbt == null) {
				return true;
			}
		}
		return false;
	}

	public int getNextOpen() {
		for (int i = 0; i < partyPokemon.length; i++) {
			if (partyPokemon[i] == null) {
				return i;
			}
		}
		return 0;
	}

	public void setPokemon(NBTTagCompound[] pokemon) {
		partyPokemon = pokemon;
	}

	public boolean contains(int id) {
		for (int i = 0; i < partyPokemon.length; i++) {
			NBTTagCompound nbt = partyPokemon[i];
			if (nbt != null) {
				if (nbt.getInteger("pixelmonID") == id)
					return true;
			}
		}
		return false;
	}

	public NBTTagCompound getNBT(int id) {
		for (int i = 0; i < partyPokemon.length; i++) {
			NBTTagCompound nbt = partyPokemon[i];
			if (nbt != null) {
				if (nbt.getInteger("pixelmonID") == id)
					return nbt;
			}
		}
		return null;
	}

	public NBTTagCompound[] getList() {
		return partyPokemon;
	}

	public void changePokemon(int pos, NBTTagCompound n) {
		if (n != null) {
			n.setInteger("PixelmonOrder", pos);
		}
		partyPokemon[pos] = n;
	}

	public void addToFirstEmptySpace(NBTTagCompound n) {
		for (int i = 0; i < partyPokemon.length; i++) {
			if (partyPokemon[i] == null) {
				if (n != null) {
					n.setInteger("PixelmonOrder", i);
				}
				partyPokemon[i] = n;
				return;
			}
		}
	}

	public int count() {
		int count = 0;
		for (int i = 0; i < partyPokemon.length; i++)
			if (partyPokemon[i] != null)
				count++;
		return count;
	}

	public int countAblePokemon() {
		int c = 0;
		for (int i = 0; i < partyPokemon.length; i++) {
			NBTTagCompound nbt = partyPokemon[i];
			if (nbt != null) {
				if (!nbt.getBoolean("IsFainted") && nbt.getShort("Health") > 0)
					c++;
			}
		}
		return c;
	}

	public boolean hasSentOut(int pixelmonID) {
		for (int i = 0; i < partyPokemon.length; i++) {
			NBTTagCompound nbt = partyPokemon[i];
			if (nbt != null) {
				if (nbt.getInteger("pixelmonID") == pixelmonID)
					if (!nbt.getBoolean("IsInBall"))
						return true;
			}
		}
		return false;
	}

	public boolean isFainted(int pokemonId) {
		for (int i = 0; i < partyPokemon.length; i++) {
			NBTTagCompound nbt = partyPokemon[i];
			if (nbt != null) {
				if (nbt.getInteger("pixelmonID") == pokemonId) {
					if (nbt.getBoolean("IsFainted"))
						return true;
					if (nbt.getShort("Health") <= 0)
						return true;
				}
			}
		}
		return false;
	}

	public void sendUpdatedList() {
		for (int i = 0; i < partyPokemon.length; i++) {
			NBTTagCompound nbt = partyPokemon[i];
			if (nbt != null) {
				
			}
		}
	}

	public int getIDFromPosition(int pos) {
		for (int i = 0; i < partyPokemon.length; i++) {
			NBTTagCompound n = partyPokemon[i];
			if (n != null) {
				if (n.getInteger("PixelmonOrder") == pos)
					return n.getInteger("pixelmonID");
			}
		}
		return -1;
	}

	@SuppressWarnings("rawtypes")
	public void readFromNBT(NBTTagCompound var1) {
		Iterator iterator = var1.getTags().iterator();
		do {
			if (!iterator.hasNext())
				break;

			NBTBase nbtbase = (NBTBase) iterator.next();

			if (nbtbase instanceof NBTTagCompound) {
				NBTTagCompound pokemonData = (NBTTagCompound) nbtbase;
				pokemonData.setName(pokemonData.getString("Name"));
				partyPokemon[pokemonData.getInteger("PixelmonOrder")] = pokemonData;
				
			}
		} while (true);
	}

	public int getFirstAblePokemonID(World worldObj) {
		for (int i = 0; i < carryLimit; i++) {
			int id = getIDFromPosition(i);
			if (id != -1 && !isFainted(id))
				return id;
		}
		return -1;
	}

	public void healAllPokemon() {
		for (int i = 0; i < partyPokemon.length; i++) {
			NBTTagCompound nbt = partyPokemon[i];
			if (nbt != null) {
				heal(nbt);
			}
		}
	}

	public void heal(int index) {
		for (int i = 0; i < partyPokemon.length; i++) {
			NBTTagCompound nbt = partyPokemon[i];
			if (nbt != null) {
				if (nbt.getInteger("pixelmonID") == index)
					heal(nbt);
			}
		}
	}

	private void heal(NBTTagCompound nbt) {
		nbt.setShort("Health", (short) nbt.getInteger("StatsHP"));
		nbt.setBoolean("IsFainted", false);
		int numMoves = nbt.getInteger("PixelmonNumberMoves");
		for (int i = 0; i < numMoves; i++) {
			nbt.setInteger("PixelmonMovePP" + i, nbt.getInteger("PixelmonMovePPBase" + i));
		}
		int numStatus = nbt.getShort("EffectCount");
		for (int i = 0; i < numStatus; i++) {
			nbt.removeTag("Effect" + i);
		}
		nbt.setShort("EffectCount", (short) 0);
	}

	public void recallAllPokemon() {
		for (int i = 0; i < partyPokemon.length; i++) {
			if (partyPokemon[i] != null) {
				
			}
		}
	}

}
