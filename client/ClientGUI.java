package client;

import java.awt.*;
import java.io.IOException;
import clientCommunication.*;

import javax.swing.*;

public class ClientGUI extends JFrame {
	private User user;
	// Constructor that creates the client GUI.
	public ClientGUI()
	{
		// Set up the chat client.
		GameClient client = new GameClient();
		client.setHost("localhost");
		client.setPort(8300);

		// Set the title and default close operation.
		this.setTitle("Clue!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create the card layout container.
		CardLayout cardLayout = new CardLayout();
		JPanel container = new JPanel(cardLayout);

		//Create the Controllers next
		//Next, create the Controllers
		IPControl ipc = new IPControl(container, client);
		InitialControl ic = new InitialControl(container,client);
		LoginControl lc = new LoginControl(container,client);
		CreateAccountControl cac = new CreateAccountControl(container,client);
		ChooseCharacterControl ccc = new ChooseCharacterControl(container, client);
		WaitingRoomControl wrc = new WaitingRoomControl(container, client);

		//Set the client info
//		client.setLoginControl(lc);
//		client.setCreateAccountControl(cac);
//		client.setChooseCharacterControl(ccc);
//		client.setWaitingRoom(wrc);

		// Create the views. (need the controller to register with the Panels
		JPanel view1 = new IPPanel(ipc);
		JPanel view2 = new InitialPanel(ic);
		JPanel view3 = new LoginPanel(lc);
		JPanel view4 = new CreateAccountPanel(cac);
		JPanel view5 = new ChooseCharacterPanel(ccc);
		JPanel view6 = new WaitingRoomPanel(wrc);

		// Add the views to the card layout container.
		container.add(view1, "1");
		container.add(view2, "2");
		container.add(view3, "3");
		container.add(view4, "4");
		container.add(view5, "5");
		container.add(view6, "6");

		// Show the initial view in the card layout.
		cardLayout.show(container, "1");

		// Add the card layout container to the JFrame.
		// GridBagLayout makes the container stay centered in the window.
		this.setLayout(new GridBagLayout());
		this.add(container);

		// Show the JFrame.
		this.setSize(550, 350);
		this.setVisible(true);
	}



	public static void main(String[] args) {
		new ClientGUI();
	}



	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return this.user;
	}

}

