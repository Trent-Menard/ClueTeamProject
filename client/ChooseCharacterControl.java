package client;

import java.awt.CardLayout;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import clientCommunication.*;

public class ChooseCharacterControl implements ActionListener {
	  private final JPanel container;
	  private final GameClient client;
	  private JComboBox myBox;
	  
	  ChooseCharacterControl(JPanel container, GameClient client){
		  this.container = container;
		  this.client = client;
	  }
	  
	  public void actionPerformed(ActionEvent ae)
	  {
	    // Get the name of the button clicked.
	    String command = ae.getActionCommand();
	    if(command.equals("Cancel")) {
	    	CardLayout cardLayout = (CardLayout)container.getLayout();
	        cardLayout.show(container, View.CONNECT_TO_SERVER.name());
	        try {
				client.closeConnection();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    } else if(command.equals("Confirm")) {
	    	CardLayout cardLayout = (CardLayout)container.getLayout();
	        cardLayout.show(container, View.WAITING_ROOM.name());
	        
	        String myChar = myBox.getSelectedItem().toString();
	        ChooseCharacterData data = new ChooseCharacterData(myChar);
	        try {
				client.sendToServer(data);
			} catch (IOException e) {
				e.printStackTrace();
			}
	    } 
	  }

	public void setMyComboBox(JComboBox box) {
		myBox = box;
	}
}
