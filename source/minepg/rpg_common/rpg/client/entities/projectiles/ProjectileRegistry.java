package rpg.client.entities.projectiles;

import rpg.RPG;
import rpg.client.renderers.projectiles.RenderStaffTrainingBolt;
import rpg.client.renderers.projectiles.RenderTrainingArrow;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;

public class ProjectileRegistry {

    protected static void registerProjectiles() {
        EntityRegistry.registerModEntity(EntityStaffTrainingBolt.class, "staffTrainingBolt", EntityRegistry.findGlobalUniqueEntityId(), RPG.instance, 350, 5, false);
        EntityRegistry.registerModEntity(EntityTrainingArrow.class, "trainingArrow", EntityRegistry.findGlobalUniqueEntityId(), RPG.instance, 350, 5, false);
    }

    protected static void registerProjectileRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntityStaffTrainingBolt.class, new RenderStaffTrainingBolt());
        RenderingRegistry.registerEntityRenderingHandler(EntityTrainingArrow.class, new RenderTrainingArrow());
    }

    public static void initProjectileRegistry() {
        registerProjectiles();
        registerProjectileRenders();
    }
}
