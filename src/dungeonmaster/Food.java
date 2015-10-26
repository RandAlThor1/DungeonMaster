package dungeonmaster;

/**
 *
 * @author Davin
 */
class Food implements Item{
    
    String name;
    
    public Food(String name) {
        this.name = name;
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
