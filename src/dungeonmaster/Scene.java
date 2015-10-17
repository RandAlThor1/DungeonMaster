package dungeonmaster;

/**
 * Project:
 * @author Davin
 * Date: 02/10/2015 
 * Teacher: Mr. Wachs 
 */
class Scene {//temp class for testing
    
    Actor[] actors = new Actor[0];
    
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
            if (actors[i].name.compareTo(actor) == 0) {
                index = i;
                break;
            }
            
        }
        return index;
    } 

}
