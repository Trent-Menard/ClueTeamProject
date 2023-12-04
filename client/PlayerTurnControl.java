package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JPanel;

import clientCommunication.GameClient;

public class PlayerTurnControl implements ActionListener{
	private final JPanel container;
	private final GameClient client;
	
	public PlayerTurnControl(JPanel container, GameClient client) {
		this.container = container;
		this.client = client;
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		PlayerTurnPanel ptp = (PlayerTurnPanel)container.getComponent(View.PLAYER_TURN.ordinal());
		PlayerTurnData pdt;
		if(command.equals("Skip Turn")) {
			pdt = new PlayerTurnData(command);
			try {
				client.sendToServer(pdt);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else if(command.equals("Roll Dice")) {
			pdt = new PlayerTurnData(command);
			try {
				client.sendToServer(pdt);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else if(command.equals("Make Accusation/Suggestion")) {
			pdt = new PlayerTurnData(command);
			try {
				client.sendToServer(pdt);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else {
			//tf did you do
		}

	}

}
