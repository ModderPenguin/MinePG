package rpg.client.renderers;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class RenderWandTrainingBolt extends Render {

	@Override
	public void doRender(Entity entity, double par1, double par2, double par4, float par6, float par9) {
		 this.loadTexture("/mods/rpg/textures/wandBolts/trainingBolt.png");
		 GL11.glPushMatrix();
		 GL11.glTranslatef((float)par2, (float)par4, (float)par6);
		 GL11.glRotatef(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * par9 - 90.0F, 0.0F, 1.0F, 0.0F);
		 GL11.glRotatef(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * par9, 0.0F, 0.0F, 1.0F);
		 Tessellator tessellator = Tessellator.instance;
		 byte b0 = 0;
		 float f2 = 0.0F;
		 float f3 = 0.5F;
		 float f4 = (float)(0 + b0 * 10) / 32.0F;
		 float f5 = (float)(5 + b0 * 10) / 32.0F;
		 float f10 = 0.05625F;
		 GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		 float f11 = 0;

		 if (f11 > 0.0F)
		 {
		   float f12 = -MathHelper.sin(f11 * 3.0F) * f11;
		   GL11.glRotatef(f12, 0.0F, 0.0F, 1.0F);
		 }

		 GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);
		 GL11.glScalef(f10, f10, f10);
		 GL11.glTranslatef(-4.0F, 0.0F, 0.0F);
		 GL11.glNormal3f(f10, 0.0F, 0.0F);
		 
		 for (int i = 0; i < 4; ++i)
		 {
		   GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
		   GL11.glNormal3f(0.0F, 0.0F, f10);
		   tessellator.startDrawingQuads();
		   tessellator.addVertexWithUV(-8.0D, -2.0D, 0.0D, (double)f2, (double)f4);
		   tessellator.addVertexWithUV(8.0D, -2.0D, 0.0D, (double)f3, (double)f4);
		   tessellator.addVertexWithUV(8.0D, 2.0D, 0.0D, (double)f3, (double)f5);
		   tessellator.addVertexWithUV(-8.0D, 2.0D, 0.0D, (double)f2, (double)f5);
		   tessellator.draw();
		 }

		 GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		 GL11.glPopMatrix();

	}
}
