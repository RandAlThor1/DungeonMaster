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
        for (int r = 0; r < 2; r++) {
            for (int c = 0; c < temp.length; c++) {
                Words[0][c] = temp[c];
            }
        }
        checkForsynonym(Words);
    }

    private void checkForsynonym(String[][] Words) {// this is what we would do for words that come up very often with the chekcing it makes it simpler to find what we are looking for.[in most case]
        for (int i = 0; i < Words.length; i++) {
            if ("move".equals(Words[0][i]) || "walk".equals(Words[0][i])) {// add syonyms of the words, only doing the one for now as a example. will add more at school
                CommandProcessing.Words[1][i] = "go";
            }
            else if ("search".equals(Words[0][i])){
                CommandProcessing.Words[1][i] = "check";
            }
            else if ("kill".equals(Words[0][i])){
                CommandProcessing.Words[1][i] = "attack";
            }
            else if ("exit".equals(Words[0][i])){
                CommandProcessing.Words[1][i] = "enter";
            }
            else if (/*"poop".equals(Words[0][i])*/ false){//make this into more sysnonpmkjndsas
                CommandProcessing.Words[1][i] = "things";
            }
            else CommandProcessing.Words[1][i] = CommandProcessing.Words[0][i];
        }
    }
}
