package rpg.network.packet;

import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import rpg.pet.EnumPetType;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

import cpw.mods.fml.relauncher.Side;

public class PacketSpawnPet extends MinePGPacket {

    public World world;
    public EnumPetType petType;

    public PacketSpawnPet() {}
    
    public PacketSpawnPet(World par1World, EnumPetType par2PetType) {
        this.world = par1World;
        this.petType = par2PetType;
    }

    @Override
    protected void execute(EntityPlayer player, Side side) {
        if(side.isServer()) {
            switch(petType) {
            default:
                world.spawnEntityInWorld(new EntityZombie(world));
                break;
            }
        }
    }

    @Override
    protected void writeData(ByteArrayDataOutput out) {
        
    }

    @Override
    protected void readData(ByteArrayDataInput in) {
        
    }
}