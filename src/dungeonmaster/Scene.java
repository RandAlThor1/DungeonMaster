package dungeonmaster;

/**
 * Project:
 * @author Davin
 * Date: 02/10/2015 
 * Teacher: Mr. Wachs 
 */
class Scene {//temp class for testing
    
    Actor[] actors = new Actor[0];
    Item[] inventory = new Item[20];

    public Scene() {
        for (int i = 0; i < inventory.length; i++) {
            inventory[i] = new Item("empty");
        }
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
