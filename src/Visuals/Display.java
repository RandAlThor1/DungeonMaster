/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visuals;

import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author b.allen
 */
public class Display  extends JFrame{
    static int downOff = 0, rightOff = 0;
    static int x,y;

    public Display() throws HeadlessException {
        x = this.getWidth()/50;
        y = this.getHeight()/50;
        this.setSize(1256, 728);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public void renderMap(){
        for (int i = 0; i < x; i++){
                for (int j = 0; j < y; j++){
                    Map.grid[i][j].setTile(Map.tileType[i + rightOff][j + downOff]);

                }
            }
    }
    
    
}
