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
    Map activeMap;
    int[][] activeTileTypes;
    Tile[][] activeTiles;
    public boolean isRunning;
    static Container tiles;

    public Display() {
        downOff = 0;
        rightOff = 0;
        x = this.getWidth() / 50;
        y = this.getHeight() / 50;
        
        this.setSize(1000, 1000);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(null);
        tiles = this.getContentPane();
        this.setVisible(true);
        
    }
    public void runGame(){
        while(isRunning){
            renderMap(activeMap);
        }
    }

    public void renderMap(Map map) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                activeMap.tiles[i][j].setTile(activeTileTypes[i + rightOff][j + downOff]);
            }
        }
    }

    public void UpdateActive(Map map) {
        activeMap = map;
        activeTileTypes = map.tileType;
        activeTiles = map.tiles;
    }

}
