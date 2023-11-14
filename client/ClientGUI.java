package client;

import clientCommunication.GameClient;
import game.Player;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ClientGUI extends JFrame {
    private Player player;

    public ClientGUI() {
        // Set up the chat client.
        GameClient client = new GameClient();
        client.setHost("localhost");
        client.setPort(8300);
        try {
            client.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Set the title and default close operation.
        this.setTitle("Clue!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the card layout container.
        CardLayout cardLayout = new CardLayout();
        JPanel container = new JPanel(cardLayout);

        // Create the Controllers
        InitialControl ic = new InitialControl(container, client);
        LoginControl lc = new LoginControl(container, client);
        CreateAccountControl cac = new CreateAccountControl(container, client);
        ChooseCharacterControl ccc = new ChooseCharacterControl(container, client);
        WaitingRoomControl wrc = new WaitingRoomControl(container, client);

		IPControl ipc = new IPControl(container, client);
		InitialControl ic = new InitialControl(container,client);
        // Set the client info
		client.setLoginControl(lc);
		client.setCreateAccountControl(cac);
//		client.setChooseCharacterControl(ccc);
//		client.setWaitingRoom(wrc);

		JPanel view1 = new IPPanel(ipc);
		JPanel view2 = new InitialPanel(ic);

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

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
