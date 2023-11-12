package client;

public class User {
	private String un;
	private String pw;
	
	User(String username, String password){
		this.setUsername(username);
		this.setPassword(password);
	}
	public String getUsername() {
		return un;
	}
	public void setUsername(String username) {
		un = username;
	}
	public String getPassword() {
		return pw;
	}
	public void setPassword(String password) {
		pw = password;
	}
}
