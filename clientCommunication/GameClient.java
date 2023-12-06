package clientCommunication;

import client.CreateAccountControl;
import client.LoginControl;
import ocsf.client.AbstractClient;
import game.*;
import client.*;
import server.DataNeededForClient;

public class GameClient extends AbstractClient {
	private LoginControl loginControl;
	private CreateAccountControl createAccountControl;
	private WaitingRoomControl waitingRoomControl;
	private BoardPanel boardPanel;
	private BoardController boardController;
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
			player.getDeck().getRooms().forEach(s -> System.out.println(" - "+ s.getCardName()));

			System.out.println("- Suspects:");
			player.getDeck().getSuspects().forEach(s -> System.out.println(" - "+ s.getCardName()));

			System.out.println("- Weapons:");
			player.getDeck().getWeapons().forEach(s -> System.out.println(" - "+ s.getCardName()));

			//			WaitingRoomPanel waitingRoomPanel = (WaitingRoomPanel) waitingRoomControl.getContainer();
			//			waitingRoomPanel.setMsg("You are character: " + player.getCharacter());
		}

		else if (msg instanceof LoginData loginData) {
			player = loginData.getPlayer();
			this.loginControl.loginSuccess();
		}
		else if (msg instanceof CreateAccountData createAccountData) {
			player = createAccountData.getPlayer();
			this.loginControl.loginSuccess();
		}

		else if (msg instanceof DataNeededForClient dataNeededForClient) {
			this.waitingRoomControl.updateStatusMsg(dataNeededForClient.getPlayersReady() + "/" + dataNeededForClient.getPlayersNeededToStart() + " players needed to start");
		}

		else if (msg instanceof BoardData boardData) {
			this.boardController.setBoardData(boardData);
			this.boardController.getBoardPanel().setBoardData(boardData);
			this.boardController.getBoardPanel().drawWeapons();
			this.boardController.getBoardPanel().drawPlayerPositions();

			this.boardPanel = boardController.getBoardPanel();
			this.boardPanel.setVisible(true);
		}

		else if (msg instanceof Suspect) {
			Suspect character = (Suspect) msg;
			player.setCharacter(character.getCardName());
		}
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

	public void setBoardPanel(BoardPanel boardPanel) {
		this.boardPanel = boardPanel;
	}

	public void setBoardControl(BoardController bc) {
		this.boardController = bc;
	}
}