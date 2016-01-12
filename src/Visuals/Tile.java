/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visuals;

import java.awt.Point;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author b.allen
 */
public class Tile extends JLabel{
    public int type;
    public Point point;

    public Tile(int type, Point point) {
        this.type = type;
        this.point = point;
    }
     public void setTile(int type) {
        tileType = type;//stores new type
        if (type == 0 ){//grass
            Icon tile = new ImageIcon("src\\Images\\GrassTile1.png");
            this.setIcon(tile);
            movement = 1;
            production = 1;
            food = 1;
        }
        if (type == 1){//dessert
            Icon tile = new ImageIcon("src\\Images\\DessertTile1.png");
            this.setIcon(tile);
            movement = 1;
            production = 0;
            food = 0;
        }
        if (type == 2){//water
            Icon tile = new ImageIcon("src\\Images\\WaterTile1.png");
            this.setIcon(tile);
            movement = 1;
            production = 0;
            food = 1;
        }
        if (type == 3){//border
            Icon tile = new ImageIcon("src\\Images\\BorderTile1.png");
            this.setIcon(tile);
            production = 0;
            food = 0;
        }
        if (type == 50){//farm improvement
            Icon tile = new ImageIcon("src\\Images\\FarmTile1.png");
            this.setIcon(tile);
            production = 0;
            food = 3;
        }
        if (type == 51){//mine improvement
            Icon tile = new ImageIcon("src\\Images\\MineTile1.png");
            this.setIcon(tile);
            production = 3;
            food = 0;
        }
        if (type == 100){//city
            Icon tile = new ImageIcon("src\\Images\\CityTile1.png");
            this.setIcon(tile);
        }
    }
    
}
