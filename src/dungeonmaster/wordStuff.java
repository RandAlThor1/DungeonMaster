/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dungeonmaster;

/**
 * Project:
 * @author Davin
 * Date: 02/10/2015 
 * Teacher: Mr. Wachs 
 */
class wordStuff {

    static String[] verbs = textFiles.; 
    static String foundVerb = "poop";
    static String checkForVerbs(String[] command) {
        
        for (int i = 0; i < command.length; i++) {
            
            boolean present = false;
            
            for (int j = 0; j < verbs.length; j++) {
                if (verbs[j].compareTo(command[i]) == 0) {
                    present = true;
                }                
            }
            
            if (present) {
                foundVerb = command[i];
                break;
            }
        }
        return foundVerb;
    }

}
