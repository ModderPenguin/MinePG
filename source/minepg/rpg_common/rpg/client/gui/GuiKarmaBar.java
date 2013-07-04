package rpg.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.ForgeSubscribe;

import org.lwjgl.opengl.GL11;

import rpg.lib.Reference;
import rpg.playerinfo.PlayerInformation;

public class GuiKarmaBar extends Gui {

    private Minecraft mc;

    public GuiKarmaBar() {
        this.mc = Minecraft.getMinecraft();
    }

    @ForgeSubscribe
    public void onRenderHUD(RenderGameOverlayEvent.Pre evt) {
        if (evt.type.equals(RenderGameOverlayEvent.ElementType.HOTBAR)) {
            ScaledResolution scaledRes = new ScaledResolution(this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight);
            int scaledWdt = scaledRes.getScaledWidth() / 2 - (182 / 2);
            int scaledHgt = scaledRes.getScaledHeight() - scaledRes.getScaledHeight() + 6;

            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

            GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.mc.renderEngine.getTexture("/mods/" + Reference.MOD_ID + "/textures/gui/karmaBars.png"));

            PlayerInformation playerInfo = PlayerInformation.forPlayer(this.mc.thePlayer);

            int karmaBarCap = playerInfo.karmaBarCap();

            if (karmaBarCap > 0) {
                short short1 = 182;
                int currentKarma = (int) (playerInfo.getKarma() * (short1 + 1));
                this.drawTexturedModalRect(scaledWdt, scaledHgt, 0, 0, short1, 5);

                if (currentKarma > 0) {
                    this.drawTexturedModalRect(scaledWdt, scaledHgt + 1, 0, 5, currentKarma, 4);
                }
            }
        }

        this.mc.renderEngine.resetBoundTexture();
    }

    public class GuiRenderKarmaLevel extends Gui {

        private Minecraft mc;

        public GuiRenderKarmaLevel() {
            this.mc = Minecraft.getMinecraft();
        }

        @ForgeSubscribe
        public void onRenderKarmaBar(RenderGameOverlayEvent.Text event) {
            if (event.type.equals(RenderGameOverlayEvent.ElementType.TEXT)) {
                ScaledResolution scaledRes = new ScaledResolution(this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight);
                int scaledWdt = scaledRes.getScaledWidth() / 2;
                int scaledHgt = scaledRes.getScaledHeight() - scaledRes.getScaledHeight() + 1;

                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                PlayerInformation playerInfo = PlayerInformation.forPlayer(this.mc.thePlayer);

                String karmaLevel = "" + playerInfo.getKarmaLevel();

                this.drawString(this.mc.fontRenderer, karmaLevel, scaledWdt, scaledHgt, 0xFFFFFF);
            }
        }
    }
}