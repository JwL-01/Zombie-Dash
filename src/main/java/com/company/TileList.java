package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class TileList {

    private ArrayList<Sprite> objects;        // store character sprites

    public TileList(){
        objects = new ArrayList<>();
    }

    // the following methods are getters for a sprite list or a specific sprite.
    public ArrayList<Sprite> getList(){
        return this.objects;
    }
    public BufferedImage getSprite(int index){
        return this.objects.get(index).getSprite();
    }



}
