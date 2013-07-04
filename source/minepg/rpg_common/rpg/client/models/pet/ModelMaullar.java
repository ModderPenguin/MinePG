package rpg.client.models.pet;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelMaullar extends ModelBase {

    // fields
    ModelRenderer MEW;
    ModelRenderer HEADBASE;
    ModelRenderer LEFTLEG;
    ModelRenderer RIGHTLEG;
    ModelRenderer TAILBASE;
    ModelRenderer TAILSEG1;
    ModelRenderer TAILSEG2;
    ModelRenderer TAILSEG3;
    ModelRenderer TAILSEG4;
    ModelRenderer TAILSEG5;
    ModelRenderer TAILTIP;

    public ModelMaullar() {
        this.textureWidth = 64;
        this.textureHeight = 32;

        this.MEW = new ModelRenderer(this, "MEW");
        this.MEW.setRotationPoint(0F, 0F, 0F);
        this.setRotation(this.MEW, 0F, 0F, 0F);
        this.MEW.mirror = true;
        ModelRenderer Neck = new ModelRenderer(this, 0, 11);
        Neck.addBox(-1F, -1F, -1.5F, 2, 1, 3);
        Neck.setRotationPoint(0F, 12F, 0F);
        Neck.setTextureSize(64, 32);
        Neck.mirror = true;
        this.setRotation(Neck, 0F, 0F, 0F);
        ModelRenderer Torso = new ModelRenderer(this, 0, 19);
        Torso.addBox(-1.5F, -3F, -1.5F, 3, 3, 3);
        Torso.setRotationPoint(0F, 14.7F, 0.1F);
        Torso.setTextureSize(64, 32);
        Torso.mirror = true;
        this.setRotation(Torso, 0F, 0F, 0F);
        ModelRenderer Belly = new ModelRenderer(this, 0, 15);
        Belly.addBox(-1.5F, -1.5F, -1F, 3, 3, 1);
        Belly.setRotationPoint(0F, 13.3F, -0.8F);
        Belly.setTextureSize(64, 32);
        Belly.mirror = true;
        this.setRotation(Belly, -0.0523599F, 0F, 0F);
        ModelRenderer BodyBottom = new ModelRenderer(this, 0, 25);
        BodyBottom.addBox(-2F, -1.5F, -2F, 4, 3, 4);
        BodyBottom.setRotationPoint(0F, 16F, 0F);
        BodyBottom.setTextureSize(64, 32);
        BodyBottom.mirror = true;
        this.setRotation(BodyBottom, 0.0872665F, 0F, 0F);
        ModelRenderer Bottom = new ModelRenderer(this, 0, 7);
        Bottom.addBox(-1F, 0F, -1.5F, 2, 1, 3);
        Bottom.setRotationPoint(0F, 16.9F, 0F);
        Bottom.setTextureSize(64, 32);
        Bottom.mirror = true;
        this.setRotation(Bottom, 0.0872665F, 0F, 0F);
        ModelRenderer ArmR = new ModelRenderer(this, 16, 22);
        ArmR.addBox(-0.5F, 0F, -0.5F, 1, 3, 1);
        ArmR.setRotationPoint(-1.1F, 12.1F, -1F);
        ArmR.setTextureSize(64, 32);
        ArmR.mirror = true;
        this.setRotation(ArmR, -0.5585054F, -0.0523599F, 0F);
        ModelRenderer ArmL = new ModelRenderer(this, 16, 22);
        ArmL.addBox(-0.5F, 0F, -0.5F, 1, 3, 1);
        ArmL.setRotationPoint(1.1F, 12.1F, -1F);
        ArmL.setTextureSize(64, 32);
        ArmL.mirror = true;
        this.setRotation(ArmL, -0.5585054F, 0.0523599F, 0F);

        this.MEW.addChild(Neck);
        this.MEW.addChild(Torso);
        this.MEW.addChild(Belly);
        this.MEW.addChild(BodyBottom);
        this.MEW.addChild(Bottom);
        this.MEW.addChild(ArmR);
        this.MEW.addChild(ArmL);

        this.HEADBASE = new ModelRenderer(this, "HEADBASE");
        this.HEADBASE.setRotationPoint(0F, 11.1F, 0.1F);
        this.setRotation(this.HEADBASE, 0F, 0F, 0F);
        this.HEADBASE.mirror = true;
        ModelRenderer Cheeks = new ModelRenderer(this, 24, 22);
        Cheeks.addBox(-2.5F, -2F, -1F, 5, 2, 2);
        Cheeks.setRotationPoint(0F, -0.1F, 0.2F);
        Cheeks.setTextureSize(64, 32);
        Cheeks.mirror = true;
        this.setRotation(Cheeks, 0F, 0F, 0F);
        ModelRenderer InnerCheeks = new ModelRenderer(this, 24, 15);
        InnerCheeks.addBox(-1.5F, -0.5F, -1F, 3, 1, 1);
        InnerCheeks.setRotationPoint(0F, -0.6F, -1F);
        InnerCheeks.setTextureSize(64, 32);
        InnerCheeks.mirror = true;
        this.setRotation(InnerCheeks, 0F, 0F, 0F);
        ModelRenderer EarR = new ModelRenderer(this, 24, 12);
        EarR.addBox(-1F, -2F, -0.5F, 1, 2, 1);
        EarR.setRotationPoint(-1.2F, -1.8F, 0.3F);
        EarR.setTextureSize(64, 32);
        EarR.mirror = true;
        this.setRotation(EarR, 0F, 0.2792527F, -0.3490659F);
        ModelRenderer EarL = new ModelRenderer(this, 24, 12);
        EarL.addBox(0F, -2F, -0.5F, 1, 2, 1);
        EarL.setRotationPoint(1.2F, -1.8F, 0.3F);
        EarL.setTextureSize(64, 32);
        EarL.mirror = true;
        this.setRotation(EarL, 0F, -0.2792527F, 0.3490659F);
        ModelRenderer Nose = new ModelRenderer(this, 24, 17);
        Nose.addBox(-1F, -0.5F, -1F, 2, 1, 1);
        Nose.setRotationPoint(0F, -0.6F, -1.4F);
        Nose.setTextureSize(64, 32);
        Nose.mirror = true;
        this.setRotation(Nose, 0F, 0F, 0F);
        ModelRenderer NoseBridge = new ModelRenderer(this, 24, 17);
        NoseBridge.addBox(-1F, -0.5F, -1F, 2, 1, 1);
        NoseBridge.setRotationPoint(0F, -1.1F, -1F);
        NoseBridge.setTextureSize(64, 32);
        NoseBridge.mirror = true;
        this.setRotation(NoseBridge, 0F, 0F, 0F);
        ModelRenderer Head = new ModelRenderer(this, 26, 26);
        Head.addBox(-2F, -3F, -1.5F, 4, 3, 3);
        Head.setRotationPoint(0F, 0F, 0F);
        Head.setTextureSize(64, 32);
        Head.mirror = true;
        this.setRotation(Head, 0F, 0F, 0F);
        ModelRenderer HeadTop = new ModelRenderer(this, 24, 19);
        HeadTop.addBox(-1.5F, -1F, -1F, 3, 1, 2);
        HeadTop.setRotationPoint(0F, -2.6F, 0.1F);
        HeadTop.setTextureSize(64, 32);
        HeadTop.mirror = true;
        this.setRotation(HeadTop, 0F, 0F, 0F);

        this.HEADBASE.addChild(Cheeks);
        this.HEADBASE.addChild(InnerCheeks);
        this.HEADBASE.addChild(EarR);
        this.HEADBASE.addChild(EarL);
        this.HEADBASE.addChild(Nose);
        this.HEADBASE.addChild(NoseBridge);
        this.HEADBASE.addChild(Head);
        this.HEADBASE.addChild(HeadTop);
        this.MEW.addChild(this.HEADBASE);

        this.LEFTLEG = new ModelRenderer(this, "LEFTLEG");
        this.LEFTLEG.setRotationPoint(1F, 15.5F, 0.5F);
        this.setRotation(this.LEFTLEG, 0F, 0F, 0F);
        this.LEFTLEG.mirror = true;
        ModelRenderer FootL = new ModelRenderer(this, 16, 16);
        FootL.addBox(-1F, -0.5F, 0F, 2, 5, 1);
        FootL.setRotationPoint(1.1F, 3.3F, -0.5F);
        FootL.setTextureSize(64, 32);
        FootL.mirror = true;
        this.setRotation(FootL, -0.5934119F, -0.1745329F, 0F);
        ModelRenderer LegL = new ModelRenderer(this, 20, 23);
        LegL.addBox(-0.5F, -0.5F, -1F, 1, 2, 1);
        LegL.setRotationPoint(1.1F, 2.4F, -0.3F);
        LegL.setTextureSize(64, 32);
        LegL.mirror = true;
        this.setRotation(LegL, 0.2268928F, -0.1745329F, 0F);
        ModelRenderer HipL = new ModelRenderer(this, 16, 26);
        HipL.addBox(0F, -0.7F, -2.5F, 2, 3, 3);
        HipL.setRotationPoint(0F, 0F, 0F);
        HipL.setTextureSize(64, 32);
        HipL.mirror = true;
        this.setRotation(HipL, 0.5235988F, -0.1745329F, 0F);

        this.LEFTLEG.addChild(FootL);
        this.LEFTLEG.addChild(LegL);
        this.LEFTLEG.addChild(HipL);
        this.MEW.addChild(this.LEFTLEG);

        this.RIGHTLEG = new ModelRenderer(this, "RIGHTLEG");
        this.RIGHTLEG.setRotationPoint(-1F, 15.5F, 0.5F);
        this.setRotation(this.RIGHTLEG, 0F, 0F, 0F);
        this.RIGHTLEG.mirror = true;
        ModelRenderer FootR = new ModelRenderer(this, 16, 16);
        FootR.addBox(-1F, -0.5F, 0F, 2, 5, 1);
        FootR.setRotationPoint(-1.1F, 3.3F, -0.5F);
        FootR.setTextureSize(64, 32);
        FootR.mirror = true;
        this.setRotation(FootR, -0.5934119F, 0.1745329F, 0F);
        ModelRenderer LegR = new ModelRenderer(this, 20, 23);
        LegR.addBox(-0.5F, -0.5F, -1F, 1, 2, 1);
        LegR.setRotationPoint(-1.1F, 2.4F, -0.3F);
        LegR.setTextureSize(64, 32);
        LegR.mirror = true;
        this.setRotation(LegR, 0.2268928F, 0.1745329F, 0F);
        ModelRenderer HipR = new ModelRenderer(this, 16, 26);
        HipR.addBox(-2F, -0.7F, -2.5F, 2, 3, 3);
        HipR.setRotationPoint(0F, 0F, 0F);
        HipR.setTextureSize(64, 32);
        HipR.mirror = true;
        this.setRotation(HipR, 0.5235988F, 0.1745329F, 0F);

        this.RIGHTLEG.addChild(FootR);
        this.RIGHTLEG.addChild(LegR);
        this.RIGHTLEG.addChild(HipR);
        this.MEW.addChild(this.RIGHTLEG);

        this.TAILBASE = new ModelRenderer(this, "TAILBASE");
        this.TAILBASE.setRotationPoint(0F, 16F, 1.5F);
        this.setRotation(this.TAILBASE, 0F, 0F, 0F);
        this.TAILBASE.mirror = true;
        ModelRenderer TailBase = new ModelRenderer(this, 0, 2);
        TailBase.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
        TailBase.setRotationPoint(0F, 0F, 0F);
        TailBase.setTextureSize(64, 32);
        TailBase.mirror = true;
        this.setRotation(TailBase, 0.7853982F, 0F, 0F);

        this.TAILBASE.addChild(TailBase);
        this.MEW.addChild(this.TAILBASE);

        this.TAILSEG1 = new ModelRenderer(this, "TAILSEG1");
        this.TAILSEG1.setRotationPoint(0F, 2.7F, 2.5F);
        this.setRotation(this.TAILSEG1, 0F, 0F, 0F);
        this.TAILSEG1.mirror = true;
        ModelRenderer TailSeg1 = new ModelRenderer(this, 0, 2);
        TailSeg1.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
        TailSeg1.setRotationPoint(0F, 0F, 0F);
        TailSeg1.setTextureSize(64, 32);
        TailSeg1.mirror = true;
        this.setRotation(TailSeg1, 1.570796F, 0F, 0F);

        this.TAILSEG1.addChild(TailSeg1);
        this.TAILBASE.addChild(this.TAILSEG1);

        this.TAILSEG2 = new ModelRenderer(this, "TAILSEG2");
        this.TAILSEG2.setRotationPoint(0F, 0.2F, 3.6F);
        this.setRotation(this.TAILSEG2, 0F, 0F, 0F);
        this.TAILSEG2.mirror = true;
        ModelRenderer TailSeg2 = new ModelRenderer(this, 0, 2);
        TailSeg2.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
        TailSeg2.setRotationPoint(0F, 0F, 0F);
        TailSeg2.setTextureSize(64, 32);
        TailSeg2.mirror = true;
        this.setRotation(TailSeg2, 2.373648F, 0F, 0F);

        this.TAILSEG2.addChild(TailSeg2);
        this.TAILSEG1.addChild(this.TAILSEG2);

        this.TAILSEG3 = new ModelRenderer(this, "TAILSEG3");
        this.TAILSEG3.setRotationPoint(0F, -2.5F, 2.7F);
        this.setRotation(this.TAILSEG3, 0F, 0F, 0F);
        this.TAILSEG3.mirror = true;
        ModelRenderer TailSeg3 = new ModelRenderer(this, 4, 3);
        TailSeg3.addBox(-0.5F, 0F, -0.5F, 1, 3, 1);
        TailSeg3.setRotationPoint(0F, 0F, 0F);
        TailSeg3.setTextureSize(64, 32);
        TailSeg3.mirror = true;
        this.setRotation(TailSeg3, -3.124139F, 0F, 0F);

        this.TAILSEG3.addChild(TailSeg3);
        this.TAILSEG2.addChild(this.TAILSEG3);

        this.TAILSEG4 = new ModelRenderer(this, "TAILSEG4");
        this.TAILSEG4.setRotationPoint(0F, -2.7F, 0F);
        this.setRotation(this.TAILSEG4, 0F, 0F, 0F);
        this.TAILSEG4.mirror = true;
        ModelRenderer TailSeg4 = new ModelRenderer(this, 4, 3);
        TailSeg4.addBox(-0.5F, 0F, -0.5F, 1, 3, 1);
        TailSeg4.setRotationPoint(0F, 0F, 0F);
        TailSeg4.setTextureSize(64, 32);
        TailSeg4.mirror = true;
        this.setRotation(TailSeg4, -2.513274F, 0F, 0F);

        this.TAILSEG4.addChild(TailSeg4);
        this.TAILSEG3.addChild(this.TAILSEG4);

        this.TAILSEG5 = new ModelRenderer(this, "TAILSEG5");
        this.TAILSEG5.setRotationPoint(0F, -2.1F, -1.7F);
        this.setRotation(this.TAILSEG5, 0F, 0F, 0F);
        this.TAILSEG5.mirror = true;
        ModelRenderer TailSeg5 = new ModelRenderer(this, 4, 3);
        TailSeg5.addBox(-0.5F, 0F, -0.5F, 1, 3, 1);
        TailSeg5.setRotationPoint(0F, 0F, 0F);
        TailSeg5.setTextureSize(64, 32);
        TailSeg5.mirror = true;
        this.setRotation(TailSeg5, 3.089233F, 0F, 0F);

        this.TAILSEG5.addChild(TailSeg5);
        this.TAILSEG4.addChild(this.TAILSEG5);

        this.TAILTIP = new ModelRenderer(this, "TAILTIP");
        this.TAILTIP.setRotationPoint(0F, -2.6F, 0F);
        this.setRotation(this.TAILTIP, 0F, 0F, 0F);
        this.TAILTIP.mirror = true;
        ModelRenderer TailTip = new ModelRenderer(this, 0, 2);
        TailTip.addBox(-0.5F, -1.5F, 0F, 1, 3, 1);
        TailTip.setRotationPoint(0F, -0.9F, 1.4F);
        TailTip.setTextureSize(64, 32);
        TailTip.mirror = true;
        this.setRotation(TailTip, -1.291544F, 0F, 0F);
        ModelRenderer TailSeg7 = new ModelRenderer(this, 8, 4);
        TailSeg7.addBox(-0.5F, 0F, -0.5F, 1, 2, 1);
        TailSeg7.setRotationPoint(0F, -1.1F, 1.2F);
        TailSeg7.setTextureSize(64, 32);
        TailSeg7.mirror = true;
        this.setRotation(TailSeg7, 1.448623F, 0F, 0F);
        ModelRenderer TailSeg6 = new ModelRenderer(this, 8, 4);
        TailSeg6.addBox(-0.5F, 0F, -0.5F, 1, 2, 1);
        TailSeg6.setRotationPoint(0F, 0F, 0F);
        TailSeg6.setTextureSize(64, 32);
        TailSeg6.mirror = true;
        this.setRotation(TailSeg6, 2.234021F, 0F, 0F);

        this.TAILTIP.addChild(TailTip);
        this.TAILTIP.addChild(TailSeg6);
        this.TAILTIP.addChild(TailSeg7);
        this.TAILSEG5.addChild(this.TAILTIP);

    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.MEW.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        this.HEADBASE.rotateAngleY = f3 / (180F / (float) Math.PI);
        this.HEADBASE.rotateAngleX = f4 / (180F / (float) Math.PI);
        this.MEW.rotationPointY = MathHelper.cos(f2 * .2F) * 1.5F;
        this.RIGHTLEG.rotateAngleX = MathHelper.cos(f2 * .2F + (float) Math.PI) * .2F + .1F;
        this.LEFTLEG.rotateAngleX = MathHelper.cos(f2 * .2F + (float) Math.PI + .5F) * .2F + .1F;
        this.TAILBASE.rotateAngleX = MathHelper.cos(f2 * .2F) * .2F;
        this.TAILBASE.rotateAngleY = MathHelper.cos(f2 * .1F) * 1F;
        this.TAILSEG1.rotateAngleY = MathHelper.cos(f2 * .1F + 4F);
        this.TAILSEG2.rotateAngleY = MathHelper.cos(f2 * .1F + 5F);
        this.TAILSEG3.rotateAngleZ = MathHelper.cos(f2 * .1F + 3.6F) * .5F;
        this.TAILSEG4.rotateAngleY = MathHelper.cos(f2 * .1F + 8.7F);
        this.TAILSEG4.rotateAngleZ = MathHelper.cos(f2 * .1F + 8.7F) * .5F;
        this.TAILSEG5.rotateAngleZ = MathHelper.cos(f2 * .1F + 10.7F) * .5F;
        this.TAILSEG5.rotateAngleY = MathHelper.cos(f2 * .1F + 9.5F) * .5F;
        this.TAILTIP.rotateAngleY = MathHelper.cos(f2 * .1F + 4.2F) * 1.2F;
        this.TAILTIP.rotateAngleZ = MathHelper.cos(f2 * .1F + 12.6F) * .5F;
        this.TAILTIP.rotateAngleX = MathHelper.cos(f2 * .2F + 12.6F) * .6F;
    }
}