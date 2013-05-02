package rpg.client.gui;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.world.storage.WorldInfo;
import rpg.BaseClassList;
import rpg.RPG;
import rpg.enums.EnumGui;
import rpg.gui.ContainerEmpty;
import rpg.worldgen.feature.WorldGenArcherStarterChest;

public class GuiLoreStartingPage extends GuiContainer {

	public GuiLoreStartingPage() {
		super(new ContainerEmpty());
	}

	@SuppressWarnings("unchecked")
	public void initGui() {
		super.initGui();
		buttonList.clear();
		buttonList.add(new GuiButton(0, 2, 90, "Next"));
	}

	public void keyTyped(char i, int i1) {
	}
	
	public void actionPerformed(GuiButton button) {
		
		mc.thePlayer.closeScreen();
	}

	public void drawGuiContainerBackgroundLayer(float par3, int par1, int par2) {
		drawDefaultBackground();
		drawString(fontRenderer, "Steve was bored. He had slain the great dragon, which had guarded the dark abyss", 2, 10, 0xFFFFFF);
		drawString(fontRenderer, "of the End. He had gone to the molten depths of the underworld. He watched the", 2, 20, 0xFFFFFF);
		drawString(fontRenderer, "sunset from his mansionand thought to himself, where did my adventure go? Not ", 3, 30, 0xFFFFFF);
		drawString(fontRenderer, "one to wait for an update for new stuff, he took action. He forged new tools", 2, 40, 0xFFFFFF);
		drawString(fontRenderer, "and armor. Finally, after hours of preparation, his moment had come. Time to ", 2, 50, 0xFFFFFF);
		drawString(fontRenderer, "show Minecraft what real adventure is. What he did not know was a great evil was", 2, 60, 0xFFFFFF);
		drawString(fontRenderer, "growing, and he needs all the luck he can get to stop this great darkness that ", 2, 70, 0xFFFFFF);
		drawString(fontRenderer, "plagues Minecraftia. Now your story starts here...... good luck.", 2, 80, 0xFFFFFF);
	}
}