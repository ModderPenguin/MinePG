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

    public static final int MAX_KARMA_VALUE = 99999999;

    public static PlayerInformation forPlayer(Entity player) {
        return (PlayerInformation) player.getExtendedProperties(IDENTIFIER);
    }

    //private int feild_abcd_a = 0;
    //public int ticksExisted;
    
    public boolean dirty = true;
    //private int karmaLevel;
    private float karma = 0;
    //private int karmaTotal;
    public byte[] eventAmounts = new byte[PlayerInformation.CountableKarmaEvent
                                          .values().length];
    private String playersClass;
    private int danris = 0;

    private final EntityPlayer player;

    public PlayerInformation(EntityPlayer player) {
        this.player = player;
        //this.ticksExisted = player.ticksExisted;
    }

    public int getCurrency() {
        return danris;
    }

    public byte getEventAmount(CountableKarmaEvent event) {
        return eventAmounts[event.ordinal()];
    }

    public float getKarma() {
        return karma;
    }

    public String getPlayersClass() {
        return playersClass;
    }

    public boolean increaseEventAmount(
            PlayerInformation.CountableKarmaEvent event) {
        return setEventAmount(event, eventAmounts[event.ordinal()] + 1);
    }

    @Override
    public void init(Entity entity, World world) {

    }

    @Override
    public void loadNBTData(NBTTagCompound playerNbt) {
        NBTTagCompound nbt = playerNbt.getCompoundTag(IDENTIFIER);

        playersClass = nbt.getString("playersClass");

        danris = nbt.getInteger("danris");
        karma = nbt.getFloat("karma");
        //karmaLevel = nbt.getInteger("karmaLevel");
        //karmaTotal = nbt.getInteger("karmaTotal");

        NBTTagList eventList = nbt.getTagList("events");
        for (int i = 0; i < eventList.tagCount(); i++) {
            NBTTagCompound evtInfo = (NBTTagCompound) eventList.tagAt(i);
            byte eventId = evtInfo.getByte("id");
            if (eventId >= 0 && eventId < eventAmounts.length) {
                eventAmounts[eventId] = evtInfo.getByte("value");
            }
        }
    }

    public float modifyKarma(float modifier) {
        player.worldObj.playSoundAtEntity(player, "minepg.karma"
                + (modifier < 0 ? "down" : "up"), 1, 1);

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

    @Override
    public void saveNBTData(NBTTagCompound compound) {
        NBTTagCompound nbt = new NBTTagCompound();

        nbt.setString("playersClass", playersClass);
        nbt.setInteger("danris", danris);
        nbt.setFloat("karma", karma);
        //nbt.setInteger("karmaLevel", karmaLevel);
        //nbt.setInteger("karmaTotal", karmaTotal);

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

    /**
     * marks that this needs to be resend to the client
     */
    public void setDirty() {
        dirty = true;
    }

    public boolean setEventAmount(CountableKarmaEvent event, int amount) {
        if (amount < event.getMaxCount()
                && eventAmounts[event.ordinal()] != amount) {
            eventAmounts[event.ordinal()] = (byte) amount;
            setDirty();
            return true;
        } else
            return false;
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

    public String setPlayersClass(String playersClass) {
        if (this.playersClass != playersClass) {
            this.playersClass = playersClass;
            setDirty();
        }

        return this.playersClass;
    }
    
    /*
    public int xpBarCap()
    {
        return this.karmaLevel >= 30 ? 62 + (this.karmaLevel - 30) * 7 : (this.karmaLevel >= 15 ? 17 + (this.karmaLevel - 15) * 3 : 17);
    }
    
    public void addKarma(int par1)
    {
        int j = Integer.MAX_VALUE - this.karmaTotal;

        if (par1 > j)
        {
            par1 = j;
        }

        this.karma += (float)par1 / (float)this.xpBarCap();

        for (this.karmaTotal += par1; this.karma >= 1.0F; this.karma /= (float)this.xpBarCap())
        {
            this.karma = (this.karma - 1.0F) * (float)this.xpBarCap();
            this.addExperienceLevel(1);
        }
    }
    
    public void addKarmaLevel(int par1)
    {
        this.karmaLevel += par1;

        if (this.karmaLevel < 0)
        {
            this.karmaLevel = 0;
            this.karma = 0.0F;
            this.karmaTotal = 0;
        }

        if (par1 > 0 && this.karmaLevel % 5 == 0 && (float)this.feild_abcd_a < (float)this.ticksExisted - 100.0F)
        {
            float f = this.experienceLevel > 30 ? 1.0F : (float)this.experienceLevel / 30.0F;
            this.worldObj.playSoundAtEntity(this, "random.levelup", f * 0.75F, 1.0F);
            this.feild_abcd_a = this.ticksExisted;
        }
        
    }*/
}