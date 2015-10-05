/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonmaster;

import javax.swing.JOptionPane;

/**
 *
 * @author b.allen
 */
public class DungeonMaster {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] command = inputCommand();
    }

    private static String[] inputCommand() {
        String rawCommand = JOptionPane.showInputDialog("Enter command");
        rawCommand.split(" ");
        return null;
    }
    
}
