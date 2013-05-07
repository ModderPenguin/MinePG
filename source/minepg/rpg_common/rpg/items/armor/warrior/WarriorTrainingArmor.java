package rpg.items.armor.warrior;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;
import rpg.config.base.warrior.WarriorArmor;
import rpg.enums.EnumRPGArmorMaterial;
import rpg.items.armor.ItemRPGArmor;

@SuppressWarnings("deprecation")
public class WarriorTrainingArmor extends ItemRPGArmor implements IArmorTextureProvider {
		
	public WarriorTrainingArmor(int itemid, EnumRPGArmorMaterial material, int par3, int par4, String name) {
		super(itemid, material, par3, par4, name);
	}
	
	public String getArmorTextureFile(ItemStack itemstack) {
		if (itemstack.itemID == WarriorArmor.helmetTraining.itemID || itemstack.itemID == WarriorArmor.cuirassTraining.itemID || itemstack.itemID == WarriorArmor.sabatonsTraining.itemID)
		{
		    return "/mods/rpg/textures/armor/pk/training_1.png";
		}
		else if (itemstack.itemID == WarriorArmor.greavesTraining.itemID)
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
