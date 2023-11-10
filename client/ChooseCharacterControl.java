package client;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.*;
import clientCommunication.GameClient;

public class ChooseCharacterControl {
	  // Private data fields for the container and chat client.
	  private JPanel container;
	  private GameClient client;
	  
	  ChooseCharacterControl(JPanel container, GameClient client){
		  this.container = container;
		  this.client = client;
	  }
	  
	  public void actionPerformed(ActionEvent ae)
	  {
	    // Get the name of the button clicked.
	    String command = ae.getActionCommand();
	    
	    
	    
	  }

	  
}
