package client;

import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import clientCommunication.*;

public class WaitingRoomControl implements ActionListener {
	private JPanel container;
	private final GameClient client;

	WaitingRoomControl(JPanel container, GameClient client){
		this.setContainer(container);
		this.setClient(client);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("Ready")) {
			WaitingRoomData data = new WaitingRoomData(true, this.client);
			try {
				client.sendToServer(data);
			} catch (IOException er) {
				er.printStackTrace();
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
	
	public void setClient(GameClient client) {
		this.client = client;
	}
}
