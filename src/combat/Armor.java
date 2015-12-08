/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combat;

/**
 *
 * @author b.allen
 */
public class Armor extends Equipment {
    int armorBonus;
    boolean isHelm, isBoots, isChest, isArms, isLegs, isHands;

    public Armor(String name,int armorClass, int maxDurability) {
        super(name, maxDurability);
        this.armorBonus = armorClass;
    }
}
