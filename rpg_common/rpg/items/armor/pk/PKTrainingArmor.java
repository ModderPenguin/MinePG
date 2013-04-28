package rpg.items.armor.pk;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;
import rpg.config.armor.PKArmor;
import rpg.enums.EnumRPGArmorMaterial;
import rpg.items.armor.ItemRPGArmor;

@SuppressWarnings("deprecation")
public class PKTrainingArmor extends ItemRPGArmor implements IArmorTextureProvider {
		
	public PKTrainingArmor(int itemid, EnumRPGArmorMaterial material, int par3, int par4, String name) {
		super(itemid, material, par3, par4, name);
	}
	
	public String getArmorTextureFile(ItemStack itemstack) {
		if (itemstack.itemID == PKArmor.helmetTraining.itemID || itemstack.itemID == PKArmor.cuirassTraining.itemID || itemstack.itemID == PKArmor.sabatonsTraining.itemID)
		{
		    return "/mods/rpg/textures/armor/pk/training_1.png";
		}
		else if (itemstack.itemID == PKArmor.greavesTraining.itemID)
		{
		    return "/mods/rpg/textures/armor/pk/training_2.png";
		}
		
        return null;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        par3List.add("Class: §CKnight, §CPaladin");
    }
}
