package server;

import game.Player;
import game.Suspect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameManager {
    private final Deck deck;
    private int playersReady = 0;
    private int numOfPlayersNeededToStart;
    private final List<Player> players = new ArrayList<>();
    private List<Suspect> suspects;
    List<Deck> originalPlayerDecks = new ArrayList<>();
    private List<Player> playersCopy = new ArrayList<>();
    private Player currentPlayerTurn;
    private int counterForTurns = 0;

    public GameManager() {
        this.deck = new Deck();
        this.deck.categorizeCards();
        this.suspects = deck.getSuspects();
        this.deck.shuffle();
        this.deck.CreateEnvelope();
    }

    public void createPlayerDecks() {

        int numCardsPerPlayer = deck.getFullDeck().size() / numOfPlayersNeededToStart;
        int numCardsRemaining = deck.getFullDeck().size() % numOfPlayersNeededToStart;

        for (int i = 0; i < numOfPlayersNeededToStart; i++) {

            // Distribute as evenly as possible (whole numbers)
            Deck playerDeck = new Deck();
            for (int j = 0; j < numCardsPerPlayer; j++) {
                playerDeck.addCard(deck.getFullDeck().get(0));
                deck.getFullDeck().remove(0);
            }

            // Distribute remaining cards
            if (numCardsRemaining > 0) {
                playerDeck.addCard(deck.getFullDeck().remove(0));
                numCardsRemaining--;
            }

            originalPlayerDecks.add(playerDeck);
        }
    }

    public void assignPlayerDeck(Player player) {
        player.setDeck(originalPlayerDecks.get(0));
        originalPlayerDecks.remove(0);
    }

    public void assignPlayerCharacter(Player player) {
    	Collections.shuffle(suspects);
        player.setCharacter(suspects.get(0).getCardName());
        suspects.remove(0);
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public Deck getDeck() {
        return deck;
    }

    public int getPlayersReady() {
        return playersReady;
    }

    public void setPlayersReady(int playersReady) {
        this.playersReady = playersReady;
    }

    public void setNumOfPlayersNeededToStart(int numOfPlayersNeededToStart) {
        this.numOfPlayersNeededToStart = numOfPlayersNeededToStart;
    }

    public int getNumOfPlayersNeededToStart() {
        return numOfPlayersNeededToStart;
    }
    
    // Function to simulate rolling a six-sided die
    public int rollDice() {
        Random random = new Random();
        // Generate a random number between 1 and 6 (inclusive) for a standard six-sided die
        return random.nextInt(6) + 1;
    }

    public List<Player> getPlayers() {
        return this.players;
    }
    public List<Player> getPlayerOrder(){
    	return playersCopy;
    }
    public Player whoseTurnIsIt() {
    	Player myTurn;
    	myTurn = getPlayerOrder().get(counterForTurns % 6);
    	counterForTurns++;
    	return myTurn;
    }
    public void determinePlayerOrder(List<Player> playerList) {
    	for(Player each : playerList) {
    		playersCopy.add(each);
    	}
    	Collections.shuffle(playersCopy);
    }

    public void handlePrePlayerJoin(Player player) {

        // Only create player decks once.
        if (playersReady == 0) {
            createPlayerDecks();
        }

        assignPlayerCharacter(player);
        setPlayersReady(getPlayersReady() + 1);
        assignPlayerDeck(player);
        addPlayer(player);
    }
}