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
    //public static ArrayList<Stats> npcStats = new ArrayList<>(); //might remove
    public static void addNPC(){
        int temp = 15; //temp number for stats of a npc
        allNPCs.add(new NPC("help",temp, temp, temp, temp, temp, temp)); // 
        
        
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
    /**
     * 
     * @param name
     * @return 
     * might just remove this method.
     */
//    public static int getNPCStatIndex(String name){
//        int result = -1;
//        if (!(NPCstats.isEmpty())) {
//            return result;
//        }
//        else {
//            for (int i = 0; i < 10; i++) {
//                
//            }
//        }
//        int unitIndex = getNPCIndex(name);
//        return -2;
//    }
    /**
     * 
     * @param string text for them to say
     * @param npcName name of NPC in string
     */
    public static void npcTalk(String string, String npcName){
        System.out.println(npcName + ": " + string);
    }
    
}
