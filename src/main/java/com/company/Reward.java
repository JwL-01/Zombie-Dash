// Reward class
package com.company;

import java.awt.image.BufferedImage;
import java.util.Random; // Randomize reward location

import static com.company.GameManager.rewardTiles;
import static com.company.GameScreen.environment;


public class Reward {
    // 15 for normal rewards, 30 for bonuses

    public static int rewardAmount = 15;
    BufferedImage rewardSprite;
    public int rewardRow;
    public int rewardCol;

    /**
     * Checks if where the reward is placed is a valid space.
     * Takes row and column indices as parameters, returns bool
     * determining whether the move is valid or not.
     * @param row
     * @param col
     * @return boolean value
     */

    public Reward(){
        Random rand = new Random();
        rewardSprite = rewardTiles.getSprite(rand.nextInt(rewardTiles.getList().size()));
        setReward();
    }

    // Taken from Player class
    public boolean validMove(int row, int col) {
        // Need to avoid start, end, wall, punishment, other rewards/bonuses (can't overlap)
        // Corresponds to 1, 2, 7, 6, 3, 4 in HashMap - leaves 0, and 5 (path or enemy)
        if (environment.map[row][col] <= 15 && environment.map[row][col] != 1) {
            return true;
        }

        else {
            return false;
        }
    }

    /**
     * Void function, no parameters and does not return anything
     * Sets starting reward positions randomly on the map.
     * 
     * Parameters: None
     * Returns: Nothing
     */
    public void setReward() {
        // 10 x 10 array, indices 0 to 9 for rows and columns
        // Use random numbers to determine placement of reward
        // Reference: https://www.educative.io/edpresso/
        // how-to-generate-random-numbers-in-java
        Random randomize = new Random();

        // 10 possible numbers, indices 0 to 9 of map
        int max = 19;
        
        rewardRow = randomize.nextInt(max);
        rewardCol = randomize.nextInt(max);
        
        // Bad location, reroll random reward starting values
        while (validMove(rewardRow, rewardCol) == false) {
            rewardRow = randomize.nextInt(max);
            rewardCol = randomize.nextInt(max);
        }

        // Starting location is valid and doesn't conflict with
        // other objects, set on map
        // 3 = representation of reward in HashMap
        environment.map[rewardRow][rewardCol] = 203;
    }

    public void hideReward() {
        // Reward has been claimed by the Player, reset back to path
        environment.map[rewardRow][rewardCol] = 0;
    }
}