package rpg.client.models.pet;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelGopher extends ModelBase {

    // fields
    ModelRenderer head;
    ModelRenderer tail;
    ModelRenderer ear2;
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer ear1;
    ModelRenderer leg4;

    public ModelGopher() {
        this.textureWidth = 64;
        this.textureHeight = 64;

        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-4F, -4F, -8F, 5, 5, 4);
        this.head.setRotationPoint(0F, 18F, -2F);
        this.head.setTextureSize(64, 64);
        this.head.mirror = true;
        this.setRotation(this.head, 0F, 0F, 0F);
        this.tail = new ModelRenderer(this, 16, 20);
        this.tail.addBox(0F, 0F, 0F, 1, 1, 2);
        this.tail.setRotationPoint(-2F, 17F, 0F);
        this.tail.setTextureSize(64, 64);
        this.tail.mirror = true;
        this.setRotation(this.tail, 0F, 0F, 0F);
        this.ear2 = new ModelRenderer(this, 26, 4);
        this.ear2.addBox(0F, 0F, 0F, 1, 1, 1);
        this.ear2.setRotationPoint(-3F, 13F, -10F);
        this.ear2.setTextureSize(64, 64);
        this.ear2.mirror = true;
        this.setRotation(this.ear2, 0F, 0F, 0F);
        this.body = new ModelRenderer(this, 28, 8);
        this.body.addBox(-5F, -10F, -7F, 7, 7, 5);
        this.body.setRotationPoint(0F, 15F, 3F);
        this.body.setTextureSize(64, 64);
        this.body.mirror = true;
        this.setRotation(this.body, 1.570796F, 0F, 0F);
        this.leg1 = new ModelRenderer(this, 28, 36);
        this.leg1.addBox(-2F, 0F, -2F, 2, 3, 2);
        this.leg1.setRotationPoint(-3F, 21F, 0F);
        this.leg1.setTextureSize(64, 64);
        this.leg1.mirror = true;
        this.setRotation(this.leg1, 0F, 0F, 0F);
        this.leg2 = new ModelRenderer(this, 8, 40);
        this.leg2.addBox(-2F, 0F, -10F, 2, 3, 2);
        this.leg2.setRotationPoint(2F, 21F, 8F);
        this.leg2.setTextureSize(64, 64);
        this.leg2.mirror = true;
        this.setRotation(this.leg2, 0F, 0F, 0F);
        this.leg3 = new ModelRenderer(this, 12, 30);
        this.leg3.addBox(-2F, 18F, -2F, 2, 3, 2);
        this.leg3.setRotationPoint(-3F, 3F, -5F);
        this.leg3.setTextureSize(64, 64);
        this.leg3.mirror = true;
        this.setRotation(this.leg3, 0F, 0F, 0F);
        this.ear1 = new ModelRenderer(this, 20, 6);
        this.ear1.addBox(-1F, 8F, -9F, 1, 1, 1);
        this.ear1.setRotationPoint(0F, 5F, -1F);
        this.ear1.setTextureSize(64, 64);
        this.ear1.mirror = true;
        this.setRotation(this.ear1, 0F, 0F, 0F);
        this.leg4 = new ModelRenderer(this, 22, 28);
        this.leg4.addBox(-2F, 0F, -2F, 2, 3, 2);
        this.leg4.setRotationPoint(2F, 21F, -5F);
        this.leg4.setTextureSize(64, 64);
        this.leg4.mirror = true;
        this.setRotation(this.leg4, 0F, 0F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.head.render(f5);
        this.tail.render(f5);
        this.ear2.render(f5);
        this.body.render(f5);
        this.leg1.render(f5);
        this.leg2.render(f5);
        this.leg3.render(f5);
        this.ear1.render(f5);
        this.leg4.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
        this.leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * .1F * f1;
        this.leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * .15F * f1;
        this.leg1.rotateAngleY = 0.0F;
        this.leg2.rotateAngleY = 0.0F;
        this.leg3.rotateAngleX = MathHelper.cos(f * 0.6662F) * .1F * f1;
        this.leg4.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * .15F * f1;
        this.leg3.rotateAngleY = 0.0F;
        this.leg4.rotateAngleY = 0.0F;
    }

}
