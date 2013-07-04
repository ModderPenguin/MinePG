package rpg.pet;

public enum EnumPetType {
    MAIN("petMain"), AIR("petAir"), EARTH("petEarth"), FIRE("petFire"), /*
                                                                         * LAVA
                                                                         * (
                                                                         * "petLava"
                                                                         * )
                                                                         * ,
                                                                         */NORMAL("petNormal"), WATER("petWater"), ;

    public static String[] petTypeList = {
            "Main", "Air", "Earth", "Fire", "Normal", "Water"
    };

    private String petType;

    private EnumPetType(String petType) {
        this.petType = petType;
    }

    public String getPetType() {
        return this.petType;
    }
}
