package client;

import java.awt.*;
import javax.swing.*;

public class ChooseCharacterPanel extends JPanel{
	private final JComboBox characters;
	private final JLabel msg;
	private final JButton choose;
	private final JButton back;

	ChooseCharacterPanel(ChooseCharacterControl ccc){
		JPanel labelPanel = new JPanel();
		msg = new JLabel("Please Choose Your Character");
		labelPanel.add(msg);
		
		JPanel boxPanel = new JPanel();
		String[] chars = {"char1", "char2", "char3", "char4", "char5", "char6"};
		characters = new JComboBox(chars);
		characters.setEditable(true);
		ccc.setMyComboBox(characters);
		boxPanel.add(characters);
		
		choose = new JButton("Confirm");
		back = new JButton("Cancel");
		choose.addActionListener(ccc);
		back.addActionListener(ccc);
		JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
		buttonPanel.add(back);
		buttonPanel.add(choose);
		
		this.setLayout(new GridLayout(3, 1));
		this.add(labelPanel);
		this.add(boxPanel);
		this.add(buttonPanel);
	}
}
