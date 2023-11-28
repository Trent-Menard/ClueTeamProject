package client;

import java.awt.CardLayout;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import clientCommunication.*;

public class WaitingRoomControl implements ActionListener {
	private JPanel container;
	private GameClient client;
    private JComboBox myBox;
    private boolean hasChosen = false;


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
	        cardLayout.show(container, "0");
	        try {
				client.closeConnection();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
	    } else if(command.equals("Confirm")) {
	    	hasChosen = true;
	    	CardLayout cardLayout = (CardLayout)container.getLayout();
	        cardLayout.show(container, "6");
	        
	        String myChar = myBox.getSelectedItem().toString();
	        ChooseCharacterData data = new ChooseCharacterData(myChar);
	        try {
				client.sendToServer(data);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
	    }
		if(command.equals("Ready") && hasChosen) {
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
	
	public void setMyComboBox(JComboBox box) {
		myBox = box;
	}
}
