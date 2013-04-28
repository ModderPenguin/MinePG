package rpg.items;

import rpg.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RPGItem extends Item {
	 
	public RPGItem(int par1, String name) {
		super(par1);
		this.setUnlocalizedName(name);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
	    this.itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + (this.getUnlocalizedName().substring(5)));
	    System.out.println("[MinePG Textures] Texture Loaded: " + (this.getUnlocalizedName().substring(5)) + ".png");
	}
}