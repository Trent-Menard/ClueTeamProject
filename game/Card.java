package game;

public class Card {
    private final String category;
    private final String name;

    public Card(String name, String category) {
        this.category = category;
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public String getCardName() {
        return name;
    }
}