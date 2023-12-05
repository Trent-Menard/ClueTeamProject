package game;

import server.Deck;

import java.io.Serializable;
import java.util.List;


public class Player implements Serializable {

    private final String username;
    private final String password;
    private int ID;
    private String character;
    private Deck deck;
	private List<Card> playerHand;

    public Player(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getID() {
        return ID;
    }

    public String getCharacter() {
        return character;
    }

    public Deck getDeck() {
        return deck;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }
    
    public List<Card> getPlayerHand()
    {
    	return playerHand;
    }
    
    public void setPlayerHand(List<Card> playerHand) {
        this.playerHand = playerHand;
    }
}