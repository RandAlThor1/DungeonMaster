package Interactable;

import dungeonmaster.DungeonMaster;
import java.awt.Point;

/**
 *
 * @author Davin
 */
public class Food extends Item{

    int heal = 0;
    int stamina = 0;
    int mana = 0;
    int poison = 0;
    
    public Food(String name, int heal, Point location) {
        super(name);
        this.location = location;
        this.heal = heal;
    }    
    
    public Food(String name, int heal, Actor actor) {
        super(name);
        this.location = actor.location;
        this.heal = heal;
    }    

    public Food(String name, int heal, int stamina, int mana, int poison, Point location) {
        super(name);
        this.heal = heal;
        this.stamina = stamina;
        this.mana = mana;
        this.poison = poison;
        this.location = location;
    }

    public Food(String name, int heal, int stamina, int mana, int poison, Actor actor) {
        super(name);
        this.heal = heal;
        this.stamina = stamina;
        this.mana = mana;
        this.poison = poison;
        this.location = actor.location;
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
