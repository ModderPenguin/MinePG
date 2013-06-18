package rpg.entity.passive.pet;

import rpg.client.models.pet.ModelFairy;
import rpg.client.renderers.RenderFairy;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class EntityPetRegistry {

    public static void registerPets() {
        registerPetRenders();
        registerPetID();
        registerPetNames();
    }

    private static void registerPetRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntityPet.class, new RenderFairy(new ModelFairy(), 0.2F));
    }

    private static void registerPetID() {
        EntityRegistry.registerGlobalEntityID(EntityPet.class, "Fairy", EntityRegistry.findGlobalUniqueEntityId(), 0xFFFFFF, 0x000000);
    }

    private static void registerPetNames() {
        LanguageRegistry.instance().addStringLocalization("entity.Fairy.name", "en_US", "Fairy");
    }
}