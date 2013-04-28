package rpg.items;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class ItemBlock extends RPGItemBlock {
	Block block;

	public ItemBlock(int par1, Block block, String textureName, String name) {
		super(par1, "blocks/" + textureName, name);
		this.block = block;
		setCreativeTab(CreativeTabs.tabDecorations);
	}
}
