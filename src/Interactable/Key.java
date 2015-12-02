package Interactable;

import dungeonmaster.DungeonMaster;
import java.awt.Point;

/**
 *
 * @author Davin
 */
public class Key extends Item{

    public Door door;
    
    public Key(String name, Door door, Point location) {
        super(name + " Key");
        this.location = location;
        this.door = door;
    }    
    
    public Key(String name, Door door) {
        super(name + " Key");
        this.door = door;
    }    
}
