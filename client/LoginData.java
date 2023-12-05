package client;

import java.io.Serializable;
import game.Player;

@SuppressWarnings("serial")
public class LoginData implements Serializable 
{
	// Private data fields for the username and password.
	private Player player;
	private String password;
	private String username;


	// Getters for the username and password.
	public String getUsername()
	{
		return username;
	}
	public String getPassword()
	{
		return password;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	// Constructor that initializes the username and password.
	public LoginData(String username, String password)
	{
		setUsername(username);
		setPassword(password);
	}
	private void setPassword(String password) {
		this.password = password;
	}
	private void setUsername(String username) {
		this.username = username;
	}
}