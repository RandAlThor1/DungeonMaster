package Interactable;

import dungeonmaster.DungeonMaster;
import java.awt.Point;

/**
 *
 * @author Davin
 */
public class DoorKey extends Item{

    public Door door;
    
    public DoorKey(String name, Door door, Point location) {
        super(name + " Key");
        this.location = location;
        this.door = door;
    }    
    
    public DoorKey(String name, Door door) {
        super(name + " Key");
        this.door = door;
    }    
}
