package server;

public class GameManager {
    private final Deck deck;
   

    public GameManager() {
        this.deck = new Deck();
        this.deck.categorizeCards();

<<<<<<< Updated upstream
=======
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
>>>>>>> Stashed changes
    }

    public Deck getDeck() {
        return deck;
    }
}