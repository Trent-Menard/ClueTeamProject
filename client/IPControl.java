package client;

import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import clientCommunication.*;

public class IPControl implements ActionListener {
	private JPanel container;
	private GameClient client;
	
	IPControl(JPanel container, GameClient client){
		this.container = container;
		this.client = client;
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("Connect")) {
			IPPanel myPanel = (IPPanel) container.getComponent(1);
			client.setHost(myPanel.getIP());
			client.setPort(myPanel.getPort());
			try {
				client.openConnection();
			} catch (IOException er) {
				er.printStackTrace();
			}
		}
	}
}
