package rpg.items.armor.mage;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;
import rpg.config.base.mage.MageArmor;
import rpg.enums.EnumRPGArmorMaterial;
import rpg.items.armor.ItemRPGArmor;
import rpg.playerinfo.PlayerInformation;

@SuppressWarnings("deprecation")
public class MageTrainingArmor extends ItemRPGArmor implements IArmorTextureProvider {
		
	public MageTrainingArmor(int itemid, EnumRPGArmorMaterial material, int par3, int par4, String name) {
		super(itemid, material, par3, par4, name);
	}
	
	public String getArmorTextureFile(ItemStack itemstack) {
		if (itemstack.itemID == MageArmor.hatTraining.itemID || itemstack.itemID == MageArmor.robeTraining.itemID || itemstack.itemID == MageArmor.sandalsTraining.itemID)
		{
		    return "/mods/rpg/textures/armor/ds/training_1.png";
		} else {
			return null;
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public void addInformation(ItemStack par1ItemStack, EntityPlayer player, List par3List, boolean par4) {
	    PlayerInformation PlayerInfoFake = PlayerInformation.forPlayer(player);
        // Checks the players class and colored item name accordingly
        if(PlayerInfoFake.getPlayersClass() == "Mage" && player.experienceLevel >= 1) {
            par3List.add("Class: ¤AMage, ¤4Alchemist");
            par3List.add("Level: ¤A1");
        } else if(PlayerInfoFake.getPlayersClass() == "Alchemist" && player.experienceLevel >= 1) {
            par3List.add("Class: ¤4Mage, ¤AAlchemist");
            par3List.add("Level: ¤41");
        } else if(PlayerInfoFake.getPlayersClass() == "Mage" && player.experienceLevel != 1) {
            par3List.add("Class: ¤AMage, ¤4Alchemist");
            par3List.add("Level: ¤41");
        } else if(PlayerInfoFake.getPlayersClass() == "Alchemist" && player.experienceLevel != 1) {
            par3List.add("Class: ¤4Mage, ¤AAlchemist");
            par3List.add("Level: ¤41");
        } else if((PlayerInfoFake.getPlayersClass() != "Mage" || PlayerInfoFake.getPlayersClass() != "Alchemist") && player.experienceLevel == 1) {
            par3List.add("Class: ¤4Mage, ¤4Alchemist");
            par3List.add("Level: ¤A1");
        } else {
            par3List.add("Class: ¤4Mage, ¤4Alchemist");
            par3List.add("Level: ¤41");
        }
    }
}
