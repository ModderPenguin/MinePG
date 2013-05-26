package rpg.items;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import rpg.pets.EnumPetType;

public class ItemPetEgg extends RPGItem {
    
    String petType;
    
    public ItemPetEgg(int par1, String name, EnumPetType petType) {
        super(par1, name);
        this.petType = petType.getPetType();
        LanguageRegistry.addName(this, "Pet Egg " + this.getUnlocalizedName().substring(11));
    }
    
    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if(par2World.isRemote) {
            //par2World.spawnEntityInWorld(EntityPet(par2World, this.petType));
        }
        return par1ItemStack;
    }
}
