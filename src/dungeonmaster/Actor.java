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
    Food[] invenFood = new Food[20];
    //Wepon[] inventoryWep;
    //Personality personality //use achitypes to make this easyer

    public Actor(String name, Point location, Scene scene) {//temp method for testing
        this.name = name;
        this.location = location;
        this.scene = scene;
        this.scene.addActor(this);
    }

    public boolean equals(Actor actor) {
        return this.name.equals(actor.name) && this.location == actor.location;
    }
  
    public boolean invenAdd(Food item){//return didComplete
        int counter = 0;
        for (int i = 0; i < this.invenFood.length ; i++) {
            if (this.invenFood[i] == null) {this.invenFood[i] = item; break;}
            else counter++;
        }
        if (counter == this.invenFood.length) return false;
        else return true;
    }
    
    public boolean invenRemov(Food item){
        int counter = 0;
        for (int i = 0; i < this.invenFood.length ; i++) {
            if (this.invenFood[i] == item) {this.invenFood[i] = null; break;}
            else counter++;
        }
        if (counter == this.invenFood.length) return false;
        else return true;
    }
    
    public void invenCheck(Item item){
    
    }
    
    
    
}
