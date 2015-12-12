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
    public int totalIntelBonus, totalDexBonus, totalStrengthBonus, totalWisBonus, totalConBonus, totalCharBonus;
    public int totalArmorClass;
    
    public Armor helm;
    public Armor chest;
    public Armor legs;
    public Armor boots;
    public Armor arms;
    public Armor hands;
    public Weapon mainHand;
    public Weapon offHand;
    public MiscGear ringRight;
    public MiscGear ringLeft;
    public MiscGear trinketRight;
    public MiscGear trinketLeft;
    public MiscGear neck;
    public static Equipment[] equipArray;
    public Armor[] armorArray = {helm, chest, legs, boots, arms, hands};

    public Gear() {
        equipArray = new Equipment[13];
        for (int i = 0; i < equipArray.length; i++) {
            equipArray[i] = new Equipment("empty", 0);
            equipArray[i].makeEmpty();
        }
    }

    public void updateAC(){
        int armorClass = 0;
        for (int i = 0; i < equipArray.length; i++) {
            armorClass += armorArray[i].armorBonus;
        }
        this.totalArmorClass = armorClass;
    }
    
    public static void getStatsBoost(){
        int intelBonus = 0, dexBonus = 0, strengthBonus = 0, wisBonus = 0, conBonus = 0, charBonus = 0;
        for (int i = 0; i < equipArray.length; i++) {
            if (!(equipArray[i].isBroken)) {
                intelBonus += equipArray[i].intelBonus;
                charBonus += equipArray[i].charBonus;
                dexBonus += equipArray[i].dexBonus;
                strengthBonus += equipArray[i].strengthBonus;
                wisBonus += equipArray[i].wisBonus;
                conBonus += equipArray[i].conBonus;
            }
        }
    }
    public Item[] updateEquipment(){
        Item[] itemArray = {helm, chest, legs, neck, boots, arms, hands, mainHand, offHand, ringRight, ringLeft, trinketRight, trinketLeft, neck};
        return itemArray;

    }
    public Armor[] DamageAllArmor(int howMuchDurabilityLoss, Armor[] armorArray){
        for (int i = 0; i < armorArray.length; i++) {
            armorArray[i].loseDurability(howMuchDurabilityLoss);
        }
        return armorArray;
    }
}



