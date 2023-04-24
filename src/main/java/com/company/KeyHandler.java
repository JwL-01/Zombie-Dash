package com.company;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean uP, dP, lP, rP;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP ){
            uP = true;
        }
        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN ){
            dP = true;
        }
        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT ){
            lP = true;
        }
        if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT ){
            rP = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP ){
            uP = false;
        }
        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN ){
            dP = false;
        }
        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT ){
            lP = false;
        }
        if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT ){
            rP = false;
        }
    }
}
