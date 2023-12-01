package client;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import clientCommunication.*;

public class ConnectToServerControl implements ActionListener {
	private final JPanel container;
	private final GameClient client;
	
	ConnectToServerControl(JPanel container, GameClient client){
		this.container = container;
		this.client = client;
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if (command.equals("Connect")) {
			ConnectToServerPanel ippanel = (ConnectToServerPanel) container.getComponent(View.CONNECT_TO_SERVER.ordinal());

			if ((ippanel.getIP().isBlank() && ippanel.getPort().isBlank()))
				ippanel.setErrorMsg("Missing IP address & port number.");

			else if (ippanel.getIP().isBlank())
				ippanel.setErrorMsg("Missing IP address.");

			else if (ippanel.getPort().isBlank())
				ippanel.setErrorMsg("Missing port number.");

			else if (!(ippanel.getIP().isBlank() && ippanel.getPort().isBlank())) {

				if (!client.isConnected()) {
					boolean isValid = true;
					int portNum = -1;

					try {
						portNum = Integer.parseInt(ippanel.getPort());
					} catch (NumberFormatException x) {
						isValid = false;
						ippanel.setErrorMsg("Invalid port number.");
					}

					if (isValid) {
						ippanel.setErrorMsg("");
						client.setHost(ippanel.getIP());
						client.setPort(portNum);

						try {
							client.openConnection();
							connectionSuccessful();
						} catch (IOException ex) {
							System.err.println("[Error:] Failed to connect to the Server. Check the IP address & port & verify the Server is running.");
							ippanel.setErrorMsg("Failed to connect to the Server.");
							throw new RuntimeException(ex);
						}
					}
				}
			}
		}
	}
	
	public void connectionSuccessful() {
		CardLayout cardLayout = (CardLayout) container.getLayout();
		cardLayout.show(container, View.INITIAL.name());
		// TODO: 11/22/2023 Remove this; Bypasses login if DB not connected.
//		cardLayout.show(container, View.WAITING_ROOM.name());
	}
}