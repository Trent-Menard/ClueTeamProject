package client;

import java.io.*;

@SuppressWarnings("serial")
public class AccusationData implements Serializable{
	private String suspect;
	private String room;
	private String weapon;
	private boolean isFinal;
	
	public AccusationData(String suspect, String room, String weapon, boolean isFinal) {
		setSuspect(suspect);
		setRoom(room);
		setWeapon(weapon);
		setIsFinal(isFinal);
	}
	
	
	public String getSuspect() {
		return suspect;
	}
	
	public void setSuspect(String suspect) {
		this.suspect = suspect;
	}
	
	public String getRoom() {
		return room;
	}
	
	public void setRoom(String room) {
		this.room = room;
	}
	
	public String getWeapon() {
		return weapon;
	}
	
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	public boolean isFinal() {
		return isFinal;
	}

	public void setIsFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}
}
