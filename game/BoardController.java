package game;

import clientCommunication.GameClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardController implements ActionListener {
    private BoardPanel boardPanel;
    private GameClient client;
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boardPanel.getGridButtons()[row][col].setBackground(Color.RED);
        JOptionPane.showMessageDialog(boardPanel, "Clicked on cell (" + row + ", " + col + ")");
    }
}