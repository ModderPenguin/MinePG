package rpg.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import rpg.gui.ContainerEmpty;
import cpw.mods.fml.client.FMLClientHandler;

public class GuiLoreStartingPage extends GuiContainer {

    public GuiLoreStartingPage() {
        super(new ContainerEmpty());
    }

    @Override
    public void actionPerformed(GuiButton button) {
        this.mc.thePlayer.closeScreen();
        FMLClientHandler.instance().getClient().displayGuiScreen(new GuiChooseClass());
    }

    @Override
    public void drawGuiContainerBackgroundLayer(float par3, int par1, int par2) {
        this.drawDefaultBackground();
        this.drawString(this.fontRenderer, "Steve was bored. He had slain the great dragon, which had guarded the dark abyss", 2, 40, 0xFFFFFF);
        this.drawString(this.fontRenderer, "of the End. He had gone to the molten depths of the underworld. He watched the", 2, 50, 0xFFFFFF);
        this.drawString(this.fontRenderer, "sunset from his mansion and thought to himself, where did my adventure go? Not ", 3, 60, 0xFFFFFF);
        this.drawString(this.fontRenderer, "one to wait for an update for new stuff, he took action. He prepared to go out", 2, 70, 0xFFFFFF);
        this.drawString(this.fontRenderer, "and find new adventures, new battles, new purposes for the life he lives. What", 2, 80, 0xFFFFFF);
        this.drawString(this.fontRenderer, "he did not know was a great evil was growing, and he needs all the luck he can", 2, 90, 0xFFFFFF);
        this.drawString(this.fontRenderer, "get to stop this great darkness that plagues Minecraftia.", 2, 100, 0xFFFFFF);
        this.drawString(this.fontRenderer, "Now your story starts here...... good luck.", 2, 110, 0xFFFFFF);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void initGui() {
        super.initGui();
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, 210, 200, "Next"));
    }

    @Override
    public void keyTyped(char i, int i1) {
    }
}