package rpg.items;

import net.minecraft.block.Block;
import rpg.enums.EnumRPGToolMaterial;

public class ItemRPGSpade extends ItemRPGTool {

    /**
     * an array of the blocks this spade is effective
     * against
     */
    public static final Block[] blocksEffectiveAgainst = new Block[] {
            Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand,
            Block.mycelium
    };

    public ItemRPGSpade(int par1, EnumRPGToolMaterial par2EnumToolMaterial, String name) {
        super(par1, 1, par2EnumToolMaterial, blocksEffectiveAgainst, name);
    }

    /**
     * Returns if the item (tool) can harvest results from
     * the block type.
     */
    @Override
    public boolean canHarvestBlock(Block par1Block) {
        return par1Block == Block.snow ? true : par1Block == Block.blockSnow;
    }
}
