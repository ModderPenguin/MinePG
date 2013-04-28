package rpg.config.druid;

import net.minecraftforge.common.Configuration;

public class DruidItems {
	
	public static void load(Configuration config) {
		DruidWeapons.load(config);
		DruidArmor.load(config);
	}
	
	public static void addNames() {
		DruidWeapons.addNames();
		DruidArmor.addNames();
	}
}
