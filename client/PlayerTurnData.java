package client;

import java.io.*;
import java.util.Random;


public class PlayerTurnData implements Serializable{
	private String turnType;
    private int rollNumber=0;
	
	public PlayerTurnData(String turnType) {
		setTurnType(turnType);
	}
	
	public String getTurnType() {
		return turnType;
	}
	public void setTurnType(String turnType) {
		this.turnType = turnType;
	}
	
	public int getPlayerRoll() {
	    	Random random = new Random();
	        // Generate a random number between 1 and 6 (inclusive) for a standard six-sided die
	        rollNumber = random.nextInt(6) + 1;
	        return rollNumber;
	}
	    
	public void setPlayerRoll(int rollNumber) {
	   this.rollNumber = rollNumber;
	}


		

	
	
}
