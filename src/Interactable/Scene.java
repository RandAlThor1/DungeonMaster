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
    
    public Actor[] actors = new Actor[0];
    public Objects[] objects = new Objects[0];
    public Item[] inventory = new Item[40];
    public ArrayList<Door> doors = new ArrayList<>();
    public String name;
    public String niceName;


    public Scene(String name) {
        this.niceName = name;
        this.name = name.toLowerCase();
        Item empty = new Item("empty");
        for (int i = 0; i < inventory.length; i++) {
            inventory[i] = empty;
        }
    }
    
        
    public void addKey(Point location, Door door){
        Key key = new Key(door.name, door);
        this.invenAdd(key);
        key.location = location;
    } 
    
    public void addDoor(Scene connectScene, Point connectPoint, Point location, boolean moreDoors){ 
        Door door = new Door(location, connectPoint, connectScene, connectScene.niceName);
        doors.add(door);
        if (moreDoors) connectScene.addDoor(this, location, connectPoint, false);
    }
    
    public void addDoor(Scene connectScene, Point connectPoint, Point location, boolean moreDoors, boolean locked){ 
        Door door = new Door(location, connectPoint, connectScene, connectScene.niceName);
        door.locked = true;
        doors.add(door);
        if (moreDoors) connectScene.addDoor(this, location, connectPoint, false);
    }
    
    public void addDoor(Door door, boolean moreDoors){
        doors.add(door);
        if (moreDoors) door.connectScene.addDoor(this, door.connectPoint, door.location, false);
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

    void addObject(Objects object) {
        Objects[] temp = new Objects[objects.length+1];
        for (int i = 0; i < objects.length; i++) temp[i] = objects[i];
        temp[objects.length] = object;
        objects = temp;
    }
    
    public int findObject(Objects object){
        int index = -1;
        for (int i = 0; i < objects.length; i++) {
            if (objects[i].equals(object)) {
                index = i;
                break;
            }
            
        }
        return index;
    } 
    
    public int findObject(String object){
        int index = -1;
        for (int i = 0; i < objects.length; i++) {
            if (objects[i].name.equals(object)) {
                index = i;
                break;
            }
            
        }
        return index;
    }
}
