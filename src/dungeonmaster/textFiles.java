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

/**
 *
 * @author b.allen
 */
public class textFiles {

    /**
     *
     * @param file name without .txt type
     * @throws FileNotFoundException
     */
    static public void editWordDocument(String file) throws FileNotFoundException{
        try (PrintWriter writer = new PrintWriter("file" +  ".txt")) {
        }
    }
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
}

