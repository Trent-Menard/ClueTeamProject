package client;

import java.awt.*;
import javax.swing.*;

public class WaitingRoomPanel extends JPanel {
	private JButton isReady;
	
	WaitingRoomPanel(WaitingRoomControl wrc){
		this.setLayout(new BorderLayout());
		isReady = new JButton("Ready?");
		isReady.addActionListener(wrc);
		this.add(isReady, BorderLayout.SOUTH);
	}
}
