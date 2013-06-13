package rpg.playerinfo;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public final class PlayerInformation implements IExtendedEntityProperties {

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

    public static final String IDENTIFIER = "minepg_playerinfo";

    public static final int MAX_KARMA_LEVEL = 100;

    public static PlayerInformation forPlayer(Entity player) {
        return (PlayerInformation) player.getExtendedProperties(IDENTIFIER);
    }

    public boolean dirty = true;
    
    /** The current amount of mana the player has in their mana bar */
    private int currentMana;
    
    /** The maximum amount of mana that can be stored in the mana bar */
    private final int maxMana = 100;
    
    /** The timer used for regenerating mana.
     * It is automatically set to zero once a world is started. */
    private int manaTimer = 0;
    
    /** The current karma level the player is on */
    private int karmaLevel;
    
    /**
     * The total amount of karma the player has. This also includes the amount of karma within their
     * Karma Bar.
     */
    private int karmaTotal;
    
    /**
     * The current amount of karma the player has within their Karma Bar.
     */
    private float karma;
    
    /** False: Negative karma, True: Positive karma */
    boolean isPositiveKarma;
    
    /** False: The player is of Negative or Positive Karma, True: Nuetral Karma (i.e. 0) */
    boolean isNuetralKarma;
    
    /** How many ticks has this entity had ran since being alive */
    public int ticksExisted;
    private int field_82249_h = 0;
    
    public byte[] eventAmounts = new byte[PlayerInformation.CountableKarmaEvent.values().length];
    private String playersClass = "";
    private boolean shouldUseMysteriousVoice = true;
    private int danris = 0;

    private final EntityPlayer player;

    public PlayerInformation(EntityPlayer player) {
        this.player = player;
        this.ticksExisted = player.ticksExisted;
    }
    
    @Override
    public void init(Entity entity, World world) {

    }
    
    @Override
    public void saveNBTData(NBTTagCompound compound) {
        NBTTagCompound nbt = new NBTTagCompound();

        nbt.setString("playersClass", playersClass);
        nbt.setBoolean("shouldUseMysteriousVoice", shouldUseMysteriousVoice);
        nbt.setInteger("danris", danris);
        nbt.setInteger("currentMana", currentMana);
        nbt.setInteger("manaTimer", manaTimer);
        nbt.setFloat("karma", karma);
        nbt.setInteger("karmaLevel", karmaLevel);
        nbt.setInteger("karmaTotal", karmaTotal);
        nbt.setBoolean("isPositivekarma", isPositiveKarma);
        nbt.setBoolean("isNuetralKarma", isNuetralKarma);

        NBTTagList eventList = new NBTTagList();
        for (int i = 0; i < eventAmounts.length; i++) {
            NBTTagCompound evtInfo = new NBTTagCompound();
            evtInfo.setByte("id", (byte) i);
            evtInfo.setByte("value", eventAmounts[i]);
            eventList.appendTag(evtInfo);
        }
        nbt.setTag("events", eventList);

        compound.setCompoundTag(IDENTIFIER, nbt);
    }
    
    @Override
    public void loadNBTData(NBTTagCompound playerNbt) {
        NBTTagCompound nbt = playerNbt.getCompoundTag(IDENTIFIER);

        playersClass = nbt.getString("playersClass");
        shouldUseMysteriousVoice = nbt.getBoolean("shouldUseMysteriousVoice");
        danris = nbt.getInteger("danris");
        currentMana = nbt.getInteger("currentMana");
        manaTimer = nbt.getInteger("manaTimer");
        karma = nbt.getFloat("karma");
        karmaLevel = nbt.getInteger("karmaLevel");
        karmaTotal = nbt.getInteger("karmaTotal");
        isPositiveKarma = nbt.getBoolean("isPositiveKarma");
        isNuetralKarma = nbt.getBoolean("isNuetralKarma");

        NBTTagList eventList = nbt.getTagList("events");
        for (int i = 0; i < eventList.tagCount(); i++) {
            NBTTagCompound evtInfo = (NBTTagCompound) eventList.tagAt(i);
            byte eventId = evtInfo.getByte("id");
            if (eventId >= 0 && eventId < eventAmounts.length) {
                eventAmounts[eventId] = evtInfo.getByte("value");
            }
        }
    }
    
    public int getMana() {
        return currentMana;
    }

    public int setMana(int currentMana) {
        if (this.currentMana != currentMana) {
            this.currentMana = currentMana;
            setDirty();
        }

        return this.currentMana;
    }

    public int getMaxMana() {
        return this.maxMana;
    }

    public int getManaTimer() {
        return this.manaTimer;
    }

    public int setManaTimer(int manaTimer) {
        if(this.manaTimer != manaTimer) {
            this.manaTimer = manaTimer;
            setDirty();
        }

        return this.manaTimer;
    }

    public int decreaseMana(int decrement) {
        currentMana -= decrement;
        setDirty();
        if (currentMana < 0) {
            currentMana = 0;
            setDirty();
        }

        return currentMana;
    }

    public int increaseMana(int increment) {
        currentMana += increment;
        setDirty();
        if (currentMana > 100) {
            currentMana = 100;
            setDirty();
        }

        return currentMana;
    }

    public int getCurrency() {
        return danris;
    }

    public byte getEventAmount(CountableKarmaEvent event) {
        return eventAmounts[event.ordinal()];
    }
    
    
    
    public boolean getKarmaType() {
        if(this.karmaLevel < 0) {
            this.isPositiveKarma = false;
            this.isNuetralKarma = false;
            return this.isPositiveKarma;
        } else if(this.karmaLevel > 0) {
            this.isPositiveKarma = true;
            this.isNuetralKarma = false;
            return this.isPositiveKarma;
        } else {
            this.isNuetralKarma = true;
            return this.isNuetralKarma;
        }
    }
    
    public float setKarma(float karma) {
        if(this.karma != karma) {
            this.karma = karma;
            setDirty();
        }
        
        return this.karma;
    }
    
    public float getKarma() {
        return karma;
    }
    
    public int getKarmaLevel() {
        return this.karmaLevel;
    }
    
    public int getKarmaTotal() {
        return this.karmaTotal;
    }
    
    /**
     * This method increases the player's current amount of karma.
     */
    public void addKarma(int par1) {
        int j = Integer.MAX_VALUE - this.karmaTotal;

        if (par1 > j)
        {
            par1 = j;
        }

        this.karma += (float)par1 / (float)this.karmaBarCap();

        for (this.karmaTotal += par1; this.karma >= 1.0F; this.karma /= (float)this.karmaBarCap())
        {
            this.karma = (this.karma - 1.0F) * (float)this.karmaBarCap();
            this.addKarmaLevel(1);
        }
    }
    
    /**
     * Add karma levels to this player.
     */
    public void addKarmaLevel(int par1) {
        this.karmaLevel += par1;

        if (par1 > 0 && this.karmaLevel % 5 == 0 && (float)this.field_82249_h < (float)this.ticksExisted - 100.0F)
        {
            float f = this.karmaLevel > 30 ? 1.0F : (float)this.karmaLevel / 30.0F;
            player.worldObj.playSoundAtEntity(player, "random.levelup", f * 0.75F, 1.0F);
            this.field_82249_h = this.ticksExisted;
        }
        
        if(this.karmaLevel > PlayerInformation.MAX_KARMA_LEVEL || this.karmaLevel < -PlayerInformation.MAX_KARMA_LEVEL) {
            this.karmaLevel = this.getKarmaType() ? PlayerInformation.MAX_KARMA_LEVEL : -PlayerInformation.MAX_KARMA_LEVEL;
        }
    }
    
    
    
    
    public int karmaBarCap() {
        return this.karmaLevel >= 30 ? 62 + (this.karmaLevel - 30) * 7 : (this.karmaLevel >= 15 ? 17 + (this.karmaLevel - 15) * 3 : 17);
    }

    public String getPlayersClass() {
        return playersClass;
    }

    public boolean increaseEventAmount(PlayerInformation.CountableKarmaEvent event) {
        return setEventAmount(event, eventAmounts[event.ordinal()] + 1);
    }
    
    public boolean setEventAmount(CountableKarmaEvent event, int amount) {
        if (amount < event.getMaxCount() && eventAmounts[event.ordinal()] != amount) {
            eventAmounts[event.ordinal()] = (byte) amount;
            setDirty();
            return true;
        } else
            return false;
    }

    public String setPlayersClass(String playersClass) {
        if (this.playersClass != playersClass) {
            this.playersClass = playersClass;
            setDirty();
        }

        return this.playersClass;
    }

    public boolean getShouldUseMysteriousVoice() {
        return shouldUseMysteriousVoice;
    }

    public boolean setShouldUseMysteriousVoice(boolean shouldUseMysteriousVoice) {
        if (this.shouldUseMysteriousVoice != shouldUseMysteriousVoice) {
            this.shouldUseMysteriousVoice = shouldUseMysteriousVoice;
            setDirty();
        }

        return this.shouldUseMysteriousVoice;
    }

    public int setCurrency(int danris) {
        if (this.danris != danris) {
            this.danris = danris;
            setDirty();
        }
        if (this.danris > 999999) {
            this.danris = 999999;
            setDirty();
        }
        return this.danris;
    }

    /*
     * marks that this needs to be resend to the client
     */
    public void setDirty() {
        dirty = true;
    }
}