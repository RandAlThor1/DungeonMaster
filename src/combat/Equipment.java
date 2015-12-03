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
public class Equipment {
    public static Armor helm;
    public static Armor Chest;
    public static Armor Legs;
    public static Armor Boots;
    public static Armor Arms;
    public static Armor Hands;
    public static Weapon mainHand;
    public static Weapon offHand;
    public static MagicGear Ring1;
    public static MagicGear Ring2;
    public static MagicGear Trinket1;
    public static MagicGear Trinket2;
    public static MagicGear Neck;
    public Item[] equipArray = {helm, Chest, Legs, Neck, Boots, Arms, Hands, mainHand, offHand};//used for outputing
    public int getAC(){
        return 0;
    }
    public String getEquipNames(){
        return null;
    }
    public static void getStatsBoost(){
        int intelBonus, dexBonus, strengthBonus, wisBonus, conBonus, charBonus;
    }
    public  void equipNewArmor(Armor newArmor){
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
    }
    public static void equipNewWeapon(){
}

