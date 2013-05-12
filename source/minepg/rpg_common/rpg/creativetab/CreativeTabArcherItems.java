package rpg.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import rpg.config.base.archer.ArcherWeapons;

public class CreativeTabArcherItems extends CreativeTabs {

    public CreativeTabArcherItems(String label) {
        super(label);
    }

    @Override
    public ItemStack getIconItemStack() {
        return new ItemStack(ArcherWeapons.bowTraining, 1);
    }
}
