package rpg.client.models.projectiles;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelStaffBolt extends ModelBase {

    // fields
    ModelRenderer BoltBody;
    ModelRenderer BoltPointBack;
    ModelRenderer BoltPointBottom;
    ModelRenderer BoltPointRight;
    ModelRenderer BoltPointLeft;
    ModelRenderer BoltPointFront;
    ModelRenderer BoltPointTop;

    public ModelStaffBolt() {
        this.textureWidth = 64;
        this.textureHeight = 32;

        this.BoltBody = new ModelRenderer(this, 0, 0);
        this.BoltBody.addBox(0F, 0F, 0F, 3, 3, 3);
        this.BoltBody.setRotationPoint(-1F, 12F, -1F);
        this.BoltBody.setTextureSize(64, 32);
        this.BoltBody.mirror = true;
        this.setRotation(this.BoltBody, 0F, 0F, 0F);
        this.BoltPointBack = new ModelRenderer(this, 12, 0);
        this.BoltPointBack.addBox(0F, 0F, 0F, 1, 1, 1);
        this.BoltPointBack.setRotationPoint(0F, 13F, 2F);
        this.BoltPointBack.setTextureSize(64, 32);
        this.BoltPointBack.mirror = true;
        this.setRotation(this.BoltPointBack, 0F, 0F, 0F);
        this.BoltPointBottom = new ModelRenderer(this, 12, 0);
        this.BoltPointBottom.addBox(0F, 0F, 0F, 1, 1, 1);
        this.BoltPointBottom.setRotationPoint(0F, 15F, 0F);
        this.BoltPointBottom.setTextureSize(64, 32);
        this.BoltPointBottom.mirror = true;
        this.setRotation(this.BoltPointBottom, 0F, 0F, 0F);
        this.BoltPointRight = new ModelRenderer(this, 12, 0);
        this.BoltPointRight.addBox(0F, 0F, 0F, 1, 1, 1);
        this.BoltPointRight.setRotationPoint(2F, 13F, 0F);
        this.BoltPointRight.setTextureSize(64, 32);
        this.BoltPointRight.mirror = true;
        this.setRotation(this.BoltPointRight, 0F, 0F, 0F);
        this.BoltPointLeft = new ModelRenderer(this, 12, 0);
        this.BoltPointLeft.addBox(0F, 0F, 0F, 1, 1, 1);
        this.BoltPointLeft.setRotationPoint(-2F, 13F, 0F);
        this.BoltPointLeft.setTextureSize(64, 32);
        this.BoltPointLeft.mirror = true;
        this.setRotation(this.BoltPointLeft, 0F, 0F, 0F);
        this.BoltPointFront = new ModelRenderer(this, 12, 0);
        this.BoltPointFront.addBox(0F, 0F, 0F, 1, 1, 1);
        this.BoltPointFront.setRotationPoint(0F, 13F, -2F);
        this.BoltPointFront.setTextureSize(64, 32);
        this.BoltPointFront.mirror = true;
        this.setRotation(this.BoltPointFront, 0F, 0F, 0F);
        this.BoltPointTop = new ModelRenderer(this, 12, 0);
        this.BoltPointTop.addBox(0F, 0F, 0F, 1, 1, 1);
        this.BoltPointTop.setRotationPoint(0F, 11F, 0F);
        this.BoltPointTop.setTextureSize(64, 32);
        this.BoltPointTop.mirror = true;
        this.setRotation(this.BoltPointTop, 0F, 0F, 0F);
    }

    @Override
    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        super.render(par1Entity, par2, par3, par4, par5, par6, par7);
        this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
        this.BoltBody.render(par7);
        this.BoltPointBack.render(par7);
        this.BoltPointBottom.render(par7);
        this.BoltPointRight.render(par7);
        this.BoltPointLeft.render(par7);
        this.BoltPointFront.render(par7);
        this.BoltPointTop.render(par7);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
        super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
    }
}
