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
public class Weapon extends Item{
    int minDam, maxDam, requiredStrength, bonus;
    int intelBonus, dexBonus, strengthBonus, wisBonus, conBonus, charBonus;
    boolean isMainHand, isOffHand;
    
    String type;
    public Weapon(String name) {
        super(name);
        niceName =  name;
    }
    public int getMinDam(){
        return this.minDam;
    }
    public int getMaxDam(){
        return this.maxDam;
    }
    public int getBonus(){
        return this.bonus;
    }
    public int getRequiredStrength(){
        return this.requiredStrength;
    }
}
