/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visuals;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author b.allen
 */
public class Map {

    String mapFileName;
    int Height, Width;
    public int[][] tileType;
    Tile[][] tiles;
    boolean isBiggerThenScreen;
    public boolean isActiveMap;
    String mapName;

    public Map(String mapFileName) {
        this.tileType = new int[20][20];
        this.tiles = new Tile[20][20];
        this.mapFileName = mapFileName;
        this.mapName = mapFileName.toLowerCase();
        File temp = new File("src\\Maps\\" + mapFileName + ".txt");//reads the map and stores it in tileType, also sets all borderType to 0
        try {
            Scanner s = new Scanner(temp);
            for (int j = 0; j <= 19 ; j++) {
                for (int i = 0; i <= 19; i++) {
                    tileType[i][j] = s.nextInt();
                    tiles[i][j] = new Tile(tileType[i][j], new Point(i, j));
                }
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("error: Map File Not Found! " + mapFileName);
        }
    }

    public void changeTileType(Point point, Tile tile) {
        tileType[point.x][point.y] = tile.type;
    }

    public void changeTileType(Point point, int type) {
        tileType[point.x][point.y] = type;
    }

//    public Point findTile(Point point) {
//        for (int i = 0; i < tiles.length; i++) {
//            for (int j = 0; j < tiles[i].length; j++) {
//                if (tiles[i][j].point.equals(point)) {
//                    return tiles[i][j].point;
//
//                }
//            }
//        }
//        return new Point(point);
//    }
}
