package rpg.config;

import net.minecraft.creativetab.CreativeTabs;
import rpg.creativetab.CreativeTabArcherItems;
import rpg.creativetab.CreativeTabMageItems;
import rpg.creativetab.CreativeTabWarriorItems;

public class RPGCreativeTabs {
	
	public static final CreativeTabs tabArcherItems = new CreativeTabArcherItems("archerItems");
	public static final CreativeTabs tabMageItems = new CreativeTabMageItems("mageItems");
	public static final CreativeTabs tabWarriorItems = new CreativeTabWarriorItems("warriorItems");
	
	public static void addTabNames() {
	    
	}
}
