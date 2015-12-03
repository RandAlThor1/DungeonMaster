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
public class Armor extends Item {
    int durability, maxDurability;
    int armorBonus;
    int intelBonus, dexBonus, strengthBonus, wisBonus, conBonus, charBonus;
    boolean isHelm, isBoots, isChest, isArms, isLegs, isHands;

    public Armor(String name) {
        super(name);
    }
}
