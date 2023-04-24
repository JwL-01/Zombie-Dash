package com.company;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static com.company.GameScreen.environment;

/*
0 = unwalkable grid
1 = path / available grid
2 = start
3 = end
4 = wall
 */

public class Environment {
    public static int[][] map;
    private int numRows;
    private int numCols;
    private HashMap<Integer, Integer> availSpot;

    private int position;
    private int startRow;
    private int startCol;
    private int endRow;
    private int endCol;

    public Environment() {
        availSpot = new HashMap<Integer, Integer>(); // stores & tells us available spot at [row][col] of map
        map = new int[][] {
                { 1,  1,  1,  1,  1, 10, 16, 17, 18, 65,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                {16, 20, 20, 20, 18,  2, 24, 25, 26,  5,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                {44,  0,  0,  0, 45,  2, 46, 65, 65,  2,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                {44,  0,  0,  0, 45,  7,  1,  1,  1,  13, 1, 15,  1, 10,  0,  0,  0,  0,  0,  0},
                {24, 25, 35, 25, 26,  2, 58, 59, 59, 59, 60,  2, 46, 11,  10,  0,  0,  0,  0,  0},
                { 0,  0,  2,  0,  0,  2, 66,  9,  1,  4, 68,  2,  0,  0,  2,  0,  0,  0,  0,  0},
                { 0,  0,  7,  1,  1, 14, 66,  2, 65, 65, 68,  2,  0,  0,  2,  0,  0,  0,  0,  0},
                {54,  0,  2,  0, 63,  2, 66,  2, 58, 75, 76,  2,  0,  0,  2, 32, 33, 33, 33, 34},
                {39,  0,  2, 63,  0,  7,  1, 14, 66,  0,  0, 11,  1, 10,  2, 40,  0,  0,  0, 42},
                {47,  0,  2,  0,  0,  2, 66,  6, 66,  0,  0,  0,  0,  2,  2, 40,  0,  0,  0, 42},
                {71,  0,  2,  0, 38,  2, 74, 75, 65,  0,  0,  0,  0,  7,  13, 57,  0,  0,  0, 42},
                { 0,  0,  7,  1,  1,  8,  1, 1, 15,  1,  1,  1, 15, 12,  0, 48, 49, 49, 49,  50},
                {71,  0,  2,  0,  0,  0,  0,  0,  2,  0,  0,  0,  2,  0,  0,  0,  0,  0,  0,  0},
                { 0,  0,  6,  0,  0,  0,  0,  0,  2,  0,  0,  0,  2,  0,  0,  0,  0,  0,  0,  0},
                { 24,25, 25, 25, 25, 25, 25, 25, 43, 25, 25, 25, 43, 25, 25, 25, 25, 25, 25, 26},
                { 0,  0,  0,  0,  0,  0,  0,  0,  2, 65, 65, 65,  2,  0,  0,  0,  0,  0,  0,  0},
                { 0,  0,  0, 55,  0,  0,  0,  0,  6,  0,  0,  0,  2,  0,  0,  0,  0, 38, 93, 94},
                { 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  2,  0,  0,  0, 63,  0,101,102},
                { 0,  0,  0,  0,  0,  0, 71,  0,  0,  0,  0,  0,  2,  0,  0,  0,  0, 39, 71,  2},
                { 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  11, 1,  1,  1,  1,  1,  1, 12},
        };

        numRows = environment.map.length;
        numCols = environment.map[0].length;
    }
    public int getRows(){
        return this.numRows;
    }
    public int getCols(){
        return this.numCols;
    }
    public void printMap(){
        for (int[] row : map) {
            System.out.println(Arrays.toString(row));
        }
    }

    public boolean checkValidGrid(int row, int col){
        if ((row < this.map[row].length) && (col < this.map[col].length)){
            return true;
        }else{
            return false;
        }
    }
    public void setStartEnd(int startRow, int startCol, int endRow, int endCol) {
        if (checkValidGrid(startRow,startCol)) {
            this.startRow = startRow;
            this.startCol = startCol;
            this.endRow = endRow;
            this.endCol = endCol;
            System.out.println("\n~~ Start & End Set ~~");
        }else{
            System.out.println("\n Error: Not a valid grid in the map.");
        }
    }

    public int getGridValue (int row, int col){
        return map[row][col];
    }

    // check if a grid is available (path) for an object to be placed on.
    public boolean checkAvailSpot(int row, int col){
        if (this.map[row][col] == 1){
            return true;
        }
        return false;
    }

    // Iterator to check available spots on the map for availSpotList
    // Useful for putting random enemy/rewards on random index in the map
    public void getAvailSpots() {
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                if (map[row][col] == 1) {// add more
                    availSpot.put(row*col, 1); // key = row, 1 = available spot
                }
            }
        }
    }
}
