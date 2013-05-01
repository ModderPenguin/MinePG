package rpg.worldgen.feature;

import rpg.config.archer.ArcherWeapons;
import rpg.config.armor.BAArmor;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;

public class WorldGenMageStarterChest {
    
    private World world;
    private int x; //X
    private int y; //Y
    private int z; //Z
    
    public WorldGenMageStarterChest(World theWorld, int i, int j, int k) {
        world = theWorld;
        x = i;
        y = j;
        z = k;
        
    }
    
    public void generateChest() {
        world.setBlock(x + 1, y, z, Block.chest.blockID);
        
        TileEntityChest chest2 = new TileEntityChest();
        
        world.setBlockTileEntity(x + 1, y, z, chest2);
     
        //chest2.setInventorySlotContents(0, new ItemStack());
        //chest2.setInventorySlotContents(1, new ItemStack());
        //chest2.setInventorySlotContents(2, new ItemStack());
        //chest2.setInventorySlotContents(3, new ItemStack());
        //chest2.setInventorySlotContents(4, new ItemStack());
    }
}
