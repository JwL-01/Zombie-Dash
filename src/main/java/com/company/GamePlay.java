package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import static com.company.Bonus.bonusAmount;
import static com.company.Game.gm;
import static com.company.GameManager.*;
import static com.company.GameScreen.gameThread;
import static com.company.Punishment.punishAmount;
import static com.company.Reward.rewardAmount;

public class GamePlay extends JPanel  {

    Player player;
    Enemy enemy1;
    Enemy enemy2;
    ArrayList <Reward> randReward;
    ArrayList <Punishment> randPunishment;

    public GamePlay(){
        player = new Player();
        enemy1 = new Enemy(enemyTiles.getSprite(0));
        enemy2 = new Enemy(enemyTiles.getSprite(1));
        randReward = new ArrayList<>();
        randPunishment = new ArrayList<>();
        setRandReward(6);
        setRandPunishment(6);

        enemy1.enemyCol = 400;
        enemy1.enemyRow = 200;

        enemy2.enemyRow = 600;
        enemy2.enemyCol = 100;

        player.speed = 3;
    }

    public void setRandReward( int numItems){
        for (int i = 0; i < numItems; i++ ) {
            randReward.add(new Reward());
        }
    }

    public void setRandPunishment( int numItems){
        for (int i = 0; i < numItems; i++ ) {
            randPunishment.add(new Punishment());
            randPunishment.get(i).setPunishment();
        }
    }
    public void setRandEnemyMovement(Enemy enemy){

        int goalRow = player.playerRow; // Max is 640
        int goalCol = player.playerCol; // Max is 640

        if (enemy.enemyCol != goalCol && enemy.enemyCol > goalCol){
            enemy.enemyCol += -1;
        }
        if (enemy.enemyCol != goalCol && enemy.enemyCol < goalCol){
            enemy.enemyCol += 1;
        }
        if (enemy.enemyRow != goalRow && enemy.enemyRow > goalRow) {
            enemy.enemyRow += -1;
        }
        if (enemy.enemyRow != goalRow && enemy.enemyRow < goalRow){
            enemy.enemyRow += 1;
        }
        System.out.println(enemy.enemyRow);
        System.out.println(enemy.enemyCol);
    }

    public void paintPlayer (Graphics g, int pRow , int pCol){
        g.drawImage(player.playerSprite, pRow , pCol , null);  // draw sprite at row,col of the jFrame
    }

    public void paintEnemy (Graphics g, Enemy enemy, int pRow , int pCol){
        g.drawImage(enemy.enemySprite, pRow, pCol, null);  // draw sprite at row,col of the jFrame
    }
    public void paintReward(Graphics g){
        for (int i = 0; i < 6; i++ ) {
            g.drawImage(randReward.get(i).rewardSprite , randReward.get(i).rewardRow *35 , randReward.get(i).rewardCol*35 , null);  // draw sprite at row,col of the jFrame
        }
    }
    public void paintPunishment(Graphics g){
        for (int i = 0; i < 6; i++ ) {
            g.drawImage(randPunishment.get(i).punishmentSprite , randPunishment.get(i).punishRow*35 , randPunishment.get(i).punishCol*35 , null);  // draw sprite at row,col of the jFrame
        }
    }


}
