package client;

import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import clientCommunication.*;

public class WaitingRoomControl implements ActionListener {
	private JPanel container;
	private final GameClient client;

	WaitingRoomControl(JPanel container, GameClient client){
		this.container = container;
		this.client = client;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("Ready")) {
			WaitingRoomData data = new WaitingRoomData(true, this.client);
			try {
				client.sendToServer(data);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
