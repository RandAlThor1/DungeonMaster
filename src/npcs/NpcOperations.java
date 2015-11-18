/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npcs;

import java.util.ArrayList;

/**
 *
 * @author b.allen
 */
public class NpcOperations {
    public static ArrayList<NPC> allNPCs = new ArrayList<>();
    public static ArrayList<Stats> NPCstats = new ArrayList<>();
            
    public static void addNPC(){
        allNPCs.add(new NPC("help"));
        
    }
    /**
     * 
     * @param name
     * @return Index of NPC with name, returns -1 if ArrayList is empty
     */
    public static int getNPCIndex(String name){
        if (!(allNPCs.isEmpty())) {
            return -1;
        }
        else {
            for (int i = 0; i < allNPCs.size(); i++) {
                NPC temp = allNPCs.get(i);
                if (temp.name.equalsIgnoreCase(name)) {
                    return i;
                }
            }
        }
        return -2;
    }
    public static int getNPCStatIndex(String name){
        int result = -1;
        if (!(NPCstats.isEmpty())) {
            return result;
        }
        int unitIndex = getNPCIndex(name);
        return -2;
    }
}
