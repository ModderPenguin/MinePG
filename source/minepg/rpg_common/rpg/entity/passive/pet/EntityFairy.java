package rpg.entity.passive.pet;

import rpg.lib.Reference;
import net.minecraft.world.World;

public class EntityFairy extends EntityPet {

    public EntityFairy(World par1World) {
        super(par1World);
        this.petHealth = 10;
        this.texture = "/mods/" + Reference.MOD_ID + "/textures/mob/fairy1.png";
        this.setSize(0.6F, 0.8F);
        // this.getNavigator().setAvoidsWater(true);
        // this.tasks.addTask(1, new EntityAIFollowOwner(this, this.moveSpeed, 10.0F, 2.0F));
        // this.tasks.addTask(2, new EntityAILeapAtTarget(this, 0.4F));
        // this.tasks.addTask(3, new EntityAIAttackOnCollide(this, this.moveSpeed, true));
        // this.tasks.addTask(4, new EntityAIMate(this, this.moveSpeed));
        // this.tasks.addTask(5, new EntityAIWander(this, this.moveSpeed));
        // this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        // this.tasks.addTask(7, new EntityAILookIdle(this));
        // this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        // this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        // this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
    }
}
