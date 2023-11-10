package clientCommunication;

import ocsf.client.AbstractClient;

public class GameClient extends AbstractClient {
	
	// Private Data Fields
	
	// Setters and Getters
	
	//Constructor
	public GameClient() {
		super("localhost", 8300);
	}
	
	// Handle messages from the server
	public void handleMessageFromServer(Object arg0) {
		
		
	}
	
	
}
