package client;

import java.awt.*;

import javax.swing.*;

public class WaitingRoomPanel extends JPanel {
	private JButton isReady;
	private JLabel msg;
	private JButton back;

	WaitingRoomPanel(WaitingRoomControl wrc){
		JPanel labelPanel = new JPanel();
		msg = new JLabel("Are ya ready kids?");
		labelPanel.add(msg);
						
		back = new JButton("Cancel");
		back.addActionListener(wrc);
		isReady = new JButton("Vote to Start");
		isReady.addActionListener(wrc);
		JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
		buttonPanel.add(back);
		buttonPanel.add(isReady);
		
		this.setLayout(new GridLayout(2, 1));
		this.add(labelPanel);
		this.add(buttonPanel);
	}

	public void setMsg(String msg) {
		this.msg.setText(msg);
	}
}
