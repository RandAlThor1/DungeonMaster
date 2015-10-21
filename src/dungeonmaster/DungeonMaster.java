/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonmaster;

import static dungeonmaster.CommandProcessing.Words;
import java.awt.Point;
import java.io.IOException;
import javax.swing.JOptionPane;

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
        player = new Actor("player", new Point(0, 0), outside);
        Actor theTree = new Actor("the tree", new Point(1, 1), outside);
        Actor theHill = new Actor("the hill", new Point(5, 5), outside);
        Actor maxsBar = new Actor("max's bar", new Point(3, 0), outside);
        inputCommand();
        
    }
       static public void inputCommand(){
        String rawCommand = JOptionPane.showInputDialog("Enter command");
        rawCommand = rawCommand.toLowerCase();
        if (rawCommand.compareTo("end") == 0) {
            System.exit(0);
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
                System.out.println("poop");
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
