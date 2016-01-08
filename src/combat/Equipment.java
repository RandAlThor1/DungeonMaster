/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combat;

import Interactable.Item;

/**
 *
 * @author b.allen
 */
public class Equipment extends Item{
    int intelBonus, dexBonus, strengthBonus, wisBonus, conBonus, charBonus;
    int durability, maxDurability;
    public boolean isBroken, isEmpty;
    public char Type;
    final int DEFAULT_DURABILITY = 60; // can change
    final int DEFAULT_DURABILITY_DAMAGE = 10; // can change
    public Equipment(String name, int maxDurability) {
        super(name);
        if (maxDurability == -1) {
            maxDurability = DEFAULT_DURABILITY;
        }
        else {
            this.maxDurability = maxDurability;
        }
        this.durability = this.maxDurability;
    }
    public static void use(){
        
    }
    public void loseDurability(int durabilityToLose){
        if (durabilityToLose == -1) {
            this.durability -= DEFAULT_DURABILITY_DAMAGE;
        }
        if (durability <= 0) {
            this.isBroken = true;
        }
    }
    /**
     * 
     * @return <b> 0 if Weapon, 1 if Armor, 2 if MiscGear </b>
     * @see <b> Requires the chat Type to be set within Equipment, 'W' for Weapon, 'A' for Armor, 'M' for MiscGear. MUST BE CAPS 
     */
    public int getType(){
        int result = -1;
        if (Type == 'W') {
            result = 0;
        }
        else if (Type == 'A') {
            result = 1;
        }
        else if (Type == 'M') {
            result = 2;
        }
        return result;
    }
}


