package game;

import clientCommunication.GameClient;
import game.Room;
import server.Deck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class BoardController implements ActionListener {
    private BoardPanel boardPanel;
    private GameClient client;
    private Weapon weapon;
    private Player player;
    Random rand = new Random();
    
    private int row;
    private int col;
    private ArrayList<Integer> xPoints = new ArrayList<>();
    private ArrayList<Integer> yPoints = new ArrayList<>();
    
    //private int[] WeaponPointsX = {1,2,1,7,7,13,12,13};
    //private int[] WeaponPointsY = {2,7,12,2,12,2,7,12};
    	
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
    	xPoints.add(1);
    	xPoints.add(2);
    	xPoints.add(1);
    	xPoints.add(7);
    	xPoints.add(7);
    	xPoints.add(13);
    	xPoints.add(12);
    	xPoints.add(13);
    	
    	yPoints.add(2);
    	yPoints.add(7);
    	yPoints.add(12);
    	yPoints.add(2);
    	yPoints.add(12);
    	yPoints.add(2);
    	yPoints.add(7);
    	yPoints.add(12);
    	for (int i= 0; i < 6 ; i++)
    	{
    		int randX = rand.nextInt(xPoints.size());
    		int randY = rand.nextInt(yPoints.size());
    		weapon.setXcoord(randX);
    		weapon.setYcoord(randY);
    		xPoints.remove(randX);
    		yPoints.remove(randX);	
    	}
    }
    public void setPlayerPositions()
    {
    	String character = " ";
    	character = player.getCharacter();
    	
    	if (character == "Dr. Orchid") 
    	{
    		boardPanel.getGridButtons()[0][4].setBackground(Color.PINK);
    		//ImageIcon orchid = new ImageIcon("Dr Orchid.png");
    		
    		
    	}
    	if (character == "Reverend Green") 
    	{
    		boardPanel.getGridButtons()[0][10].setBackground(Color.GREEN);
    	}
    	if (character == "Mrs. Peacock") 
    	{
    		boardPanel.getGridButtons()[4][14].setBackground(Color.BLUE);
    	}
    	if (character == "Professor Plum") 
    	{
    		boardPanel.getGridButtons()[10][14].setBackground(Color.MAGENTA);
    	}
    	if (character == "Miss Scarlet") 
    	{
    		boardPanel.getGridButtons()[14][4].setBackground(Color.RED);
    	}
    	if (character == "Colonel Mustard") 
    	{
    		boardPanel.getGridButtons()[10][0].setBackground(Color.YELLOW);
    	}
    	
  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boardPanel.getGridButtons()[row][col].setBackground(Color.RED);
        JOptionPane.showMessageDialog(boardPanel, "Clicked on cell (" + row + ", " + col + ")");
    }
}