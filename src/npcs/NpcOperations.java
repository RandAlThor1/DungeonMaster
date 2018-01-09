/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npcs;

import Interactable.Scene;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author b.allen
 */
public class NpcOperations {
    public static ArrayList<NPC> allNPCs = new ArrayList<>();
    
    public static void addNPC(NPC npc){
        allNPCs.add(npc);
    }
    
    public static NPC newNPC(PersonalityType personType, String name, Point location, Scene scene, Stats stats){
        NPC npc = new NPC(personType, name, location, scene, stats);
        addNPC(npc);
        return npc;
    }
    /**
     * 
     * @param name
     * @return Index of NPC with name, returns -1 if ArrayList is empty
     */
    public int getNPCIndex(String name){
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
    public int[] findNpcsInScene(Scene scene){
        int[] array = null;
        for (int i = 0; i < allNPCs.size(); i++) {
            if (allNPCs.get(i).scene.equals(scene) ) {
                array[array.length] = i;
            }
        }
        return array;
    }
    /**
     * 
     * @param string text for them to say
     * @param npcName name of NPC in string
     */
    public void npcTalk(String string, NPC npc){
        System.out.println(npc.niceName + ": " + string);
    }
    
}
