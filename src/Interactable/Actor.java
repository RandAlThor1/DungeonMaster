package Interactable;

import java.awt.Point;
import npcs.Stats;

/**
 * Project:
 * @author Davin
 * Date: 02/10/2015 
 * Teacher: Mr. Wachs 
 */
public class Actor {//temp class for testing

    public String name;
    public String niceName;
    public Point location;
    public Scene scene;
    public Item[] inventory = new Item[20];
    public Stats stats;
    //public Wepon[] invenWep;
    //public Personality personality //use achitypes to make this easyer
    public boolean isLootable;
    public Actor(String name, Point location, Scene scene) {//temp method for testing
        this.niceName = name;
        this.name = name.toLowerCase();
        this.location = location;
        this.scene = scene;
        this.scene.addActor(this);
        isLootable = false; 
        stats = new Stats(10, 10, 10, 10, 10, 10);
        for (int i = 0; i < inventory.length; i++) {
            inventory[i] = new Item("empty");
        }
    }

    public boolean equals(Actor actor) {
        return this.name.equals(actor.name) && this.location == actor.location;
    }
  
    public void invenAdd(Item item){
        for (int i = 0; i < this.inventory.length ; i++) {
            if (this.inventory[i].name.equals("empty")) {
                this.inventory[i] = item;
                break;
            }
        }
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
    
    public void fight(Actor actor){//we need to figure out how combat works; 
        if (this.location.equals(actor.location)) {
            actor.stats.Health = 0;//instakill
            actor.isLootable = true;
            int xp = 10;
            //this.stats.xp += xp; why xp not a thing?
            System.out.println("System: Fight won! Gained " + xp + "XP.");
        }
        else System.out.println("System: You can't attack that from here.");
    }

    public void eat(Food food) {
       
        if (food.heal >= 0 && this.stats.Health != this.stats.maxHealth){
            System.out.println("System: You recovered "+food.heal+"HP.");
            if (this.stats.Health != this.stats.maxHealth) {
                this.stats.Health += food.heal;//need maximum
            }
        }
        if (food.heal < 0){
            System.out.println("System: You lost "+food.heal*-1+"HP.");
            this.stats.Health += food.heal;
        }
        
    }
    
}
