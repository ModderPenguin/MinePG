package rpg.playerinfo;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public final class PlayerInfoFake {

    private static final String IDENTIFIER = "minpg_playerinfo";

    private static final int MAX_KARMA_VALUE = 999999;

    @SuppressWarnings("unused")
    private static boolean dirty = true;
    private static boolean hasClassBeenChosen = false;
    private static float karma;
    private static byte[] eventAmounts = new byte[PlayerInfoFake.CountableKarmaEvent.values().length];
    private static String playersClass = "";
    private static int danris = 0;
    
    private static EntityPlayer player;

    public PlayerInfoFake(EntityPlayer thePlayer) {
        player = thePlayer;
    }

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
    
    public static boolean getHasClassBeenChosen() {
        return hasClassBeenChosen;
    }
    
    public static boolean setHasClassBeenChosen(boolean hasClassBeenChosen) {
        if(PlayerInfoFake.hasClassBeenChosen != hasClassBeenChosen) {
            PlayerInfoFake.hasClassBeenChosen = hasClassBeenChosen;
            setDirty();
            return hasClassBeenChosen;
        }
        return PlayerInfoFake.hasClassBeenChosen;
    }
    
    public static String getPlayersClass() {
        return playersClass;
    }
    
    public static String setPlayersClass(String playersClass) {
        if(PlayerInfoFake.playersClass != playersClass) {
            PlayerInfoFake.playersClass = playersClass;
            setDirty();
            return playersClass;
        }
        
        return PlayerInfoFake.playersClass;
    }
    
    public static String modifyPlayersClass(String classChangingTo) {
        return setPlayersClass(classChangingTo);
    }
    
    public static float getKarma() {
        return karma;
    }

    public static float setKarma(float karma) {
        if (PlayerInfoFake.karma != karma) {
            PlayerInfoFake.karma = karma;
            if (PlayerInfoFake.karma > MAX_KARMA_VALUE) {
                PlayerInfoFake.karma = MAX_KARMA_VALUE;
            }
            if (PlayerInfoFake.karma < -MAX_KARMA_VALUE) {
                PlayerInfoFake.karma = -MAX_KARMA_VALUE;
            }
            setDirty();
        }
        
        return PlayerInfoFake.karma;
    }

    public static float modifyKarma(float modifier) {
        player.worldObj.playSoundAtEntity(player, "minepgkarma.karma" + (modifier < 0 ? "down" : "up"), 1, 1);

        return setKarma(karma + modifier);
    }

    public static float modifyKarmaWithMax(float modifier, float max) {
        if (karma < max) {
            modifyKarma(modifier);
        }
        
        return karma;
    }

    public static float modifyKarmaWithMin(float modifier, float min) {
        if (karma > min) {
            modifyKarma(modifier);
        }
        
        return karma;
    }

    public static byte getEventAmount(CountableKarmaEvent event) {
        return eventAmounts[event.ordinal()];
    }

    public static boolean setEventAmount(CountableKarmaEvent event, int amount) {
        if (amount < event.getMaxCount() && eventAmounts[event.ordinal()] != amount) {
            eventAmounts[event.ordinal()] = (byte)amount;
            setDirty();
            return true;
        } else {
            return false;
        }
    }

    public static boolean increaseEventAmount(PlayerInfoFake.CountableKarmaEvent event) {
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
    
    public static int getCurrency() {
        return danris;
    }

    public static int setCurrency(int currency) {
        if(PlayerInfoFake.danris != currency) {
            PlayerInfoFake.danris = currency;
            setDirty();
        }
        if(PlayerInfoFake.danris > 999999) {
            PlayerInfoFake.danris = 999999;
            setDirty();
        }
        return danris;
    }

    /**
     * marks that PlayerInfoFake needs to be resend to the client
     */
    private static void setDirty() {
        dirty = true;
    }
}