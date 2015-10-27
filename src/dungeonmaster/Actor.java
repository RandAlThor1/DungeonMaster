package dungeonmaster;

import java.awt.Point;
import java.awt.datatransfer.DataFlavor;

/**
 * Project:
 * @author Davin
 * Date: 02/10/2015 
 * Teacher: Mr. Wachs 
 */
class Actor {//temp class for testing

    String name;
    Point location;
    Scene scene;
    Item[] inventory = new Item[20];
    //Wepon[] invenWep;
    //Personality personality //use achitypes to make this easyer

    public Actor(String name, Point location, Scene scene) {//temp method for testing
        this.name = name;
        this.location = location;
        this.scene = scene;
        this.scene.addActor(this);
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
                this.inventory[i] = new Food("empty");
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
