package game;

import game.Room;
public class Weapon {
	Room room;
	private String weaponName;
	private int xCoord;
	private int yCoord;

	
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
	public boolean isInRoom(String roomName)
	{
		return false;
	}
}

