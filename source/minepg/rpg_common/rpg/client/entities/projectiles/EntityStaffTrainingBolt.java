package rpg.client.entities.projectiles;

import rpg.enums.weapons.EnumRPGStaffMaterial;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityStaffTrainingBolt extends EntityThrowable {

    public byte damage = (byte)EnumRPGStaffMaterial.TRAINING.getMagicDamage();

    public EntityStaffTrainingBolt(World var1) {
        super(var1);
    }

    public EntityStaffTrainingBolt(World var1, EntityLiving var2) {
        super(var1, var2);
    }

    public EntityStaffTrainingBolt(World var1, double var2, double var4, double var6) {
        super(var1, var2, var4, var6);
    }

    @Override
    protected void onImpact(MovingObjectPosition var1) {
        if (var1.entityHit != null) {
            var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), this.damage);
        }

        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }
    
    /**
     * Gets the amount of gravity to apply to the thrown entity with each tick.
     */
    @Override
    protected float getGravityVelocity()
    {
        return 0;
    }
}