package rpg.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWandBolt extends ModelBase
{
  //fields
    ModelRenderer BoltBody;
    ModelRenderer BoltPointBack;
    ModelRenderer BoltPointBottom;
    ModelRenderer BoltPointRight;
    ModelRenderer BoltPointLeft;
    ModelRenderer BoltPointFront;
    ModelRenderer BoltPointTop;
  
  public ModelWandBolt()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      BoltBody = new ModelRenderer(this, 0, 0);
      BoltBody.addBox(0F, 0F, 0F, 3, 3, 3);
      BoltBody.setRotationPoint(-1F, 12F, -1F);
      BoltBody.setTextureSize(64, 32);
      BoltBody.mirror = true;
      setRotation(BoltBody, 0F, 0F, 0F);
      BoltPointBack = new ModelRenderer(this, 12, 0);
      BoltPointBack.addBox(0F, 0F, 0F, 1, 1, 1);
      BoltPointBack.setRotationPoint(0F, 13F, 2F);
      BoltPointBack.setTextureSize(64, 32);
      BoltPointBack.mirror = true;
      setRotation(BoltPointBack, 0F, 0F, 0F);
      BoltPointBottom = new ModelRenderer(this, 12, 0);
      BoltPointBottom.addBox(0F, 0F, 0F, 1, 1, 1);
      BoltPointBottom.setRotationPoint(0F, 15F, 0F);
      BoltPointBottom.setTextureSize(64, 32);
      BoltPointBottom.mirror = true;
      setRotation(BoltPointBottom, 0F, 0F, 0F);
      BoltPointRight = new ModelRenderer(this, 12, 0);
      BoltPointRight.addBox(0F, 0F, 0F, 1, 1, 1);
      BoltPointRight.setRotationPoint(2F, 13F, 0F);
      BoltPointRight.setTextureSize(64, 32);
      BoltPointRight.mirror = true;
      setRotation(BoltPointRight, 0F, 0F, 0F);
      BoltPointLeft = new ModelRenderer(this, 12, 0);
      BoltPointLeft.addBox(0F, 0F, 0F, 1, 1, 1);
      BoltPointLeft.setRotationPoint(-2F, 13F, 0F);
      BoltPointLeft.setTextureSize(64, 32);
      BoltPointLeft.mirror = true;
      setRotation(BoltPointLeft, 0F, 0F, 0F);
      BoltPointFront = new ModelRenderer(this, 12, 0);
      BoltPointFront.addBox(0F, 0F, 0F, 1, 1, 1);
      BoltPointFront.setRotationPoint(0F, 13F, -2F);
      BoltPointFront.setTextureSize(64, 32);
      BoltPointFront.mirror = true;
      setRotation(BoltPointFront, 0F, 0F, 0F);
      BoltPointTop = new ModelRenderer(this, 12, 0);
      BoltPointTop.addBox(0F, 0F, 0F, 1, 1, 1);
      BoltPointTop.setRotationPoint(0F, 11F, 0F);
      BoltPointTop.setTextureSize(64, 32);
      BoltPointTop.mirror = true;
      setRotation(BoltPointTop, 0F, 0F, 0F);
  }
  
  public void render(Entity par1Entity, float par2, float par3, float par4, float par5,float par6,
		  float par7)
  {
	  super.render(par1Entity, par2, par3, par4, par5, par6, par7);
	  setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
	  BoltBody.render(par7);
	  BoltPointBack.render(par7);
	  BoltPointBottom.render(par7);
	  BoltPointRight.render(par7);
	  BoltPointLeft.render(par7);
  	  BoltPointFront.render(par7);
  	  BoltPointTop.render(par7);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5,
		  float par6, Entity par7Entity)
  {
    super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
  }
}
