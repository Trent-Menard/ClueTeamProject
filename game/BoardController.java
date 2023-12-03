package game;

import clientCommunication.GameClient;
import game.Room;
import server.Deck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class BoardController implements ActionListener {
    private BoardPanel boardPanel;
    private GameClient client;
    private Weapon weapon;
    private Room room;
    private Deck deck;
    Random rand = new Random();
    
    private int row;
    private int col;
    private int[] WeaponPointsX = {1,2,1,7,7,13,12,13};
    private int[] WeaponPointsY = {2,7,12,2,12,2,7,12};
    	
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
    public void randomizeWeapons(Weapon weapon)
    {
    	for (int i= 0; i < 6 ; i++)
    	{
    		int randX = rand.nextInt(WeaponPointsX.length);
    		int randY = rand.nextInt(WeaponPointsY.length);
    		weapon.setXcoord(randX);
    		weapon.setYcoord(randY);
    	}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boardPanel.getGridButtons()[row][col].setBackground(Color.RED);
        JOptionPane.showMessageDialog(boardPanel, "Clicked on cell (" + row + ", " + col + ")");
    }
}