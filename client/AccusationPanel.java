package client;

import java.awt.*;
import javax.swing.*;

public class AccusationPanel extends JPanel{
	private String[] roomList = {"Kitchen", "Ballroom", "Conservatory", "Dining Room", "Billiard Room", "Lounge", "Hall", "Study"};
	private String[] weaponList = {"Candlestick", "Revolver", "Dagger", "Lead Pipe", "Wrench", "Rope"};
	private String[] suspectList = {"Colonel Mustard", "Miss Scarlet", "Mrs. Peacock", "Dr. Orchid", "Professor Plum", "Reverend Green"};
	JComboBox<String> suspects;
	JComboBox<String> weapons;
	JComboBox<String> rooms;
	JCheckBox isFinal;
	
	public AccusationPanel(AccusationControl ac) {
		JPanel choicePanel = new JPanel(new GridLayout(1, 3));
		suspects = new JComboBox<>(suspectList);
		choicePanel.add(suspects);
		rooms = new JComboBox<>(roomList);
		choicePanel.add(rooms);
		weapons = new JComboBox<>(weaponList);
		choicePanel.add(weapons);
		
		JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
		JButton cancel = new JButton("Cancel");
		buttonPanel.add(cancel);
		JButton confirm = new JButton("Confirm");
		buttonPanel.add(confirm);
		isFinal = new JCheckBox("Final Accusation?");
		buttonPanel.add(isFinal);

		cancel.addActionListener(ac);
		confirm.addActionListener(ac);

		this.setLayout(new GridLayout(2, 1));
		this.add(choicePanel);
		this.add(buttonPanel);
	}
	
	public String getSuspect() {
        return (String) suspects.getSelectedItem();
	}
	public String getRoom() {
        return (String) rooms.getSelectedItem();
	}
	public String getWeapon() {
        return (String) weapons.getSelectedItem();
	}
	public boolean getIsFinal() {
        return isFinal.isSelected();
	}
}