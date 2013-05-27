package rpg.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import rpg.pets.EnumPetType;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemPetEgg extends RPGItem {

    EnumPetType petType;
    String petTypeToString;

    public ItemPetEgg(int par1, String name, EnumPetType petType) {
        super(par1, name);
        this.petType = petType;
        // this.petTypeToString = petType.getPetType();
        LanguageRegistry.addName(this, "Pet Egg: "
                + this.getUnlocalizedName().substring(11));
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void addInformation(ItemStack par1ItemStack,
            EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        switch (this.petType) {
        case AIR:
            par3List.add("Contains an Animal");
            par3List.add("of the Air Element");
            break;
        case EARTH:
            par3List.add("Contains an Animal");
            par3List.add("of the Earth Element");
            break;
        case FIRE:
            par3List.add("Contains an Animal");
            par3List.add("of the Fire Element");
            break;
        /*
         * case LAVA: par3List.add("Contains an Animal"); par3List.add("of the Lava Element"); break;
         */
        case NORMAL:
            par3List.add("Contains an Animal");
            par3List.add("of the Normal Element");
            break;
        case WATER:
            par3List.add("Contains an Animal");
            par3List.add("of the Water Element");
            break;
        default:
            par3List.add("Contains an Animal");
            break;
        }
    }
}
