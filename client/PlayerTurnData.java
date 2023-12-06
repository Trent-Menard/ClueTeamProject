package client;

import java.io.*;

public class PlayerTurnData implements Serializable{
	private String turnType;
	
	public PlayerTurnData(String turnType) {
		setTurnType(turnType);
	}
	
	public String getTurnType() {
		return turnType;
	}
	public void setTurnType(String turnType) {
		this.turnType = turnType;
	}
}
