/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visuals;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author b.allen
 */
public class EventListener implements MouseListener, KeyListener{
    private final int ESCAPE = 27;
    private final int UP = 38;
    private final int DOWN = 40;
    private final int LEFT = 37;
    private final int RIGHT = 39;

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    @Override
    public void mousePressed(MouseEvent e) {
        
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == UP) {
           // DisplayHandleing.upPressed();
        }
        else if (e.getKeyCode() == DOWN) {
            //DisplayHandleing.downPressed();
        }
        else if (e.getKeyCode() == LEFT) {
            //DisplayHandleing.leftPressed();
        }
        else if (e.getKeyCode() == RIGHT) {
           // DisplayHandleing.rightPressed();
        }
        else if (e.getKeyCode() == ESCAPE) {
            //DisplayHandleing.escapePressed();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
