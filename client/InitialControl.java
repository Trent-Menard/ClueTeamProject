package client;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import clientCommunication.*;

public class InitialControl implements ActionListener
{
  private final JPanel container;
  private GameClient client;
  public InitialControl(JPanel container, GameClient client)
  {
    this.container = container;
    this.client = client;
  }
  
  // Handle button clicks.
  public void actionPerformed(ActionEvent ae)
  {
    // Get the name of the button clicked.
    String command = ae.getActionCommand();
    
    // The Login button takes the user to the login panel.
    if (command.equals("Login"))
    {
      LoginPanel loginPanel = (LoginPanel)container.getComponent(2);
      loginPanel.setError("");
      CardLayout cardLayout = (CardLayout)container.getLayout();
      cardLayout.show(container, "3");
     
    }
    
    // The Create button takes the user to the create account panel.
    else if (command.equals("Create"))
    {
      CreateAccountPanel createAccountPanel = (CreateAccountPanel)container.getComponent(3);
      createAccountPanel.setError("");
      CardLayout cardLayout = (CardLayout)container.getLayout();
      cardLayout.show(container, "4");
    }
  }
}
