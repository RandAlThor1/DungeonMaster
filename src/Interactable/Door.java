/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interactable;

import java.awt.Point;

/**
 * Project:
 * @author Davin
 * Date: 02/10/2015 
 * Teacher: Mr. Wachs 
 */
public class Door {

    public boolean locked;
    public Point location; 
    public Point connectPoint; 
    public Scene connectScene;
    public String name;

    public Door(Point location,Point connectPoint , Scene connectScene, String name) {
        this.location = location;
        this.connectScene = connectScene;
        this.connectPoint = connectPoint;
        this.name = name;
    }
    

}
