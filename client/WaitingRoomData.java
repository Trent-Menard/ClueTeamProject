package client;

import clientCommunication.*;

public class WaitingRoomData {
	boolean isReady = false;
	private GameClient client;
	
	WaitingRoomData(boolean ready, GameClient myClient){
		setReady(ready);
		setClient(myClient);
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
	
}
