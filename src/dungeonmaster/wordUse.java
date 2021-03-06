package dungeonmaster;

import Interactable.Item;
import Interactable.Actor;
import Interactable.Food;
import Interactable.Scene;
import Interactable.Door;
import Interactable.DoorKey;
import Interactable.Objects;
import combat.Armor;
import combat.Equipment;
import combat.Gear;
import combat.MiscGear;
import combat.Weapon;
import java.awt.Point;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import npcs.NPC;

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
            else if (verb.equals("talk")) {
                interact(command, index);
            }
            else if (verb.equals("give")) {
                give(command, index);
            }
            else if (verb.equals("equip")) {
                equip(command, index);
            }
            else {
                System.out.println("System: No command code found");
                if (DungeonMaster.help)System.out.println("Help: Code error");
            }
        }
        DungeonMaster.inputCommand();
    }
    
    /**
     * checks if the given string is a number
     * @param string the string to be checked
     * @return is the string a number
     */
    public static boolean isNum(String string) {
        boolean ret = true;
        try {
            Integer.parseInt(string);

        } catch (NumberFormatException e) {
            ret = false;
        }
        return ret;
    }

    /**
     * makes the player enter the door, if its not locked
     */
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
                    DoorKey testKey = new DoorKey(null, null, null);
                    for (int j = 0; j < DungeonMaster.player.inventory.length; j++) {
                        if(DungeonMaster.player.inventory[j].getClass().equals(testKey.getClass())){
                            DoorKey key = (DoorKey)DungeonMaster.player.inventory[j];
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
        }
        if (!found) {
            System.out.println("System: No door here");
            if (DungeonMaster.help)System.out.println("Help: Try Go To-");
        }
    }
    /**
     * Sends the player to the given actorIndex, door, or item
     * @param command
     * @param index 
     */
    private static void go(String[] command, int index){
        Scene curScene = DungeonMaster.player.scene;//look for actors
        int actorIndex = -1;
        String place = "";
        boolean found = false;
        if (command[index+1].equals("to")) index++;         
        for (int i = 1; i < command.length - index; i++) {
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
        if (!found){
            actorIndex = -1;//look for objects
            place = "";
            found = false;        
            for (int i = 1; i < command.length - index; i++) {
                place += command[index + i];
                actorIndex = curScene.findObject(place);
                if (actorIndex != -1) found = true;
                else place += " ";
            }
        }
        if (found) {
            DungeonMaster.player.location = curScene.objects[actorIndex].location;
            System.out.println("System: You're new loctaion is: " + DungeonMaster.player.location.x + ", " + DungeonMaster.player.location.y);
            for (int i = 0; i < DungeonMaster.player.inventory.length; i++) {
                DungeonMaster.player.inventory[i].location = DungeonMaster.player.location;
            }
            DungeonMaster.inputCommand();
        }
        int itemIndex = -1;
        if (!found){

            String item = "";//look for actors
            for (int i = 1; i < command.length - index; i++) {
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
            for (int i = 1; i < command.length - index; i++) {
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
    /**
     * makes the player drop the given item
     * @param command
     * @param index 
     */
    private static void drop(String[] command, int index) {
        String itemName = "";
        Item item = null;
        for (int i = 1; i < command.length - index; i++) {
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
    /**
     * makes the player take the given item that has the same location as them
     * @param command
     * @param index 
     */
    private static void take(String[] command, int index) {
        String itemName = "";
        Item item = null;
        for (int i = 1; i < command.length - index; i++) {
            itemName += command[index + i];
            item = DungeonMaster.player.scene.invenFind(itemName);
            if (item != null) {
                //if (item.location.equals(DungeonMaster.player.location)) {
                    DungeonMaster.player.invenAdd(item);
                    DungeonMaster.player.scene.invenRemov(item);
                    System.out.println("System: Item taken");
                //} 
                //else {
                //    System.out.println("System: Can't pick that up from here");
                //   if (DungeonMaster.help)System.out.println("Help: Try Go To-");
                //}
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
    /**
     * outputs the inventory of the given actorIndex or the players inventory or the players equipment
     * @param command
     * @param index 
     */
    private static void check(String[] command, int index) {
        String output = "";
        Item[] inventory = null;
        boolean possible = true;
        if (command[index + 1].equals("inventory")) {
            inventory = DungeonMaster.player.inventory;
            output = "System: You have ";
        } 
        if (command[index + 1].equals("equipment")) {
            System.out.println("System: You have equiped:");
            check(new String[]{"check", "armor"}, 0);
            check(new String[]{"check", "weapon"}, 0);
            check(new String[]{"check", "misc"}, 0);
            DungeonMaster.inputCommand();
        } 
        else if (command[index + 1].equals("armor")) {
            inventory = DungeonMaster.player.gear.armorArray;
            output = "  Armor: ";
        } 
        else if (command[index + 1].equals("weapon")) {
            inventory = DungeonMaster.player.gear.weaponArray;
            output = "  Weapon: ";
        } 
        else if (command[index + 1].equals("misc")) {
            inventory = DungeonMaster.player.gear.miscArray;
            output = "  Misc: ";
        } 
        else {
            String invenName = "";
            Scene curScene = DungeonMaster.player.scene;
            for (int i = 1; i < command.length - index; i++) {
                invenName += command[index + i];
                
                int objectIndex = curScene.findObject(invenName);
                if (objectIndex != -1) {
                    inventory = curScene.objects[objectIndex].inventory;
                    output = "System: You found ";
                    break;
                }
                else{
                    invenName += " ";
                }
            }
        }
        if (inventory != null && possible) {
            output += nameList(inventory);
            System.out.println(output);
        }
        if (inventory == null && possible) {
            System.out.println("System: Object not found");
            if (DungeonMaster.help)System.out.println("Help: Given object isn't in your current scene");
        }
    }
    /**
     * makes the player take everything from the given objects inventory, if allowed
     * @param command
     * @param index 
     */
    private static void loot(String[] command, int index) {
        String objectName = "";
        Objects object = null;
        boolean possible = true;
        for (int i = 1; i < command.length - index; i++) {
            objectName += command[index + i];
            int objectIndex = DungeonMaster.player.scene.findObject(objectName);
            if (objectIndex != -1) {
                object = DungeonMaster.player.scene.objects[objectIndex];
                possible = false;
            } 
            else {
                objectName += " ";
            }
        }
        if (object != null && possible) {
            if (object.isLootable) {
                String output = "System: You looted ";
                boolean empty = true;
                for (int i = 0; i < object.inventory.length; i++) {
                    if (!object.inventory[i].name.equals("empty")) {
                        empty = false;
                        DungeonMaster.player.invenAdd(object.inventory[i]);
                        object.invenRemov(object.inventory[i]);
                    }
                }
                if (empty) {
                    System.out.println(output += "nothing.");
                } 
                else {
                    output += nameList(object.inventory);
                    output = output.substring(0, output.length() - 2);
                    System.out.println(output += ".");
                }
            } 
            else if(object.isActor){
                System.out.println("System: It's still alive, you'll have to fight it!");
                if (DungeonMaster.help)System.out.println("Help: Try attack- first");
            }
            else if(object.isLocked){
                System.out.println("System: It's locked");
                if (DungeonMaster.help)System.out.println("Help: You need to unlock it first");
            }
        }
        if (object == null && possible) {
            System.out.println("System: Actor not found");
        }
    }
    /**
     * starts a fight with the given actorIndex
     * @param command
     * @param index 
     */
    private static void attack(String[] command, int index) {
        Scene curScene = DungeonMaster.player.scene;
        String actorName = "";
        for (int i = 1; i < command.length - index; i++) {
            actorName += command[index + i];
            int actorIndex = curScene.findActor(actorName);
            if (actorIndex != -1) {
                //if (curScene.actors[actorIndex].location == DungeonMaster.player.location) {
                    DungeonMaster.player.fight(curScene.actors[actorIndex]);
                //} 
                //else {
                //    System.out.println("You can't attack that from here");
                //    if (DungeonMaster.help)System.out.println("Help: Try Go To-");
                //}
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
    /**
     * make the player eat the given item in their inventory
     * @param command
     * @param index 
     */
    private static void eat(String[] command, int index) {
        String foodName = "";
        Item food;
        Food testFood = new Food("", 0, new Point(-10000, -10000));
        for (int i = 1;i < command.length - index; i++) {
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
    /**
     * outputs all of the actors, actors, and doors in the current scene
 or outputs all of the respective objects in the current scene
     * @param command
     * @param index 
     */
    private static void look(String[] command, int index) {
        String output = "";
        Scene scene = DungeonMaster.player.scene;
        if (command.length-index >= 2 && command[index + 1].equals("for")){
            if (command[index + 2].equals("items")){
                System.out.println("System: You see: ");
                output += " Items: "; 
                output += nameList(scene.inventory);
                System.out.println(output);
            }
            if (command[index + 2].equals("actors")){
                System.out.println("System: You see: ");
                output += " Actors: "; 
                output += nameList(scene.actors);
                System.out.println(output);
            }
            if (command[index + 2].equals("objects")){
                System.out.println("System: You see: ");
                output += " Objects: "; 
                output += nameList(scene.objects);
                System.out.println(output);
            }
            if (command[index + 2].equals("places")){
                System.out.println("System: You see: ");
                output += " Places: "; 
                output += nameList(scene.doors);
                System.out.println(output);
            }
        }
        else if(command[index + 1].equals("around")){
            System.out.println("System: You see: ");
            output = " Items: "; 
            output += nameList(scene.inventory);
            System.out.println(output);
            output = " Actors: "; 
            output += nameList(scene.actors);
            System.out.println(output);
            output = " Objects: "; 
            output += nameList(scene.objects);
            System.out.println(output);
            output = " Places: "; 
            output += nameList(scene.doors);
            System.out.println(output);
        }
    }
    /**
     * temp method for npc interactions
     * @param command
     * @param index 
     */
    private static void interact(String[] command, int index){
        Scene curScene = DungeonMaster.player.scene;
        int npcIndex = -1;
        String npcName = "";
        boolean found = false;
        NPC testNpc = new NPC(null, npcName, null, curScene, null);
        if (command[index+1].equals("to")) index++;
        if (command[index+1].equals("with")) index++;
        for (int i = 1; i < command.length - index; i++) {
            npcName += command[index + i];
            npcIndex = curScene.findActor(npcName);
            if (npcIndex != -1) {
                if (curScene.actors[npcIndex].getClass().equals(testNpc.getClass())) {
                    NPC realNpc = (NPC)curScene.actors[npcIndex];
                    realNpc.talk.run();
                } 
                else {
                    System.out.println("System: You can't talk to that");
                    if (DungeonMaster.help)System.out.println("Help: That actor isn't a NPC");
                }
                break;
            } 
            else {
                npcName += " ";
            }
            if ((i == 3 || i == command.length - index - 1) && npcIndex != -1) {
                System.out.println("System: NPC not found");
                if (DungeonMaster.help)System.out.println("Help: Given NPC not found in current scene");
            }
        }
        testNpc = null;
    }
    private static void give(String[] command, int index){
        Item item = null;
        Objects object = null;
        String name = "";
        boolean done = false;
        for (int i = index; i < command.length-1; i++) {
            name += command[i+1];
            if (item == null) {
                item = DungeonMaster.player.invenFind(name);
                if (item != null){
                    name = "";
                    if(command.length > i) if(command[i+1].equals("in"))i++;    
                }
                
            }
            if (object == null){
                int objectIndex = DungeonMaster.player.scene.findObject(name);
                if(objectIndex != -1) {
                    object = DungeonMaster.player.scene.objects[objectIndex];
                    name = "";
                }
            }
            if(object != null && item != null) {done = true; break;}
        }
        if (done) {
            object.invenAdd(item);
            DungeonMaster.player.invenRemov(item);
            System.out.println("System: "+item.niceName+" is now in "+object.niceName+"'s inventory.");
            NPC testNpc= new NPC(null, "", null, DungeonMaster.outside, null);
            if (object.getClass() == testNpc.getClass()) System.out.println(object.niceName+": Thank you.");
        }
        else System.out.println("System: Actor or Item not found");
    }
    private static void equip(String[] command, int index){
        String itemName = "";
        Item item = null;
        for (int i = 1; i < command.length - index; i++) {
            itemName += command[index + i];
            item = DungeonMaster.player.invenFind(itemName);         
            itemName += " ";
            if ((i == 3 || i == command.length - index - 1) && item == null) {
                System.out.println("System: Item not found");
                if (DungeonMaster.help)System.out.println("Help: Given item isn't in your inventory");
            }
        }
        if (item != null) {
            Weapon weapon = Gear.getEmptyWeapon();
            Armor armor = Gear.getEmptyArmor();
            MiscGear misc = Gear.getEmptyMisc();       
//            Weapon weapon = new Weapon("empty", -1, "none", "none", 4, 1);
//            Armor armor =  new Armor("empty", -1, -1, "Empty");
//            MiscGear misc = new MiscGear("empty", "none", -1);
            if (item.getClass().equals(weapon.getClass())){
                DungeonMaster.player.invenRemov(item);
                DungeonMaster.player.equipNewWeapon((Weapon)item);
                System.out.println("System: Weapon equiped");          
            }
            else if (item.getClass().equals(armor.getClass())){
                DungeonMaster.player.invenRemov(item);
                DungeonMaster.player.equipNewArmor((Armor)item);
                System.out.println("System: Armor equiped");          
            }
            else if (item.getClass().equals(misc.getClass())){
                DungeonMaster.player.invenRemov(item);
                DungeonMaster.player.equipMagicItem((MiscGear)item, "left");
                System.out.println("System: Item equiped");          
            }
            else System.out.println("System: You can't equip that.");
            
        } 
    }
    
    private static String nameList(Objects[] array){
        String output = "";
        boolean nothing = true;
        boolean found = false;
        String[] objects = new String[array.length];
        for (int i = 0; i < objects.length; i++) objects[i] = "";
        int[] amount = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (!array[i].isActor){
                nothing = false;
                for (int j = 0; j < objects.length; j++) {
                    if (objects[j].equals(array[i].niceName)) {
                        amount[j]++;
                        found = true;
                        break;
                    }
                }
                if(!found){
                    for (int j = 0; j < objects.length; j++) {
                        if (objects[j].equals("")) {
                            objects[j] = array[i].niceName;
                            amount[j]++;
                            break;
                        }
                    }
                }
            }     
        }
        if (nothing) output += "nothing  ";
        else{
            for (int i = 0; i < objects.length; i++) {
                if (!objects[i].equals("")) {
                    if (amount[i] == 1) output += objects[i]+", ";
                    else output += objects[i]+" X"+amount[i]+", ";    
                }
                
            }
        }
        output = output.substring(0, output.length()-2)+".";
        return output;
    }
    private static String nameList(Actor[] array){
        String output = "";
        boolean nothing = true;
        boolean found = false;
        String[] actors = new String[array.length];
        for (int i = 0; i < actors.length; i++) actors[i] = "";
        int[] amount = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (!array[i].name.equals(DungeonMaster.player.name)) {
                nothing = false;
                for (int j = 0; j < actors.length; j++) {
                    if (actors[j].equals(array[i].niceName)) {
                        amount[j]++;
                        found = true;
                        break;
                    }
                }
                if(!found){
                    for (int j = 0; j < actors.length; j++) {
                        if (actors[j].equals("")) {
                            actors[j] = array[i].niceName;
                            amount[j]++;
                            break;
                        }
                    }
                }
            }     
        }
        if (nothing) output += "nothing  ";
        else{
            for (int i = 0; i < actors.length; i++) {
                if (!actors[i].equals("")) {
                    if (amount[i] == 1) output += actors[i]+", ";
                    else output += actors[i]+" X"+amount[i]+", ";    
                }
                
            }
        }
        output = output.substring(0, output.length()-2)+".";
        return output;
    }
    private static String nameList(Item[] array){
        String output = "";
        boolean nothing = true;
        boolean found = false;
        String[] items = new String[array.length];
        for (int i = 0; i < items.length; i++) items[i] = "";
        int[] amount = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (!array[i].name.equals("empty")) {
                nothing = false;
                for (int j = 0; j < items.length; j++) {
                    if (items[j].equals(array[i].niceName)) {
                        amount[j]++;
                        found = true;
                        break;
                    }
                }
                if(!found){
                    for (int j = 0; j < items.length; j++) {
                        if (items[j].equals("")) {
                            items[j] = array[i].niceName;
                            amount[j]++;
                            break;
                        }
                    }
                }
            }     
        }
        if (nothing) output += "nothing  ";
        else{
            for (int i = 0; i < items.length; i++) {
                if (!items[i].equals("")) {
                    if (amount[i] == 1) output += items[i]+", ";
                    else output += items[i]+" X"+amount[i]+", ";    
                }
                
            }
        }
        output = output.substring(0, output.length()-2)+".";
        return output;
    }
    private static String nameList(ArrayList<Door> array){
        String output = "";
        boolean nothing = true;
        for (int i = 0; i < array.size(); i++) {
                    output += array.get(i).niceName + ", ";
                    nothing = false;
                }
                if (nothing) output += "nothing  ";
                output = output.substring(0, output.length()-2)+".";
        return output;
    }

    
}









