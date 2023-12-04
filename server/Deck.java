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
    private final List<Card> envelope;
    private final List<Card> playerHand;
   
    
    // Constructor to initialize the lists
    public Deck() {
    	this.rooms = new ArrayList<>();
    	this.suspects = new ArrayList<>();
    	this.fullDeck = new ArrayList<>();
    	this.weapons = new ArrayList<>();
    	this.envelope = new ArrayList<>();
    	this.playerHand = new ArrayList<>();
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
    
    public void PlayerHand() {
    	
    //Ensures that only one set of three cards is in the set and it doesn't multiply
    	playerHand.removeAll(playerHand);   
    	
    	//Creates a fresh player hand of three cards.
    	if (playerHand.isEmpty())
    	{
        	double randomValue = Math.random();
        	
        	
        	int minr = 1; // Minimum value of range
            int maxr = (fullDeck.size()-1); // Maximum value of range
            int r = minr + (int) (randomValue * ((maxr - minr) + 1));
            
            int mins = 1; // Minimum value of range
            int maxs = (fullDeck.size()-1); // Maximum value of range
            int s = mins + (int) (randomValue * ((maxs - mins) + 1));
            
            int minw = 1; // Minimum value of range
            int maxw = (fullDeck.size()-1); // Maximum value of range
            int w = minw + (int) (randomValue * ((maxw - minw) + 1));
          
        	
        	playerHand.add(fullDeck.get(r));
         	fullDeck.remove(fullDeck.get(r));
        	playerHand.add(fullDeck.get(s));
           	fullDeck.remove(fullDeck.get(s));
        	playerHand.add(fullDeck.get(w));
        	fullDeck.remove(fullDeck.get(w));
   
     
        	
    	}
        
    	
    	

    }
    // Getter functions for rooms, suspects, fullDeck, and weapons
    public List<Room> getRooms() {
    	return rooms;
    }
    
    public List<Card> getEnvelope() {
    	return envelope;
    }
    
    public List<Card> getPlayerHand() {
    	return playerHand;
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
    
    // This is a test main to ensure that the playerhands are being created and they are different from the envelope
   /* public static void main(String[] args) {
    	Deck deck = new Deck();
    	deck.categorizeCards();
    	deck.shuffle();
    	deck.CreateEnvelope();
    	deck.PlayerHand();
    	// Example usage of getter functions
    	System.out.println("Hand 1" + deck.getPlayerHand());
    	deck.PlayerHand();
    	System.out.println("Hand 2" + deck.getPlayerHand());
    	deck.PlayerHand();
    	System.out.println("Hand 3" + deck.getPlayerHand());
    	deck.PlayerHand();
     	System.out.println("Hand 4" + deck.getPlayerHand());
    	deck.PlayerHand();
     	System.out.println("Hand 5" + deck.getPlayerHand());
     	
     	System.out.println("This is the Envelope" + deck.getEnvelope());
    }*/
}
