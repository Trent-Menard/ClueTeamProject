package server;

public class GameManager {
    private final Deck deck;

    public GameManager() {
        this.deck = new Deck();
        this.deck.categorizeCards();
    }

    public Deck getDeck() {
        return deck;
    }
}