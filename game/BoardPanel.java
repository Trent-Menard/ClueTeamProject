package game;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BoardPanel extends JFrame implements Serializable {
    private final int gridSize = 15;
    private final JButton[][] gridButtons = new JButton[gridSize][gridSize];
    private List<Room> rooms = new ArrayList<>();
    private List<String> roomNames = new ArrayList<>();
    public BoardPanel() {
        this.roomNames.add("Kitchen");
        this.roomNames.add("Ballroom");
        this.roomNames.add("Conservatory");
        this.roomNames.add("Dining Room");
        this.roomNames.add("?");
        this.roomNames.add("Billard Room");
        this.roomNames.add("Lounge");
        this.roomNames.add("Hall");
        this.roomNames.add("Study");

        createBoard();
        createRooms();
        setVisible(true);
    }

    private void createBoard() {
        setTitle("Clue Board");
        setPreferredSize(new Dimension(1200, 1000));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(gridSize, gridSize));

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
                button.addActionListener(new BoardController(this, row, column));

                // Add button to 2D-Array
                gridButtons[row][column] = button;

                // Add button to Container
                add(button);
            }
        }

        // Center Frame
        setLocationRelativeTo(null);
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

    public List<Room> getRooms() {
        return rooms;
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

    public JButton[][] getGridButtons() {
        return gridButtons;
    }

    public void drawWeapons(List<Weapon> weapons) {
        for (Weapon weapon : weapons) {
            ImageIcon ii = new ImageIcon("resources/weapons/Small" + weapon.getCardName() + ".png");
            gridButtons[weapon.getXcoord()][weapon.getYcoord()].setIcon(ii);
        }
    }
}