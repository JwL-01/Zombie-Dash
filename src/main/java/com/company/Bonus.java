// Bonus reward class
package com.company;
import java.util.Random; // Randomize bonus location

import static com.company.GameScreen.environment;

public class Bonus extends Reward {
    public static int bonusAmount = 30;
    // How many ticks have elapsed since placing the Bonus
    // Reward disappears after
    public int turns = 0;

    /**
     * Void function, no parameters and does not return anything
     * Sets starting bonus positions randomly on the map.
     *
     * Parameters: None
     * Returns: Nothing
     */
    public void setBonus() {
        // 10 x 10 array, indices 0 to 9 for rows and columns
        // Use random numbers to determine placement of reward
        // Reference: https://www.educative.io/edpresso/
        // how-to-generate-random-numbers-in-java
        Random randomize = new Random();

        // 10 possible numbers, indices 0 to 9 of map
        int max = 10;

        rewardRow = randomize.nextInt(max);
        rewardCol = randomize.nextInt(max);

        // Bad location, reroll random reward starting values
        while (validMove(rewardRow, rewardCol) == false) {
            rewardRow = randomize.nextInt(max);
            rewardCol = randomize.nextInt(max);
        }

        // Starting location is valid and doesn't conflict with
        // other objects, set on map
        // 4 = representation of bonus in HashMap
        environment.map[rewardRow][rewardCol] = 4;
    }
}
