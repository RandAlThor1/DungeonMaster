 package dungeonmaster;

import Interactable.Item;
import Interactable.Actor;
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
            Item[] inventory = null;
            if (command[index+1].equals("inventory")) {
                inventory = DungeonMaster.player.inventory;
                System.out.print("System: You have ");
            }
            else{
                String invenName = "";
                Scene curScene = DungeonMaster.player.scene;
                for (int i = 1; i < 4 && i < command.length-index; i++) {
                    invenName += command[index + i];
                    inventory = curScene.actors[curScene.findActor(invenName)].inventory;
                }
            }
                boolean empty = true;
                for (int j = 0; j < inventory.length; j++) {
                    if (!inventory[j].name.equals("empty")) {
                        empty = false;
                        if (inventory[j+1] != null) {
                            if (!inventory[j+1].name.equals("empty")) System.out.print(inventory[j].name+", "); 
                            else System.out.println(inventory[j].name+". ☺"); 
                        }
                        else System.out.println(inventory[j].name); 
                    }   
                }
                if (empty) System.out.println("nothing.");
            else{
                Scene curScene = DungeonMaster.player.scene;
                String invenName = "";
                for (int i = 1; i < 4 && i < command.length-index; i++) {
                    invenName += command[index + i];
                    inventory = curScene.actors[curScene.findActor(invenName)].inventory;
                    if (inventory != null) {
                        System.out.print("System: You have");
                        for (int j = 0; j < inventory.length; j++) {
                            if (!inventory[j].name.equals("empty")) {
                                System.out.print(inventory[j].name+" ");    
                            } 
                        }
                        break;
                    }
                    else invenName += " ";
                    if((i == 3 || i == command.length-index-1) && inventory == null) System.out.println("System: Inventory not found");
                }
            }
            DungeonMaster.inputCommand();
        }
        
        else if (compareWords(stuff, "loot")) {
            String actorName = "";
            Actor actor = null;
            for (int i = 1; i < 4 && i < command.length-index; i++) {
                actorName += command[index + i];
                int poop = DungeonMaster.player.scene.findActor(actorName);
                if (!(poop == -1)) actor = DungeonMaster.player.scene.actors[poop];//best code
                if (actor != null) {
                    if (actor.isLootable){
                        System.out.print("System: You looted ");
                        boolean empty = true;
                        for (int j = 0; j < actor.inventory.length; j++) {
                            if (!actor.inventory[j].name.equals("empty")) {
                                empty = false;
                                if (actor.inventory[j+1] != null) {
                                    if (!actor.inventory[j+1].name.equals("empty")){
                                        System.out.print(actor.inventory[j].name+", ");
                                    } 
                                    else {
                                        System.out.println(actor.inventory[j].name+"."); 
                                        break;
                                    }
                                    DungeonMaster.player.invenAdd(actor.inventory[j]);
                                    actor.invenRemov(actor.inventory[j]);
                                }  
                                else System.out.println(DungeonMaster.player.inventory[j].name); 
                            }
                        }
                        if (empty) System.out.println("nothing.");
                    }
                    else{
                        System.out.println("System: It's still alive, you'll have to fight it!");
                        DungeonMaster.player.fight(actor);
                    }
                }
                else actorName += " ";
                if((i == 3 || i == command.length-index-1) && actor == null) System.out.println("System: Actor not found");
            }
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
