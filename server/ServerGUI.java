package server;

import serverCommunication.GameServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ServerGUI extends JFrame {
    private final JLabel status;
    private final String[] labels = {"Port #", "Timeout", "# of Players"};
    private final JTextField[] textFields = new JTextField[labels.length];
    private final JTextArea log;
    private final JButton listen;
    private final JButton close;
    private final JButton stop;
    private final JButton quit;
    private final GameServer server;
    private int numOfPlayers = 0;

    public ServerGUI() {
        // Create the main variables that will be used.
        JPanel north = new JPanel();
        JPanel center = new JPanel(new BorderLayout());
        JPanel south = new JPanel();
        EventHandler handler = new EventHandler();

        // Set the title and default close operation.
        this.setTitle("Clue Server");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the status label.
        JLabel statusText = new JLabel("Status:");
        north.add(statusText);
        status = new JLabel("Not Connected");
        status.setForeground(Color.RED);
        north.add(status);

        // Create the grid of text fields.
        JPanel centerNorth = new JPanel(new GridLayout(labels.length, 2, 5, 5));
        for (int i = 0; i < textFields.length; i++) {
            JLabel label = new JLabel(labels[i], JLabel.RIGHT);
            centerNorth.add(label);
            textFields[i] = new JTextField(10);
            centerNorth.add(textFields[i]);
        }

        // Set some default values for the server.
        textFields[0].setText("8300");
        textFields[1].setText("500");
        textFields[2].setText("2");

        // Buffer the grid of text fields and add it to the north part of the center.
        JPanel centerNorthBuffer = new JPanel();
        centerNorthBuffer.add(centerNorth);
        center.add(centerNorthBuffer, BorderLayout.NORTH);

        // Create the server log panel.
        JPanel serverLogPanel = new JPanel(new BorderLayout());
        JLabel serverLabel = new JLabel("Server Log", JLabel.CENTER);
        JPanel serverLabelBuffer = new JPanel();
        serverLabelBuffer.add(serverLabel);
        serverLogPanel.add(serverLabelBuffer, BorderLayout.NORTH);
        log = new JTextArea(10, 35);
        log.setEditable(false);
        JScrollPane serverLogPane = new JScrollPane(log);
        JPanel serverLogPaneBuffer = new JPanel();
        serverLogPaneBuffer.add(serverLogPane);
        serverLogPanel.add(serverLogPaneBuffer, BorderLayout.SOUTH);

        // Add the server log panel to the south part of the center.
        JPanel centerSouth = new JPanel();
        centerSouth.add(serverLogPanel);
        center.add(centerSouth, BorderLayout.SOUTH);

        // Create the buttons.
        listen = new JButton("Listen");
        listen.addActionListener(handler);
        south.add(listen);
        close = new JButton("Close");
        close.addActionListener(handler);
        south.add(close);
        stop = new JButton("Stop");
        stop.addActionListener(handler);
        south.add(stop);
        quit = new JButton("Quit");
        quit.addActionListener(handler);
        south.add(quit);

        // Add the north, center, and south JPanels to the JFrame.
        this.add(north, BorderLayout.NORTH);
        this.add(center, BorderLayout.CENTER);
        this.add(south, BorderLayout.SOUTH);

        // Display the window.
        this.setSize(450, 450);
        this.setVisible(true);

        // Set up the chat server object.
        server = new GameServer();
        server.setLog(log);
        server.setStatus(status);

        if (!server.isDBConnected()) {
            status.setText("Can't connect to database");
            log.append("[Error:] Can't connect to DB. Bypassing login for now.\n");
            // TODO: 11/22/2023 Remove this; Bypass server start if can't connect to DB.
//            listen.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        new ServerGUI();
    }

    // Getters for the important components.
    public JTextField getTextFieldAt(int index) {
        return textFields[index];
    }

    public JLabel getStatus() {
        return status;
    }

    public JTextArea getLog() {
        return log;
    }

    // Class for handling events.
    class EventHandler implements ActionListener {
        // Event handler for ActionEvent.
        public void actionPerformed(ActionEvent e) {
            // Determine which button was clicked.
            Object buttonClicked = e.getSource();

            // Handle the Listen button.
            if (buttonClicked == listen) {

                boolean isValid = true;

                // Display an error if the port number or timeout was not entered.
                if (textFields[0].getText().equals("") || textFields[1].getText().equals("")) {
                    log.append("Port number or timeout not entered before pressing Listen\n");
                    isValid = false;
                }

                if (textFields[2].getText().isBlank()) {
                    log.append("Missing # of Players.\n");
                    isValid = false;
                }

                numOfPlayers = Integer.parseInt(textFields[2].getText());

                if (numOfPlayers < 2) {
                    log.append("Minimum of 2 players required.\n");
                    isValid = false;
                }

                if (numOfPlayers > 6) {
                    log.append("Maximum of 6 players.\n");
                    isValid = false;
                }

                if (isValid) {
                    server.setNumOfPlayers(numOfPlayers);

                    server.setPort(Integer.parseInt(textFields[0].getText()));
                    server.setTimeout(Integer.parseInt(textFields[1].getText()));
                    try {
                        server.listen();
                    } catch (IOException e1) {
                        log.append("An exception occurred: " + e1.getMessage() + "\n");
                    }
                }
            }

            // Handle the Close button.
            else if (buttonClicked == close) {
                // Display an error if the server has not been started.
                if (!server.isListening()) {
                    log.append("Server not currently started\n");
                }

                // Otherwise, close the server.
                else {
                    try {
                        server.close();
                    } catch (IOException e1) {
                        log.append("An exception occurred: " + e1.getMessage() + "\n");
                    }
                }
            }

            // Handle the Stop button.
            else if (buttonClicked == stop) {
                // Display an error if the server is not listening.
                if (!server.isListening()) {
                    log.append("Server not currently listening\n");
                }

                // Otherwise, stop listening.
                else {
                    server.stopListening();
                }
            }

            // For the Quit button, just stop this program.
            else if (buttonClicked == quit) {
                System.exit(0);
            }
        }
    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }
}