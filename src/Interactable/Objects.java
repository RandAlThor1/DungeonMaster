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
public class Objects {

    public String name;
    public String niceName;
    public Point location;
    public Scene scene;
    public Item[] inventory = new Item[1];
    public int gold; 
    public Runnable use = new Runnable() {

        @Override
        public void run() {
            System.out.println("System: You can't use that");
        }
    };
    
    //public Personality personality //use achitypes to make this easyer
    public boolean isLootable;
    
    public Objects(String name, Point location, Scene scene) {
        this.niceName = name;
        this.name = name.toLowerCase();
        this.location = location;
        this.scene = scene;
        this.scene.addObject(this);
        isLootable = false; 
    }
    
    public void addKey(Door door){
        Key key = new Key(door.niceName, door);
        this.invenAdd(key);
        key.location = this.location;
    } 
  
    public void invenAdd(Item item){
        Item[] temp = new Item[inventory.length+1];
        for (int i = 0; i < inventory.length; i++) temp[i] = inventory[i];
        temp[inventory.length] = item;
        inventory = temp;
    }
    
    public void invenRemov(Item item){
        for (int i = 0; i < this.inventory.length ; i++) {
            if (this.inventory[i] == item){
                this.inventory[i] = new Item("empty");
                break;}
            } 
    }
    
    public Item invenFind(String name){
        Item item = null;
        boolean found = false;
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].name.equals(name)) item = inventory[i];
        }
        return item;
    }
}
