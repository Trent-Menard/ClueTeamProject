package serverCommunication;

import client.CreateAccountData;
import client.LoginData;
import database.Database;
import game.Suspect;
import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;
import server.GameManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class GameServer extends AbstractServer {
    private JTextArea log;
    private JLabel status;
    private boolean running = false;
    private final Database database = new Database();
    private final boolean isDBConnected;
    private GameManager gameManager;
    private List<Suspect> suspects = gameManager.getDeck().getSuspects();

    // Constructor for initializing the server with default settings.
    public GameServer() {
        super(12345);
        this.setTimeout(500);
        isDBConnected = database.isConnected();
        this.gameManager = new GameManager();
    }

    // Getter that returns whether the server is currently running.
    public boolean isRunning() {
        return running;
    }

    // Setters for the data fields corresponding to the GUI elements.
    public void setLog(JTextArea log) {
        this.log = log;
    }

    public void setStatus(JLabel status) {
        this.status = status;
    }

    // When the server starts, update the GUI.
    public void serverStarted() {
        running = true;
        status.setText("Listening");
        status.setForeground(Color.GREEN);
        log.append("Server started\n");
    }

    // When the server stops listening, update the GUI.
    public void serverStopped() {
      status.setText("Stopped");
      status.setForeground(Color.RED);
      log.append("Server stopped accepting new clients - press Listen to start accepting new clients\n");
    }

    // When the server closes completely, update the GUI.
    public void serverClosed() {
        running = false;
        status.setText("Close");
        status.setForeground(Color.RED);
        log.append("Server and all current clients are closed - press Listen to restart\n");
    }

    // When a client connects or disconnects, display a message in the log.
    public void clientConnected(ConnectionToClient client) {
        log.append("Client " + client.getId() + " connected\n");
    }

    // When a message is received from a client, handle it.
    public void handleMessageFromClient(Object object, ConnectionToClient connectionToClient) {

        if (object instanceof LoginData loginData) {

            boolean isVerified = database.verifyUser(loginData.getUsername(), loginData.getPassword());

            // Account exists & Username & Password are valid.
            if (isVerified) {
                try {
                    connectionToClient.sendToClient(loginData);
                    System.out.println("User is authenticated.");
                    Suspect character = suspects.get(0);
                    suspects.remove(0);
                    connectionToClient.sendToClient(character);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            else {
                String errorMessage;

                // Account exists but incorrect Password.
                if (database.checkUserExists(loginData.getUsername()))
                    errorMessage = "User is not authenticated.";

                // Account does not exist.
                else
                    errorMessage = "Account does not exist.";

                try {
                    System.err.println(errorMessage);
                    connectionToClient.sendToClient(new Error(errorMessage));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        else if (object instanceof CreateAccountData createAccountData) {
            // Username already exists.
            if (database.checkUserExists(createAccountData.getUsername())) {
                try {
                    System.err.println("Username already exists.");
                    connectionToClient.sendToClient(new Error("Username already exists."));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            // Add new user to database.
            else {
                database.addUser(createAccountData.getUsername(), createAccountData.getPassword());

                try {
                    System.out.println("Successfully created account!");
                    connectionToClient.sendToClient(createAccountData);
                    System.out.println("User's ID is: " + database.getUserID(createAccountData.getUsername()));
                    Suspect character = suspects.get(0);
                    suspects.remove(0);
                    connectionToClient.sendToClient(character);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public boolean isDBConnected() {
        return isDBConnected;
    }

    // Method that handles listening exceptions by displaying exception information.
    public void listeningException(Throwable exception) {
        running = false;
        status.setText("Exception occurred while listening");
        status.setForeground(Color.RED);
        log.append("Listening exception: " + exception.getMessage() + "\n");
        log.append("Press Listen to restart server\n");
    }
}