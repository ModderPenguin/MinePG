package rpg.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;

import org.lwjgl.opengl.GL11;

import rpg.gui.ContainerEmpty;
import rpg.lib.Reference;

public class GuiPlayerStats extends GuiContainer {

    public GuiPlayerStats() {
        super(new ContainerEmpty());
    }

    @Override
    public void drawGuiContainerBackgroundLayer(float par3, int par1, int par2) {
        this.drawDefaultBackground();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture("/mods/" + Reference.MOD_ID + "/textures/gui/playerStats.png");
        int k = this.width / 2 - 100;
        int l = this.height / 2 + 30;
        this.drawTexturedModalRect(k, l, 0, 0, 256, 256);
    }

    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.clear();
    }
}