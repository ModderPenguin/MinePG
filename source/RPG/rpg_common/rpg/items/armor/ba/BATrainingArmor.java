package rpg.items.armor.ba;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;
import rpg.config.armor.BAArmor;
import rpg.enums.EnumRPGArmorMaterial;
import rpg.items.armor.ItemRPGArmor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SuppressWarnings("deprecation")
public class BATrainingArmor extends ItemRPGArmor implements IArmorTextureProvider {
	
    final int armorType;
    
	public BATrainingArmor(int itemid, EnumRPGArmorMaterial material, int par3, int par4, String name) {
		super(itemid, material, par3, par4, name);
		this.armorType = par4;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public String getArmorTextureFile(ItemStack itemstack) {
		if (itemstack.itemID == BAArmor.tunicTraining.itemID || itemstack.itemID == BAArmor.bootsTraining.itemID)
		{
		    return "/mods/rpg/textures/armor/ba/training_1.png";
		}
		else if (itemstack.itemID == BAArmor.legsTraining.itemID)
		{
		    return "/mods/rpg/textures/armor/ba/training_2.png";
		}

		return null;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
	    
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
	    par3List.add("Class: §AArcher, §CBerserker");
    }
}