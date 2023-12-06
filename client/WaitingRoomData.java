package client;

import java.io.Serializable;

import clientCommunication.*;

@SuppressWarnings("serial")
public class WaitingRoomData implements Serializable {
	boolean isReady = false;
	//private String character;
	private GameClient client;
	
	WaitingRoomData(boolean ready, GameClient myClient){
		setReady(ready);
		setClient(myClient);
		//setCharacter(character);
	}
	
	public void setReady(boolean readiness) {
		isReady = readiness;
	}
	
	public boolean getReady() {
		return isReady;
	}
	
	public void setClient(GameClient myClient) {
		client = myClient;
	}
	
	public GameClient getClient() {
		return client;
	}
	
//	public String getCharacter() {
//		return this.character;
//	}
//	
//	public void setCharacter(String character) {
//		this.character = character;
//	}
	
}
