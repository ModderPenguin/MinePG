package rpg.entity.passive.pet;

import rpg.RPG;
import rpg.client.models.pet.ModelFairy;
import rpg.client.renderers.RenderPet;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;


public class EntityPetRegistry {
        
    public static void registerPets() {
        registerPetRenders();
        registerPetEntities();
        registerPetID();
    }
    
    protected static void registerPetRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntityFairy.class, new RenderPet(new ModelFairy(), 0.2F));
    }
    
    protected static void registerPetEntities() {
        EntityRegistry.registerModEntity(EntityFairy.class, "Fairy", EntityRegistry.findGlobalUniqueEntityId(), RPG.instance, 200, 50, true);
    }
    
    protected static void registerPetID() {
        EntityRegistry.registerGlobalEntityID(EntityFairy.class, "Fairy", EntityRegistry.findGlobalUniqueEntityId(), 0xFFFFFF, 0x000000);
    }
}
