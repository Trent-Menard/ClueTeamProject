package serverCommunication;

import client.AccusationData;
import client.CreateAccountData;
import client.GatherIntelData;
import client.LoginData;
import client.WaitingRoomData;
import client.PlayerTurnData;
import database.Database;
import game.BoardController;
import game.BoardData;
import game.Card;
import game.Player;
import game.Suspect;
import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;
import server.DataNeededForClient;
import server.GameManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class GameServer extends AbstractServer {
    private JTextArea log;
    private JLabel status;
    private boolean running = false;
    private final Database database = new Database();
    private final boolean isDBConnected;
    private int numOfPlayers;
    private GameManager gameManager;
    private BoardData boardData;
    private DataNeededForClient dataNeededForClient;
    private List<String> currentAccusation = new ArrayList<String>();

    // Constructor for initializing the server with default settings.
    public GameServer() {
        super(12345);
        this.setTimeout(500);
        isDBConnected = database.isConnected();
        this.gameManager = new GameManager();
        this.dataNeededForClient = new DataNeededForClient();
        boardData = new BoardData();
        boardData.createBoard();
        boardData.randomizeWeapons();
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
        try {
            log.append("Running on: " + InetAddress.getLocalHost().getHostAddress() + " with port: " + this.getPort() + "\n");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
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
                    System.out.println("User is authenticated.");

                    Player player = new Player(loginData.getUsername(), loginData.getPassword());
                    gameManager.handlePrePlayerJoin(player);

//                    gameManager.assignPlayerCharacter(player);
//                    gameManager.setPlayersReady(gameManager.getPlayersReady() + 1);
//                    gameManager.createPlayerDecks();
//                    gameManager.assignPlayerDeck(player);
//                    gameManager.addPlayer(player);

                    loginData.setPlayer(player);
                    boardData.setPlayers(gameManager.getPlayers());
                    dataNeededForClient.setPlayersReady(gameManager.getPlayersReady());

                    if (gameManager.getNumOfPlayersNeededToStart() == gameManager.getPlayersReady()) {
                        dataNeededForClient.setStarting(true);
                        System.out.println("Starting the game!");

//                        boardData.setPlayers(gameManager.getPlayers());

                        connectionToClient.sendToClient(boardData);
                    }

                    System.out.println("Players ready: " + gameManager.getPlayersReady() + "/" + gameManager.getNumOfPlayersNeededToStart());

                    connectionToClient.sendToClient(loginData);
                    connectionToClient.sendToClient(dataNeededForClient);
                    connectionToClient.sendToClient(player);

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
                else {
					errorMessage = "Account does not exist.";
					try {
						System.err.println(errorMessage);
						connectionToClient.sendToClient(new Error(errorMessage));
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
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

                    Player player = new Player(createAccountData.getUsername(), createAccountData.getPassword());
                    gameManager.handlePrePlayerJoin(player);

                    createAccountData.setPlayer(player);
                    boardData.setPlayers(gameManager.getPlayers());
                    dataNeededForClient.setPlayersReady(gameManager.getPlayersReady());

                    if (gameManager.getNumOfPlayersNeededToStart() == gameManager.getPlayersReady()) {
                        dataNeededForClient.setStarting(true);
                        System.out.println("Starting the game!");

//                        boardData.setPlayers(gameManager.getPlayers());

                        connectionToClient.sendToClient(boardData);
                    }

                    System.out.println("Players ready: " + gameManager.getPlayersReady() + "/" + gameManager.getNumOfPlayersNeededToStart());
                    System.out.println("User's ID is: " + database.getUserID(createAccountData.getUsername()));

                    connectionToClient.sendToClient(createAccountData);
                    connectionToClient.sendToClient(dataNeededForClient);
                    connectionToClient.sendToClient(player);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

		else if (object instanceof WaitingRoomData waitingRoomData) {}

		else if (object instanceof PlayerTurnData playerTurn) {
            if (playerTurn.getTurnType().equals("Roll Dice")) {
                //Roll Dice
                playerTurn.setRoll(gameManager.rollDice());
                try {
                    connectionToClient.sendToClient(playerTurn);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

		else if (object instanceof AccusationData accusationData) {
            boolean isFinal = accusationData.isFinal();
            List<Card> envelope = gameManager.getDeck().getEnvelope();
            int matches = 0;
            currentAccusation.add(accusationData.getRoom());
            currentAccusation.add(accusationData.getSuspect());
            currentAccusation.add(accusationData.getWeapon());
            for (String each : currentAccusation) {
                for (int j = 0; j < envelope.size(); j++) {
                    if (each.equals(envelope.get(j).getCardName())) {
                        matches++;
                    }
                }
            }
            if (matches == 3 && isFinal) {
                //WINNER WINNER CHICKEN DINNER
            } else if (matches != 3 && isFinal) {
                //KILL HIM
            } else if (!isFinal) {
                //Tell Client theyre allowed to gather intel? gatherIntelControl automatically
                //Sends them to gatherIntelPanel if they don't select isFinal
            }
        }

		else if (object instanceof GatherIntelData intelData) {
            Player playerToGatherIntelFrom = null;
            String playerWeWantIntelFrom = intelData.getPlayer();
            for (Player each : gameManager.getPlayers()) {
                if (each.getCharacter().equals(playerWeWantIntelFrom)) {
                    playerToGatherIntelFrom = each;
                }
            }
            if (!playerToGatherIntelFrom.equals(null)) {
                List<Card> hand = playerToGatherIntelFrom.getPlayerHand();
                weGotCard:
                for (Card each : hand) {
                    for (int i = 0; i < currentAccusation.size(); i++) {
                        if (each.getCardName().equals(currentAccusation.get(i))) {
                            break weGotCard;
                        }
                    }
                }
            }
        }
    }

    public boolean isDBConnected() {
        return isDBConnected;
    }

    public void setNumOfPlayers(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
        this.gameManager.setNumOfPlayersNeededToStart(numOfPlayers);
        this.dataNeededForClient.setPlayersNeededToStart(numOfPlayers);
    }
}