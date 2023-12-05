package client;

import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import clientCommunication.*;

public class GatherIntelControl implements ActionListener{
	private final JPanel container;
	private final GameClient client;
	
	public GatherIntelControl(JPanel container, GameClient client) {
		this.container = container;
		this.client = client;
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		GatherIntelData gid = new GatherIntelData(command);
		try {
			client.sendToServer(gid);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
}
