package dungeonmaster;

import Interactable.Item;
import Interactable.Actor;
import Interactable.Food;
import Interactable.Scene;
import Interactable.Door;
import Interactable.Key;
import java.awt.Point;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Project:
 *
 * @author Davin Date: 02/10/2015 Teacher: Mr. Wachs
 */
public class wordUse {

    /**
     * Checks if the given verb and command are valid and runs the code.  
     * @param verb the verb to check
     * @param command the full command entered
     * @param index the index of the verb in the command
     */
    public static void checkVerbs(String verb, String[] command, int index){

        if (command.length == 1) {
            if (verb.equals("end")) {
                System.exit(0);
            }
            else if (verb.equals("enter")) {
                enter();
            }
            else {
                System.out.println("System: No command code found");
                if (DungeonMaster.help)System.out.println("Help: Code error");
            }
        } 
        else {
            if (verb.equals("go") && command[index + 1].equals("in")) {
                enter();
            }
            else if(verb.equals("enter")){
                enter();
            }
            else if (verb.equals("go")) {
                go(command,index);
            } 
            else if (verb.equals("drop")) {
                drop(command, index);
            } 
            else if (verb.equals("take")) {
                take(command, index);
            } 
            else if (verb.equals("check")) {
                check(command, index);
            } 
            else if (verb.equals("loot")) {
                loot(command, index);
            } 
            else if (verb.equals("attack")) {
                attack(command, index);
            } 
            else if (verb.equals("eat")) {
                eat(command, index);
            } 
            else if (verb.equals("look")) {
                look(command, index);
            }
            else if (verb.equals("use")) {
                look(command, index);
            }
            else {
                System.out.println("System: No command code found");
                if (DungeonMaster.help)System.out.println("Help: Code error");
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

    private static void enter() {
        Point players = DungeonMaster.player.location;
        Scene curScene = DungeonMaster.player.scene;
        boolean found = false;
        for (int i = 0; i < curScene.doors.size(); i++) {
            if (curScene.doors.get(i).location == players) {
                found = true;
                if (!curScene.doors.get(i).locked) {
                    DungeonMaster.player.scene = curScene.doors.get(i).connectScene;
                    DungeonMaster.player.location = curScene.doors.get(i).connectPoint;
                    System.out.println("System: You`re now in " + DungeonMaster.player.scene.niceName);
                    System.out.println("System: You're new loctaion is: " + DungeonMaster.player.location.x + ", " + DungeonMaster.player.location.y);
                    for (int j = 0; j < DungeonMaster.player.inventory.length; j++) {
                        DungeonMaster.player.inventory[j].location = DungeonMaster.player.location;
                    }
                    String[] temp = new String[2];temp[0] = "look";temp[1] = "around";
                    checkVerbs("look", temp, 0);
                    DungeonMaster.inputCommand();
                }
                else {
                    Key testKey = new Key(null, null, null);
                    for (int j = 0; j < DungeonMaster.player.inventory.length; j++) {
                        if(DungeonMaster.player.inventory[j].getClass().equals(testKey.getClass())){
                            Key key = (Key)DungeonMaster.player.inventory[j];
                            if(key.door == curScene.doors.get(i)){
                                curScene.doors.get(i).locked = false;
                                System.out.println("System: Door unlocked");
                                enter();
                            }
                            else System.out.println("System: This door is locked");
                        }
                    }
                }
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
            else{ 
                System.out.println("System: Can't enter that from here");
                if (DungeonMaster.help)System.out.println("Help: Try Go To-");
            }
        }
        if (!found) {
            System.out.println("System: No door here");
            if (DungeonMaster.help)System.out.println("Help: Try Go To-");
        }
    }
    
    private static void go(String[] command, int index){
        Scene curScene = DungeonMaster.player.scene;//look for actors
        int actorIndex = -1;
        String place = "";
        boolean found = false;
        if (command[index+1].equals("to")) index++;         
        for (int i = 1; i < 4 && i < command.length - index; i++) {
            place += command[index + i];
            actorIndex = curScene.findActor(place);
            if (actorIndex != -1) found = true;
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

            String item = "";//look for items
            for (int i = 1; i < 4 && i < command.length - index; i++) {
                item += command[index + i];
                for (int j = 0; j < curScene.inventory.length; j++) {
                    if (curScene.inventory[j].name.equals(item)) {itemIndex = j; break;}
                }
                if (itemIndex != -1) found = true;
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
            place = "";//look for doors
            for (int i = 1; i < 4 && i < command.length - index; i++) {
                place += command[index + i];
                for (int j = 0; j < curScene.doors.size(); j++) {
                    if (curScene.doors.get(j).name.equals(place)) {
                        actorIndex = j;
                        found = true;;
                    }
                }
                place += " ";
            }
        }
        if (found) {
            if (!curScene.doors.get(actorIndex).locked) {
                DungeonMaster.player.location = curScene.doors.get(actorIndex).location;
                String[] temp = new String[1];temp[0] = "enter";
                enter();
                DungeonMaster.inputCommand();    
            }
            else{
                System.out.println("System: It's locked");
                for (int i = 0; i < DungeonMaster.player.inventory.length; i++) {
                    if(DungeonMaster.player.inventory[i].name.equals(curScene.doors.get(actorIndex).name+" key")){
                        System.out.println("System: Key used");
                        DungeonMaster.player.invenRemov(DungeonMaster.player.inventory[i]);
                        curScene.doors.get(actorIndex).locked = false;
                        DungeonMaster.player.location = curScene.doors.get(actorIndex).location;
                        String[] temp = new String[1];temp[0] = "enter";
                        enter();
                    }
                }
            }

        } 
        else if (isNum(command[index + 1]) && isNum(command[index + 2])) {//check if it's a location
            DungeonMaster.player.location = new Point(Integer.parseInt(command[index + 1]), Integer.parseInt(command[index + 2]));
            System.out.println("System: You're new loctaion is: " + DungeonMaster.player.location.x + ", " + DungeonMaster.player.location.y);
            for (int i = 0; i < DungeonMaster.player.inventory.length; i++) {
                DungeonMaster.player.inventory[i].location = DungeonMaster.player.location;
            }
        } 
        else {
            System.out.println("System: Location not found");
            if (DungeonMaster.help)System.out.println("Help: Try Look Around");
        }
    }

    private static void drop(String[] command, int index) {
        String itemName = "";
        Item item = null;
        for (int i = 1; i < 4 && i < command.length - index; i++) {
            itemName += command[index + i];
            item = DungeonMaster.player.invenFind(itemName);         
            itemName += " ";
            if ((i == 3 || i == command.length - index - 1) && item == null) {
                System.out.println("System: Item not found");
                if (DungeonMaster.help)System.out.println("Help: Given item isn't in your inventory");
            }
        }
        if (item != null) {
                DungeonMaster.player.invenRemov(item);
                DungeonMaster.player.scene.invenAdd(item);
                System.out.println("System: Item droped");      
        } 
    }

    private static void take(String[] command, int index) {
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
                    if (DungeonMaster.help)System.out.println("Help: Try Go To-");
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

    private static void check(String[] command, int index) {
        String output = "";
        Item[] inventory = null;
        boolean possible = true;
        if (command[index + 1].equals("inventory")) {
            inventory = DungeonMaster.player.inventory;
            output = "System: You have ";
        } 
        if (command[index + 1].equals("equipment")) {
            inventory = DungeonMaster.player.gear.equipArray;
            output = "System: You're wearing ";
        } 
        else {
            String invenName = "";
            Scene curScene = DungeonMaster.player.scene;
            for (int i = 1; i < 4 && i < command.length - index; i++) {
                invenName += command[index + i];
                int actorIndex = curScene.findActor(invenName);
                if (actorIndex != -1) {
                    inventory = curScene.actors[actorIndex].inventory;
                    if (curScene.actors[actorIndex].location.equals(DungeonMaster.player.location)) {
                        output = "System: You found ";
                    } 
                    else {
                        System.out.println("System: You can't check that form here");
                        if (DungeonMaster.help)System.out.println("Help: Try Go To-");
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
            if (DungeonMaster.help)System.out.println("Help: Given actor isn't in your current scene");
        }
    }

    private static void loot(String[] command, int index) {
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
                    if (DungeonMaster.help)System.out.println("Help: Try Go To-");
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
                if (DungeonMaster.help)System.out.println("Help: Try attack- first");
                DungeonMaster.player.fight(actor);
            }
        }
        if (actor == null && possible) {
            System.out.println("System: Actor not found");
        }
    }

    private static void attack(String[] command, int index) {
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
                    if (DungeonMaster.help)System.out.println("Help: Try Go To-");
                }
            } 
            else {
                actorName += " ";
            }
            if ((i == 3 || i == command.length - index - 1) && actorIndex == -1) {
                System.out.println("System: Actor not found");
                if (DungeonMaster.help)System.out.println("Help: Given actor not found in current scene");
            }
        }
    }

    private static void eat(String[] command, int index) {
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
                    if (DungeonMaster.help)System.out.println("Help: That item isn't food");
                }
            } 
            else {
                foodName += " ";
            }
            if ((i == 3 || i == command.length - index - 1) && food == null) {
                System.out.println("System: Item not found");
                if (DungeonMaster.help)System.out.println("Help: Given item not found in your inventory");
            }
        }
        testFood = null;
    }

    private static void look(String[] command, int index) {
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
}
