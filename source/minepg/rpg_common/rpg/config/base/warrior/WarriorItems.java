package rpg.config.base.warrior;

import net.minecraftforge.common.Configuration;

public class WarriorItems {

    public static void addNames() {
        WarriorWeapons.addNames();
        WarriorArmor.addNames();
    }

    public static void load(Configuration config) {
        WarriorWeapons.load(config);
        WarriorArmor.load(config);
    }
}
