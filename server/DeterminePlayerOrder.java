package server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DeterminePlayerOrder {

    public static void main(String[] args) {
        // We need to make the number of players dynamic and not static or hard-coded
        int numberOfPlayers = 4;

        List<String> players = new ArrayList<>();
        for (int i = 1; i <= numberOfPlayers; i++) {
            players.add("Player " + i);
        }

        determinePlayerOrder(players);

        System.out.println("Player order:");
        for (int i = 0; i < players.size(); i++) {
            System.out.println((i + 1) + ": " + players.get(i));
        }
    }

    // Function to determine the player order randomly
    public static void determinePlayerOrder(List<String> players) {
        Collections.shuffle(players, new Random());
    }
}