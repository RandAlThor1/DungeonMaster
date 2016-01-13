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
    public static Display display;
    ArrayList<Map> maps = new ArrayList<>();

    static void leftPressed() {
        if (display.rightOff != 0) display.rightOff--;     
    }
    static void rightPressed(){
        if (display.rightOff !=0) display.rightOff++;
    } 
    static void downPressed() {
        if (display.downOff != 0) display.downOff++;
    }
    static void upPressed(){
        if (display.downOff != 0) display.downOff--;
    } 
    
    static void escapePressed() {
    }
    public void createMainDisplay(){
        display = new Display();
    }
    public void addMap(Map map){
        maps.add(map);
    }
    public void setMapActive(Map map){
        
        map.isActiveMap = true;
    }
    /**
     * 
     * @param map
     * @return <b> -1 if not found or broken </b> 
     */
    public int getActiveMapIndex(Map map){
        int index = -1;
        for (int i = 0; i < maps.size(); i++) {
            if (maps.get(i).equals(map)) return i;
        }
        return index;
    }
    
}
