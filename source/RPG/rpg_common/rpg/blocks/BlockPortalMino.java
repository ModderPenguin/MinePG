package rpg.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.world.World;
import rpg.config.MinotaurBlocks;

public class BlockPortalMino extends BlockPortal {

	public BlockPortalMino(int par1) {
		super(par1);
        this.setTickRandomly(true);
	}
	
	@Override
	/**
     * Checks to see if this location is valid to create a portal and will return True if it does. Args: world, x, y, z
     */
    public boolean tryToCreatePortal(World par1World, int par2, int par3, int par4)
    {
        byte b0 = 0;
        byte b1 = 0;

        if (par1World.getBlockId(par2 - 1, par3, par4) == MinotaurBlocks.blockTaurite.blockID || par1World.getBlockId(par2 + 1, par3, par4) == MinotaurBlocks.blockTaurite.blockID)
        {
            b0 = 1;
        }

        if (par1World.getBlockId(par2, par3, par4 - 1) == MinotaurBlocks.blockTaurite.blockID || par1World.getBlockId(par2, par3, par4 + 1) == MinotaurBlocks.blockTaurite.blockID)
        {
            b1 = 1;
        }

        if (b0 == b1)
        {
            return false;
        }
        else
        {
            if (par1World.getBlockId(par2 - b0, par3, par4 - b1) == 0)
            {
                par2 -= b0;
                par4 -= b1;
            }

            int l;
            int i1;

            for (l = -1; l <= 2; ++l)
            {
                for (i1 = -1; i1 <= 3; ++i1)
                {
                    boolean flag = l == -1 || l == 2 || i1 == -1 || i1 == 3;

                    if (l != -1 && l != 2 || i1 != -1 && i1 != 3)
                    {
                        int j1 = par1World.getBlockId(par2 + b0 * l, par3 + i1, par4 + b1 * l);

                        if (flag)
                        {
                            if (j1 != MinotaurBlocks.blockTaurite.blockID)
                            {
                                return false;
                            }
                        }
                        else if (j1 != 0 && j1 != Block.fire.blockID)
                        {
                            return false;
                        }
                    }
                }
            }

            for (l = 0; l < 2; ++l)
            {
                for (i1 = 0; i1 < 3; ++i1)
                {
                    par1World.setBlock(par2 + b0 * l, par3 + i1, par4 + b1 * l, Block.portal.blockID, 0, 2);
                }
            }

            return true;
        }
    }
}
