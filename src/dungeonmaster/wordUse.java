package dungeonmaster;

import Interactable.Item;
import Interactable.Actor;
import Interactable.Food;
import Interactable.Scene;
import Interactable.Door;
import java.awt.Point;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Project:
 *
 * @author Davin Date: 02/10/2015 Teacher: Mr. Wachs
 */
class wordUse {

    /**
     * Checks if the given verb and command are valid and runs the code.  
     * @param verb the verb to check
     * @param command the full command entered
     * @param index the index of the verb in the command
     */
    static void checkVerbs(String verb, String[] command, int index){

        if (command.length == 1) {
            if (verb.equals("end")) {
                System.exit(0);
            }
            else if (verb.equals("enter")) {
                Point players = DungeonMaster.player.location;
                Scene curScene = DungeonMaster.player.scene;
                boolean found = false;
                for (int i = 0; i < curScene.doors.size(); i++) {
                    if (curScene.doors.get(i).location == players) {
                        found = true;
                        DungeonMaster.player.scene = curScene.doors.get(i).connectScene;
                        DungeonMaster.player.location = curScene.doors.get(i).connectPoint;
                        System.out.println("System: You`re now in " + curScene.doors.get(i).niceName);
                        System.out.println("System: You're new loctaion is: " + DungeonMaster.player.location.x + ", " + DungeonMaster.player.location.y);
                        for (int j = 0; j < DungeonMaster.player.inventory.length; j++) {
                            DungeonMaster.player.inventory[j].location = DungeonMaster.player.location;
                        }
                        String[] temp = new String[2];temp[0] = "look";temp[1] = "around";
                        checkVerbs("look", temp, 0);
                    }
                }
                if (!found) {
                    System.out.println("System: No door here");
                    if (DungeonMaster.help)System.out.println("Help: Try Go To-");
                }

            }
            else {
                System.out.println("System: No command code found");
                if (DungeonMaster.help)System.out.println("Help: Code error");
            }
        } 
        else {
            if (verb.equals("go") && command[index + 1].equals("in")) {
                String[] temp = new String[command.length-1];
                for (int i = 0; i < temp.length; i++) { 
                    if (i == index) temp[i] = "enter";
                    else if (i < index+1) temp[i] = command[i];
                    else temp[i] = command[i+1];
                }
                checkVerbs("enter", temp, index);
            }
            else if(verb.equals("enter")){
                Scene curScene = DungeonMaster.player.scene;
                int doorIndex = -1;
                String door = "";
                for (int i = 1; i < 4 && i < command.length - index; i++) {
                    door += command[index + i];
                    for (int j = 0; j < curScene.doors.size(); j++) {
                        if(curScene.doors.get(j).name.equals(door)){doorIndex = j; break;}
                    }
                    if (doorIndex != -1) break;
                    else door += " ";
                }
                if (doorIndex != -1) {
                    if(curScene.doors.get(doorIndex).location.equals(DungeonMaster.player.location)){
                        DungeonMaster.player.scene = curScene.doors.get(doorIndex).connectScene;
                        DungeonMaster.player.location = curScene.doors.get(doorIndex).connectPoint;
                        System.out.println("System: You`re now in " + DungeonMaster.player.scene.niceName);
                        System.out.println("System: You're new loctaion is: " + DungeonMaster.player.location.x + ", " + DungeonMaster.player.location.y);
                        for (int i = 0; i < DungeonMaster.player.inventory.length; i++) {
                            DungeonMaster.player.inventory[i].location = DungeonMaster.player.location;
                        }
                        String[] temp = new String[2];temp[0] = "look";temp[1] = "around";
                        checkVerbs("look", temp, 0);
                        DungeonMaster.inputCommand();
                    }
                    else{ 
                        System.out.println("System: Can't enter that from here");
                        if (DungeonMaster.help)System.out.println("Help: Try Go To-");
                    }
                }
                else System.out.println("System: Door not found");

            }
            else if (verb.equals("go") && command[index + 1].equals("to")) {
                Scene curScene = DungeonMaster.player.scene;
                int actorIndex = -1;
                String place = "";
                boolean found = false;
                for (int i = 1; i < 4 && i < command.length - index - 1; i++) {
                    place += command[index + 1 + i];
                    actorIndex = curScene.findActor(place);
                    if (actorIndex != -1) {found = true; break;}
                    else place += " ";
                }
                if (found) {
                    DungeonMaster.player.location = curScene.actors[actorIndex].location;
                    System.out.println("System: You're new loctaion is: " + DungeonMaster.player.location.x + ", " + DungeonMaster.player.location.y);
                    for (int i = 0; i < DungeonMaster.player.inventory.length; i++) {
                        DungeonMaster.player.inventory[i].location = DungeonMaster.player.location;
                    }
                    DungeonMaster.inputCommand();
                }
                int itemIndex = -1;
                if (!found){
                    
                    String item = "";
                    for (int i = 1; i < 4 && i < command.length - index - 1; i++) {
                        item += command[index + 1 + i];
                        for (int j = 0; j < curScene.inventory.length; j++) {
                            if (curScene.inventory[i].name.equals(item)) {itemIndex = i; break;}
                        }
                        if (itemIndex != -1) {found = true; break;}
                        else item += " ";
                    }
                }
                if (found) {
                    DungeonMaster.player.location = curScene.inventory[itemIndex].location;
                    System.out.println("System: You're new loctaion is: " + DungeonMaster.player.location.x + ", " + DungeonMaster.player.location.y);
                    for (int i = 0; i < DungeonMaster.player.inventory.length; i++) {
                        DungeonMaster.player.inventory[i].location = DungeonMaster.player.location;
                    }
                    DungeonMaster.inputCommand();
                }
                if (!found) {
                    place = "";
                    for (int i = 1; i < 4 && i < command.length - index - 1; i++) {
                        place += command[index + 1 + i];
                        for (int j = 0; j < curScene.doors.size(); j++) {
                            if (curScene.doors.get(j).name.equals(place)) {
                                actorIndex = j;
                                found = true;;
                            }
                        }
                        if (found) break;
                        else place += " ";
                    }
                }
                if (found) {
                    DungeonMaster.player.location = curScene.doors.get(actorIndex).location;
                    System.out.println("System: You're new loctaion is: " + DungeonMaster.player.location.x + ", " + DungeonMaster.player.location.y);
                    for (int i = 0; i < DungeonMaster.player.inventory.length; i++) {
                        DungeonMaster.player.inventory[i].location = DungeonMaster.player.location;
                    }
                    DungeonMaster.inputCommand();
                } 
                else if (isNum(command[index + 2]) && isNum(command[index + 3])) {
                    DungeonMaster.player.location = new Point(Integer.parseInt(command[index + 2]), Integer.parseInt(command[index + 3]));
                    System.out.println("System: You're new loctaion is: " + DungeonMaster.player.location.x + ", " + DungeonMaster.player.location.y);
                    for (int i = 0; i < DungeonMaster.player.inventory.length; i++) {
                        DungeonMaster.player.inventory[i].location = DungeonMaster.player.location;
                    }
                } 
                else {
                    System.out.println("System: Location not found");
                }
            } 
            else if (verb.equals("drop")) {
                String itemName = "";
                Item item = null;
                for (int i = 1; i < 4 && i < command.length - index; i++) {
                    itemName += command[index + i];
                    item = DungeonMaster.player.invenFind(itemName);
                    if (item != null) {
                        DungeonMaster.player.invenRemov(item);
                        DungeonMaster.player.scene.invenAdd(item);
                        System.out.println("System: Item droped");
                        break;
                    } 
                    else {
                        itemName += " ";
                    }
                    if ((i == 3 || i == command.length - index - 1) && item == null) {
                        System.out.println("System: Item not found");
                    }
                }

            } 
            else if (verb.equals("take")) {
                String itemName = "";
                Item item = null;
                for (int i = 1; i < 4 && i < command.length - index; i++) {
                    itemName += command[index + i];
                    item = DungeonMaster.player.scene.invenFind(itemName);
                    if (item != null) {
                        if (item.location.equals(DungeonMaster.player.location)) {
                            DungeonMaster.player.invenAdd(item);
                            DungeonMaster.player.scene.invenRemov(item);
                            System.out.println("System: Item taken");
                        } 
                        else {
                            System.out.println("System: Can't pick that up from here");
                        }
                        break;
                    } 
                    else {
                        itemName += " ";
                    }
                    if ((i == 3 || i == command.length - index - 1) && item == null) {
                        System.out.println("System: Item not found");
                    }
                }
            } 
            else if (verb.equals("check")) {
                String output = "";
                Item[] inventory = null;
                boolean possible = true;
                if (command[index + 1].equals("inventory")) {
                    inventory = DungeonMaster.player.inventory;
                    output = "System: You have ";
                } 
                else {
                    String invenName = "";
                    Scene curScene = DungeonMaster.player.scene;
                    for (int i = 1; i < 4 && i < command.length - index; i++) {
                        invenName += command[index + i];
                        int actorIndex = curScene.findActor(invenName);
                        if (actorIndex != -1) {
                            inventory = curScene.actors[actorIndex].inventory;
                        }
                        if (inventory != null) {
                            if (curScene.actors[actorIndex].location.equals(DungeonMaster.player.location)) {
                                output = "System: You found ";
                            } 
                            else {
                                System.out.println("System: You can't check that form here");
                                possible = false;
                            }
                            break;
                        } 
                        else {
                            invenName += " ";
                        }
                    }
                }
                if (inventory != null && possible) {
                    boolean empty = true;
                    for (int i = 0; i < inventory.length; i++) {
                        if (!inventory[i].name.equals("empty")) {
                            empty = false;
                            output += inventory[i].niceName + ", ";
                        }
                    }
                    if (empty) {
                        System.out.println(output += "nothing.");
                    } 
                    else {
                        output = output.substring(0, output.length() - 2);
                        System.out.println(output += ".");
                    }
                }
                if (inventory == null && possible) {
                    System.out.println("System: Actor not found");
                }
            } 
            else if (verb.equals("loot")) {
                String actorName = "";
                Actor actor = null;
                boolean possible = true;
                for (int i = 1; i < 4 && i < command.length - index; i++) {
                    actorName += command[index + i];
                    int actorIndex = DungeonMaster.player.scene.findActor(actorName);
                    if (actorIndex != -1) {
                        actor = DungeonMaster.player.scene.actors[actorIndex];
                        if (!actor.location.equals(DungeonMaster.player.location)) {
                            possible = false;
                            System.out.println("System: You can't loot that from here");
                        }
                    } 
                    else {
                        actorName += " ";
                    }
                }
                if (actor != null && possible) {
                    if (actor.isLootable) {
                        String output = "System: You looted ";
                        boolean empty = true;
                        for (int i = 0; i < actor.inventory.length; i++) {
                            if (!actor.inventory[i].name.equals("empty")) {
                                empty = false;
                                output += actor.inventory[i].niceName + ", ";
                                DungeonMaster.player.invenAdd(actor.inventory[i]);
                                actor.invenRemov(actor.inventory[i]);
                            }
                        }
                        if (empty) {
                            System.out.println(output += "nothing.");
                        } 
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
                if (actor == null && possible) {
                    System.out.println("System: Actor not found");
                }
            } 
            else if (verb.equals("attack")) {
                Scene curScene = DungeonMaster.player.scene;
                String actorName = "";
                for (int i = 1; i < 4 && i < command.length - index; i++) {
                    actorName += command[index + i];
                    int actorIndex = curScene.findActor(actorName);
                    if (actorIndex != -1) {
                        if (curScene.actors[actorIndex].location == DungeonMaster.player.location) {
                            DungeonMaster.player.fight(curScene.actors[actorIndex]);
                        } 
                        else {
                            System.out.println("You can't attack that from here");
                        }
                    } 
                    else {
                        actorName += " ";
                    }
                    if ((i == 3 || i == command.length - index - 1) && actorIndex == -1) {
                        System.out.println("System: Actor not found");
                    }
                }
            } 
            else if (verb.equals("eat")) {
                String foodName = "";
                Item food;
                Food testFood = new Food("", 0, new Point(-10000, -10000));
                for (int i = 1; i < 4 && i < command.length - index; i++) {
                    foodName += command[index + i];
                    food = DungeonMaster.player.invenFind(foodName);
                    if (food != null) {
                        if (food.getClass().equals(testFood.getClass())) {
                            System.out.println("System: You ate " + food.niceName);
                            DungeonMaster.player.eat((Food) food);
                            DungeonMaster.player.invenRemov(food);
                        } 
                        else {
                            System.out.println("System: You can't eat that");
                        }
                    } 
                    else {
                        foodName += " ";
                    }
                    if ((i == 3 || i == command.length - index - 1) && food == null) {
                        System.out.println("System: Item not found");
                    }
                }
                testFood = null;
            } 
            else if (verb.equals("enter")) {
                String doorName = "";
                Door door = new Door(null, null, null, "");
                Scene curScene = DungeonMaster.player.scene; 
                boolean found = false;
                for (int i = 1; i < 4 && i < command.length - index; i++) {
                    doorName += command[index + i];
                    for (int j = 0; j < curScene.doors.size(); j++) {
                        door = curScene.doors.get(j);
                        if (door.name.equals(doorName) && door.location == DungeonMaster.player.location){ found = true; break;} 
                    }
                    if (!found) doorName += " ";
                    else if(found){
                        DungeonMaster.player.scene = door.connectScene;
                        DungeonMaster.player.location = door.connectPoint;
                    } 
                    if ((i == 3 || i == command.length - index - 1) && !found) {
                        System.out.println("System: Item not found");
                    }
                }
                
            }
            else if (verb.equals("look")) {
                String output = "";
                Scene scene = DungeonMaster.player.scene;
                boolean nothing = true;
                if (command.length-index >= 2 && command[index + 1].equals("for")){
                    if (command[index + 2].equals("items")){
                        System.out.println("System: You see: ");
                        output += " Items: "; 
                        for (int i = 0; i < scene.inventory.length; i++) {
                            if (!scene.inventory[i].name.equals("empty")) {
                                output += scene.inventory[i].niceName + ", ";
                                nothing = false;
                            }     
                        }
                        if (nothing) output += "nothing  ";
                        output = output.substring(0, output.length()-2)+".";
                        System.out.println(output);
                        nothing = true;
                    }
                    if (command[index + 2].equals("actors")){
                        System.out.println("System: You see: ");
                        output += " Actors: "; 
                        for (int i = 0; i < scene.actors.length; i++) {
                            if(scene.actors[i] != DungeonMaster.player){
                                output += scene.actors[i].niceName + ", ";
                                nothing = false;
                            }
                        }
                        if (nothing) output += "nothing  ";
                        output = output.substring(0, output.length()-2)+".";
                        System.out.println(output);
                    }
                    if (command[index + 2].equals("places")){
                        System.out.println("System: You see: ");
                        output += " Places: "; 
                        for (int i = 0; i < scene.doors.size(); i++) {
                            output += scene.doors.get(i).niceName + ", ";
                            nothing = false;
                        }
                        if (nothing) output += "nothing  ";
                        output = output.substring(0, output.length()-2)+".";
                        System.out.println(output);
                    }
                }
                else if(command[index + 1].equals("around")){
                    System.out.println("System: You see: ");
                    output += " Items: "; 
                    for (int i = 0; i < scene.inventory.length; i++) {
                        if (!scene.inventory[i].name.equals("empty")) {
                            output += scene.inventory[i].niceName + ", ";
                            nothing = false;
                        }     
                    }
                    if (nothing) output += "nothing  ";
                    output = output.substring(0, output.length()-2)+".\n";
                    nothing = true;
                    output += " Actors: "; 
                    for (int i = 0; i < scene.actors.length; i++) {
                        if(scene.actors[i] != DungeonMaster.player){
                            output += scene.actors[i].niceName + ", ";
                            nothing = false;
                        }
                    }
                    if (nothing) output += "nothing  ";
                    output = output.substring(0, output.length()-2)+".\n";
                    nothing = true;
                    output += " Places: "; 
                    for (int i = 0; i < scene.doors.size(); i++) {
                        output += scene.doors.get(i).niceName + ", ";
                        nothing = false;
                    }
                    if (nothing) output += "nothing  ";
                    output = output.substring(0, output.length()-2)+".";
                    System.out.println(output);
                }
            }
            else {
                System.out.println("System: No command code found");
            }
        }
        DungeonMaster.inputCommand();
    }
   
    public static boolean isNum(String string) {
        boolean ret = true;
        try {
            Integer.parseInt(string);

        } catch (NumberFormatException e) {
            ret = false;
        }
        return ret;
    }

}
