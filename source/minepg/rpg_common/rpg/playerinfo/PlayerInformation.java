package rpg.playerinfo;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public final class PlayerInformation implements IExtendedEntityProperties {

	public static final String IDENTIFIER = "minpg_playerinfo";

	public static PlayerInformation forPlayer(Entity player) {
		return (PlayerInformation)player.getExtendedProperties(IDENTIFIER);
	}

	// called by the ASM hook in EntityPlayer.clonePlayer
	public static void handlePlayerClone(EntityPlayer source, EntityPlayer target) {
		target.registerExtendedProperties(IDENTIFIER, source.getExtendedProperties(IDENTIFIER));
	}

	public static final int MAX_KARMA_VALUE = 99999999;

	public boolean dirty = true;
	public boolean hasClassBeenChosen = false;
	public float karma = 0;
	public byte[] eventAmounts = new byte[PlayerInformation.CountableKarmaEvent.values().length];
	public String playersClass = "";
	public int danris = 0;
	
	private final EntityPlayer player;

	public PlayerInformation(EntityPlayer player) {
		this.player = player;
	}

	@Override
	public void init(Entity entity, World world) {
		// nothing for now
	}

	@Override
	public void saveNBTData(NBTTagCompound nbtPlayer) {
		NBTTagCompound nbt = new NBTTagCompound();
		
		nbt.setString("playersClass", playersClass);
		nbt.setBoolean("hasClassBeenChosen", hasClassBeenChosen);
		nbt.setInteger("danris", danris);
		nbt.setFloat("karma", karma);

		NBTTagList eventList = new NBTTagList();
		for (int i = 0; i < eventAmounts.length; i++) {
			NBTTagCompound evtInfo = new NBTTagCompound();
			evtInfo.setByte("id", (byte)i);
			evtInfo.setByte("value", eventAmounts[i]);
			eventList.appendTag(evtInfo);
		}
		nbt.setTag("events", eventList);
		
		nbtPlayer.setCompoundTag(IDENTIFIER, nbt);
	}

	@Override
	public void loadNBTData(NBTTagCompound playerNbt) {
		NBTTagCompound nbt = playerNbt.getCompoundTag(IDENTIFIER);
		
		playersClass = nbt.getString("playersClass");
		hasClassBeenChosen = nbt.getBoolean("hasClassBeenChosen");
		danris = nbt.getInteger("danris");
		karma = nbt.getFloat("karma");

		NBTTagList eventList = nbt.getTagList("events");
		for (int i = 0; i < eventList.tagCount(); i++) {
			NBTTagCompound evtInfo = (NBTTagCompound)eventList.tagAt(i);
			byte eventId = evtInfo.getByte("id");
			if (eventId >= 0 && eventId < eventAmounts.length) {
				eventAmounts[eventId] = evtInfo.getByte("value");
			}
		}
	}
	
	public boolean getHasClassBeenChosen() {
		return hasClassBeenChosen;
	}
	
	public boolean setHasClassBeenChosen(boolean hasClassBeenChosen) {
		if(this.hasClassBeenChosen != hasClassBeenChosen) {
			this.hasClassBeenChosen = hasClassBeenChosen;
			setDirty();
			return hasClassBeenChosen;
		}
		return this.hasClassBeenChosen;
	}
	
	public String getPlayersClass() {
		return playersClass;
	}
	
	public String setPlayersClass(String playersClass) {
		if(this.playersClass != playersClass) {
			this.playersClass = playersClass;
			setDirty();
			return playersClass;
		}
		
		return this.playersClass;
	}
	
	public String modifyPlayersClass(String classChangingTo) {
		return setPlayersClass(classChangingTo);
	}
	
	public float getKarma() {
		return karma;
	}

	public float setKarma(float karma) {
		if (this.karma != karma) {
			this.karma = karma;
			if (this.karma > MAX_KARMA_VALUE) {
				this.karma = MAX_KARMA_VALUE;
			}
			if (this.karma < -MAX_KARMA_VALUE) {
				this.karma = -MAX_KARMA_VALUE;
			}
			setDirty();
		}
		
		return this.karma;
	}

	public float modifyKarma(float modifier) {
		player.worldObj.playSoundAtEntity(player, "minepgkarma.karma" + (modifier < 0 ? "down" : "up"), 1, 1);

		return setKarma(karma + modifier);
	}

	public float modifyKarmaWithMax(float modifier, float max) {
		if (karma < max) {
			modifyKarma(modifier);
		}
		
		return karma;
	}

	public float modifyKarmaWithMin(float modifier, float min) {
		if (karma > min) {
			modifyKarma(modifier);
		}
		
		return karma;
	}

	public byte getEventAmount(CountableKarmaEvent event) {
		return eventAmounts[event.ordinal()];
	}

	public boolean setEventAmount(CountableKarmaEvent event, int amount) {
		if (amount < event.getMaxCount() && eventAmounts[event.ordinal()] != amount) {
			eventAmounts[event.ordinal()] = (byte)amount;
			setDirty();
			return true;
		} else {
			return false;
		}
	}

	public boolean increaseEventAmount(PlayerInformation.CountableKarmaEvent event) {
		return setEventAmount(event, eventAmounts[event.ordinal()] + 1);
	}

	public static enum CountableKarmaEvent {
		PIGMEN_ATTACK(1), CREATE_SNOWGOLEM(2), CREATE_IRONGOLEM(3);

		private final int maxCount;

		private CountableKarmaEvent(int maxCount) {
			this.maxCount = maxCount;
		}

		public int getMaxCount() {
			return maxCount;
		}
	}
	
	public int getCurrency() {
		return danris;
	}

	public int setCurrency(int danris) {
		if(this.danris != danris) {
			this.danris = danris;
			setDirty();
		}
		if(this.danris > 999999) {
			this.danris = 999999;
			setDirty();
		}
		return this.danris;
	}

	/**
	 * marks that this needs to be resend to the client
	 */
	public void setDirty() {
		dirty = true;
	}
}