package rpg.enums;

public enum EnumMovement {
	Accelerate(0), Decelerate(1), Left(2), Right(3), Jump(4), Crouch(5);
	private EnumMovement(int index) {
		this.index = index;
	}

	public int index;

	public static EnumMovement getMovement(int index) {
		for (EnumMovement e : values()) {
			if (e.index == index)
				return e;
		}
		return null;
	}
}
