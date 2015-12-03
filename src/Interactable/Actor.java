package Interactable;

import combat.Armor;
import combat.Equipment;
import combat.Weapon;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import npcs.Stats;

/**
 * Project:
 * @author Davin
 * Date: 02/10/2015 
 * Teacher: Mr. Wachs 
 */
public class Actor {

    public String name;
    public String niceName;
    public Point location;
    public Scene scene;
    public Weapon equippedWeapon;
    public Armor armor;
    public Item[] inventory = new Item[20];
    public Stats stats;
    public int gold; 
    public Runnable death = new Runnable() {
        @Override
        public void run() {
            isLootable = true;
            niceName += "(dead)";
        }
    };
    public Runnable use = new Runnable() {

        @Override
        public void run() {
            System.out.println("System: You can't use that");
        }
    };
    //public Personality personality //use achitypes to make this easyer
    public boolean isLootable;
    public Equipment equipment;
    
    public Actor(String name, Point location, Scene scene) {
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
        equipment = new Equipment();
    }

    public Actor(String name, Point location, Scene scene, Stats stats) {
        this.name = name.toLowerCase();
        this.niceName = name;
        this.location = location;
        this.scene = scene;
        this.stats = stats;
        this.isLootable = false;
    }
    

    public void addKey(Door door){
        Key key = new Key(door.niceName, door);
        this.invenAdd(key);
        key.location = this.location;
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
            if (actor.stats.health > 0) {
            actor.stats.health = 0;//instakill
            actor.death.run();
            int xp = 10;
            //this.stats.xp += xp; why xp not a thing?
            System.out.println("System: Fight won! Gained " + xp + "XP.");    
            }
            else System.out.println("System: Your target is dead");   
            
        }
        else System.out.println("System: You can't attack that from here.");
    }

    public void eat(Food food) {
       
        if (food.heal >= 0 && this.stats.health != this.stats.maxHealth){
            System.out.println("System: You recovered "+food.heal+"HP.");
            if (this.stats.health != this.stats.maxHealth) {
                this.stats.health += food.heal;//need maximum
            }
        }
        if (food.heal < 0){
            System.out.println("System: You lost "+food.heal*-1+"HP.");
            this.stats.health += food.heal;
        }
    }

    
}
