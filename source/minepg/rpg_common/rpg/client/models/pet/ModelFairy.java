package rpg.client.models.pet;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFairy extends ModelBase {

    // fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer breast;
    ModelRenderer hair1;
    ModelRenderer hair2;
    ModelRenderer hair3;
    ModelRenderer hair4;
    ModelRenderer leftwing;
    ModelRenderer leftwing2;
    ModelRenderer rightwing;
    ModelRenderer Shape1;

    public ModelFairy() {
        this.textureWidth = 128;
        this.textureHeight = 64;

        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-6F, -12F, -6F, 12, 12, 12);
        this.head.setRotationPoint(0F, 1F, -1F);
        this.head.setTextureSize(128, 64);
        this.head.mirror = true;
        this.setRotation(this.head, 0F, 0F, 0F);
        this.body = new ModelRenderer(this, 16, 24);
        this.body.addBox(-4F, 0F, -2F, 8, 11, 4);
        this.body.setRotationPoint(0F, 1F, 0F);
        this.body.setTextureSize(128, 64);
        this.body.mirror = true;
        this.setRotation(this.body, 0F, 0F, 0F);
        this.rightarm = new ModelRenderer(this, 0, 24);
        this.rightarm.addBox(0F, -1F, -2F, 4, 12, 4);
        this.rightarm.setRotationPoint(4F, 2F, 0F);
        this.rightarm.setTextureSize(128, 64);
        this.rightarm.mirror = true;
        this.setRotation(this.rightarm, 0F, 0F, 0F);
        this.leftarm = new ModelRenderer(this, 0, 24);
        this.leftarm.addBox(-4F, -1F, -2F, 4, 12, 4);
        this.leftarm.setRotationPoint(-4F, 2F, 0F);
        this.leftarm.setTextureSize(128, 64);
        this.leftarm.mirror = true;
        this.setRotation(this.leftarm, 0F, 0F, 0F);
        this.rightleg = new ModelRenderer(this, 40, 24);
        this.rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        this.rightleg.setRotationPoint(2F, 12F, 0F);
        this.rightleg.setTextureSize(128, 64);
        this.rightleg.mirror = true;
        this.setRotation(this.rightleg, 0F, 0F, 0F);
        this.leftleg = new ModelRenderer(this, 40, 24);
        this.leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        this.leftleg.setRotationPoint(-2F, 12F, 0F);
        this.leftleg.setTextureSize(128, 64);
        this.leftleg.mirror = true;
        this.setRotation(this.leftleg, 0F, 0F, 0F);
        this.breast = new ModelRenderer(this, 30, 40);
        this.breast.addBox(0F, 0F, 0F, 8, 4, 2);
        this.breast.setRotationPoint(-4F, 3F, -4F);
        this.breast.setTextureSize(128, 64);
        this.breast.mirror = true;
        this.setRotation(this.breast, 0F, 0F, 0F);
        this.hair1 = new ModelRenderer(this, 48, 0);
        this.hair1.addBox(0F, 0F, 0F, 2, 6, 12);
        this.hair1.setRotationPoint(6F, -9F, -7F);
        this.hair1.setTextureSize(128, 64);
        this.hair1.mirror = true;
        this.setRotation(this.hair1, 0F, 0F, 0F);
        this.hair2 = new ModelRenderer(this, 48, 0);
        this.hair2.addBox(0F, 0F, 0F, 2, 6, 12);
        this.hair2.setRotationPoint(-8F, -9F, -7F);
        this.hair2.setTextureSize(128, 64);
        this.hair2.mirror = true;
        this.setRotation(this.hair2, 0F, 0F, 0F);
        this.hair3 = new ModelRenderer(this, 0, 40);
        this.hair3.addBox(0F, 0F, 0F, 11, 5, 3);
        this.hair3.setRotationPoint(-5.5F, -10F, 5F);
        this.hair3.setTextureSize(128, 64);
        this.hair3.mirror = true;
        this.setRotation(this.hair3, 0F, 0F, 0F);
        this.hair4 = new ModelRenderer(this, 26, 46);
        this.hair4.addBox(0F, 0F, 0F, 20, 6, 6);
        this.hair4.setRotationPoint(-10F, -5F, 3F);
        this.hair4.setTextureSize(128, 64);
        this.hair4.mirror = true;
        this.setRotation(this.hair4, 0F, 0F, 0F);
        this.leftwing = new ModelRenderer(this, 68, 20);
        this.leftwing.addBox(0F, -4F, 0F, 10, 8, 0);
        this.leftwing.setRotationPoint(1F, 5F, 2.1F);
        this.leftwing.setTextureSize(128, 64);
        this.leftwing.mirror = true;
        this.setRotation(this.leftwing, 0F, 0F, 0F);
        this.leftwing2 = new ModelRenderer(this, 94, 16);
        this.leftwing2.addBox(0F, -2F, 0F, 2, 4, 0);
        this.leftwing2.setRotationPoint(0F, 5F, 2.1F);
        this.leftwing2.setTextureSize(128, 64);
        this.leftwing2.mirror = true;
        this.setRotation(this.leftwing2, 0F, 0F, 0F);
        this.leftwing2.mirror = false;
        this.rightwing = new ModelRenderer(this, 68, 20);
        this.rightwing.addBox(0F, -4F, 0F, 10, 8, 0);
        this.rightwing.setRotationPoint(-11F, 5F, 2.1F);
        this.rightwing.setTextureSize(128, 64);
        this.rightwing.mirror = true;
        this.setRotation(this.rightwing, 0F, 0F, 0F);
        this.rightwing.mirror = false;
        this.Shape1 = new ModelRenderer(this, 100, 16);
        this.Shape1.addBox(0F, -2F, 0F, 2, 4, 0);
        this.Shape1.setRotationPoint(-2F, 5F, 2.1F);
        this.Shape1.setTextureSize(128, 64);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0F, 0F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.head.render(f5);
        this.body.render(f5);
        this.rightarm.render(f5);
        this.leftarm.render(f5);
        this.rightleg.render(f5);
        this.leftleg.render(f5);
        this.breast.render(f5);
        this.hair1.render(f5);
        this.hair2.render(f5);
        this.hair3.render(f5);
        this.hair4.render(f5);
        this.leftwing.render(f5);
        this.leftwing2.render(f5);
        this.rightwing.render(f5);
        this.Shape1.render(f5);
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