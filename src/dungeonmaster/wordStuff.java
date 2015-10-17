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

    static String[] verbs = textFiles.verbs; 
    static String[] nouns = textFiles.nouns; 
    static String[] adj = textFiles.adj;  
    
    static int checkForVerbs(String[] command) {
        int index = -1;
        for (int i = 0; i < command.length; i++) {
            
            boolean present = false;
            for (int j = 0; j < verbs.length; j++) {
                if (verbs[j].compareTo(command[i]) == 0) {
                    present = true;
                }                
            }
            
            if (present) {
                index = i;
                break;
            }
        }
        return index;
    }
    
    static String checkForNouns(String[] command) {
        String foundNoun = "poop";
        for (int i = 0; i < command.length; i++) {
            
            boolean present = false;
            
            for (int j = 0; j < nouns.length; j++) {
                if (nouns[j].compareTo(command[i]) == 0) {
                    present = true;
                }                
            }
            
            if (present) {
                foundNoun = command[i];
                break;
            }
        }
        return foundNoun;
    }
    
    static String checkForAdj(String[] command) {
        String foundAdj = "poop";
        for (int i = 0; i < command.length; i++) {
            
            boolean present = false;
            
            for (int j = 0; j < adj.length; j++) {
                if (adj[j].compareTo(command[i]) == 0) {
                    present = true;
                }                
            }
            
            if (present) {
                foundAdj = command[i];
                break;
            }
        }
        return foundAdj;
    }
    static void updateArrays(){
        verbs = textFiles.verbs; 
        nouns = textFiles.nouns; 
        adj = textFiles.adj; 
    }

}
