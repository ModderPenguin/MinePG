package rpg.enums;

public enum EnumGui {
    ChooseClass(0), LoreStartingPage(1), PlayerStats(2);

    private int index;

    private EnumGui(int i) {
        index = i;
    }

    public Integer getIndex() {
        return index;
    }
}
