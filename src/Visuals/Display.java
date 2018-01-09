/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visuals;

import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author b.allen
 */
public class Display extends JFrame {

    int downOff, rightOff;
    static int x, y;
    Map map;
    public boolean isRunning; //why is this needed? - Davin
    Container tiles;
    Container Actors;

    public Display() {
        downOff = 0;
        rightOff = 0;
        x = this.getWidth() / 50;
        y = this.getHeight() / 50;
        
        this.setSize(1000, 1000);
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        
        tiles = this.getContentPane();
        this.setVisible(true);
    }
    public void runGame(){
       // while(true){ //this should be timer controled, every possible tick is too much -Davin
            renderMap();
        //}
    }

    public void renderMap() {
        if (map == null) return;
        for (int i = 0; i < map.width; i++) {
            for (int j = 0; j < map.height; j++) {
                map.tiles[i][j].setTile(map.tileType[i + rightOff][j + downOff]);
            }
        }
        this.repaint();
    }

    public void UpdateActive(Map map) {
        this.map = map;
        rightOff = map.defRightOff;
        downOff = map.defDownOff;
        renderMap();
//        for (int i = 0; i < activeTiles.length; i++) {
//            for (int j = 0; j < activeTiles[i].length; j++) {
//                tiles.add(activeTiles[i][j]);
//            }
//        }
    }

}
