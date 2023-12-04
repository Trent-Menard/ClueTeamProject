package client;

import java.awt.*;
import javax.swing.*;

public class PlayerTurnPanel extends JPanel{
	
	
	public PlayerTurnPanel(PlayerTurnControl ptc) {
		JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
		JButton roll = new JButton("Roll Dice");
		buttonPanel.add(roll);
		JButton skip = new JButton("Skip Turn");
		buttonPanel.add(skip);
		JButton accuse = new JButton("Make Accusation/Suggestion");
		buttonPanel.add(accuse);
		
		roll.addActionListener(ptc);
		skip.addActionListener(ptc);
		accuse.addActionListener(ptc);
		
		this.add(buttonPanel);
	}
}
