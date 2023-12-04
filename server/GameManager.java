package server;

import java.util.Collections;

import game.Player;

public class GameManager {
    private final Deck deck;
   

    public GameManager() {
        this.deck = new Deck();
        this.deck.categorizeCards();
    }

    public void assignPlayerDeck(Player player) {
    	player.setPlayerHand(deck.getPlayerHand());
    }

    public void assignPlayerCharacter(Player player) {
    	Collections.shuffle(suspects);
        player.setCharacter(suspects.get(0).getSuspectName());
        suspects.remove(0);
    }

    public void addPlayer(Player player) {
        this.players.add(player);

    }

    public Deck getDeck() {
        return deck;
    }
}