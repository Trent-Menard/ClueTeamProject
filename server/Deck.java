package server;

import game.Card;
import game.Room;
import game.Suspect;
import game.Weapon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Room> rooms;
    private final List<Suspect> suspects;
    private final List<Weapon> weapons;
    private final List<Card> fullDeck;

    // Constructor to initialize the lists
    public Deck() {
    	this.rooms = new ArrayList<>();
    	this.suspects = new ArrayList<>();
    	this.fullDeck = new ArrayList<>();
    	this.weapons = new ArrayList<>();
    }

    // Function to categorize cards into rooms, suspects, and weapons
    public void categorizeCards() {

    	rooms.add(new Room("Kitchen", 0, 3, 0, 3));
    	rooms.add(new Room("Ballroom", 0,3,6,9));
    	rooms.add(new Room("Conservatory", 0, 3, 12, 15));
    	rooms.add(new Room("Dining Room", 6, 9, 0, 3));
    	rooms.add(new Room("Billiard Room", 6, 9, 12, 15));
    	rooms.add(new Room("Lounge", 12, 15, 0, 3));
    	rooms.add(new Room("Hall", 12, 15, 6, 9));
    	rooms.add(new Room("Study", 12, 15, 12, 15));

    	suspects.add(new Suspect("Colonel Mustard"));
    	suspects.add(new Suspect("Miss Scarlet"));
    	suspects.add(new Suspect("Mrs. Peacock"));
    	suspects.add(new Suspect("Dr. Orchid"));
    	suspects.add(new Suspect("Professor Plum"));
    	suspects.add(new Suspect("Reverend Green"));

    	weapons.add(new Weapon("Candlestick", 0, 0));
    	weapons.add(new Weapon("Revolver", 0, 0));
    	weapons.add(new Weapon("Dagger", 0, 0));
    	weapons.add(new Weapon("Lead Pipe", 0, 0));
    	weapons.add(new Weapon("Wrench", 0, 0));
    	weapons.add(new Weapon("Rope", 0, 0));

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

    public List<Card> getFullDeck() {
    	return fullDeck;
    }
}
