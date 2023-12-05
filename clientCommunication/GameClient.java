package clientCommunication;

import client.CreateAccountControl;
import client.LoginControl;
import ocsf.client.AbstractClient;
import game.*;
import client.*;

public class GameClient extends AbstractClient {

	private LoginControl loginControl;
	private CreateAccountControl createAccountControl;
	private WaitingRoomControl waitingRoomControl;
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

		else if (msg instanceof Player playerMsg) {
			player = playerMsg;

			this.loginControl.loginSuccess();
			waitingRoomControl.updateMsg("Your character: " + player.getCharacter());

			// Override (or set for the first time) the Player's deck.
			player.setDeck(playerMsg.getDeck());
			System.out.println(player.getUsername() + "'s deck:");

			System.out.println("- Rooms: ");
			player.getDeck().getRooms().forEach(s -> System.out.println(" - "+ s.getRoomName()));

			System.out.println("- Suspects:");
			player.getDeck().getSuspects().forEach(s -> System.out.println(" - "+ s.getSuspectName()));

			System.out.println("- Weapons:");
			player.getDeck().getWeapons().forEach(s -> System.out.println(" - "+ s.getWeaponName()));


//			WaitingRoomPanel waitingRoomPanel = (WaitingRoomPanel) waitingRoomControl.getContainer();
//			waitingRoomPanel.setMsg("You are character: " + player.getCharacter());
		}
		
		/*
		else if (msg instanceof LoginData) {
			LoginData myData = (LoginData) msg;
			player = new Player(myData.getUsername(), myData.getPassword());
		}
			else if (msg instanceof CreateAccountData) {
			CreateAccountData myData = (CreateAccountData) msg;
			player = new Player(myData.getUsername(), myData.getPassword());
			
		}
				else if (msg instanceof Suspect) {
			Suspect character = (Suspect) msg;
			player.setCharacter(character.getCardName());
		}*/
	}

	public void setLoginControl(LoginControl lc) {
		this.loginControl = lc;
	}

	public void setCreateAccountControl(CreateAccountControl cac) {
		this.createAccountControl = cac;
	}

	public void setWaitingRoomControl(WaitingRoomControl waitingRoomControl) {
		this.waitingRoomControl = waitingRoomControl;
	}

	public Player getPlayer() {
		return this.player;
	}
}