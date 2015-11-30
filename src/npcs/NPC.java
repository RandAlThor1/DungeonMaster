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
    PersonalityType personType;
    public NPC(PersonalityType personType, String name, String niceName, Point location, Scene scene, Stats stats) {
        super(name, niceName, location, scene, stats);
        this.personType = personType;
    }    
}   
