package server;

import game.Player;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private final Deck deck;
    private int playersReady = 0;
    private final int MIN_PLAYERS_NEEDED_TO_START = 0;
    private final List<Player> players = new ArrayList<>();

    public GameManager() {
        this.deck = new Deck();
        this.deck.categorizeCards();
    }

    public void assignPlayerDeck(Player player) {
    }

    public void assignPlayerCharacter(Player player) {
        player.setCharacter(deck.getSuspects().get(0).getSuspectName());
        deck.getSuspects().remove(0);
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
}