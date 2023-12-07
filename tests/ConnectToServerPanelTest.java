package tests;

import static org.junit.Assert.*;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;

import client.ConnectToServerControl;
import client.ConnectToServerPanel;
import client.View;
import clientCommunication.GameClient;

public class ConnectToServerPanelTest {

	private JButton button;
	private JPanel forBoxes;
	private JPanel forLabels;
	
	@Before
	public void setUp() {
		// create JFrame / panel
		JFrame frame = new JFrame();
		GameClient client = new GameClient();
		CardLayout cardLayout = new CardLayout();
		JPanel container = new JPanel(cardLayout);
		ConnectToServerControl ipc = new ConnectToServerControl(container, client);
		JPanel view1 = new ConnectToServerPanel(ipc);
		button = ((ConnectToServerPanel) view1).getButton();
		container.add(view1, View.CONNECT_TO_SERVER.name());
		cardLayout.show(container, View.CONNECT_TO_SERVER.name());
		forBoxes = (JPanel) view1.getComponent(1);
		forLabels = (JPanel) view1.getComponent(0);
		frame.setLayout(new GridBagLayout());
		frame.add(container);
		frame.setSize(400, 400);
		frame.setVisible(true);
		
	}

	
	// Test for RuntimeException thrown when
	// user can't connect to client
	@Test(expected = RuntimeException.class)
	public void testRunTimeException() {
		
		JTextField ipBox =  (JTextField) forBoxes.getComponent(2);
		JTextField portBox = (JTextField) forBoxes.getComponent(3);
		portBox.setText("1234");
		ipBox.setText("1234");
		
		button.doClick(500);
		
	}
	
	// Test for a numberFormatException
	@Test
	public void testNumberFormatException() {
		JTextField ipBox =  (JTextField) forBoxes.getComponent(2);
		JTextField portBox = (JTextField) forBoxes.getComponent(3);
		JLabel errorLabel = (JLabel) forLabels.getComponent(1);
		
		portBox.setText("abcd");
		ipBox.setText("1234");
		
		button.doClick(500);
		
		assertEquals("Integer not entered in Field", errorLabel.getText(), "Invalid port number.");
	}
	
	// If both fields are empty
	@Test
	public void testFieldsEmpty() {
		JTextField ipBox =  (JTextField) forBoxes.getComponent(2);
		JTextField portBox = (JTextField) forBoxes.getComponent(3);
		JLabel errorLabel = (JLabel) forLabels.getComponent(1);
		
		portBox.setText("");
		ipBox.setText("");
		
		button.doClick(500);
		
		assertEquals("Integer not entered in Field", errorLabel.getText(), "Missing IP address & port number.");
	}
	
	// if if field is blank
	@Test
	public void testIpFieldEmpty() {
		JTextField ipBox =  (JTextField) forBoxes.getComponent(2);
		JTextField portBox = (JTextField) forBoxes.getComponent(3);
		JLabel errorLabel = (JLabel) forLabels.getComponent(1);
		
		portBox.setText("8300");
		ipBox.setText("");
		
		button.doClick(500);
		
		assertEquals("Integer not entered in Field", errorLabel.getText(), "Missing IP address.");
	}
	
	// test to see if port field is blank
	@Test 
	public void testPortField() {
		JTextField ipBox =  (JTextField) forBoxes.getComponent(2);
		JTextField portBox = (JTextField) forBoxes.getComponent(3);
		JLabel errorLabel = (JLabel) forLabels.getComponent(1);
		
		portBox.setText("");
		ipBox.setText("localhost");
		
		button.doClick(500);
		
		assertEquals("Integer not entered in Field", errorLabel.getText(), "Missing port number.");
	}
	
	

}