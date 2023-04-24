package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/*
Canvas Index:
canvas[0] = hero (player's character)
canvas[1] = enemies
canvas[2] = paths
canvas[3] = rewards
canvas[4] = bonus
canvas[5] = punishments
canvas[6] = environment
*/

public class GameManager {
    private ArrayList<BufferedImage> canvas;             // List to store multiple sprite canvases
    public static TileList charTiles;
    public static TileList enemyTiles;
    public static  TileList pathTiles;
    public static TileList rewardTiles;
    public static TileList bonusTiles;
    public static TileList punishments;
    public static TileList environmentTiles;

    public GameManager() {
        canvas = new ArrayList<>();
        // instantiate tile lists
        charTiles = instantiateTiles ("/PIPOYA FREE RPG Character Sprites 32x32/Male/Male 01-1.png", 1, 1, 32, 32);
        enemyTiles = instantiateTiles ("/ENEMY1.png", 1, 1, 32, 32);
        addToTileList (enemyTiles,"/ENEMY2.png", 1, 1, 32, 32);;
        pathTiles = instantiateTiles ("/PATHS.png", 8, 2, 32, 32);
        rewardTiles = instantiateTiles ("/FOOD.png", 8, 8, 32, 32);
        bonusTiles = instantiateTiles ("/BONUS.png", 7, 2, 32, 32);
        punishments = instantiateTiles ("/PUNISHMENT.png", 1, 1, 32, 32);
        environmentTiles = instantiateTiles ("/ENVIRONMENT.png", 8, 13, 32, 32);
    }

    public TileList instantiateTiles (String imgPath, int numColsCanvas, int numRowsCanvas, int spriteW, int spriteH) {
        int lastIndex = canvas.size();
        TileList tl = new TileList();
        addImgToCanvas(imgPath);
        saveCanvasToTile(tl.getList(), canvas.get(lastIndex), numColsCanvas, numRowsCanvas, spriteW, spriteH );
        return tl;
    }

    public void addToTileList (TileList tl, String imgPath, int numColsCanvas, int numRowsCanvas, int spriteW, int spriteH){
        if (tl.getList().size() == 0){
            tl = instantiateTiles(imgPath, numColsCanvas, numRowsCanvas, spriteW, spriteH);
        }
        int lastIndex = canvas.size();
        addImgToCanvas(imgPath);
        saveCanvasToTile(tl.getList(), canvas.get(lastIndex), numColsCanvas, numRowsCanvas, spriteW, spriteH);
    }

    // store image input into a canvas
    public void addImgToCanvas(String imgPath) {
        InputStream is = getClass().getResourceAsStream(imgPath);
        try {
            canvas.add(ImageIO.read(is));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // load a canvas into a tile array at a specific grid
    public void saveCanvasToTile(ArrayList<Sprite> tileList, BufferedImage canvas, int numColCanvas, int numRowCanvas, int w, int h){
        for (int row = 0; row < numRowCanvas; row++){
            for (int col = 0; col < numColCanvas; col++){
                tileList.add(new Sprite (canvas, col, row, w, h));
            }
        }
       // System.out.println("\n Canvas successfully converted to sprites and saved to tile");
    }







}
