package game;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BoardData implements Serializable {
    private Player player;
    private List<Player> players = new ArrayList<>();
    private List<Weapon> weapons = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();
    private final int gridSize = 15;
    private final JButton[][] gridButtons = new JButton[gridSize][gridSize];
    public void createBoard(){
        createGridButtons();
        createRooms();
    }
    public void createGridButtons() {
        for (int row = 0; row < gridSize; row++) {
            for (int column = 0; column < gridSize; column++) {
                JButton button = new JButton("(" + row + ", " + column + ")");

                // Sum to treat row & column as single cell; Alternate colors.
                if ((row + column) % 2 == 0) {
                    button.setBackground(Color.lightGray);
                } else {
                    button.setBackground(Color.darkGray);
                }

                // Remove default button UI (prevent gloss-over/highlight when pressed).
                button.setUI(new BasicButtonUI());

                // Remove button border
//                button.setBorderPainted(false);

                // Add Action Listener for button press.

                // TODO: 12/6/2023 CLIENT SIDE CONTROLLER HANDLING
//                button.addActionListener(new BoardController(this, row, column));

                // Add button to 2D-Array
                gridButtons[row][column] = button;

                // Add button to Container
//                add(button);
            }
        }
    }

    private void createRoomFromButtons(String roomName, int rowStart, int rowEnd, int columnStart, int columnEnd) {
        Room room = new Room(roomName);
        for (int rs = rowStart; rs < rowEnd; rs++) {
            for(int cs = columnStart; cs < columnEnd; cs++){
                gridButtons[rs][cs].setBorder(new LineBorder(Color.RED, 3));
                room.addXCoordinate(rs);
                room.addYCoordinate(cs);
            }
        }
        this.rooms.add(room);
    }

    private void createRooms() {
        // Top 3 Rooms
        createRoomFromButtons("Kitchen", 0, 3, 0, 3);
        gridButtons[1][1].setText("Kitchen");

        createRoomFromButtons("Ballroom",0,3,6,9);
        gridButtons[1][7].setText("Ballroom");

        createRoomFromButtons("Conservatory",0, 3, 12, 15);
        gridButtons[1][13].setText("Conservatory");

        // Middle 3 Rooms
        createRoomFromButtons("Dining Room",6, 9, 0, 3);
        gridButtons[7][1].setText("Dining Room");

        createRoomFromButtons("?",6, 9, 6, 9);
        gridButtons[7][7].setText("?");

        createRoomFromButtons("Billard Room",6, 9, 12, 15);
        gridButtons[7][13].setText("Billard Room");

        // Bottom 3 Rooms
        createRoomFromButtons("Lounge",12, 15, 0, 3);
        gridButtons[13][1].setText("Lounge");

        createRoomFromButtons("Hall",12, 15, 6, 9);
        gridButtons[13][7].setText("Hall");

        createRoomFromButtons("Study",12, 15, 12, 15);
        gridButtons[13][13].setText("Study");
    }


//    public void setPlayer(Player player) {
//        this.player = player;
//    }
//
//    public Player getPlayer() {
//        return this.player;
//    }
//
    public List<Player> getPlayers() {
        return this.players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void randomizeWeapons() {
        Random random = new Random();
        int randomX;
        int randomY;

        List<Room> roomsCopy = this.rooms;

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

        for (int i = 0; i < 6; i++) {
            randomIdx = random.nextInt(roomsCopy.size());

            randomX = roomsCopy.get(randomIdx).getxCoordinates().get(randomIdx);
            randomY = roomsCopy.get(randomIdx).getyCoordinates().get(randomIdx);
            weapon = new Weapon(weaponNames.get(i), randomX, randomY);
            weapons.add(weapon);
            roomsCopy.remove(randomIdx);
        }





//        boardPanel.drawWeapons(weapons);
//        setPlayerPositions();
    }

    // TODO: 12/6/2023 BELOW IN CONTROLLER

//    public void drawWeapons(){
//        for (Weapon weapon : weapons) {
//            ImageIcon ii = new ImageIcon("resources/weapons/Small" + weapon.getCardName() + ".png");
//            gridButtons[weapon.getXcoord()][weapon.getYcoord()].setIcon(ii);
//        }
//    }

//    public void drawPlayerPositions() {
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
}