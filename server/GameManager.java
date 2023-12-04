package server;

import game.Player;
import game.Suspect;
import game.Card;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameManager {
    private final Deck deck;
    private int playersReady = 0;
    private final int MIN_PLAYERS_NEEDED_TO_START = 0;
    private final List<Player> players = new ArrayList<>();
    private List<Suspect> suspects = new ArrayList<>();

    public GameManager() {
        this.deck = new Deck();
        this.deck.categorizeCards();
        this.suspects = deck.getSuspects();
    }

    public void assignPlayerDeck(Player player) {
    	
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

    public int getPlayersReady() {
        return playersReady;
    }

    public void setPlayersReady(int playersReady) {
        this.playersReady = playersReady;
    }
}