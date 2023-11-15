package client;

import clientCommunication.GameClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginControl implements ActionListener {
    private final JPanel container;
    private final GameClient client;

    public LoginControl(JPanel container, GameClient client) {
        this.container = container;
        this.client = client;
    }

    // Handle button clicks.
    public void actionPerformed(ActionEvent ae) {
        // Get the name of the button clicked.
        String command = ae.getActionCommand();

        // The Cancel button takes the user back to the initial panel.
        if (command.equals("Cancel")) {
            CardLayout cardLayout = (CardLayout) container.getLayout();
            cardLayout.show(container, "2");
        }

        // The Submit button submits the login information to the server.
        else if (command.equals("Submit")) {
            // Get the username and password the user entered.
            LoginPanel loginPanel = (LoginPanel) container.getComponent(1);
            LoginData data = new LoginData(loginPanel.getUsername(), loginPanel.getPassword());

            // Check the validity of the information locally first.
            if (data.getUsername().equals("") || data.getPassword().equals("")) {
                displayError("You must enter a username and password.");
                return;
            }

            // Submit the login information to the server.
            try {
                // Reset error msg.
                displayError("");
                client.sendToServer(data);
            } catch (IOException e) {
                displayError("Error connecting to the server.");
            }
        }
    }

    // After the login is successful, set the User object and display the contacts screen.
    public void loginSuccess() {
        LoginPanel loginPanel = (LoginPanel) container.getComponent(2);

        CardLayout cardLayout = (CardLayout) container.getLayout();
        cardLayout.show(container, "6");
    }

    // Method that displays a message in the error label.
    public void displayError(String error) {
        LoginPanel loginPanel = (LoginPanel) container.getComponent(1);
        loginPanel.setError(error);
    }
}
