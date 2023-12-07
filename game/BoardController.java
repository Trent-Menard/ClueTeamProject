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
    private BoardData boardData;
    private GameClient client;
    private List<Weapon> weapons = new ArrayList<>();
    private int row;
    private int col;

    public BoardController(BoardPanel boardPanel) {
        this.boardPanel = boardPanel;
    }

    public BoardController(BoardPanel boardPanel, int row, int col) {
        this(boardPanel);
        this.row = row;
        this.col = col;
    }

    public BoardController(BoardPanel bp, GameClient client) {
        this(bp);
        this.client = client;
    }

    public void randomizeWeapons() {

        Random random = new Random();
        int randomX;
        int randomY;

        List<Room> roomsCopy = this.boardPanel.getRooms();
//        List<Integer> xCenterPoints = new ArrayList<>();
//        List<Integer> yCenterPoints = new ArrayList<>();
//
//        xCenterPoints.add(1);
//        xCenterPoints.add(1);
//        xCenterPoints.add(1);
//        xCenterPoints.add(7);
//        xCenterPoints.add(7);
//        xCenterPoints.add(7);
//        xCenterPoints.add(13);
//        xCenterPoints.add(13);
//        xCenterPoints.add(13);
//
//        yCenterPoints.add(1);
//        yCenterPoints.add(7);
//        yCenterPoints.add(13);
//        yCenterPoints.add(1);
//        yCenterPoints.add(7);
//        yCenterPoints.add(13);
//        yCenterPoints.add(1);
//        yCenterPoints.add(7);
//        yCenterPoints.add(13);

        Weapon weapon;
        List<String> weaponNames = new ArrayList<>();
        weaponNames.add("Candlestick");
        weaponNames.add("Revolver");
        weaponNames.add("Dagger");
        weaponNames.add("Lead Pipe");
        weaponNames.add("Wrench");
        weaponNames.add("Rope");

        int randomIdx;

        roomsCopy.remove(4);

        for (int i = 0; i < 6; i++ ) {
            randomIdx = random.nextInt(roomsCopy.size());

            randomX = roomsCopy.get(randomIdx).getxCoordinates().get(randomIdx);
            randomY = roomsCopy.get(randomIdx).getyCoordinates().get(randomIdx);
            weapon = new Weapon(weaponNames.get(i), randomX, randomY);
            weapons.add(weapon);
            roomsCopy.remove(randomIdx);
        }

        boardPanel.drawWeapons(weapons);
//        setPlayerPositions();
    }

//    public void setPlayerPositions() {
//        for (Player character : this.boardData.getPlayers()) {
//            System.out.println(character.getCharacter());
//            switch (character.getCharacter()) {
//                case "Dr. Orchid" -> boardPanel.getGridButtons()[0][4].setBackground(Color.PINK);
//                case "Reverend Green" -> boardPanel.getGridButtons()[0][10].setBackground(Color.GREEN);
//                case "Mrs. Peacock" -> boardPanel.getGridButtons()[4][14].setBackground(Color.BLUE);
//                case "Professor Plum" -> boardPanel.getGridButtons()[10][14].setBackground(new Color(128, 0, 128));
//                case "Miss Scarlet" -> boardPanel.getGridButtons()[14][4].setBackground(Color.RED);
//                case "Colonel Mustard" -> boardPanel.getGridButtons()[10][0].setBackground(Color.YELLOW);
//            }
//        }
//    }

    public void setBoardData(BoardData bd) {
        this.boardData = bd;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boardPanel.getGridButtons()[row][col].setBackground(Color.RED);
        JOptionPane.showMessageDialog(boardPanel, "Clicked on cell (" + row + ", " + col + ")");
    }

    public BoardPanel getBoardPanel() {
        return boardPanel;
    }
}