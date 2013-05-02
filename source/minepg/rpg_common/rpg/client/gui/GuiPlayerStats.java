package rpg.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import rpg.gui.ContainerEmpty;
import rpg.lib.Reference;

public class GuiPlayerStats extends GuiContainer {

	public GuiPlayerStats() {
		super(new ContainerEmpty());
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	private String getTextureFile() {
		return "/mods/" + Reference.MOD_ID + "/textures/gui/playerStats.png";
	}
	
	/*
	public void keyTyped(char i, int i1) {
		// have to figure out how to add a key to close the GUI...
	}
	*/

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		//draw your Gui here, only thing you need to change is the path
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(getTextureFile());
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}

}