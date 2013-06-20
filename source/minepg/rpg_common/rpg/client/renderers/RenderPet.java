package rpg.client.renderers;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import rpg.entity.passive.pet.EntityPet;

public class RenderPet extends RenderLiving {
    
    public RenderPet(ModelBase par1ModelBase, float par2) {
        super(par1ModelBase, par2);
        this.mainModel =  par1ModelBase;
        this.setRenderPassModel(par1ModelBase);
    }
    
    public void renderPet(EntityPet pet, double par2, double par4, double par6, float par8, float par9) {
        try {
            super.doRenderLiving(pet, par2, par4, par6, par8, par9);
        } catch(Exception exception) {
            
        }
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        try {
            this.renderPet((EntityPet)par1EntityLiving, par2, par4, par6, par8, par9);
        } catch(Exception exception) {
            
        }
    }
    
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        try {
            this.renderPet((EntityPet)par1Entity, par2, par4, par6, par8, par9);
        } catch(Exception exception) {
            
        }
    }
}