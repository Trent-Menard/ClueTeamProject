package game;

import java.io.Serializable;

public abstract class Card implements Serializable {
    private String category;
    private final String name;

    public Card(String name, String category) {
        this.category = category;
        this.name = name;
    }

    public Card(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public String getCardName() {
        return name;
    }
    
    @Override
    public String toString() {
        return "Card{" +
                "category='" + category + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}