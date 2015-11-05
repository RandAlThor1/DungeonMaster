 package dungeonmaster;

import Interactable.Item;
import Interactable.Actor;
import Interactable.Food;
import Interactable.Scene;

/**
 * Project:
 * @author Davin
 * Date: 02/10/2015 
 * Teacher: Mr. Wachs 
 */
class wordUse {

    static void playerVerb(String stuff, String[] command, int index) {
        if (compareWords(stuff, "go")&& compareWords(command[index+1], "to")) {
            Scene curScene = DungeonMaster.player.scene;
            int actorIndex = -1;
            String place = "";
            boolean found = false;
            for (int i = 1; i < 4 && i < command.length-index-1; i++) {
                place += command[index + 1 + i];
                actorIndex = curScene.findActor(place);
                if (actorIndex != -1) found = true;
                if (found) break;
                else place += " ";
            }
            if (found) {
                DungeonMaster.player.location = curScene.actors[actorIndex].location;
                System.out.println("System: You're new loctaion is: "+DungeonMaster.player.location.x+", "+DungeonMaster.player.location.y);//JOptionPane.showMessageDialog(null, "You're new loctaion is: "+DungeonMaster.player.location.x+", "+DungeonMaster.player.location.y);     
            }
            else System.out.println("System: Location not found");//JOptionPane.showMessageDialog(null, "Location not found");  
        }
        
        else if (compareWords(stuff, "drop")) {
            String itemName = "";
            Item item = null;
            for (int i = 1; i < 4 && i < command.length-index; i++) {
                itemName += command[index + i];
                item = DungeonMaster.player.invenFind(itemName);
                if (item != null) {
                    DungeonMaster.player.invenRemov(item);
                    DungeonMaster.player.scene.invenAdd(item);
                    System.out.println("System: Item droped");
                    break;
                }
                else itemName += " ";
                if((i == 3 || i == command.length-index-1) && item == null) System.out.println("System: Item not found");
            }
            
        }
        
        else if (compareWords(stuff, "take")) {
            String itemName = "";
            Item item = null;
            for (int i = 1; i < 4 && i < command.length-index; i++) {
                itemName += command[index + i];
                item = DungeonMaster.player.scene.invenFind(itemName);
                if (item != null) {
                    DungeonMaster.player.invenAdd(item);
                    DungeonMaster.player.scene.invenRemov(item);
                    System.out.println("System: Item taken");
                    break;
                }
                else itemName += " ";
                if((i == 3 || i == command.length-index-1) && item == null) System.out.println("System: Item not found");
            }
        }
        
        else if (compareWords(stuff, "check")) {
            String output = "";
            Item[] inventory = null;
            if (command[index+1].equals("inventory")) {
                inventory = DungeonMaster.player.inventory;
                output = "System: You have ";
            }
            else{
                String invenName = "";
                Scene curScene = DungeonMaster.player.scene;
                for (int i = 1; i < 4 && i < command.length-index; i++) {
                    invenName += command[index + i];
                    int actorIndex = curScene.findActor(invenName);
                    if (actorIndex != -1) inventory = curScene.actors[actorIndex].inventory;
                    if (inventory != null) {output = "System: You found "; break;}
                    else invenName += " ";
                }
            }
            if (inventory != null) {
                boolean empty = true;
                for (int i = 0; i < inventory.length; i++) {
                    if (!inventory[i].name.equals("empty")) {
                        empty = false;
                        output += inventory[i].name+", "; 
                    }
                }
                if (empty) System.out.println(output += "nothing.");
                else {
                    output = output.substring(0, output.length() - 2);
                    System.out.println(output += ".");
                }
            }
            DungeonMaster.inputCommand();
        }
        
        else if (compareWords(stuff, "loot")) {
            String actorName = "";
            Actor actor = null;
            for (int i = 1; i < 4 && i < command.length-index; i++) {
                actorName += command[index + i];
                int actorIndex = DungeonMaster.player.scene.findActor(actorName);
                if (actorIndex != -1) actor = DungeonMaster.player.scene.actors[actorIndex];
                else actorName += " ";
            }
            if (actor != null) {
                if (actor.isLootable){
                    String output = "System: You looted ";
                    boolean empty = true;
                    for (int i = 0; i < actor.inventory.length; i++) {
                        if (!actor.inventory[i].name.equals("empty")) {
                            empty = false;
                            output += actor.inventory[i].name+", ";
                            DungeonMaster.player.invenAdd(actor.inventory[i]);
                            actor.invenRemov(actor.inventory[i]);
                        }
                    }
                    if (empty) System.out.println(output += "nothing.");
                    else {
                        output = output.substring(0, output.length() - 2);
                        System.out.println(output += ".");
                    }
                }
                else {
                    System.out.println("System: It's still alive, you'll have to fight it!");
                    DungeonMaster.player.fight(actor);
                }
            }
            else System.out.println("System: Actor not found");
            DungeonMaster.inputCommand();      
        }
        
        else if (stuff.equals("attack")) {
            String actorName = "";
            for (int i = 1; i < 4 && i < command.length-index; i++) {
                actorName += command[index + i];
                int actorIndex = DungeonMaster.player.scene.findActor(actorName);
                if (actorIndex != -1) DungeonMaster.player.fight(DungeonMaster.player.scene.actors[actorIndex]);
                else actorName += " ";
                if((i == 3 || i == command.length-index-1) && actorIndex == -1) System.out.println("System: Actor not found");
            }
            DungeonMaster.inputCommand();      
        }
        
        else if (stuff.equals("eat")) {
            String foodName = "";
            Item food = new Food(foodName, index);
            Food testFood = new Food("", 0);
            for (int i = 1; i < 4 && i < command.length-index; i++) {
                foodName += command[index + i];
                food = DungeonMaster.player.invenFind(foodName);
                if (food != null){
                    if (food.getClass().equals(testFood.getClass())) {
                        System.out.println("System: You ate "+ food.name);
                        DungeonMaster.player.eat((Food) food); 
                        DungeonMaster.player.invenRemov(food);
                    }
                    else System.out.println("System: You can't eat that");
                }
                else foodName += " ";
                if((i == 3 || i == command.length-index-1) && food == null) System.out.println("System: Item not found");
            }
            DungeonMaster.inputCommand();
        }
        
        else System.out.println("System: No command code found");
        DungeonMaster.inputCommand();        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * compareTo is a pain, so this makes it easier.
     * @param word1: first word
     * @param word2: second word
     * @return if the words are the same;
     */
    static boolean compareWords(String word1, String word2){
        return word1.compareTo(word2) == 0;
    }

}
