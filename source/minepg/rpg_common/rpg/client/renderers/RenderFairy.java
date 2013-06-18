package rpg.client.renderers;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import rpg.client.models.pet.ModelFairy;
import rpg.entity.passive.pet.EntityPet;

public class RenderFairy extends RenderLiving {

    protected ModelFairy petModel;
    
    public RenderFairy(ModelBase par1ModelBase, float par2) {
        super(par1ModelBase, par2);
        this.mainModel = (ModelFairy)petModel;
    }
    
    public void renderPet(EntityPet par1EntityTameEbby, double par2, double par4, double par6, float par8, float par9) {
        super.doRenderLiving(par1EntityTameEbby, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        this.renderPet((EntityPet)par1EntityLiving, par2, par4, par6, par8, par9);
    }
    
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.renderPet((EntityPet)par1Entity, par2, par4, par6, par8, par9);
    }
}