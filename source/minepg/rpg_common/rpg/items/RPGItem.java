package rpg.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import rpg.lib.Reference;
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
    }
}