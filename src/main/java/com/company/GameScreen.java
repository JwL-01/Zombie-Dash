package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static com.company.Game.gm;

public class GameScreen extends JPanel implements Runnable {
     static Environment environment;
     KeyHandler keyH = new KeyHandler();
     static Thread gameThread;
     static Thread enemyThread;
     GamePlay gamePlay;
     int FPS = 60;
    double drawInterval;
    double nextDrawTime ;

    double remainingTime;
    double aTime = remainingTime;
     //FPS

     // set player's default position

    public GameScreen() {
        gamePlay = new GamePlay();
        environment = new Environment();

        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null){
            System.out.println("\nRunning Game");
            update();
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                double aTime = remainingTime;
                remainingTime /= 1000000;
                if (remainingTime < 0){
                    remainingTime = 0;
                }
                nextDrawTime += drawInterval;
                gameThread.sleep((long) remainingTime);

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update() {

        if (remainingTime <= aTime) {
            gamePlay.setRandEnemyMovement(gamePlay.enemy1);
            gamePlay.setRandEnemyMovement(gamePlay.enemy2);
            aTime = remainingTime * 0.15;

            if (keyH.uP == true) {
                gamePlay.player.playerCol -= gamePlay.player.speed;
            } else if (keyH.dP == true) {
                gamePlay.player.playerCol += gamePlay.player.speed;
            } else if (keyH.lP == true) {
                gamePlay.player.playerRow -= gamePlay.player.speed;
            } else if (keyH.rP == true) {
                gamePlay.player.playerRow += gamePlay.player.speed;
            }
        }
    }


    // paint image to the JFrame screen
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        paintBackground(g2, environment.getRows(), environment.getCols());
        paintTiles(g2, gm.environmentTiles, environment.getRows(), environment.getCols());
        gamePlay.paintPlayer(g ,gamePlay.player.playerRow, gamePlay.player.playerCol);
        gamePlay.paintEnemy(g, gamePlay.enemy1 ,gamePlay.enemy1.enemyRow, gamePlay.enemy1.enemyCol);
        gamePlay.paintEnemy(g, gamePlay.enemy2 ,gamePlay.enemy2.enemyRow, gamePlay.enemy2.enemyCol);
        gamePlay.paintReward(g);
        gamePlay.paintPunishment(g);
        g2.dispose();
        g.dispose();

    }

    public void paintBackground(Graphics g, int tileRow, int tileCol){
        Sprite grass = new Sprite ("/GRASS.png");
        int index = 0;
        for (int x = 0; x < tileRow; x++){
            for (int y = 0; y < tileCol; y++) {
                g.drawImage(grass.getSprite(), y * 32, x * 32, null);  // draw sprite at row,col of the jFrame
                index++;
            }
        }
    }

    // method to load tiles from a tile list and loops the tile image
    public void paintTiles(Graphics g, TileList tl , int tileRow, int tileCol){
        int numElements = tl.getList().size();
        int index = 0;
        for (int x = 0; x < tileRow; x++){
            for (int y = 0; y < tileCol; y++) {
                g.drawImage(tl.getSprite(environment.map[x][y]), y * 32, x * 32, null);  // draw sprite at row,col of the jFrame
                index++;
                if (index == numElements){index = 0;}
            }
        }

    }



}
