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
    public Weapon emptyWeapon;
    public Armor emptyArmor;
    public MiscGear emptyMisc;
    public Equipment[] equipArray;
    public Armor[] armorArray;
    public Weapon[] weaponArray;
    public MiscGear[] miscArray;

    public Gear() {
       
            emptyWeapon = new Weapon("empty", -1, "none", "none", 4, 1);
            emptyArmor =  new Armor("empty", -1, -1, "none");
            emptyMisc = new MiscGear("none", "none", -1);
            this.helm = emptyArmor;
            this.chest = emptyArmor;
            this.legs = emptyArmor;
            this.boots = emptyArmor;
            this.arms = emptyArmor;
            this.hands = emptyArmor;
            this.mainHand = emptyWeapon;
            this.offHand = emptyWeapon;
            this.ringRight = emptyMisc;
            this.ringLeft =  emptyMisc;
            this.trinketLeft =  emptyMisc;
            this.trinketRight = emptyMisc;
            this.neck = emptyMisc;
            equipArray = new Equipment[13];
            equipArray[0] = this.helm;
            equipArray[1] = this.chest;
            equipArray[2] = this.legs;
            equipArray[3] = this.boots;
            equipArray[4] = this.arms;
            equipArray[5] = this.hands;
            equipArray[6] = this.mainHand;
            equipArray[7] = this.offHand;
            equipArray[8] = this.ringRight;
            equipArray[9] = this.ringLeft;
            equipArray[10] = this.trinketLeft;
            equipArray[11] = this.trinketRight;
            equipArray[12] = this.neck;
            for (int i = 0; i < equipArray.length; i++) {
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
    public void getStatsBoost(){
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
    public void updateEquipment(){
        Equipment[] itemArray = {helm, chest, legs, neck, boots, arms, hands, mainHand, offHand, ringRight, ringLeft, trinketRight, trinketLeft, neck};
        equipArray = itemArray;
    }
    public void DamageAllArmor(int howMuchDurabilityLoss){
        for (int i = 0; i < this.armorArray.length; i++) {
            this.armorArray[i].loseDurability(howMuchDurabilityLoss);
        }
    }
}



