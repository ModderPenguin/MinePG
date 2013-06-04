package rpg.config;

import net.minecraftforge.common.Configuration;
import rpg.config.blocks.MinotaurBlocks;

public class RPGBlocks {

    public static void addNames() {
        MinotaurBlocks.addNames();
        // PetBlocks.addNames();
    }

    public static void load(Configuration config) {
        MinotaurBlocks.load(config);
        // PetBlocks.load(config);
    }

    public static void registerBlocks() {
        MinotaurBlocks.registerBlocks();
        // PetBlocks.registerBlocks();
    }
}
