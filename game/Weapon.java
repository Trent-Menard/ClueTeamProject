package game;

public class Weapon extends Card {
    private int xCoord;
    private int yCoord;

    public Weapon(String name, int xCoord, int yCoord) {
        super(name);
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public Weapon(String name) {
        super(name);
    }

    public int getXcoord() {
        return xCoord;
    }

    public void setXcoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public void setYcoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public int getYcoord() {
        return yCoord;
    }

    public boolean isInRoom(String roomName) {
        if (roomName.contains(this.getCardName()))
        {
        	return true;
        }
        else 
        {
        	return false;
        }
    }
}