/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visuals;

import java.util.ArrayList;

/**
 *
 * @author b.allen
 */
public class DisplayHandleing {

    public Display display;
    ArrayList<Map> maps = new ArrayList<>();

    void leftPressed() {
        if (display.rightOff != 0) {
            display.rightOff--;
        }
    }

    void rightPressed() {
        if (display.rightOff != 0) {
            display.rightOff++;
        }
    }

    void downPressed() {
        if (display.downOff != 0) {
            display.downOff++;
        }
    }

    void upPressed() {
        if (display.downOff != 0) {
            display.downOff--;
        }
    }

    static void escapePressed() {
    }

    public void createMainDisplay() {
        display = new Display();
    }

    public void addMap(Map map) {
        maps.add(map);
    }

    public void setMapActive(Map map) {
        map.isActiveMap = true;
        display.UpdateActive(map);
    }

    public void addTilesToContain() {
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                display.tiles.add(display.activeTiles[i][j]);
                display.tiles.setVisible(true);
            }
        }
    }

    /**
     *
     * @param map
     * @return <b> -1 if not found or broken </b>
     */
    public int getActiveMapIndex(Map map) {
        int index = -1;
        for (int i = 0; i < maps.size(); i++) {
            if (maps.get(i).equals(map)) {
                return i;
            }
        }
        return index;
    }
}



