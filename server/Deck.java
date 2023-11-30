package server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


    
public class Deck {

    
    private List<Room> rooms;
    private List<Suspect> suspects;
    private List<Weapon> weapons;
    private List<Object> fullDeck;

    // Constructor to initialize the lists
    public Deck() {
    	this.rooms = new ArrayList<>();
    	this.suspects = new ArrayList<>();
    	this.fullDeck = new ArrayList<>();
    	this.weapons = new ArrayList<>();
    }

    // Function to categorize cards into rooms, suspects, and weapons
    public void categorizeCards() {

    	rooms.add(new Room("Kitchen"));
    	rooms.add(new Room("Ballroom"));
    	rooms.add(new Room("Conservatory"));
    	rooms.add(new Room("Dining Room"));
    	rooms.add(new Room("Billiards Room"));
    	rooms.add(new Room("Lounge"));
    	rooms.add(new Room("Hall"));
    	rooms.add(new Room("Study"));


    	suspects.add(new Suspect("Colonel Mustard"));
    	suspects.add(new Suspect("Miss Scarlet"));
    	suspects.add(new Suspect("Mrs. Peacock"));
    	suspects.add(new Suspect("Dr. Orchid"));
    	suspects.add(new Suspect("Professor Plum"));
    	suspects.add(new Suspect("Reverend Green"));


    	weapons.add(new Weapon("Candlestick"));
    	weapons.add(new Weapon("Revolver"));
    	weapons.add(new Weapon("Dagger"));
    	weapons.add(new Weapon("Lead Pipe"));
    	weapons.add(new Weapon("Wrench"));
    	weapons.add(new Weapon("Rope"));


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
    public List<Room> getRooms() {
    	return rooms;
    }

    public List<Suspect> getSuspects() {
    	return suspects;
    }

    public List<Weapon> getWeapons() {
    	return weapons;
    }

    public List<Object> getFullDeck() {
    	return fullDeck;
    }

    static class Room {
        private String name;

        public Room(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static class Suspect {
        private String name;

        public Suspect(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static class Weapon {
        private String name;

        public Weapon(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
        

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
