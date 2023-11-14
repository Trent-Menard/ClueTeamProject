package client;

import java.awt.*;
import javax.swing.*;

public class IPPanel extends JPanel{
	JTextField ipBox;
	JTextField portBox;
	
	IPPanel(IPControl ipc){
		//Instructions
		JPanel instructionPanel = new JPanel(new GridLayout(1, 1, 5, 5));
		JLabel instructions = new JLabel("Please enter your desired IP and port number to use for connection.");
		instructionPanel.add(instructions);
		
		//Data Entry
		JPanel boxPanel = new JPanel(new GridLayout(2, 1, 5, 5));
		ipBox = new JTextField();
		portBox = new JTextField();
		boxPanel.add(ipBox);
		boxPanel.add(portBox);
		
		//Button
		JPanel buttonBox = new JPanel(new GridLayout(1, 1, 5, 5));
		JButton connect = new JButton("Connect");
		connect.addActionListener(ipc);
		buttonBox.add(connect);
		
		//Put it all together
		this.setLayout(new GridLayout(3, 1, 5, 5));
		this.add(instructionPanel);
		this.add(boxPanel);
		this.add(buttonBox);	
	}
	
	public String getIP() {
		return ipBox.getText();
	}
	
	public int getPort() {
		return Integer.parseInt(portBox.getText());
	}
}
