package rpg.items.armor.ds;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;
import rpg.config.armor.DSArmor;
import rpg.enums.EnumRPGArmorMaterial;
import rpg.items.armor.ItemRPGArmor;

@SuppressWarnings("deprecation")
public class DSTrainingArmor extends ItemRPGArmor implements IArmorTextureProvider {
		
	public DSTrainingArmor(int itemid, EnumRPGArmorMaterial material, int par3, int par4, String name) {
		super(itemid, material, par3, par4, name);
	}
	
	public String getArmorTextureFile(ItemStack itemstack) {
		if (itemstack.itemID == DSArmor.hatTraining.itemID || itemstack.itemID == DSArmor.robeTraining.itemID || itemstack.itemID == DSArmor.sandalsTraining.itemID)
		{
		    return "/mods/rpg/textures/armor/ds/training_1.png";
		} else {
			return null;
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        par3List.add("Class: §CDruid, §CSorcerer");
    }
}
