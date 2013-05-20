package rpg.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTrainingStaff extends ModelBase {

    // fields
    ModelRenderer Staffbody;
    ModelRenderer Rod2;
    ModelRenderer Rod1;
    ModelRenderer StaffPointTop1;
    ModelRenderer StaffPointTop2;
    ModelRenderer StaffPointTop3;
    ModelRenderer StaffPointTop4;
    ModelRenderer StaffPoint1;
    ModelRenderer StaffPoint2;
    ModelRenderer StaffPoint3;
    ModelRenderer StaffPoint4;
    ModelRenderer Shape1;

    public ModelTrainingStaff() {
        textureWidth = 64;
        textureHeight = 32;

        Staffbody = new ModelRenderer(this, 0, 0);
        Staffbody.addBox(0F, 0F, 0F, 1, 24, 1);
        Staffbody.setRotationPoint(0F, 0F, 0F);
        Staffbody.setTextureSize(64, 32);
        Staffbody.mirror = true;
        setRotation(Staffbody, 0F, 0F, 0F);
        Rod2 = new ModelRenderer(this, 0, 25);
        Rod2.addBox(0F, 0F, 0F, 1, 1, 3);
        Rod2.setRotationPoint(0F, 1F, -1F);
        Rod2.setTextureSize(64, 32);
        Rod2.mirror = true;
        setRotation(Rod2, 0F, 0F, 0F);
        Rod1 = new ModelRenderer(this, 0, 25);
        Rod1.addBox(0F, 0F, 0F, 3, 1, 1);
        Rod1.setRotationPoint(-1F, 1F, 0F);
        Rod1.setTextureSize(64, 32);
        Rod1.mirror = true;
        setRotation(Rod1, 0F, 0F, 0F);
        StaffPointTop1 = new ModelRenderer(this, 4, 5);
        StaffPointTop1.addBox(0F, 0F, 0F, 1, 3, 1);
        StaffPointTop1.setRotationPoint(1.5F, -3F, -1.5F);
        StaffPointTop1.setTextureSize(64, 32);
        StaffPointTop1.mirror = true;
        setRotation(StaffPointTop1, 0F, 0F, 0F);
        StaffPointTop2 = new ModelRenderer(this, 4, 5);
        StaffPointTop2.addBox(0F, 0F, 0F, 1, 3, 1);
        StaffPointTop2.setRotationPoint(1.5F, -3F, 1.5F);
        StaffPointTop2.setTextureSize(64, 32);
        StaffPointTop2.mirror = true;
        setRotation(StaffPointTop2, 0F, 0F, 0F);
        StaffPointTop3 = new ModelRenderer(this, 4, 5);
        StaffPointTop3.addBox(0F, 0F, 0F, 1, 3, 1);
        StaffPointTop3.setRotationPoint(-1.5F, -3F, 1.5F);
        StaffPointTop3.setTextureSize(64, 32);
        StaffPointTop3.mirror = true;
        setRotation(StaffPointTop3, 0F, 0F, 0F);
        StaffPointTop4 = new ModelRenderer(this, 4, 5);
        StaffPointTop4.addBox(0F, 0F, 0F, 1, 3, 1);
        StaffPointTop4.setRotationPoint(-1.5F, -3F, -1.5F);
        StaffPointTop4.setTextureSize(64, 32);
        StaffPointTop4.mirror = true;
        setRotation(StaffPointTop4, 0F, 0F, 0F);
        StaffPoint1 = new ModelRenderer(this, 4, 0);
        StaffPoint1.addBox(0F, 0F, 0F, 1, 2, 1);
        StaffPoint1.setRotationPoint(-1F, -1F, -1F);
        StaffPoint1.setTextureSize(64, 32);
        StaffPoint1.mirror = true;
        setRotation(StaffPoint1, 0F, 0F, 0F);
        StaffPoint2 = new ModelRenderer(this, 4, 0);
        StaffPoint2.addBox(0F, 0F, 0F, 1, 2, 1);
        StaffPoint2.setRotationPoint(1F, -1F, -1F);
        StaffPoint2.setTextureSize(64, 32);
        StaffPoint2.mirror = true;
        setRotation(StaffPoint2, 0F, 0F, 0F);
        StaffPoint3 = new ModelRenderer(this, 4, 0);
        StaffPoint3.addBox(0F, 0F, 0F, 1, 2, 1);
        StaffPoint3.setRotationPoint(1F, -1F, 1F);
        StaffPoint3.setTextureSize(64, 32);
        StaffPoint3.mirror = true;
        setRotation(StaffPoint3, 0F, 0F, 0F);
        StaffPoint4 = new ModelRenderer(this, 4, 0);
        StaffPoint4.addBox(0F, 0F, 0F, 1, 2, 1);
        StaffPoint4.setRotationPoint(-1F, -1F, 1F);
        StaffPoint4.setTextureSize(64, 32);
        StaffPoint4.mirror = true;
        setRotation(StaffPoint4, 0F, 0F, 0F);
        Shape1 = new ModelRenderer(this, 4, 10);
        Shape1.addBox(0F, 0F, 0F, 2, 2, 2);
        Shape1.setRotationPoint(-0.5F, -4F, -0.5F);
        Shape1.setTextureSize(64, 32);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3,
            float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        Staffbody.render(f5);
        Rod2.render(f5);
        Rod1.render(f5);
        StaffPointTop1.render(f5);
        StaffPointTop2.render(f5);
        StaffPointTop3.render(f5);
        StaffPointTop4.render(f5);
        StaffPoint1.render(f5);
        StaffPoint2.render(f5);
        StaffPoint3.render(f5);
        StaffPoint4.render(f5);
        Shape1.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3,
            float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

}
