package Interactable;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Project:
 * @author Davin
 * Date: 02/10/2015 
 * Teacher: Mr. Wachs 
 */
public class Scene {//temp class for testing
    
    public Actor[] actors = new Actor[0];//i really should make methods for this
    public Item[] inventory = new Item[40];
    public ArrayList<Door> doors = new ArrayList<>();
    public String name;
    public String niceName;


    public Scene(String name) {
        this.niceName = name;
        this.name = name.toLowerCase();
        for (int i = 0; i < inventory.length; i++) {
            inventory[i] = new Item("empty");
        }
    }
    
    public void addDoor(Scene scene, Point connectPoint, Point location, boolean moreDoors){ 
        Door door = new Door(location, connectPoint, scene, scene.niceName);
        doors.add(door);
        if (moreDoors) scene.addDoor(this, location, connectPoint, false);
    }
    public void addDoor(Scene scene, Point connectPoint, Point location, boolean moreDoors, boolean locked){ 
        Door door = new Door(location, connectPoint, scene, scene.niceName);
        door.locked = true;
        doors.add(door);
        if (moreDoors) scene.addDoor(this, location, connectPoint, false);
    }
    public void addKey(String name, Door door, Point location){
        Key key = new Key(name, door, location);
        this.invenAdd(key);
    } 
    
    public void addActor(Actor actor){
        Actor[] temp = new Actor[actors.length+1];
        for (int i = 0; i < actors.length; i++) temp[i] = actors[i];
        temp[actors.length] = actor;
        actors = temp;
    }
    
    public int findActor(Actor actor){
        int index = -1;
        for (int i = 0; i < actors.length; i++) {
            if (actors[i].equals(actor)) {
                index = i;
                break;
            }
            
        }
        return index;
    } 
    
    public int findActor(String actor){
        int index = -1;
        for (int i = 0; i < actors.length; i++) {
            if (actors[i].name.equals(actor)) {
                index = i;
                break;
            }
            
        }
        return index;
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
}
