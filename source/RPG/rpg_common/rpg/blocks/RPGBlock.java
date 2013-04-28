package rpg.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RPGBlock extends Block {
	
	public static String textureName;
	
	public RPGBlock(int id, Material material, String textureFileName) {
		super(id, material);
		RPGBlock.textureName = textureFileName;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon("rpg:" + textureName);
	}
}
