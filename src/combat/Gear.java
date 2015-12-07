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
public class Gear {
    public Armor helm;
    public Armor Chest;
    public Armor Legs;
    public Armor Boots;
    public Armor Arms;
    public Armor Hands;
    public Weapon mainHand;
    public Weapon offHand;
    public MiscGear RingRight;
    public MiscGear RingLeft;
    public MiscGear TrinketRight;
    public MiscGear TrinketLeft;
    public MiscGear Neck;
    public Item[] equipArray;
    public Armor[] armorArray = {helm, Chest, Legs, Boots, Arms, Hands};
    public int armorClass;
    public int updateAC(){
        armorClass = 0;
        for (int i = 0; i < equipArray.length; i++) {
            armorClass += armorArray[i].armorBonus;
        }
        return armorClass;
    }
    
    public static void getStatsBoost(){
        int intelBonus, dexBonus, strengthBonus, wisBonus, conBonus, charBonus;
    }
    public void equipNewArmor(Armor newArmor){
        if (newArmor.isArms) {
            this.Arms = newArmor;
        }
        else if (newArmor.isBoots) {
            this.Boots = newArmor;
        }
        else if (newArmor.isChest) {
            this.Chest = newArmor;
        }
        else if (newArmor.isLegs) {
            this.Legs = newArmor;
        }
        else if (newArmor.isHelm) {
            this.helm = newArmor;
        }
        else if (newArmor.isLegs) {
            this.Legs = newArmor;
        }
        else {
            System.out.println("what are you trying to wear?");
        }
        updateEquipment();
    }
    public void equipNewWeapon(Weapon newWeapon){
        if (newWeapon.isMainHand) {
            this.mainHand = newWeapon;
        }
        else if (newWeapon.isOffHand) {
            this.offHand = newWeapon;
        }
        updateEquipment();
    }
    public void equipMagicItem(MiscGear newMagicGear, String leftOrRight){
        if (newMagicGear.isTrinket) {
            if (leftOrRight.equalsIgnoreCase("R")) {
                this.RingRight = newMagicGear;
            }
            else if (leftOrRight.equalsIgnoreCase("L")) {
                this.RingLeft =  newMagicGear;
            }
        }
        else if (newMagicGear.isRing) {
            if (leftOrRight.equalsIgnoreCase("R")) {
                this.TrinketRight = newMagicGear;
            }
            else if (leftOrRight.equalsIgnoreCase("L")) {
                this.TrinketLeft =  newMagicGear;
            }
        }
        else if (newMagicGear.isNeck) {
            this.Neck = newMagicGear;
        }
        updateEquipment();
    }
    public Item[] updateEquipment(){
        Item[] itemArray = {helm, Chest, Legs, Neck, Boots, Arms, Hands, mainHand, offHand, RingRight, RingLeft, TrinketRight, TrinketLeft, Neck};
        return itemArray;

    }
}



