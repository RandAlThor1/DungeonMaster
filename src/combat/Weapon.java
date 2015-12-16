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
public class Weapon extends Equipment{
    int minDam, maxDam, requiredStrength, bonus;
    public boolean isMainHand;
    public boolean isTwoHand;
    public boolean isOffHand;
    String statModBonus;
    
    String type;

    /**
     *
     * @param name
     * @param maxDurability
     * @param statModBonus
     * @param Hand give "MH" for MainHand, "TH" for TwoHand or "OH" for OffHand
     */
    public Weapon(String name, int maxDurability, String statModBonus, String Hand, int maxDam, int minDam) {
        super(name, maxDurability);
        this.statModBonus = statModBonus;
        niceName =  name;
        if (Hand.equalsIgnoreCase("MH")) {
            this.isMainHand = true;
        }
        else if (Hand.equalsIgnoreCase("TH")) {
            this.isTwoHand = true;
        }
        else if (Hand.equalsIgnoreCase("OF")) {
            this.isOffHand = true;
        }
        if (this.isEmpty) {
            this.maxDam = 4;
            this.minDam = 1;
        }
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
    public String getStatModBonus(){
        return this.statModBonus;
    }
}
