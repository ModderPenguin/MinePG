package rpg.config.base.mage;

import net.minecraftforge.common.Configuration;


public class MageItems {
    
    
    
    public static void load(Configuration config) {
        MageArmor.load(config);
        MageWeapons.load(config);
    }

    public static void addNames() {
        MageArmor.addNames();
        MageWeapons.addNames();
    }
}
