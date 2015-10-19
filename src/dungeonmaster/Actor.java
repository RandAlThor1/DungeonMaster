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
    //Item[] inventorty //not dealing with items right now
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
    
    
    
}
