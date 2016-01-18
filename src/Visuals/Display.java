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
    public int[][] activeTileTypes;
    public Tile[][] activeTiles;
    public boolean isRunning;
    Container tiles;

    public Display() {
        downOff = 0;
        rightOff = 0;
        x = this.getWidth() / 50;
        y = this.getHeight() / 50;
        
        this.setSize(1000, 1000);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("THIS IS A TITLE");
        this.setVisible(true);
        tiles = this.getContentPane();
        
        tiles.setLayout(null);
    }
    public void runGame(){
       // while(true){
            renderMap(activeMap);
        //}
    }

    public void renderMap(Map map) {
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                activeTiles[i][j].setTile(activeTileTypes[i + rightOff][j + downOff]);
            }
        }
    }

    public void UpdateActive(Map map) {
        activeMap = map;
        activeTileTypes = map.tileType;
        activeTiles = map.tiles;
        for (int i = 0; i < activeTiles.length; i++) {
            for (int j = 0; j < activeTiles[i].length; j++) {
                tiles.add(activeTiles[i][j]);
            }
        }
    }

}
