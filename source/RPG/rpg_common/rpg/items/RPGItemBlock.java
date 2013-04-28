package rpg.items;

import rpg.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RPGItemBlock extends Item {
		 
	public RPGItemBlock(int par1, String string, String name) {
		super(par1);
		this.setUnlocalizedName(name);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon(Reference.MOD_ID + (this.getUnlocalizedName().substring(5)));
		System.out.println("[MinePG Textures] Loaded texture: " + this.getUnlocalizedName() + ".png");
	}
}
