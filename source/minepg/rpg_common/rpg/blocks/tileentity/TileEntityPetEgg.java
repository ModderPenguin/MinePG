package rpg.blocks.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import rpg.blocks.BlockPetEgg;
import rpg.pet.EnumPetType;

public class TileEntityPetEgg extends TileEntity{

    public static boolean canIncubate;
    public static int incubatingTimer = 0;
    
    public static EnumPetType petType;
    
    public TileEntityPetEgg() {
        TileEntityPetEgg.petType = BlockPetEgg.petType;
    }
    
    public static int getIncubationTime() {
        return BlockPetEgg.incubationTime;
    }
    
    @Override
    public void writeToNBT(NBTTagCompound par1NBTTag) {
        super.writeToNBT(par1NBTTag);
        par1NBTTag.setBoolean("canIncubate", canIncubate);
        par1NBTTag.setInteger("incubatingTimer", incubatingTimer);
        
    }

    @Override
    public void readFromNBT(NBTTagCompound par1NBTTag) {
        super.readFromNBT(par1NBTTag);
        canIncubate = par1NBTTag.getBoolean("canIncubate");
        incubatingTimer = par1NBTTag.getInteger("incubatingTimer");
    }
}