/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dungeonmaster;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 * Project:
 * @author Ben
 * Date: 02/10/2015 
 * Teacher: Mr. Wachs 
 */
public class CommandProcessing {
    public static String[][] Words;
    public CommandProcessing() throws NullPointerException, ArrayIndexOutOfBoundsException{
        int allWords = textFiles.nouns.length + textFiles.adj.length + textFiles.verbs.length;
        Words = new String[allWords][allWords];
        String[] temp = new String[allWords];
//        System.arraycopy(textFiles.verbs, 0, temp, 0, textFiles.adj.length);
//        System.arraycopy(textFiles.nouns, 0, temp, textFiles.verbs.length + 1, textFiles.verbs.length);
//        System.arraycopy(textFiles.adj, 0, temp, textFiles.verbs.length + textFiles.nouns.length - 1, textFiles.nouns.length);
//        System.out.println(Arrays.toString(temp));
        for (int i = 0; i < textFiles.verbs.length; i++) {
            temp[i] = textFiles.verbs[i];
        }
        for (int i = 0; i < textFiles.nouns.length; i++) {
            temp[textFiles.verbs.length + 1] = textFiles.nouns[i];
        }
        for (int i = 0; i < textFiles.adj.length; i++) {
            temp[textFiles.verbs.length + textFiles.nouns.length - 1] = textFiles.adj[i];
        }
        System.out.println(Arrays.toString(temp)); //Testing to see if the temp array is correct filled.
        for (int r = 0; r < 2; r++) {
            for (int c = 0; c < temp.length; c++) {
                Words[0][c] = temp[c];
            }
        }
        System.out.println(temp.length + " temp"); // all for testing
        System.out.println(allWords + " allwords");
        System.out.println(Words.length + " words length"); // all souts for testing
        System.out.println("STARTING ");
        checkForsynonym(Words);
        for (int i = 0; i < Words.length ; i++) {
        }
    }

    private void checkForsynonym(String[][] Words) {// this is what we would do for words that come up very often with the chekcing it makes it simpler to find what we are looking for.[in most case]
        for (int i = 0; i < Words.length; i++) {
            if ("go".equals(Words[0][i]) || "move".equals(Words[0][i]) || "walk".equals(Words[0][i])) {// add syonyms of the words, only doing the one for now as a example. will add more at school
                this.Words[1][i] = "go";
            }
        }
    }
    /**
     * Example method
     * no idea how you are dealing with X,Y so ill just return a string for now that is "x , y"
     * this is all temp below this.
     * @param actor
     * @return "x , y"
     */
    public Actor Move(Actor actor, int newX, int newY){
        actor.location.x = newX;
        actor.location.y = newY;
        return actor;
    }
    public void tempInputCommand(){
        String rawCommand = JOptionPane.showInputDialog("Enter command");
        rawCommand = rawCommand.toLowerCase();
        if (rawCommand.compareTo("end") == 0) {
            System.exit(0);
        }
        String[] command = rawCommand.split(" ");
        //t index = wordStuff.checkForVerbs(command);
        //wordUse.playerVerb(command, index);
        boolean temp = false;
        for (int i = 0; i < Words.length; i++) {
            for (int j = 0; j < command.length; j++) {
                if (Words[1][i].equalsIgnoreCase(command[j])){
                    temp = true;
                    break;
            }
            }
            
        }
        if(temp){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (Words[0][i].equalsIgnoreCase(command[j])) {
                    temp = true;
                    break;
                }
            }
        }
        }
    }
    
}
