package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import game.Player;
import server.Deck;
import server.GameManager;

public class GameManagerTest {

	private GameManager gameManager;
	private int numPlayers;
	private Deck deck;
	private Player player1;
	private Player player2;
	private Player player3;
	private Player player4; 
	
	@Before
	public void setUpGameManager() {
		gameManager = new GameManager();
		numPlayers = 4;
		gameManager.setNumOfPlayersNeededToStart(numPlayers);
		player1 = new Player("user1", "password1");
		player2 = new Player("user2", "password2");
		player3 = new Player("user3", "password3");
		player4 = new Player("user4", "password4");
		deck = new Deck();
	}

	// Test to see if all cards are distributed to players.
	// No cards should remain
	@Test
	public void testCreatePlayerDecks() {
		// deal cards to multiple decks based on number of players
		gameManager.createPlayerDecks();

		// assign each player a deck
		gameManager.assignPlayerDeck(player1);
		gameManager.assignPlayerDeck(player2);
		gameManager.assignPlayerDeck(player3);
		gameManager.assignPlayerDeck(player4);

		// GameManager's deck should be zero
		deck = gameManager.getDeck();

		assertEquals("Decks are not empty", deck.getFullDeck().size(), 0);
	}

}
