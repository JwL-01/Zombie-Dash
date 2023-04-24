package com.company;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import static com.company.Bonus.bonusAmount;
import static com.company.GameManager.charTiles;
import static com.company.GameScreen.environment;
import static com.company.Punishment.punishAmount;
import static com.company.Reward.rewardAmount;

public class Player{
    String name;
    BufferedImage playerSprite;
    int speed = 1;
    int score = 0;
    int rewards = 0;
    int playerRow;
    int playerCol;//I reset the environment.map from private to public static

    public Player() {
        playerSprite = charTiles.getSprite(0);
        playerRow = 0;
        playerCol = 0;
    }

    public String getPlayer() {
        return name;
    }

    public int getReward() {
        return rewards;
    }

    public int getScore() {
        return score;
    }

    public int getPosition_row() {
        return playerRow;
    }

    public int getPosition_column() {
        return playerCol;
    }


    //rewards should increase when player get the reward place
    public boolean isReward(int position_row, int position_column) {
        if (environment.map[position_row][position_column] == 203) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPunishment(int position_row, int position_column) {
        if (environment.map[position_row][position_column] == 204) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBonus(int position_row, int position_column) {
        if (environment.map[position_row][position_column] == 205) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEnemy(int position_row, int position_column) {
        if (environment.map[position_row][position_column] == 202) {
            return true;
        } else {
            return false;
        }
    }

/*
    public void move(KeyEvent e) {//input by keyboard
        //if user press any of the keys that can control the movement,then execute the functions below
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            moveup();
            if (isReward(playerRow, playerCol)) {
                rewards = rewards + rewardAmount;
            }
            if (isPunishment(playerRow, playerCol)) {
                rewards = rewards - punishAmount;
            }
            if (isReward(playerRow, playerCol)) {
                rewards = rewards + rewardAmount;
            }
            if (isBonus(playerRow, playerCol)) {
                score = score + bonusAmount;
            }
            if (isEnemy(playerRow, playerCol)) {
                System.out.println("Game Over");
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            movedown();
            if (isReward(playerRow, playerCol)) {
                rewards = rewards + rewardAmount;
            }
            if (isPunishment(playerRow, playerCol)) {
                rewards = rewards - punishAmount;
            }
            if (isBonus(playerRow, playerCol)) {
                score = score + bonusAmount;
            }
            if (isEnemy(playerRow, playerCol)) {
                System.out.println("Game Over");
            }
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            moveleft();
            if (isReward(playerRow, playerCol)) {
                rewards = rewards + rewardAmount;
            }
            if (isPunishment(playerRow, playerCol)) {
                rewards = rewards - punishAmount;
            }
            if (isBonus(playerRow, playerCol)) {
                score = score + bonusAmount;
            }
            if (isEnemy(playerRow, playerCol)) {
                System.out.println("Game Over");
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            moveright();
            if (isReward(playerRow, playerCol)) {
                rewards = rewards + rewardAmount;
            }
            if (isPunishment(playerRow, playerCol)) {
                rewards = rewards - punishAmount;
            }
            if (isBonus(playerRow, playerCol)) {
                score = score + bonusAmount;
            }
            if (isEnemy(playerRow, playerCol)) {
                System.out.println("Game Over");
            }
        }


    }

    //the row num of the position should minus one when moving up
    private void moveup() {
        if (validMove(playerRow - 1, playerCol)) {
            playerRow = playerRow - 1;


        }
    }

    //the row number of the position should plus one when moving down
    private void movedown() {
        if (validMove(playerRow + 1, playerCol)) {
            playerRow = playerRow + 1;
        }
    }

    //the column num of the position should minus one when moving left
    private void moveleft() {
        if (validMove(playerRow, playerCol - 1)) {
            playerCol = playerCol - 1;
        }
    }

    //the column num of the position should plus one when moving left
    private void moveright() {
        if (validMove(playerRow, playerCol + 1)) {
            playerCol = playerCol + 1;
        }
    }*/
}



