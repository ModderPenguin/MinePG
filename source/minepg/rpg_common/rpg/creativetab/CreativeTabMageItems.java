package rpg.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import rpg.config.base.mage.MageWeapons;

public class CreativeTabMageItems extends CreativeTabs {

    public CreativeTabMageItems(String label) {
        super(label);
    }
    
    public ItemStack getIconItemStack() {
        return new ItemStack(MageWeapons.staffTraining, 1);
    }
}
