// Punishment class
package com.company;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.Random; // Randomize enemy location

import static com.company.GameManager.environmentTiles;
import static com.company.GameManager.punishments;
import static com.company.GameScreen.environment;

public class Punishment {
    // i.e. how much the punishment deducts from score
    public static int punishAmount;
    BufferedImage punishmentSprite;
    int[] amounts = {10, 15, 20, 25};

    int punishRow;
    int punishCol;

    public Punishment() {
        punishmentSprite = environmentTiles.getSprite(96);
        setPunishment();
    }

    /**
     * Checks if where the punishment is placed is a valid space.
     * Takes row and column indices as parameters, returns bool
     * determining whether the move is valid or not.
     * @param row
     * @param col
     * @return boolean value
     */
    // Taken from Player class
    public boolean validMove(int row, int col) {
        // Need to avoid start, end, wall, reward, bonus, and other punishment tiles
        // Corresponds to 1, 2, 7, 3, 4, 6 in HashMap - leaves 0, and 5 (path or enemy)
        if (environment.map[row][col] <=15) {
            return true;
        }

        else {
            return false;
        }
    }

    /**
     * Void function, no parameters and does not return anything
     * Sets starting punishment positions randomly on the map.
     *
     * Parameters: None
     * Returns: Nothing
     */
    public void setPunishment() {
        // 10 x 10 array, indices 0 to 9 for rows and columns
        // Use random numbers to determine placement of punishment
        // Reference: https://www.educative.io/edpresso/
        // how-to-generate-random-numbers-in-java
        Random randomize = new Random();

        // 10 possible numbers, indices 0 to 9 of map
        int max = 19;

        punishRow = randomize.nextInt(max);
        punishCol = randomize.nextInt(max);

        // Bad location, reroll random enemy starting values

        while (validMove(punishRow, punishCol) == false) {
            punishRow = randomize.nextInt(max);
            punishCol = randomize.nextInt(max);
        }

        // Starting location is valid and doesn't conflict with
        // other moving objects or walls/barriers, set on map
        // 6 = representation of punishment in HashMap
        environment.map[punishRow][punishCol] = 204;

        Random randomized = new Random();
        int maximum = 4; // 4 possible punishment deductions

        // Amount corresponding to randomized index in array
        // becomes the punishment's deduction value
        punishAmount = amounts[randomized.nextInt(maximum)];
    }
}