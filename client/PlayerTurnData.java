package client;

import java.io.*;

public class PlayerTurnData implements Serializable{
	private String turnType;
	private int rollNumber;
	
	public PlayerTurnData(String turnType) {
		setTurnType(turnType);
	}
	
	public String getTurnType() {
		return turnType;
	}
	public void setTurnType(String turnType) {
		this.turnType = turnType;
	}
	public int getRoll() {
		return rollNumber;
	}
	public void setRoll(int roll) {
		this.rollNumber = roll;
	}
}
