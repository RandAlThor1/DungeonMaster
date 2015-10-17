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

    public Actor(int temp) {//temp method for testing
        if (temp == 0) {
            name = "player";
            location = new Point(0, 0);
            scene = DungeonMaster.outside;
            scene.addActor(this);
        }
        
        if (temp == 1) {
            name = "the tree";
            location = new Point(1, 1);
            scene = DungeonMaster.outside;
            scene.addActor(this);
        }
        
        if (temp == 2) {
            name = "the hill";
            location = new Point(5, 5);
            scene = DungeonMaster.outside;
            scene.addActor(this);
        }
    }

    public boolean equals(Actor actor) {
        return this.name.equals(actor.name) && this.location == actor.location;
    }
    
    
    
}
