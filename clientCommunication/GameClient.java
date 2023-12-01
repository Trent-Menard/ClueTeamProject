package clientCommunication;

import client.CreateAccountControl;
import client.LoginControl;
import ocsf.client.AbstractClient;
import game.Player;
import client.*;

public class GameClient extends AbstractClient {

	private LoginControl loginControl;
	private CreateAccountControl createAccountControl;
	private Player player;
	
	
	public GameClient() {
		super("localhost", 8300);
	}
	
	// Handle messages from the server
	public void handleMessageFromServer(Object msg) {

		if (msg instanceof Error result) {
			switch (result.getMessage()) {
				case "User is not authenticated." -> this.loginControl.displayError("Invalid username or password.");
				case "Account does not exist." -> this.loginControl.displayError("Account does not exist.");
				case "Username already exists." -> this.createAccountControl.displayError("Username already exists.");
			}
		}

		else if (msg instanceof LoginData) {
			LoginData myData = (LoginData) msg;
			player = new Player(myData.getUsername(), myData.getPassword());
		}
		else if (msg instanceof CreateAccountData) {
			CreateAccountData myData = (CreateAccountData) msg;
			player = new Player(myData.getUsername(), myData.getPassword());
		}

	}

	public void setLoginControl(LoginControl lc) {
		this.loginControl = lc;
	}

	public void setCreateAccountControl(CreateAccountControl cac) {
		this.createAccountControl = cac;
	}
}