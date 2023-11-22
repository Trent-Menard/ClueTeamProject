package client;

import java.awt.*;
import javax.swing.*;

public class WaitingRoomPanel extends JPanel {
	private final JButton isReady;
	private final JComboBox characters;
	private final JLabel msg;
	private final JButton choose;
	private final JButton back;
	
	WaitingRoomPanel(WaitingRoomControl wrc){
		JPanel labelPanel = new JPanel();
		msg = new JLabel("Please Choose Your Character");
		labelPanel.add(msg);
		
		JPanel boxPanel = new JPanel(new GridLayout(1, 2));
		choose = new JButton("Confirm");
		choose.addActionListener(wrc);
		String[] chars = {"char1", "char2", "char3", "char4", "char5", "char6"};
		characters = new JComboBox(chars);
		characters.setEditable(true);
		wrc.setMyComboBox(characters);
		boxPanel.add(characters);
		boxPanel.add(choose);
		
		back = new JButton("Cancel");
		back.addActionListener(wrc);
		isReady = new JButton("Ready?");
		isReady.addActionListener(wrc);
		JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
		buttonPanel.add(back);
		buttonPanel.add(isReady);
		
		this.setLayout(new GridLayout(2, 1));
		this.add(boxPanel);
		this.add(buttonPanel);
	}
}
