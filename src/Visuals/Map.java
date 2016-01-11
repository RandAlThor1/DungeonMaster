/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visuals;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author b.allen
 */
public class Map {

    public Map(String mapFileName) {
       File temp = new File("src\\finalProject\\Map.txt");//reads the map and stores it in tileType, also sets all borderType to 0
        Scanner s = new Scanner(temp);
        for (int j = 0; j <= HEIGHT-1; j++){
            for (int i = 0; i <= WIDTH-1; i++){
                borderType[i][j] = 0;
                tileType[i][j] = s.nextInt();
            }
        }
        s.close();
    }
    
}
