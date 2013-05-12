package rpg.config.base.mage.druid;

import net.minecraftforge.common.Configuration;

public class DruidItems {

    public static void addNames() {
        DruidWeapons.addNames();
        DruidArmor.addNames();
    }

    public static void load(Configuration config) {
        DruidWeapons.load(config);
        DruidArmor.load(config);
    }
}
