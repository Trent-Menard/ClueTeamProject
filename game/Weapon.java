package game;

public class Weapon extends Card {
    private String weaponName;
    private int xCoord;
    private int yCoord;

    public Weapon(String name, int xCoord, int yCoord) {
        super(name);
        this.weaponName = name;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getXcoord() {
        return xCoord;
    }

    public void setXcoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public void setYoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public int getYcoord() {
        return yCoord;
    }

    public boolean isInRoom(String roomName) {
        return false;
    }
}

