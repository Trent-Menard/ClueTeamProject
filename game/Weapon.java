package game;


public class Weapon extends Card{
	Room room;
	private String weaponName;
	private int xCoord;
	private int yCoord;
	
	public Weapon(String name, String category, String weaponName, int xCoord, int yCoord)
	{
		super(name,category);
		this.weaponName = weaponName;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}

	
	public void setWeaponName(String weaponName)
	{
		this.weaponName = weaponName;
	}
	public String getWeaponName()
	{
		return weaponName;
	}
	public void setXcoord(int xCoord)
	{
		this.xCoord = xCoord;
		
	}
	public int getXcoord()
	{
		return xCoord;
	}
	public void setYoord(int yCoord)
	{
		this.yCoord = yCoord;
		
	}
	public int getYcoord()
	{
		return yCoord;
	}
	public boolean isInRoom(String roomName)
	{
		return false;
	}
}

