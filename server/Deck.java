package server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<String> rooms;
    private List<String> suspects;
    private List<String> fullDeck;
    private List<String> weapons;

    // Constructor to initialize the lists
    public Deck() {
        this.rooms = new ArrayList<>();
        this.suspects = new ArrayList<>();
        this.fullDeck = new ArrayList<>();
        this.weapons = new ArrayList<>();
    }

    // Function to categorize cards into rooms, suspects, and weapons
    public void categorizeCards() {
       
        rooms.add("Kitchen");
        rooms.add("Ballroom");
        rooms.add("Conservatory");
        rooms.add("Dining Room");
        rooms.add("Billiards Room");
        rooms.add("Lounge");
        rooms.add("Hall");
        rooms.add("Study");


        suspects.add("Colonel Mustard");
        suspects.add("Miss Scarlet");
        suspects.add("Mrs. Peacock");
        suspects.add("Dr. Orchid");
        suspects.add("Professor Plum");
        suspects.add("Reverend Green");
      

        weapons.add("Candlestick");
        weapons.add("Revolver");
        weapons.add("Dagger");
        weapons.add("Lead Pipe");
        weapons.add("Wrench");
        weapons.add("Rope");
  

        // Combine all cards into the fullDeck
        fullDeck.addAll(rooms);
        fullDeck.addAll(suspects);
        fullDeck.addAll(weapons);
    }

    // Function to shuffle the full deck
    public void shuffle() {
        Collections.shuffle(fullDeck);
    }

    // Getter functions for rooms, suspects, fullDeck, and weapons
    public List<String> getRooms() {
        return rooms;
    }

    public List<String> getSuspects() {
        return suspects;
    }

    public List<String> getFullDeck() {
        return fullDeck;
    }

    public List<String> getWeapons() {
        return weapons;
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.categorizeCards();
        deck.shuffle();

        // Example usage of getter functions
        System.out.println("Rooms: " + deck.getRooms());
        System.out.println("Suspects: " + deck.getSuspects());
        System.out.println("Weapons: " + deck.getWeapons());
        System.out.println("Full Deck: " + deck.getFullDeck());
    }
}