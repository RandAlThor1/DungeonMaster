/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npcs;

import Interactable.Actor;
import Interactable.Scene;
import java.awt.Point;

/**
 *
 * @author b.allen
 */
public class NPC extends Actor{
    String name;
    Stats stats;
    PersonalityType personType;

    public NPC(String name, Point location, Scene scene) {
        super(name, location, scene);
    }
    public void temp(){
        
    }
            
}   
