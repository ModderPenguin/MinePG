package rpg.client.gui;

import java.util.Collection;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import org.lwjgl.opengl.GL11;

public class GuiBuffBar extends Gui
{
    private Minecraft mc;

    public GuiBuffBar(Minecraft mc)
    {
        super();
        this.mc = mc;
    }

    private static final int BUFF_ICON_SIZE = 18;
    private static final int BUFF_ICON_SPACING = BUFF_ICON_SIZE + 2;
    private static final int BUFF_ICON_BASE_U_OFFSET = 0;
    private static final int BUFF_ICON_BASE_V_OFFSET = 198;
    private static final int BUFF_ICONS_PER_ROW = 8;

    @SuppressWarnings("rawtypes")
    @ForgeSubscribe(priority = EventPriority.NORMAL)
    public void onRenderExperienceBar(RenderGameOverlayEvent event)
    {
        if(event.isCancelable() || event.type != ElementType.EXPERIENCE)
        {      
            return;
        }

        int xPos = 2;
        int yPos = 2;
        Collection collection = this.mc.thePlayer.getActivePotionEffects();
        if (!collection.isEmpty())
        {
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDisable(GL11.GL_LIGHTING);      
            this.mc.renderEngine.bindTexture("/gui/inventory.png");      

            for (Iterator iterator = this.mc.thePlayer.getActivePotionEffects()
                    .iterator(); iterator.hasNext(); xPos += BUFF_ICON_SPACING)
            {
                PotionEffect potioneffect = (PotionEffect) iterator.next();
                Potion potion = Potion.potionTypes[potioneffect.getPotionID()];

                if (potion.hasStatusIcon())
                {
                    int iconIndex = potion.getStatusIconIndex();
                    this.drawTexturedModalRect(
                            xPos, yPos, 
                            BUFF_ICON_BASE_U_OFFSET + iconIndex % BUFF_ICONS_PER_ROW * BUFF_ICON_SIZE, BUFF_ICON_BASE_V_OFFSET + iconIndex / BUFF_ICONS_PER_ROW * BUFF_ICON_SIZE,
                            BUFF_ICON_SIZE, BUFF_ICON_SIZE);
                }       
            }
        }
    }
}