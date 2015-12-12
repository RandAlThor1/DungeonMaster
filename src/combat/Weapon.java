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
    public Weapon(String name, int maxDurability, String statModBonus) {
        super(name, maxDurability);
        this.statModBonus = statModBonus;
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
    public String getStatModBonus(){
        return this.statModBonus;
    }
}
