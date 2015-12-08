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
    public Runnable talk = new Runnable() {

        @Override
        public void run() {
            System.out.println(NPC.this.niceName+": Hello "+dungeonmaster.DungeonMaster.player.niceName+".");
        }
    };
    
    public NPC(PersonalityType personType, String name, Point location, Scene scene, Stats stats) {
        super(name, location, scene, stats);
        this.personType = personType;
    }    
}   
