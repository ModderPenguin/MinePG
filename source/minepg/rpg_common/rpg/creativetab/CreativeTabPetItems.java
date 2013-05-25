package rpg.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import rpg.config.PetItems;

public class CreativeTabPetItems extends CreativeTabs {

    public CreativeTabPetItems(String label) {
        super(label);
    }

    @Override
    public ItemStack getIconItemStack() {
        return new ItemStack(PetItems.petEggNormal, 1);
    }
}
