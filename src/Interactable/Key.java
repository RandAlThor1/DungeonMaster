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
      
    
    @Override
    public void eat(Actor actor) {
        //todo
        DungeonMaster.inputCommand();
    }

    @Override
    public void equip(Actor actor) {
        System.out.println("You can't equip this");
        DungeonMaster.inputCommand();
    }

    @Override
    public void take(Actor actor) {
        //add item to inventory
        //remove from scene
        DungeonMaster.inputCommand();
    }

    @Override
    public void drop() {
        //remove item from inventory
        //add to scene
        DungeonMaster.inputCommand();
    }
    
}
