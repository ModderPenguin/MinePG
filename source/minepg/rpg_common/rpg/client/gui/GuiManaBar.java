package rpg.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.ForgeSubscribe;

import org.lwjgl.opengl.GL11;

import rpg.lib.Reference;
import rpg.playerinfo.PlayerInformation;

public class GuiManaBar extends Gui {

    private Minecraft mc;

    public GuiManaBar() {
        this.mc = Minecraft.getMinecraft();
    }

    @ForgeSubscribe
    public void onRenderHUD(RenderGameOverlayEvent.Pre evt) {
        if (evt.type.equals(RenderGameOverlayEvent.ElementType.HOTBAR)) {
            ScaledResolution scaledRes = new ScaledResolution(this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight);
            int scaledWdt = scaledRes.getScaledWidth() - 102;
            int scaledHgt = scaledRes.getScaledHeight() - 12;

            GL11.glColor4f(1F, 1F, 1F, 1F);

            GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.mc.renderEngine.getTexture("/mods/" + Reference.MOD_ID + "/textures/gui/manaBar.png"));

            PlayerInformation playerInfo = PlayerInformation.forPlayer(this.mc.thePlayer);

            int manaBarCap = playerInfo.getMaxMana();

            if (manaBarCap > 0) {
                short short1 = 101;
                int currentMana = 1 + playerInfo.getMana();
                this.drawTexturedModalRect(scaledWdt, scaledHgt, 0, 0, short1, 11);

                if (currentMana > 0) {
                    this.drawTexturedModalRect(scaledWdt, scaledHgt + 1, 0, 11, currentMana, 21);
                }
            }

            this.mc.renderEngine.resetBoundTexture();
        }
    }
}