package game;

import clientCommunication.GameClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BoardController implements ActionListener {
    private BoardPanel boardPanel;
    private GameClient client;
    private List<Weapon> weapons = new ArrayList<>();
    private Player player;
    private int row;
    private int col;

    public BoardController(BoardPanel boardPanel) {
        this.boardPanel = boardPanel;
        
    }

    public BoardController(BoardPanel boardPanel, int row, int col) {
        this.boardPanel = boardPanel;
        this.row = row;
        this.col = col;
    }

    public BoardController(BoardPanel bp, GameClient client) {
        this(bp);
        this.client = client;
        this.player = client.getPlayer();
    }

    public void randomizeWeapons() {
        List<Integer> xPlacementCoords = new ArrayList<>();
        xPlacementCoords.add(0);
        xPlacementCoords.add(1);
        xPlacementCoords.add(2);
        xPlacementCoords.add(6);
        xPlacementCoords.add(7);
        xPlacementCoords.add(8);
        xPlacementCoords.add(12);
        xPlacementCoords.add(13);
        xPlacementCoords.add(14);

        List<Integer> yPlacementCoords = new ArrayList<>(xPlacementCoords);

        Random random = new Random();
        int randomXIdx;
        int randomX;
        int randomYIdx;
        int randomY;

        Weapon weapon;
        List<String> weaponNames = new ArrayList<>();

        weaponNames.add("Candlestick");
        weaponNames.add("Revolver");
        weaponNames.add("Dagger");
        weaponNames.add("Lead Pipe");
        weaponNames.add("Wrench");
        weaponNames.add("Rope");

        for(int i = 0; i < 6; i ++) {

            randomXIdx = random.nextInt(xPlacementCoords.size());
            randomX = xPlacementCoords.get(randomXIdx);

            randomYIdx = random.nextInt(yPlacementCoords.size());
            randomY = yPlacementCoords.get(randomYIdx);

            weapon = new Weapon(weaponNames.get(i), randomX, randomY);
            weapons.add(weapon);

            xPlacementCoords.remove(randomXIdx);
            yPlacementCoords.remove(randomYIdx);
        }

        boardPanel.drawWeapons(weapons);
    }

    public void setPlayerPositions() {
        String character = "";
        character = player.getCharacter();

        if (character == "Dr. Orchid") {
            boardPanel.getGridButtons()[0][4].setBackground(Color.PINK);
            //ImageIcon orchid = new ImageIcon("Dr Orchid.png");
        }
        if (character == "Reverend Green") {
            boardPanel.getGridButtons()[0][10].setBackground(Color.GREEN);
        }
        if (character == "Mrs. Peacock") {
            boardPanel.getGridButtons()[4][14].setBackground(Color.BLUE);
        }
        if (character == "Professor Plum") {
            boardPanel.getGridButtons()[10][14].setBackground(Color.MAGENTA);
        }
        if (character == "Miss Scarlet") {
            boardPanel.getGridButtons()[14][4].setBackground(Color.RED);
        }
        if (character == "Colonel Mustard") {
            boardPanel.getGridButtons()[10][0].setBackground(Color.YELLOW);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boardPanel.getGridButtons()[row][col].setBackground(Color.RED);
        JOptionPane.showMessageDialog(boardPanel, "Clicked on cell (" + row + ", " + col + ")");
    }
}