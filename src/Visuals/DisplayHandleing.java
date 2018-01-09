package Visuals;

import java.util.ArrayList;

/**
 *
 * @author b.allen
 */
public class DisplayHandleing {

    public static Display display;
    public ArrayList<Map> maps;
    
    
    public DisplayHandleing() {
        maps = new ArrayList<>();
        createMainDisplay();
    }

    static void leftPressed() {
        if (display.rightOff != 0) {
            display.rightOff--;
        }
    }

    static void rightPressed() {
        if (display.rightOff != 0) {
            display.rightOff++;
        }
    }

    static void downPressed() {
        if (display.downOff != 0) {
            display.downOff++;
        }
    }

    static void upPressed() {
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
        display.tiles.removeAll();
        if(getActiveMap()!=null)
            getActiveMap().isActiveMap = false;
        map.isActiveMap = true;
        display.UpdateActive(map);
        addTilesToContain();
    }

    public void addTilesToContain() {
        for (int i = 0; i < display.map.width; i++) {
            for (int j = 0; j < display.map.height; j++) {
                display.tiles.add(display.map.tiles[i][j]);
                display.tiles.setVisible(true);
            }
        }
    }
    public Map getMap(String name){
        for (int i = 0; i < maps.size(); i++) {
            if (maps.get(i).mapName.equalsIgnoreCase(name)) {
                return maps.get(i);
            }
        }
        return null;
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
    public void setIsRunning(boolean isRunning){
        display.isRunning = isRunning;
    }
    
    public void render(){
        display.renderMap();
    }
    
    public Map getActiveMap() throws NullPointerException{
        for (int i = 0; i < maps.size(); i++) {
            if (maps.get(i).isActiveMap) {
                return maps.get(i);
            }
        }
        return null;
    }
    public void UpdateActives(){
        display.UpdateActive(getActiveMap());
    }
}



