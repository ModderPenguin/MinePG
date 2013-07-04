package rpg.client.models.pet;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPyrefly extends ModelBase {

    // fields
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

    public ModelPyrefly() {
        this.textureWidth = 64;
        this.textureHeight = 128;

        this.body = new ModelRenderer(this, 38, 12);
        this.body.addBox(-3F, -3F, -3F, 5, 5, 5);
        this.body.setRotationPoint(-1F, 9F, -1F);
        this.body.setTextureSize(64, 128);
        this.body.mirror = true;
        this.setRotation(this.body, 0F, 0F, 0F);
        this.wing_left = new ModelRenderer(this, 46, 0);
        this.wing_left.addBox(0F, 0F, 0F, 0, 6, 2);
        this.wing_left.setRotationPoint(4F, 2F, -2F);
        this.wing_left.setTextureSize(64, 128);
        this.wing_left.mirror = true;
        this.setRotation(this.wing_left, 0F, 0.0174533F, 0.6981317F);
        this.wing_right = new ModelRenderer(this, 53, 0);
        this.wing_right.addBox(0F, 0F, 0F, 0, 6, 2);
        this.wing_right.setRotationPoint(-7F, 2F, -2F);
        this.wing_right.setTextureSize(64, 128);
        this.wing_right.mirror = true;
        this.setRotation(this.wing_right, 0F, 0F, -0.6981317F);
        this.head = new ModelRenderer(this, 3, 14);
        this.head.addBox(0F, 0F, 0F, 3, 3, 3);
        this.head.setRotationPoint(-3F, 7F, -7F);
        this.head.setTextureSize(64, 128);
        this.head.mirror = true;
        this.setRotation(this.head, 0.2230717F, 0F, 0F);
        this.mouth = new ModelRenderer(this, 26, 15);
        this.mouth.addBox(0F, 0F, 0F, 1, 1, 3);
        this.mouth.setRotationPoint(-2F, 9F, -8F);
        this.mouth.setTextureSize(64, 128);
        this.mouth.mirror = true;
        this.setRotation(this.mouth, 0.2117115F, 0F, 0F);
        this.eye_left = new ModelRenderer(this, 18, 12);
        this.eye_left.addBox(0F, 0F, 0F, 1, 2, 2);
        this.eye_left.setRotationPoint(-1F, 6.5F, -6F);
        this.eye_left.setTextureSize(64, 128);
        this.eye_left.mirror = true;
        this.setRotation(this.eye_left, 0.0174533F, 0.2602503F, -0.2230717F);
        this.eye_right = new ModelRenderer(this, 18, 18);
        this.eye_right.addBox(1F, -0.6F, -0.6F, 1, 2, 2);
        this.eye_right.setRotationPoint(-4F, 6.5F, -6F);
        this.eye_right.setTextureSize(64, 128);
        this.eye_right.mirror = true;
        this.setRotation(this.eye_right, 0F, -0.2602503F, 0.2230717F);
        this.front_leg_left_ = new ModelRenderer(this, 32, 0);
        this.front_leg_left_.addBox(0F, 0F, 0F, 1, 5, 1);
        this.front_leg_left_.setRotationPoint(-1F, 10F, -3F);
        this.front_leg_left_.setTextureSize(64, 128);
        this.front_leg_left_.mirror = true;
        this.setRotation(this.front_leg_left_, -0.2792527F, 0F, -0.2792527F);
        this.front_leg_right = new ModelRenderer(this, 22, 0);
        this.front_leg_right.addBox(0F, 0F, 0F, 1, 5, 1);
        this.front_leg_right.setRotationPoint(-3F, 10F, -3F);
        this.front_leg_right.setTextureSize(64, 128);
        this.front_leg_right.mirror = true;
        this.setRotation(this.front_leg_right, -0.2792527F, 0F, 0.2792527F);
        this.back_leg_left = new ModelRenderer(this, 11, 0);
        this.back_leg_left.addBox(0F, 0F, 0F, 1, 5, 1);
        this.back_leg_left.setRotationPoint(-1F, 10F, -1F);
        this.back_leg_left.setTextureSize(64, 128);
        this.back_leg_left.mirror = true;
        this.setRotation(this.back_leg_left, 0.2792527F, 0F, -0.2792527F);
        this.back_leg_right = new ModelRenderer(this, 2, 0);
        this.back_leg_right.addBox(0F, 0F, 0F, 1, 5, 1);
        this.back_leg_right.setRotationPoint(-3F, 10F, -1F);
        this.back_leg_right.setTextureSize(64, 128);
        this.back_leg_right.mirror = true;
        this.setRotation(this.back_leg_right, 0.2792527F, 0F, 0.2792527F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.body.render(f5);
        this.wing_left.render(f5);
        this.wing_right.render(f5);
        this.head.render(f5);
        this.mouth.render(f5);
        this.eye_left.render(f5);
        this.eye_right.render(f5);
        this.front_leg_left_.render(f5);
        this.front_leg_right.render(f5);
        this.back_leg_left.render(f5);
        this.back_leg_right.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

}
