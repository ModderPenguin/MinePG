package rpg.client.renderers.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import rpg.client.models.weapons.ModelStaffTraining;
import rpg.lib.Reference;

public class RenderItemTrainingStaff implements IItemRenderer {

    protected ModelStaffTraining gopherModel;

    public RenderItemTrainingStaff() {
        this.gopherModel = new ModelStaffTraining();
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        switch (type) {
            case EQUIPPED:
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return false;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        switch (type) {
            case EQUIPPED: {
                GL11.glPushMatrix();

                Minecraft.getMinecraft().renderEngine.bindTexture("/mods/" + Reference.MOD_ID + "/textures/items/staffs/trainingStaff.png");

                if (data[1] != null && data[1] instanceof EntityPlayer) {
                    if (!((EntityPlayer) data[1] == Minecraft.getMinecraft().renderViewEntity
                            && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0 && !((Minecraft.getMinecraft().currentScreen instanceof GuiInventory || Minecraft
                            .getMinecraft().currentScreen instanceof GuiContainerCreative) && RenderManager.instance.playerViewY == 180.0F))) {
                        // The first parameter of this
                        // method is the forward-back axis
                        //
                        // Second parameter is the up-down
                        // axis
                        //
                        // Third paramter is the left-right
                        // axis
                        GL11.glTranslatef(0.25F, 0.0F, 0.0F);
                        GL11.glTranslatef(-0.85F, 0.0F, 0.0F);
                        GL11.glTranslatef(0.0F, 0.2F, 0.0F);
                        GL11.glRotatef(180F, 1.0F, 1.0F, 0.0F);
                        GL11.glRotatef(45F, 0.0F, 0.0F, 1.0F);
                        GL11.glRotatef(5F, 0.0F, 0.0F, 1.0F);
                        GL11.glTranslatef(1.0F, 0.0F, 0.0F);
                    } else {
                    }
                } else {
                    // GL11.glTranslatef(float, float,
                    // float);
                    //
                    // The first parameter of this method is
                    // the up-down axis
                    //
                    // Second parameter is the forward-back
                    // axis

                    // Third paramter is the left-right axis
                    GL11.glTranslatef(0.25F, 0.0F, 0.0F);
                    GL11.glTranslatef(-0.85F, 0.0F, 0.0F);
                    GL11.glTranslatef(0.0F, 0.2F, 0.0F);
                    GL11.glRotatef(180F, 1.0F, 1.0F, 0.0F);
                    GL11.glRotatef(45F, 0.0F, 0.0F, 1.0F);
                    GL11.glRotatef(5F, 0.0F, 0.0F, 1.0F);
                    GL11.glTranslatef(1.0F, 0.0F, 0.0F);
                }

                float scale = 1.3F;
                GL11.glScalef(scale, scale, scale);

                this.gopherModel.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0635F);

                GL11.glPopMatrix();
            }
            default:
                break;
        }
    }

}
