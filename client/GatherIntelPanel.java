package client;

import javax.swing.*;
import java.awt.*;

public class GatherIntelPanel extends JPanel{
	private String[] tempList = {"player 1", "player 2", "player 3", "player 4", "player 5"};
	
	public GatherIntelPanel(GatherIntelControl gic) {
		JPanel buttonPanel = new JPanel(new GridLayout(1, 5));
		JButton button1 = new JButton(tempList[0]);
		buttonPanel.add(button1);
		JButton button2 = new JButton(tempList[1]);
		buttonPanel.add(button2);
		JButton button3 = new JButton(tempList[2]);
		buttonPanel.add(button3);
		JButton button4 = new JButton(tempList[3]);
		buttonPanel.add(button4);
		JButton button5 = new JButton(tempList[4]);
		buttonPanel.add(button5);
		
		JLabel choose = new JLabel("Please select a player to gather intel from");
		
		this.setLayout(new GridLayout(2, 1));
		this.add(choose);
		this.add(buttonPanel);
	}
}
