package rpg.enums;


public enum EnumGui {
	ChooseStarter(0);
	
	private int index;
	
	private EnumGui(int i)
	{
		index=i;
	}
	
	public Integer getIndex()
	{
		return index;
	}
}
