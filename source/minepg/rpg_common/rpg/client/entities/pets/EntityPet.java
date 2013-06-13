package rpg.client.entities.pets;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityPet extends EntityTameable {

    public int petHealth;
    
    /** The current amount experience the pet has including 
     * the experience in their experience bar. */
    public int experienceTotal;
    
    /** The current level the pet is on. */
    public int experienceLevel;
    
    /** The current amount of experience in the pet's experience bar. */
    public float experience;
    private int field_82249_h = 0;
    
    public EntityPet(World par1World) {
        super(par1World);
    }

    @Override
    protected void entityInit() {
        
    }
    
    /**
     * This method increases the player's current amount of experience.
     */
    public void addExperience(int par1)
    {
        int j = Integer.MAX_VALUE - this.experienceTotal;

        if (par1 > j)
        {
            par1 = j;
        }

        this.experience += (float)par1 / (float)this.xpBarCap();

        for (this.experienceTotal += par1; this.experience >= 1.0F; this.experience /= (float)this.xpBarCap())
        {
            this.experience = (this.experience - 1.0F) * (float)this.xpBarCap();
            this.addExperienceLevel(1);
        }
    }

    /**
     * Add experience levels to this player.
     */
    public void addExperienceLevel(int par1)
    {
        this.experienceLevel += par1;

        if (this.experienceLevel < 0)
        {
            this.experienceLevel = 0;
            this.experience = 0.0F;
            this.experienceTotal = 0;
        }

        if (par1 > 0 && this.experienceLevel % 5 == 0 && (float)this.field_82249_h < (float)this.ticksExisted - 100.0F)
        {
            float f = this.experienceLevel > 30 ? 1.0F : (float)this.experienceLevel / 30.0F;
            this.worldObj.playSoundAtEntity(this, "random.levelup", f * 0.75F, 1.0F);
            this.field_82249_h = this.ticksExisted;
        }
    }

    /**
     * This method returns the cap amount of experience that the experience bar can hold. With each level, the
     * experience cap on the player's experience bar is raised by 10.
     */
    public int xpBarCap()
    {
        return this.experienceLevel >= 30 ? 62 + (this.experienceLevel - 30) * 7 : (this.experienceLevel >= 15 ? 17 + (this.experienceLevel - 15) * 3 : 17);
    }
    
    @Override
    public int getMaxHealth() {
        return this.petHealth;
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        
    }

    @Override
    public EntityAgeable createChild(EntityAgeable entityageable) {
        return null;
    }
}
