/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonmaster;

import npcs.Stats;
import Interactable.Actor;
import Interactable.Food;
import Interactable.Scene;
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
    static boolean help;
    public static void main(String[] args) throws IOException {
        new textFiles();
        new CommandProcessing();
        outside = new Scene("Outside");
        System.out.println("System: Help Mode?(Y/N)");
        Scanner s = new Scanner(System.in);
        String helpMode = s.nextLine();
        if(helpMode.equals("Y")||helpMode.equals("Yes")) help = true;
        else if(helpMode.equals("N")||helpMode.equals("No")) help = false;
        else System.out.println("System: Invalid input, continuing");
        //System.out.println("System: Enter your name");
        //Scanner s = new Scanner(System.in);
        //String playerName = s.nextLine();
        player = new Actor("player", new Point(0, 0), outside);
        player.stats = new Stats(20, 20, 20, 20, 20, 20);
        Actor theTree = new Actor("The Tree", new Point(1, 1), outside);
        Actor theHill = new Actor("The Hill", new Point(5, 5), outside);
        Scene theShack = new Scene("The Shack"); outside.addDoor(theShack, new Point(0, 0),new Point(12, 7), true);
        Scene maxsBar = new Scene("Max's Bar"); outside.addDoor(maxsBar, new Point(0, 0),new Point(3, 0), true);
        Scene johnsHouse = new Scene("John's House"); outside.addDoor(johnsHouse, new Point(0, 0),new Point(28, 17), true);
        Actor juliansMomsHouse = new Actor("Mom's House", new Point(100, 100), outside);
        //Actor thePetShop = new Actor("the pet shop", new Point(7, 4), outside);
        //Actor arena = new Actor("the arena", new Point(32, 16), outside);
        //Actor potionsShop = new Actor("the potion shop", new Point(23, 14), outside);
        Actor actualEnemy = new Actor("The Boar", player.location, maxsBar);
        
        actualEnemy.invenAdd(new Food("The Bread", 10, actualEnemy));
        actualEnemy.invenAdd(new Food("The Apple", 5, actualEnemy));
        actualEnemy.invenAdd(new Food("John's Cookie", -20, -20, -20, 20, actualEnemy));//john's a dick
        
        for (int i = 0; i < 20; i++) johnsHouse.invenAdd(new Food("John's Cookie", -20, -20, -20, 20, new Point(5, 5)));           
        
        
        System.out.println("System: Enter a command below");
        inputCommand();
    }
       static public void inputCommand(){
        Scanner s = new Scanner(System.in);
        String rawCommand = s.nextLine();
        rawCommand = rawCommand.toLowerCase();
        if (rawCommand.equals("")) {
            inputCommand();
        }
        String[] command = rawCommand.split(" ");
        
        boolean temp = false;
        int index = -1;
        for (int i = 0; i < CommandProcessing.Words.length; i++) {
            for (int j = 0; j < command.length; j++) {
                if (CommandProcessing.Words[0][i].equalsIgnoreCase(command[j])){
                    temp = true;
                    wordUse.checkVerbs(CommandProcessing.Words[1][i],command, j);
                    break;
                }
            } 
        }
        if (!temp) {
            System.out.println("System: No command found");
            try {
                textFiles.addToLog(rawCommand);
            } catch (IOException ex) {
                Logger.getLogger(DungeonMaster.class.getName()).log(Level.SEVERE, null, ex);      //This is breaking everything
            }
           System.out.println("error");
            inputCommand();
        }
        
    }
}
