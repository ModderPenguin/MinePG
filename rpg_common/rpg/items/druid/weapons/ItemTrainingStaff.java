package rpg.items.druid.weapons;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import rpg.PlayerClassHandler;
import rpg.enums.EnumRPGStaffMaterial;
import rpg.items.ItemRPGStaff;

public class ItemTrainingStaff extends ItemRPGStaff {

	public ItemTrainingStaff(int id, EnumRPGStaffMaterial material,
			String textureFileName) {
		super(id, material, textureFileName);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        // Checks the players class and displays a color accordingly
        if(PlayerClassHandler.getPlayersClass() == "Druid") {
            par3List.add("Class: §ADruid");
        } else {
            par3List.add("Class: §4Druid");
        }
    }
}
