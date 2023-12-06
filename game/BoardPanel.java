package game;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BoardPanel extends JFrame {
    private final int gridSize = 15;
    private final JButton[][] gridButtons = new JButton[gridSize][gridSize];
    private List<Room> rooms;
    public BoardPanel() {
    	this.rooms = new ArrayList<>();
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

    private void createRoomFromButtons(int rowStart, int rowEnd, int columnStart, int columnEnd) {
        for (int rs = rowStart; rs < rowEnd; rs++) {
            for(int cs = columnStart; cs < columnEnd; cs++){
                gridButtons[rs][cs].setBorder(new LineBorder(Color.RED, 3));
            }
        }
    }

    private void createRooms() {

        // Top 3 Rooms
        createRoomFromButtons(0, 3, 0, 3);
        gridButtons[1][1].setText("KITCHEN");
        rooms.add(new Room("Kitchen", 0, 3, 0, 3));

        createRoomFromButtons(0,3,6,9);
        gridButtons[1][7].setText("BALLROOM");
        rooms.add(new Room("Ballroom", 0, 3, 6, 9));
        
        createRoomFromButtons(0, 3, 12, 15);
        gridButtons[1][13].setText("CONSERVATORY");
        rooms.add(new Room("Conservatory", 0, 3, 12, 15));

        // Middle 3 Rooms
        createRoomFromButtons(6, 9, 0, 3);
        gridButtons[7][1].setText("DINING ROOM");
        rooms.add(new Room("Dining Room", 6, 9, 0, 3));
        
        createRoomFromButtons(6, 9, 6, 9);
        gridButtons[7][7].setText("?");
        rooms.add(new Room("?", 6, 9, 6, 9));
        
        createRoomFromButtons(6, 9, 12, 15);
        gridButtons[7][13].setText("BILLIARD ROOM");
        rooms.add(new Room("Billard Room", 6, 9, 12, 15));

        // Bottom 3 Rooms
        createRoomFromButtons(12, 15, 0, 3);
        gridButtons[13][1].setText("LOUNGE");
        rooms.add(new Room("Lounge", 12, 15, 0, 3));

        createRoomFromButtons(12, 15, 6, 9);
        gridButtons[13][7].setText("HALL");
        rooms.add(new Room("Hall", 12, 15, 6, 9));

        createRoomFromButtons(12, 15, 12, 15);
        gridButtons[13][13].setText("STUDY");
        rooms.add(new Room("Study", 12, 15, 12, 15));
    }

    public JButton[][] getGridButtons() {
        return gridButtons;
    }

    public void drawWeapons(List<Weapon> weapons) {
        for (Weapon weapon : weapons) {
            ImageIcon ii = new ImageIcon("resources/weapons/Small" + weapon.getWeaponName() + ".png");
            gridButtons[weapon.getXcoord()][weapon.getYcoord()].setIcon(ii);
        }
    }
}