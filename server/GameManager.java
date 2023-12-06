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
    public static int rollDice() {
        Random random = new Random();
        // Generate a random number between 1 and 6 (inclusive) for a standard six-sided die
        return random.nextInt(6) + 1;
    }
}