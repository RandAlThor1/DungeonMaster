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
        this.type = type;//stores new type
        if (type == 0 ){//grass
            Icon tile = new ImageIcon("src\\Images\\BlankTile.png");
            this.setIcon(tile);
        }
    }
    
}
