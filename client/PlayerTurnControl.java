package client;

import java.awt.*;
import java.awt.event.*;
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
			
				pdt.getPlayerRoll();			
		
		}
		else if(command.equals("Make Accusation/Suggestion")) {
			CardLayout cardLayout = (CardLayout) container.getLayout();
			cardLayout.show(container, View.ACCUSATION_PANEL.name());
		}
		else {
			//tf did you do
		}

	}
	public GameClient getClient() {
		return this.client;
	}

}
