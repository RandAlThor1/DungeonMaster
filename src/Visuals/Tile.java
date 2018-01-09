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
    public static int tileSize = 50;

    public Tile(int type, Point point) {
        this.type = type;
        this.point = point;
            this.setSize(tileSize, tileSize);//sets bounds
            this.setLocation((point.x * tileSize), (point.y * tileSize));
    }
     public void setTile(int type) {
        type = type;//stores new type
        if (type == 0 ){//grass
            Icon tile = new ImageIcon("src\\Images\\GrassTile1.png");
            this.setIcon(tile);
        }
        if (type == 1){//dessert
            Icon tile = new ImageIcon("src\\Images\\GrassTile1.png");
            this.setIcon(tile);
        }
        if (type == 2){//water
            Icon tile = new ImageIcon("src\\Images\\WaterTile1.png");
            this.setIcon(tile);
        }
        if (type == 3){//border
            Icon tile = new ImageIcon("src\\Images\\BorderTile1.png");
            this.setIcon(tile);
        }
        if (type == 50){//farm improvement
            Icon tile = new ImageIcon("src\\Images\\FarmTile1.png");
            this.setIcon(tile);
        }
        if (type == 51){//mine improvement
            Icon tile = new ImageIcon("src\\Images\\MineTile1.png");
            this.setIcon(tile);
        }
        if (type == 100){//city
            Icon tile = new ImageIcon("src\\Images\\CityTile1.png");
            this.setIcon(tile);
        }
        this.setVisible(true);
    }
    
}
