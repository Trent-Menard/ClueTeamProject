package client;

import java.awt.*;
import javax.swing.*;

public class IPPanel extends JPanel{
	JTextField ipBox;
	JTextField portBox;
	JLabel errorMsg;

	IPPanel(IPControl ipc){
		//Instructions
		JPanel instructionPanel = new JPanel(new GridLayout(2, 1, 5, 5));
		JLabel instructions = new JLabel("Please enter the Host's IP address and port number.");
		errorMsg = new JLabel("", JLabel.CENTER);
		errorMsg.setForeground(Color.RED);

		instructionPanel.add(instructions);
		instructionPanel.add(errorMsg);

		//Data Entry
		JPanel boxPanel = new JPanel(new GridLayout(2, 2, 5, 5));
		JLabel ipAddress = new JLabel("IP address:", JLabel.CENTER);
		JLabel portNumber = new JLabel("Port number:", JLabel.CENTER);

		boxPanel.add(ipAddress);
		boxPanel.add(portNumber);

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
	
	public String getPort() {
		return portBox.getText();
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg.setText(errorMsg);
	}
}
