package server;

import game.Card;
import game.Room;
import game.Suspect;
import game.Weapon;


import java.io.Serializable;
import java.util.*;
import java.util.stream.Stream;

public class Deck implements Serializable {
    private final List<Room> rooms;
    private final List<Suspect> suspects;
    private final List<Weapon> weapons;
    private final List<Card> fullDeck;
    private final List<Card> envelope;

    // Constructor to initialize the lists
    public Deck() {
    	this.rooms = new ArrayList<>();
    	this.suspects = new ArrayList<>();
    	this.fullDeck = new ArrayList<>();
    	this.weapons = new ArrayList<>();
    	this.envelope = new ArrayList<>();
    }

    // Function to categorize cards into rooms, suspects, and weapons
    public void categorizeCards() {

    	rooms.add(new Room("Kitchen"));
    	rooms.add(new Room("Ballroom"));
    	rooms.add(new Room("Conservatory"));
    	rooms.add(new Room("Dining Room"));
    	rooms.add(new Room("Billiard Room"));
    	rooms.add(new Room("Lounge" ));
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
    	Collections.shuffle(rooms);
    	Collections.shuffle(suspects);
    	Collections.shuffle(weapons);
    	Collections.shuffle(fullDeck);
    }
    
    public void CreateEnvelope() {
    	envelope.add(rooms.get(0));
    	envelope.add(suspects.get(0));
    	envelope.add(weapons.get(0));
    	fullDeck.remove(rooms.get(0));
    	fullDeck.remove(suspects.get(0));
    	fullDeck.remove(weapons.get(0));
    }

    // Getter functions for rooms, suspects, fullDeck, and weapons
    public List<Room> getRooms() {
    	return rooms;
    }
    
    public List<Card> getEnvelope() {
    	return envelope;
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

	public void addCard(Card card) {
		if (card instanceof Room) {
			this.rooms.add((Room) card);
		}

		if (card instanceof Suspect) {
			this.suspects.add((Suspect) card);
		}

		if (card instanceof Weapon) {
			this.weapons.add((Weapon) card);
		}

		this.fullDeck.add(card);
	}
}