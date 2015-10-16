package dungeonmaster;

/**
 * Project:
 * @author Davin
 * Date: 02/10/2015 
 * Teacher: Mr. Wachs 
 */
class Scene {//temp class for testing
    
    Actor[] actors;
    
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

}
