package rpg.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.ForgeSubscribe;

import org.lwjgl.opengl.GL11;

import rpg.lib.Reference;
import rpg.playerinfo.PlayerInformation;

public class HudOverlayHandler extends Gui {

    private final Minecraft mc = Minecraft.getMinecraft();

    @ForgeSubscribe
    public void drawOverlay(RenderGameOverlayEvent.Pre event) {
        ScaledResolution scaler = event.resolution;
        int width = scaler.getScaledWidth();
        mc.entityRenderer.setupOverlayRendering();
        GL11.glColor3f(1, 1, 1);
        PlayerInformation clientPlayerInfo = PlayerInformation.forPlayer(mc.thePlayer);
        mc.renderEngine.bindTexture("/mods/" + Reference.MOD_ID + "/textures/gui.png");
        int barXStart = width / 2 - 182 / 2;

        // background of the bar
        drawTexturedModalRect(barXStart, 10, 0, 0, 182, 5);
        float karma = clientPlayerInfo.getKarma();

        // the bar itself
        if (karma != 0) {
            int rescaledKarmaWidth = (int) (Math.abs(karma) / PlayerInformation.MAX_KARMA_VALUE * 91F);
            if (rescaledKarmaWidth > 91) {
                rescaledKarmaWidth = 91;
            }
            int barTextureXStart = karma > 0 ? 91 : 91 - rescaledKarmaWidth;
            drawTexturedModalRect(barXStart + barTextureXStart, 10, barTextureXStart, 5, rescaledKarmaWidth, 5);
        }

        String karmaString = String.valueOf((int) karma);
        FontRenderer fr = mc.fontRenderer;
        int xPos = width / 2 - fr.getStringWidth(karmaString) / 2;
        int yPos = 2;
        fr.drawString(karmaString, xPos + 1, yPos, 0x000000);
        fr.drawString(karmaString, xPos - 1, yPos, 0x000000);
        fr.drawString(karmaString, xPos, yPos + 1, 0x000000);
        fr.drawString(karmaString, xPos, yPos - 1, 0x000000);
        if (karma >= 0) {
            fr.drawString(karmaString, xPos, yPos, 0x4444FF);
        } else {
            fr.drawString(karmaString, xPos, yPos, 0xFF0000);
        }
    }
}