/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonmaster;

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
    static Actor tree;
    static Actor hill;
    public static void main(String[] args) throws IOException {
        new textFiles();
        outside = new Scene();
        player = new Actor(0);
        tree = new Actor(1);
        hill = new Actor(2);
        inputCommand();
        
    }
    static void inputCommand() {
        String rawCommand = JOptionPane.showInputDialog("Enter command");
        rawCommand = rawCommand.toLowerCase();
        if (rawCommand.compareTo("end") == 0) {
            System.exit(0);
        }
        String[] command = rawCommand.split(" ");
        int index = wordStuff.checkForVerbs(command);
        wordUse.playerVerb(command, index);
    }
}
