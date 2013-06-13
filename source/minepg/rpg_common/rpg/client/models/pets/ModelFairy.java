package rpg.client.models.pets;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFairy extends ModelPet
{
    //fields
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

    public ModelFairy()
    {
        textureWidth = 128;
        textureHeight = 64;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-6F, -12F, -6F, 12, 12, 12);
        head.setRotationPoint(0F, 1F, -1F);
        head.setTextureSize(128, 64);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body = new ModelRenderer(this, 16, 24);
        body.addBox(-4F, 0F, -2F, 8, 11, 4);
        body.setRotationPoint(0F, 1F, 0F);
        body.setTextureSize(128, 64);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        rightarm = new ModelRenderer(this, 0, 24);
        rightarm.addBox(0F, -1F, -2F, 4, 12, 4);
        rightarm.setRotationPoint(4F, 2F, 0F);
        rightarm.setTextureSize(128, 64);
        rightarm.mirror = true;
        setRotation(rightarm, 0F, 0F, 0F);
        leftarm = new ModelRenderer(this, 0, 24);
        leftarm.addBox(-4F, -1F, -2F, 4, 12, 4);
        leftarm.setRotationPoint(-4F, 2F, 0F);
        leftarm.setTextureSize(128, 64);
        leftarm.mirror = true;
        setRotation(leftarm, 0F, 0F, 0F);
        rightleg = new ModelRenderer(this, 40, 24);
        rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        rightleg.setRotationPoint(2F, 12F, 0F);
        rightleg.setTextureSize(128, 64);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 40, 24);
        leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        leftleg.setRotationPoint(-2F, 12F, 0F);
        leftleg.setTextureSize(128, 64);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, 0F, 0F);
        breast = new ModelRenderer(this, 30, 40);
        breast.addBox(0F, 0F, 0F, 8, 4, 2);
        breast.setRotationPoint(-4F, 3F, -4F);
        breast.setTextureSize(128, 64);
        breast.mirror = true;
        setRotation(breast, 0F, 0F, 0F);
        hair1 = new ModelRenderer(this, 48, 0);
        hair1.addBox(0F, 0F, 0F, 2, 6, 12);
        hair1.setRotationPoint(6F, -9F, -7F);
        hair1.setTextureSize(128, 64);
        hair1.mirror = true;
        setRotation(hair1, 0F, 0F, 0F);
        hair2 = new ModelRenderer(this, 48, 0);
        hair2.addBox(0F, 0F, 0F, 2, 6, 12);
        hair2.setRotationPoint(-8F, -9F, -7F);
        hair2.setTextureSize(128, 64);
        hair2.mirror = true;
        setRotation(hair2, 0F, 0F, 0F);
        hair3 = new ModelRenderer(this, 0, 40);
        hair3.addBox(0F, 0F, 0F, 11, 5, 3);
        hair3.setRotationPoint(-5.5F, -10F, 5F);
        hair3.setTextureSize(128, 64);
        hair3.mirror = true;
        setRotation(hair3, 0F, 0F, 0F);
        hair4 = new ModelRenderer(this, 26, 46);
        hair4.addBox(0F, 0F, 0F, 20, 6, 6);
        hair4.setRotationPoint(-10F, -5F, 3F);
        hair4.setTextureSize(128, 64);
        hair4.mirror = true;
        setRotation(hair4, 0F, 0F, 0F);
        leftwing = new ModelRenderer(this, 68, 20);
        leftwing.addBox(0F, -4F, 0F, 10, 8, 0);
        leftwing.setRotationPoint(1F, 5F, 2.1F);
        leftwing.setTextureSize(128, 64);
        leftwing.mirror = true;
        setRotation(leftwing, 0F, 0F, 0F);
        leftwing2 = new ModelRenderer(this, 94, 16);
        leftwing2.addBox(0F, -2F, 0F, 2, 4, 0);
        leftwing2.setRotationPoint(0F, 5F, 2.1F);
        leftwing2.setTextureSize(128, 64);
        leftwing2.mirror = true;
        setRotation(leftwing2, 0F, 0F, 0F);
        rightwing.mirror = true;
        rightwing = new ModelRenderer(this, 68, 20);
        rightwing.addBox(0F, -4F, 0F, 10, 8, 0);
        rightwing.setRotationPoint(-11F, 5F, 2.1F);
        rightwing.setTextureSize(128, 64);
        rightwing.mirror = true;
        setRotation(rightwing, 0F, 0F, 0F);
        rightwing.mirror = false;
        Shape1 = new ModelRenderer(this, 100, 16);
        Shape1.addBox(0F, -2F, 0F, 2, 4, 0);
        Shape1.setRotationPoint(-2F, 5F, 2.1F);
        Shape1.setTextureSize(128, 64);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        head.render(f5);
        body.render(f5);
        rightarm.render(f5);
        leftarm.render(f5);
        rightleg.render(f5);
        leftleg.render(f5);
        breast.render(f5);
        hair1.render(f5);
        hair2.render(f5);
        hair3.render(f5);
        hair4.render(f5);
        leftwing.render(f5);
        leftwing2.render(f5);
        rightwing.render(f5);
        Shape1.render(f5);
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