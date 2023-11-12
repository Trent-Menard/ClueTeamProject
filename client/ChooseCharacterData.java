package client;

public class ChooseCharacterData {
	private String character;
	
	public String getCharacter() {
		return this.character;
	}
	
	public void setCharacter(String character) {
		this.character = character;
	}
	
	ChooseCharacterData(String character){
		this.setCharacter(character);
	}
}
