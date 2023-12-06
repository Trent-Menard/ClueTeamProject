package client;

import java.awt.CardLayout;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import clientCommunication.*;

public class WaitingRoomControl implements ActionListener {
	private JPanel container;
	private GameClient client;
	WaitingRoomControl(JPanel container, GameClient client){
		this.setContainer(container);
		this.setGameClient(client);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Get the name of the button clicked.
	    String command = e.getActionCommand();
	    if(command.equals("Cancel")) {
	    	CardLayout cardLayout = (CardLayout)container.getLayout();
	        cardLayout.show(container, View.CONNECT_TO_SERVER.name());
	        try {
				client.closeConnection();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
	    }
		if (command.equals("Vote to Start")) {
			//Add 1 to playersVotedToStart on server side
			WaitingRoomData data = new WaitingRoomData(true, this.client);
			try {
				client.sendToServer(data);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public JPanel getContainer() {
		return container;
	}

	public void setContainer(JPanel container) {
		this.container = container;
	}
	
	public GameClient getClient() {
		return client;
	}
	
	public void setGameClient(GameClient client) {
		this.client = client;
	}

	public void updateMsg(String msg) {
		WaitingRoomPanel waitingRoomPanel = (WaitingRoomPanel) container.getComponent(View.WAITING_ROOM.ordinal());
		waitingRoomPanel.setMsg(msg);
	}

	public void updateStatusMsg(String msg) {
		WaitingRoomPanel waitingRoomPanel = (WaitingRoomPanel) container.getComponent(View.WAITING_ROOM.ordinal());
		waitingRoomPanel.setGameStatusMsg(msg);
	}
}
