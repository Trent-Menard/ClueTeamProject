package client;

import clientCommunication.GameClient;
import game.Player;

import javax.swing.*;
import java.awt.*;

public class ClientGUI extends JFrame {
    private Player player;

    public ClientGUI() {
        GameClient client = new GameClient();

        this.setTitle("Clue!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the card layout container.
        CardLayout cardLayout = new CardLayout();
        JPanel container = new JPanel(cardLayout);

        // Create the Controllers
        ConnectToServerControl ipc = new ConnectToServerControl(container, client);
        InitialControl ic = new InitialControl(container, client);
        LoginControl lc = new LoginControl(container, client);
        CreateAccountControl cac = new CreateAccountControl(container, client);
        ChooseCharacterControl ccc = new ChooseCharacterControl(container, client);
        WaitingRoomControl wrc = new WaitingRoomControl(container, client);

		client.setLoginControl(lc);
		client.setCreateAccountControl(cac);
//		client.setChooseCharacterControl(ccc);
//		client.setWaitingRoom(wrc);

        // Create the Views
		JPanel view1 = new ConnectToServerPanel(ipc);
		JPanel view2 = new InitialPanel(ic);
        JPanel view3 = new LoginPanel(lc);
        JPanel view4 = new CreateAccountPanel(cac);
        JPanel view5 = new ChooseCharacterPanel(ccc);
        JPanel view6 = new WaitingRoomPanel(wrc);

        // Add the views to the card layout container.
        container.add(view1, View.CONNECT_TO_SERVER.name());
        container.add(view2, View.INITIAL.name());
        container.add(view3, View.LOGIN.name());
        container.add(view4, View.CREATE_ACCOUNT.name());
        container.add(view5, View.CHOOSE_CHARACTER.name());
		container.add(view6, View.WAITING_ROOM.name());

        // Show the initial view in the card layout.
        cardLayout.show(container, View.CONNECT_TO_SERVER.name());

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