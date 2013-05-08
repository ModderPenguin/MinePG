package rpg.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import rpg.config.base.warrior.WarriorWeapons;

public class CreativeTabWarriorItems extends CreativeTabs {

    public CreativeTabWarriorItems(String label) {
        super(label);
    }
    
    public ItemStack getIconItemStack() {
        return new ItemStack(WarriorWeapons.swordTraining, 1);
    }
}
