/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combat;

import java.util.ArrayList;

/**
 *
 * @author b.allen
 */


//This can be put somewhere else.
public class UniqueGear {
    private static ArrayList<Equipment> uniqueGear;

    public UniqueGear() {
        uniqueGear = new ArrayList<>();
    }
    /**
     * 
     * @param name
     * @return Index for the Unique Equipment with that name. 
     * @see <b> returns -1 if item name is invalid </b>
     */
    public static int findUniqueIndex(String name){
        for (int i = 0; i < uniqueGear.size(); i++) {
            if (uniqueGear.get(i).name.equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }
    /**
     * 
     * @param equipment 
     * @see Adds Equipment to ArrayList Storage
     */
    public static void addUniqueItem(Equipment equipment){
        if (isUnique(equipment)) {
            uniqueGear.add(equipment);
        }
    }
    /**
     * 
     * @param name
     */
    public static void removeUniqueItem(String name){
        for (int i = 0; i < uniqueGear.size(); i++) {
            if (uniqueGear.get(i).name.equalsIgnoreCase(name)) {
                uniqueGear.remove(i);
            }
        }
    }
    public static void removeUniqueItem(Equipment equipment){
        for (int i = 0; i < uniqueGear.size(); i++) {
            if (uniqueGear.get(i).equals(equipment)) {
                uniqueGear.remove(i);
            }
        }
    }
    /**
     * 
     * @param equipment
     * @return True if Unique False if not
     */
    private static boolean isUnique(Equipment equipment){
          for (int i = 0; i < uniqueGear.size(); i++) {
              if (uniqueGear.get(i).equals(equipment)) {
                  return false;
              }
        }
          return true;
    }
}