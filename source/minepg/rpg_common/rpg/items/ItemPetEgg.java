package rpg.items;

import rpg.pets.EnumPetType;

public class ItemPetEgg extends RPGItem {
    
    String petType;
    
    public ItemPetEgg(int par1, String name, EnumPetType petType) {
        super(par1, name);
        this.petType = petType.getPetType();
    }
    
    
}
