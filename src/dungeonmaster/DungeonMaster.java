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
    public static void main(String[] args) throws IOException {
        String[] command = inputCommand();
        String foundVerb = wordStuff.checkForVerbs(command);
        System.out.println(foundVerb);
    }

    private static String[] inputCommand() {
        String rawCommand = JOptionPane.showInputDialog("Enter command");
        rawCommand = rawCommand.toLowerCase();
        String[] command = rawCommand.split(" ");
        return command;
    }
    
}
