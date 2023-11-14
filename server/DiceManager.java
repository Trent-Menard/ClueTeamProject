package server;

import java.util.Random;

public class DiceManager {

    public static void main(String[] args) {
        int result = rollDice();
        System.out.println("You rolled a " + result);
    }

    // Function to simulate rolling a six-sided die
    public static int rollDice() {
        Random random = new Random();
        // Generate a random number between 1 and 6 (inclusive) for a standard six-sided die
        return random.nextInt(6) + 1;
    }
}

