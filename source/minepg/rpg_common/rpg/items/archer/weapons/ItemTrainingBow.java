package rpg.items.archer.weapons;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import rpg.items.ItemRPGBow;

public class ItemTrainingBow extends ItemRPGBow {
    
	public ItemTrainingBow(int par1, String name) {
        super(par1, name);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        // Checks the players class and colored item name accordingly
        //if(playerInfo.getPlayersClass() == "Archer") {
            par3List.add("A Bow used in");
            par3List.add("training");
            par3List.add("");
            par3List.add("Class: ¤AArcher");
        //} else {
            //par3List.add("Class: ¤4Archer");
        //}
    }
}
