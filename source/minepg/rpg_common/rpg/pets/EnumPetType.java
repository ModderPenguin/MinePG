package rpg.pets;

public enum EnumPetType {
    MAIN("petMain"), EARTH("petEarth"), FIRE("petFire"), LAVA("petLava"), NORMAL("petNormal"), WATER("petWater"), AIR("petAir");
    
    private String petType;
    
    private EnumPetType(String petType) {
        this.petType = petType;
    }
    
    public String getPetType() {
        return petType;
    }
}
