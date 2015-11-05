/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonmaster;

import Interactable.Stats;
import Interactable.Actor;
import Interactable.Food;
import Interactable.Scene;
import static dungeonmaster.CommandProcessing.Words;
import java.awt.Point;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b.allen
 */
public class DungeonMaster {
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    static Scene outside;
    static Actor player;
    public static void main(String[] args) throws IOException {
        new textFiles();
        new CommandProcessing();
        outside = new Scene();
        System.out.println("System: Enter your name");
        Scanner s = new Scanner(System.in);
        String playerName = s.nextLine();
        player = new Actor(playerName, new Point(0, 0), outside);
        player.stats = new Stats(20, 20, 20, 20, 20, 20);
        Actor theTree = new Actor("the tree", new Point(1, 1), outside);
        Actor theHill = new Actor("the hill", new Point(5, 5), outside);
        //Actor theShack = new Actor("the shack", new Point(12, 7), outside); Davin needs to make scenes/locations useful 
        //Actor maxsBar = new Actor("max's bar", new Point(3, 0), outside);
        Actor juliansMomsHouse = new Actor("mom's house", new Point(100, 100), outside);
        //Actor thePetShop = new Actor("the pet shop", new Point(7, 4), outside);
        //Actor arena = new Actor("the arena", new Point(32, 16), outside);
        //Actor potionsShop = new Actor("the potion shop", new Point(23, 14), outside);
        Actor actualEnemy = new Actor("boar", player.location, outside);
        
        juliansMomsHouse.invenAdd(new Food("the bread", 10, juliansMomsHouse));
        juliansMomsHouse.invenAdd(new Food("the apple", 5, juliansMomsHouse));
        juliansMomsHouse.invenAdd(new Food("john's cookie", -20, -20, -20, 20, juliansMomsHouse));//john's a dick
        
        System.out.println("System: Enter a command below");
        inputCommand();
    }
       static public void inputCommand(){
        Scanner s = new Scanner(System.in);
        String rawCommand = s.nextLine();//JOptionPane.showInputDialog("Enter command");
        rawCommand = rawCommand.toLowerCase();
        if (rawCommand.equals("end")) {
            System.exit(0);
        }
        if (rawCommand.equals("")) {
            inputCommand();
        }
        String[] command = rawCommand.split(" ");
        //t index = wordStuff.checkForVerbs(command);
        
        boolean temp = false;
        int index = -1;
        for (int i = 0; i < Words.length; i++) {
            for (int j = 0; j < command.length; j++) {
                if (Words[1][i].equalsIgnoreCase(command[j])){
                    temp = true;
                    wordUse.playerVerb(Words[0][i],command, j);
                    break;
                }
            } 
        }
        if(!temp){
            for (int i = 0; i < Words.length; i++) {
                for (int j = 0; j < command.length; j++) {
                    if (Words[0][i].equalsIgnoreCase(command[j])) {
                        temp = true;
                        wordUse.playerVerb(Words[0][i],command, j);
                        break;
                    }
                }
            }
        }
        if (!temp) {
            System.out.println("System: No command found");
//            try {
//                textFiles.addToLog(rawCommand);
//            } catch (IOException ex) {
//                Logger.getLogger(DungeonMaster.class.getName()).log(Level.SEVERE, null, ex);      //This is breaking everything
//            }
//           System.out.println("error");
            inputCommand();
        }
        
    }
//    static void inputCommand() {
//        String rawCommand = JOptionPane.showInputDialog("Enter command");
//        rawCommand = rawCommand.toLowerCase();
//        if (rawCommand.compareTo("end") == 0) {
//            System.exit(0);
//        }
//        String[] command = rawCommand.split(" ");
//        int index = wordStuff.checkForVerbs(command);
//        wordUse.playerVerb(command, index);
//    }
}
