package rpg.client.models.pet;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPyrefly extends ModelPet
{
  //fields
    ModelRenderer body;
    ModelRenderer wing_left;
    ModelRenderer wing_right;
    ModelRenderer head;
    ModelRenderer mouth;
    ModelRenderer eye_left;
    ModelRenderer eye_right;
    ModelRenderer front_leg_left_;
    ModelRenderer front_leg_right;
    ModelRenderer back_leg_left;
    ModelRenderer back_leg_right;
  
  public ModelPyrefly()
  {
    textureWidth = 64;
    textureHeight = 128;
    
      body = new ModelRenderer(this, 38, 12);
      body.addBox(-3F, -3F, -3F, 5, 5, 5);
      body.setRotationPoint(-1F, 9F, -1F);
      body.setTextureSize(64, 128);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      wing_left = new ModelRenderer(this, 46, 0);
      wing_left.addBox(0F, 0F, 0F, 0, 6, 2);
      wing_left.setRotationPoint(4F, 2F, -2F);
      wing_left.setTextureSize(64, 128);
      wing_left.mirror = true;
      setRotation(wing_left, 0F, 0.0174533F, 0.6981317F);
      wing_right = new ModelRenderer(this, 53, 0);
      wing_right.addBox(0F, 0F, 0F, 0, 6, 2);
      wing_right.setRotationPoint(-7F, 2F, -2F);
      wing_right.setTextureSize(64, 128);
      wing_right.mirror = true;
      setRotation(wing_right, 0F, 0F, -0.6981317F);
      head = new ModelRenderer(this, 3, 14);
      head.addBox(0F, 0F, 0F, 3, 3, 3);
      head.setRotationPoint(-3F, 7F, -7F);
      head.setTextureSize(64, 128);
      head.mirror = true;
      setRotation(head, 0.2230717F, 0F, 0F);
      mouth = new ModelRenderer(this, 26, 15);
      mouth.addBox(0F, 0F, 0F, 1, 1, 3);
      mouth.setRotationPoint(-2F, 9F, -8F);
      mouth.setTextureSize(64, 128);
      mouth.mirror = true;
      setRotation(mouth, 0.2117115F, 0F, 0F);
      eye_left = new ModelRenderer(this, 18, 12);
      eye_left.addBox(0F, 0F, 0F, 1, 2, 2);
      eye_left.setRotationPoint(-1F, 6.5F, -6F);
      eye_left.setTextureSize(64, 128);
      eye_left.mirror = true;
      setRotation(eye_left, 0.0174533F, 0.2602503F, -0.2230717F);
      eye_right = new ModelRenderer(this, 18, 18);
      eye_right.addBox(1F, -0.6F, -0.6F, 1, 2, 2);
      eye_right.setRotationPoint(-4F, 6.5F, -6F);
      eye_right.setTextureSize(64, 128);
      eye_right.mirror = true;
      setRotation(eye_right, 0F, -0.2602503F, 0.2230717F);
      front_leg_left_ = new ModelRenderer(this, 32, 0);
      front_leg_left_.addBox(0F, 0F, 0F, 1, 5, 1);
      front_leg_left_.setRotationPoint(-1F, 10F, -3F);
      front_leg_left_.setTextureSize(64, 128);
      front_leg_left_.mirror = true;
      setRotation(front_leg_left_, -0.2792527F, 0F, -0.2792527F);
      front_leg_right = new ModelRenderer(this, 22, 0);
      front_leg_right.addBox(0F, 0F, 0F, 1, 5, 1);
      front_leg_right.setRotationPoint(-3F, 10F, -3F);
      front_leg_right.setTextureSize(64, 128);
      front_leg_right.mirror = true;
      setRotation(front_leg_right, -0.2792527F, 0F, 0.2792527F);
      back_leg_left = new ModelRenderer(this, 11, 0);
      back_leg_left.addBox(0F, 0F, 0F, 1, 5, 1);
      back_leg_left.setRotationPoint(-1F, 10F, -1F);
      back_leg_left.setTextureSize(64, 128);
      back_leg_left.mirror = true;
      setRotation(back_leg_left, 0.2792527F, 0F, -0.2792527F);
      back_leg_right = new ModelRenderer(this, 2, 0);
      back_leg_right.addBox(0F, 0F, 0F, 1, 5, 1);
      back_leg_right.setRotationPoint(-3F, 10F, -1F);
      back_leg_right.setTextureSize(64, 128);
      back_leg_right.mirror = true;
      setRotation(back_leg_right, 0.2792527F, 0F, 0.2792527F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    body.render(f5);
    wing_left.render(f5);
    wing_right.render(f5);
    head.render(f5);
    mouth.render(f5);
    eye_left.render(f5);
    eye_right.render(f5);
    front_leg_left_.render(f5);
    front_leg_right.render(f5);
    back_leg_left.render(f5);
    back_leg_right.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
