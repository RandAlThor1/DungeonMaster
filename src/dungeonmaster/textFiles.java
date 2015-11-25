/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonmaster;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b.allen
 */
public class textFiles {
    public static String[] verbs;
    public static String[] nouns;
    public static String[] adj;
    textFiles() throws IOException{
        this.verbs = readFile("verbs.txt");
        this.nouns = readFile("nouns.txt");
        this.adj = readFile("adj.txt");
    }

    /**
     *
     * @param file name without .txt type
     * @throws FileNotFoundException
     */
    static public void editWordDocument(String file) throws FileNotFoundException{
        try (PrintWriter writer = new PrintWriter(file +  ".txt")) {   
        }
        
    }

    /**
     *  
     * @param String to be added to log
     * @throws FileNotFoundException
     */
    static public void addToLog(String String)throws IOException{
        String[] array = null;
        String temp;
        array = readFile("log.txt");
        temp = Arrays.toString(array);
        temp += String + " ";
        try {
            PrintWriter writer = new PrintWriter("log.txt");
            writer.println(temp);
        } catch (FileNotFoundException ex) {
            System.out.println("Yo dog there was an error adding that to the log!!!!!!");
            //Logger.getLogger(textFiles.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    /**
     *
     * @param file to be read
     * @return
     * @throws IOException
     */
    static public String[] readFile(String file) throws IOException{
    BufferedReader reader = new BufferedReader( new FileReader (file));
    String         line = null;
    StringBuilder  stringBuilder = new StringBuilder();
    String         ls = System.getProperty("line.separator");

    while((line = reader.readLine())!= null){
        stringBuilder.append(line);
        stringBuilder.append(ls);
    }
    String result = stringBuilder.toString();
    String[] array;
    array = result.split(" ");

    return array;
    }
    static public String[] readFile(String file, boolean temp) throws IOException{
    BufferedReader reader = new BufferedReader( new FileReader (file));
    String         line = null;
    StringBuilder  stringBuilder = new StringBuilder();
    String         ls = System.getProperty("line.separator");

    while((line = reader.readLine())!= null){
        stringBuilder.append(line);
        stringBuilder.append(ls);
    }
    String result = stringBuilder.toString();
    String[] array;
    array = result.split("\n");

    return array;
    }
    static public void displayHelp() throws IOException{
        String[] array;
        array = readFile("help.txt", true);
        System.out.println(Arrays.toString(array));
    }
}

