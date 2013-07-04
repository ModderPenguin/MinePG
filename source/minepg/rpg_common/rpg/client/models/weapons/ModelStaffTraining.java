package rpg.client.models.weapons;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelStaffTraining extends ModelBase {

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

    public ModelStaffTraining() {
        this.textureWidth = 64;
        this.textureHeight = 32;

        this.Staffbody = new ModelRenderer(this, 0, 0);
        this.Staffbody.addBox(0F, 0F, 0F, 1, 24, 1);
        this.Staffbody.setRotationPoint(0F, 0F, 0F);
        this.Staffbody.setTextureSize(64, 32);
        this.Staffbody.mirror = true;
        this.setRotation(this.Staffbody, 0F, 0F, 0F);
        this.Rod2 = new ModelRenderer(this, 0, 25);
        this.Rod2.addBox(0F, 0F, 0F, 1, 1, 3);
        this.Rod2.setRotationPoint(0F, 1F, -1F);
        this.Rod2.setTextureSize(64, 32);
        this.Rod2.mirror = true;
        this.setRotation(this.Rod2, 0F, 0F, 0F);
        this.Rod1 = new ModelRenderer(this, 0, 25);
        this.Rod1.addBox(0F, 0F, 0F, 3, 1, 1);
        this.Rod1.setRotationPoint(-1F, 1F, 0F);
        this.Rod1.setTextureSize(64, 32);
        this.Rod1.mirror = true;
        this.setRotation(this.Rod1, 0F, 0F, 0F);
        this.StaffPointTop1 = new ModelRenderer(this, 4, 5);
        this.StaffPointTop1.addBox(0F, 0F, 0F, 1, 3, 1);
        this.StaffPointTop1.setRotationPoint(1.5F, -3F, -1.5F);
        this.StaffPointTop1.setTextureSize(64, 32);
        this.StaffPointTop1.mirror = true;
        this.setRotation(this.StaffPointTop1, 0F, 0F, 0F);
        this.StaffPointTop2 = new ModelRenderer(this, 4, 5);
        this.StaffPointTop2.addBox(0F, 0F, 0F, 1, 3, 1);
        this.StaffPointTop2.setRotationPoint(1.5F, -3F, 1.5F);
        this.StaffPointTop2.setTextureSize(64, 32);
        this.StaffPointTop2.mirror = true;
        this.setRotation(this.StaffPointTop2, 0F, 0F, 0F);
        this.StaffPointTop3 = new ModelRenderer(this, 4, 5);
        this.StaffPointTop3.addBox(0F, 0F, 0F, 1, 3, 1);
        this.StaffPointTop3.setRotationPoint(-1.5F, -3F, 1.5F);
        this.StaffPointTop3.setTextureSize(64, 32);
        this.StaffPointTop3.mirror = true;
        this.setRotation(this.StaffPointTop3, 0F, 0F, 0F);
        this.StaffPointTop4 = new ModelRenderer(this, 4, 5);
        this.StaffPointTop4.addBox(0F, 0F, 0F, 1, 3, 1);
        this.StaffPointTop4.setRotationPoint(-1.5F, -3F, -1.5F);
        this.StaffPointTop4.setTextureSize(64, 32);
        this.StaffPointTop4.mirror = true;
        this.setRotation(this.StaffPointTop4, 0F, 0F, 0F);
        this.StaffPoint1 = new ModelRenderer(this, 4, 0);
        this.StaffPoint1.addBox(0F, 0F, 0F, 1, 2, 1);
        this.StaffPoint1.setRotationPoint(-1F, -1F, -1F);
        this.StaffPoint1.setTextureSize(64, 32);
        this.StaffPoint1.mirror = true;
        this.setRotation(this.StaffPoint1, 0F, 0F, 0F);
        this.StaffPoint2 = new ModelRenderer(this, 4, 0);
        this.StaffPoint2.addBox(0F, 0F, 0F, 1, 2, 1);
        this.StaffPoint2.setRotationPoint(1F, -1F, -1F);
        this.StaffPoint2.setTextureSize(64, 32);
        this.StaffPoint2.mirror = true;
        this.setRotation(this.StaffPoint2, 0F, 0F, 0F);
        this.StaffPoint3 = new ModelRenderer(this, 4, 0);
        this.StaffPoint3.addBox(0F, 0F, 0F, 1, 2, 1);
        this.StaffPoint3.setRotationPoint(1F, -1F, 1F);
        this.StaffPoint3.setTextureSize(64, 32);
        this.StaffPoint3.mirror = true;
        this.setRotation(this.StaffPoint3, 0F, 0F, 0F);
        this.StaffPoint4 = new ModelRenderer(this, 4, 0);
        this.StaffPoint4.addBox(0F, 0F, 0F, 1, 2, 1);
        this.StaffPoint4.setRotationPoint(-1F, -1F, 1F);
        this.StaffPoint4.setTextureSize(64, 32);
        this.StaffPoint4.mirror = true;
        this.setRotation(this.StaffPoint4, 0F, 0F, 0F);
        this.Shape1 = new ModelRenderer(this, 4, 10);
        this.Shape1.addBox(0F, 0F, 0F, 2, 2, 2);
        this.Shape1.setRotationPoint(-0.5F, -4F, -0.5F);
        this.Shape1.setTextureSize(64, 32);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0F, 0F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Staffbody.render(f5);
        this.Rod2.render(f5);
        this.Rod1.render(f5);
        this.StaffPointTop1.render(f5);
        this.StaffPointTop2.render(f5);
        this.StaffPointTop3.render(f5);
        this.StaffPointTop4.render(f5);
        this.StaffPoint1.render(f5);
        this.StaffPoint2.render(f5);
        this.StaffPoint3.render(f5);
        this.StaffPoint4.render(f5);
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
