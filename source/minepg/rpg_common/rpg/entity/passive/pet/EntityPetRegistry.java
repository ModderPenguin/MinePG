package rpg.entity.passive.pet;

import rpg.client.models.pet.ModelMaullar;
import rpg.client.renderers.RenderPet;
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
        RenderingRegistry.registerEntityRenderingHandler(EntityMaullar.class, new RenderPet(new ModelMaullar(), 0.2F));
    }

    private static void registerPetID() {
        EntityRegistry.registerGlobalEntityID(EntityMaullar.class, "Maullar", EntityRegistry.findGlobalUniqueEntityId(), 0xFFFFFF, 0x000000);
    }

    private static void registerPetNames() {
        LanguageRegistry.instance().addStringLocalization("entity.Maullar.name", "en_US", "Maullar");
    }
}