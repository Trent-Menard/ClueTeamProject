package client;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import clientCommunication.*;

public class AccusationControl implements ActionListener{
	private final JPanel container;
	private final GameClient client;
	
	public AccusationControl(JPanel container, GameClient client) {
		this.container = container;
		this.client = client;
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("Confirm")) {
			AccusationPanel ap = (AccusationPanel)container.getComponent(View.ACCUSATION_PANEL.ordinal());
			String weapon = ap.getWeapon();
			String room = ap.getRoom();
			String suspect = ap.getSuspect();
			boolean isFinal = ap.getIsFinal();
			AccusationData data = new AccusationData(suspect, room, weapon, isFinal);
			try {
				client.sendToServer(data);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(command.equals("Cancel")) {
			CardLayout cardLayout = (CardLayout)container.getLayout();
			cardLayout.show(container, View.PLAYER_TURN.name());
		}
		else {
			//you screwed up to get here
		}
	}

}
