package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Sprite {
    private BufferedImage sprite;
    BufferedImage spriteCanvas;

    public Sprite(BufferedImage sprite){
        this.sprite = sprite;
    }

    public Sprite(String imgPath){
        InputStream is = getClass().getResourceAsStream(imgPath);
        try {
            sprite = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.sprite = sprite;
    }



    // get subimage from location at row, col, with sizexsize
    public Sprite(BufferedImage img, int x, int y, int w, int h){
        this.sprite = img.getSubimage(x*w, y*h, w, h);
    }
    public Sprite(String imgPath, int x, int y, int w, int h){
        InputStream is = getClass().getResourceAsStream(imgPath);
        try {
            spriteCanvas = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.sprite = spriteCanvas.getSubimage(x*w, y*h, w, h);
    }

    public BufferedImage getSprite(){
        return this.sprite;
    }
}
