package rpg.config.base.mage.sorcerer;

import net.minecraftforge.common.Configuration;

public class SorcererItems {

	
	
	public static void load(Configuration config) {
		SorcererWeapons.load(config);
		SorcererArmor.load(config);
	}
	
	public static void addNames() {
		SorcererWeapons.addNames();
		SorcererArmor.addNames();
	}
}
