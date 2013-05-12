package rpg.config.base.archer;

import net.minecraftforge.common.Configuration;

public class ArcherItems {

    public static void addNames() {
        ArcherWeapons.addNames();
        ArcherArmor.addNames();
    }

    public static void load(Configuration config) {
        ArcherWeapons.load(config);
        ArcherArmor.load(config);
    }
}
