package client;

import java.awt.*;
import javax.swing.*;

public class AccusationPanel extends JPanel{
	
	
	public AccusationPanel(/*some sort of controller*/) {
		JPanel choicePanel = new JPanel(new GridLayout(1, 3));
		JComboBox suspects = new JComboBox();
		JComboBox weapons = new JComboBox();
		JComboBox rooms = new JComboBox();
		
		JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
		JButton confirm = new JButton("Confirm");
		JButton cancel = new JButton("Cancel");
	}
}
