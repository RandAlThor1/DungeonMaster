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
public class MagicGear extends Item{
    boolean isRing, isTrinket, isNeck;
    int intelBonus, dexBonus, strengthBonus, wisBonus, conBonus, charBonus;

    public MagicGear(String name) {
        super(name);
    }
    
}
