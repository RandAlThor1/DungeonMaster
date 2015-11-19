/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npcs;

/**
 *
 * @author b.allen
 */
public class NPC {
    String name;
    Stats stats;
    /**
     * 
     * @param name
     * @param strength
     * @param con
     * @param dex
     * @param intelli
     * @param wis
     * @param cha
     * @param unitIndex 
     * this contructor is temp and will not exist once we let users pick there stats and or set them for NPCs
     */

    public NPC(String name, int strength, int con, int dex, int intelli, int wis, int cha, int unitIndex) {
        this.name = name;
        this.stats = new Stats(strength, con, dex, intelli, wis, cha, unitIndex);
    }
    
}
