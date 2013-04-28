package rpg.comm;

public enum EnumPackets {
	ChooseStarter(10), RegisterPlayer(11);
	private int index;

	private EnumPackets(int i) {
		index = i;
	}

	public Integer getIndex() {
		return index;
	}

	public static EnumPackets getEnum(int readInt) {
		for (int i = 0; i < values().length; i++) {
			if (values()[i].index == readInt)
				return values()[i];
		}
		return null;
	}
}
