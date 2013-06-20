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
        textureWidth = 64;
        textureHeight = 32;

        MEW = new ModelRenderer(this, "MEW");
        MEW.setRotationPoint(0F, 0F, 0F);
        setRotation(MEW, 0F, 0F, 0F);
        MEW.mirror = true;
        ModelRenderer Neck = new ModelRenderer(this, 0, 11);
        Neck.addBox(-1F, -1F, -1.5F, 2, 1, 3);
        Neck.setRotationPoint(0F, 12F, 0F);
        Neck.setTextureSize(64, 32);
        Neck.mirror = true;
        setRotation(Neck, 0F, 0F, 0F);
        ModelRenderer Torso = new ModelRenderer(this, 0, 19);
        Torso.addBox(-1.5F, -3F, -1.5F, 3, 3, 3);
        Torso.setRotationPoint(0F, 14.7F, 0.1F);
        Torso.setTextureSize(64, 32);
        Torso.mirror = true;
        setRotation(Torso, 0F, 0F, 0F);
        ModelRenderer Belly = new ModelRenderer(this, 0, 15);
        Belly.addBox(-1.5F, -1.5F, -1F, 3, 3, 1);
        Belly.setRotationPoint(0F, 13.3F, -0.8F);
        Belly.setTextureSize(64, 32);
        Belly.mirror = true;
        setRotation(Belly, -0.0523599F, 0F, 0F);
        ModelRenderer BodyBottom = new ModelRenderer(this, 0, 25);
        BodyBottom.addBox(-2F, -1.5F, -2F, 4, 3, 4);
        BodyBottom.setRotationPoint(0F, 16F, 0F);
        BodyBottom.setTextureSize(64, 32);
        BodyBottom.mirror = true;
        setRotation(BodyBottom, 0.0872665F, 0F, 0F);
        ModelRenderer Bottom = new ModelRenderer(this, 0, 7);
        Bottom.addBox(-1F, 0F, -1.5F, 2, 1, 3);
        Bottom.setRotationPoint(0F, 16.9F, 0F);
        Bottom.setTextureSize(64, 32);
        Bottom.mirror = true;
        setRotation(Bottom, 0.0872665F, 0F, 0F);
        ModelRenderer ArmR = new ModelRenderer(this, 16, 22);
        ArmR.addBox(-0.5F, 0F, -0.5F, 1, 3, 1);
        ArmR.setRotationPoint(-1.1F, 12.1F, -1F);
        ArmR.setTextureSize(64, 32);
        ArmR.mirror = true;
        setRotation(ArmR, -0.5585054F, -0.0523599F, 0F);
        ModelRenderer ArmL = new ModelRenderer(this, 16, 22);
        ArmL.addBox(-0.5F, 0F, -0.5F, 1, 3, 1);
        ArmL.setRotationPoint(1.1F, 12.1F, -1F);
        ArmL.setTextureSize(64, 32);
        ArmL.mirror = true;
        setRotation(ArmL, -0.5585054F, 0.0523599F, 0F);

        MEW.addChild(Neck);
        MEW.addChild(Torso);
        MEW.addChild(Belly);
        MEW.addChild(BodyBottom);
        MEW.addChild(Bottom);
        MEW.addChild(ArmR);
        MEW.addChild(ArmL);

        HEADBASE = new ModelRenderer(this, "HEADBASE");
        HEADBASE.setRotationPoint(0F, 11.1F, 0.1F);
        setRotation(HEADBASE, 0F, 0F, 0F);
        HEADBASE.mirror = true;
        ModelRenderer Cheeks = new ModelRenderer(this, 24, 22);
        Cheeks.addBox(-2.5F, -2F, -1F, 5, 2, 2);
        Cheeks.setRotationPoint(0F, -0.1F, 0.2F);
        Cheeks.setTextureSize(64, 32);
        Cheeks.mirror = true;
        setRotation(Cheeks, 0F, 0F, 0F);
        ModelRenderer InnerCheeks = new ModelRenderer(this, 24, 15);
        InnerCheeks.addBox(-1.5F, -0.5F, -1F, 3, 1, 1);
        InnerCheeks.setRotationPoint(0F, -0.6F, -1F);
        InnerCheeks.setTextureSize(64, 32);
        InnerCheeks.mirror = true;
        setRotation(InnerCheeks, 0F, 0F, 0F);
        ModelRenderer EarR = new ModelRenderer(this, 24, 12);
        EarR.addBox(-1F, -2F, -0.5F, 1, 2, 1);
        EarR.setRotationPoint(-1.2F, -1.8F, 0.3F);
        EarR.setTextureSize(64, 32);
        EarR.mirror = true;
        setRotation(EarR, 0F, 0.2792527F, -0.3490659F);
        ModelRenderer EarL = new ModelRenderer(this, 24, 12);
        EarL.addBox(0F, -2F, -0.5F, 1, 2, 1);
        EarL.setRotationPoint(1.2F, -1.8F, 0.3F);
        EarL.setTextureSize(64, 32);
        EarL.mirror = true;
        setRotation(EarL, 0F, -0.2792527F, 0.3490659F);
        ModelRenderer Nose = new ModelRenderer(this, 24, 17);
        Nose.addBox(-1F, -0.5F, -1F, 2, 1, 1);
        Nose.setRotationPoint(0F, -0.6F, -1.4F);
        Nose.setTextureSize(64, 32);
        Nose.mirror = true;
        setRotation(Nose, 0F, 0F, 0F);
        ModelRenderer NoseBridge = new ModelRenderer(this, 24, 17);
        NoseBridge.addBox(-1F, -0.5F, -1F, 2, 1, 1);
        NoseBridge.setRotationPoint(0F, -1.1F, -1F);
        NoseBridge.setTextureSize(64, 32);
        NoseBridge.mirror = true;
        setRotation(NoseBridge, 0F, 0F, 0F);
        ModelRenderer Head = new ModelRenderer(this, 26, 26);
        Head.addBox(-2F, -3F, -1.5F, 4, 3, 3);
        Head.setRotationPoint(0F, 0F, 0F);
        Head.setTextureSize(64, 32);
        Head.mirror = true;
        setRotation(Head, 0F, 0F, 0F);
        ModelRenderer HeadTop = new ModelRenderer(this, 24, 19);
        HeadTop.addBox(-1.5F, -1F, -1F, 3, 1, 2);
        HeadTop.setRotationPoint(0F, -2.6F, 0.1F);
        HeadTop.setTextureSize(64, 32);
        HeadTop.mirror = true;
        setRotation(HeadTop, 0F, 0F, 0F);

        HEADBASE.addChild(Cheeks);
        HEADBASE.addChild(InnerCheeks);
        HEADBASE.addChild(EarR);
        HEADBASE.addChild(EarL);
        HEADBASE.addChild(Nose);
        HEADBASE.addChild(NoseBridge);
        HEADBASE.addChild(Head);
        HEADBASE.addChild(HeadTop);
        MEW.addChild(HEADBASE);

        LEFTLEG = new ModelRenderer(this, "LEFTLEG");
        LEFTLEG.setRotationPoint(1F, 15.5F, 0.5F);
        setRotation(LEFTLEG, 0F, 0F, 0F);
        LEFTLEG.mirror = true;
        ModelRenderer FootL = new ModelRenderer(this, 16, 16);
        FootL.addBox(-1F, -0.5F, 0F, 2, 5, 1);
        FootL.setRotationPoint(1.1F, 3.3F, -0.5F);
        FootL.setTextureSize(64, 32);
        FootL.mirror = true;
        setRotation(FootL, -0.5934119F, -0.1745329F, 0F);
        ModelRenderer LegL = new ModelRenderer(this, 20, 23);
        LegL.addBox(-0.5F, -0.5F, -1F, 1, 2, 1);
        LegL.setRotationPoint(1.1F, 2.4F, -0.3F);
        LegL.setTextureSize(64, 32);
        LegL.mirror = true;
        setRotation(LegL, 0.2268928F, -0.1745329F, 0F);
        ModelRenderer HipL = new ModelRenderer(this, 16, 26);
        HipL.addBox(0F, -0.7F, -2.5F, 2, 3, 3);
        HipL.setRotationPoint(0F, 0F, 0F);
        HipL.setTextureSize(64, 32);
        HipL.mirror = true;
        setRotation(HipL, 0.5235988F, -0.1745329F, 0F);

        LEFTLEG.addChild(FootL);
        LEFTLEG.addChild(LegL);
        LEFTLEG.addChild(HipL);
        MEW.addChild(LEFTLEG);

        RIGHTLEG = new ModelRenderer(this, "RIGHTLEG");
        RIGHTLEG.setRotationPoint(-1F, 15.5F, 0.5F);
        setRotation(RIGHTLEG, 0F, 0F, 0F);
        RIGHTLEG.mirror = true;
        ModelRenderer FootR = new ModelRenderer(this, 16, 16);
        FootR.addBox(-1F, -0.5F, 0F, 2, 5, 1);
        FootR.setRotationPoint(-1.1F, 3.3F, -0.5F);
        FootR.setTextureSize(64, 32);
        FootR.mirror = true;
        setRotation(FootR, -0.5934119F, 0.1745329F, 0F);
        ModelRenderer LegR = new ModelRenderer(this, 20, 23);
        LegR.addBox(-0.5F, -0.5F, -1F, 1, 2, 1);
        LegR.setRotationPoint(-1.1F, 2.4F, -0.3F);
        LegR.setTextureSize(64, 32);
        LegR.mirror = true;
        setRotation(LegR, 0.2268928F, 0.1745329F, 0F);
        ModelRenderer HipR = new ModelRenderer(this, 16, 26);
        HipR.addBox(-2F, -0.7F, -2.5F, 2, 3, 3);
        HipR.setRotationPoint(0F, 0F, 0F);
        HipR.setTextureSize(64, 32);
        HipR.mirror = true;
        setRotation(HipR, 0.5235988F, 0.1745329F, 0F);

        RIGHTLEG.addChild(FootR);
        RIGHTLEG.addChild(LegR);
        RIGHTLEG.addChild(HipR);
        MEW.addChild(RIGHTLEG);

        TAILBASE = new ModelRenderer(this, "TAILBASE");
        TAILBASE.setRotationPoint(0F, 16F, 1.5F);
        setRotation(TAILBASE, 0F, 0F, 0F);
        TAILBASE.mirror = true;
        ModelRenderer TailBase = new ModelRenderer(this, 0, 2);
        TailBase.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
        TailBase.setRotationPoint(0F, 0F, 0F);
        TailBase.setTextureSize(64, 32);
        TailBase.mirror = true;
        setRotation(TailBase, 0.7853982F, 0F, 0F);

        TAILBASE.addChild(TailBase);
        MEW.addChild(TAILBASE);

        TAILSEG1 = new ModelRenderer(this, "TAILSEG1");
        TAILSEG1.setRotationPoint(0F, 2.7F, 2.5F);
        setRotation(TAILSEG1, 0F, 0F, 0F);
        TAILSEG1.mirror = true;
        ModelRenderer TailSeg1 = new ModelRenderer(this, 0, 2);
        TailSeg1.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
        TailSeg1.setRotationPoint(0F, 0F, 0F);
        TailSeg1.setTextureSize(64, 32);
        TailSeg1.mirror = true;
        setRotation(TailSeg1, 1.570796F, 0F, 0F);

        TAILSEG1.addChild(TailSeg1);
        TAILBASE.addChild(TAILSEG1);

        TAILSEG2 = new ModelRenderer(this, "TAILSEG2");
        TAILSEG2.setRotationPoint(0F, 0.2F, 3.6F);
        setRotation(TAILSEG2, 0F, 0F, 0F);
        TAILSEG2.mirror = true;
        ModelRenderer TailSeg2 = new ModelRenderer(this, 0, 2);
        TailSeg2.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
        TailSeg2.setRotationPoint(0F, 0F, 0F);
        TailSeg2.setTextureSize(64, 32);
        TailSeg2.mirror = true;
        setRotation(TailSeg2, 2.373648F, 0F, 0F);

        TAILSEG2.addChild(TailSeg2);
        TAILSEG1.addChild(TAILSEG2);

        TAILSEG3 = new ModelRenderer(this, "TAILSEG3");
        TAILSEG3.setRotationPoint(0F, -2.5F, 2.7F);
        setRotation(TAILSEG3, 0F, 0F, 0F);
        TAILSEG3.mirror = true;
        ModelRenderer TailSeg3 = new ModelRenderer(this, 4, 3);
        TailSeg3.addBox(-0.5F, 0F, -0.5F, 1, 3, 1);
        TailSeg3.setRotationPoint(0F, 0F, 0F);
        TailSeg3.setTextureSize(64, 32);
        TailSeg3.mirror = true;
        setRotation(TailSeg3, -3.124139F, 0F, 0F);

        TAILSEG3.addChild(TailSeg3);
        TAILSEG2.addChild(TAILSEG3);

        TAILSEG4 = new ModelRenderer(this, "TAILSEG4");
        TAILSEG4.setRotationPoint(0F, -2.7F, 0F);
        setRotation(TAILSEG4, 0F, 0F, 0F);
        TAILSEG4.mirror = true;
        ModelRenderer TailSeg4 = new ModelRenderer(this, 4, 3);
        TailSeg4.addBox(-0.5F, 0F, -0.5F, 1, 3, 1);
        TailSeg4.setRotationPoint(0F, 0F, 0F);
        TailSeg4.setTextureSize(64, 32);
        TailSeg4.mirror = true;
        setRotation(TailSeg4, -2.513274F, 0F, 0F);

        TAILSEG4.addChild(TailSeg4);
        TAILSEG3.addChild(TAILSEG4);

        TAILSEG5 = new ModelRenderer(this, "TAILSEG5");
        TAILSEG5.setRotationPoint(0F, -2.1F, -1.7F);
        setRotation(TAILSEG5, 0F, 0F, 0F);
        TAILSEG5.mirror = true;
        ModelRenderer TailSeg5 = new ModelRenderer(this, 4, 3);
        TailSeg5.addBox(-0.5F, 0F, -0.5F, 1, 3, 1);
        TailSeg5.setRotationPoint(0F, 0F, 0F);
        TailSeg5.setTextureSize(64, 32);
        TailSeg5.mirror = true;
        setRotation(TailSeg5, 3.089233F, 0F, 0F);

        TAILSEG5.addChild(TailSeg5);
        TAILSEG4.addChild(TAILSEG5);

        TAILTIP = new ModelRenderer(this, "TAILTIP");
        TAILTIP.setRotationPoint(0F, -2.6F, 0F);
        setRotation(TAILTIP, 0F, 0F, 0F);
        TAILTIP.mirror = true;
        ModelRenderer TailTip = new ModelRenderer(this, 0, 2);
        TailTip.addBox(-0.5F, -1.5F, 0F, 1, 3, 1);
        TailTip.setRotationPoint(0F, -0.9F, 1.4F);
        TailTip.setTextureSize(64, 32);
        TailTip.mirror = true;
        setRotation(TailTip, -1.291544F, 0F, 0F);
        ModelRenderer TailSeg7 = new ModelRenderer(this, 8, 4);
        TailSeg7.addBox(-0.5F, 0F, -0.5F, 1, 2, 1);
        TailSeg7.setRotationPoint(0F, -1.1F, 1.2F);
        TailSeg7.setTextureSize(64, 32);
        TailSeg7.mirror = true;
        setRotation(TailSeg7, 1.448623F, 0F, 0F);
        ModelRenderer TailSeg6 = new ModelRenderer(this, 8, 4);
        TailSeg6.addBox(-0.5F, 0F, -0.5F, 1, 2, 1);
        TailSeg6.setRotationPoint(0F, 0F, 0F);
        TailSeg6.setTextureSize(64, 32);
        TailSeg6.mirror = true;
        setRotation(TailSeg6, 2.234021F, 0F, 0F);

        TAILTIP.addChild(TailTip);
        TAILTIP.addChild(TailSeg6);
        TAILTIP.addChild(TailSeg7);
        TAILSEG5.addChild(TAILTIP);

    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        MEW.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        HEADBASE.rotateAngleY = f3 / (180F / (float) Math.PI);
        HEADBASE.rotateAngleX = f4 / (180F / (float) Math.PI);
        MEW.rotationPointY = MathHelper.cos(f2 * .2F) * 1.5F;
        RIGHTLEG.rotateAngleX = MathHelper.cos(f2 * .2F + (float) Math.PI) * .2F + .1F;
        LEFTLEG.rotateAngleX = MathHelper.cos(f2 * .2F + (float) Math.PI + .5F) * .2F + .1F;
        TAILBASE.rotateAngleX = MathHelper.cos(f2 * .2F) * .2F;
        TAILBASE.rotateAngleY = MathHelper.cos(f2 * .1F) * 1F;
        TAILSEG1.rotateAngleY = MathHelper.cos(f2 * .1F + 4F);
        TAILSEG2.rotateAngleY = MathHelper.cos(f2 * .1F + 5F);
        TAILSEG3.rotateAngleZ = MathHelper.cos(f2 * .1F + 3.6F) * .5F;
        TAILSEG4.rotateAngleY = MathHelper.cos(f2 * .1F + 8.7F);
        TAILSEG4.rotateAngleZ = MathHelper.cos(f2 * .1F + 8.7F) * .5F;
        TAILSEG5.rotateAngleZ = MathHelper.cos(f2 * .1F + 10.7F) * .5F;
        TAILSEG5.rotateAngleY = MathHelper.cos(f2 * .1F + 9.5F) * .5F;
        TAILTIP.rotateAngleY = MathHelper.cos(f2 * .1F + 4.2F) * 1.2F;
        TAILTIP.rotateAngleZ = MathHelper.cos(f2 * .1F + 12.6F) * .5F;
        TAILTIP.rotateAngleX = MathHelper.cos(f2 * .2F + 12.6F) * .6F;
    }
}