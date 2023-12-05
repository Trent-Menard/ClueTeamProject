package client;

import java.awt.*;
import javax.swing.*;
import game.*;
import java.util.*;

public class PlayerTurnPanel extends JPanel{
	Collection<Card> hand;
	
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
		
		//for Player Hand
		Player player = ptc.getClient().getPlayer();
		hand = player.getPlayerHand();
		JPanel handPanel = new JPanel(new GridLayout(1, hand.size()));
		JLabel[] labels = new JLabel[hand.size()];
		int counter = 0;
		for(Card card : hand) {
			if(card.getCategory().equals("Room")) {
				labels[counter] = new JLabel(card.getCardName());
			}
			else {
				String cat = card.getCategory();
				String name = card.getCardName();
				String fileLocation = "resources/" + cat.toLowerCase() + "s/" + name + ".png"; 
				ImageIcon ii = new ImageIcon(fileLocation);
				labels[counter] = new JLabel(ii);
			}
			handPanel.add(labels[counter]);
			counter++;
		}
		
		this.setLayout(new GridLayout(2, 1));
		this.add(buttonPanel);	
		this.add(handPanel);
	}
}
