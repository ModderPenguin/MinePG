package rpg.client.entities;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityWandTrainingBolt extends EntityThrowable
{
   public EntityWandTrainingBolt(World par1World)
   {
       super(par1World);
       setThrowableHeading(this.motionX, this.motionY, this.motionZ, 3.0F, 1.0F);
   }
  
   public EntityWandTrainingBolt(World par1World, EntityLiving par2EntityLiving)
   {
       super(par1World, par2EntityLiving);
   }
  
   public EntityWandTrainingBolt(World par1World, double par2, double par4, double par6)
   {
       super(par1World, par2, par4, par6);
   }
   
   @Override
   protected void onImpact(MovingObjectPosition movingobjectposition) 
   {
	   this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 0.2F, true);
	   this.setDead();
   }
   
   @Override
   protected float getGravityVelocity() {
	   return 0;
   }
}