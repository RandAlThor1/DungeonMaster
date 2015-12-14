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
    public boolean isHelm, isBoots, isChest, isArms, isLegs, isHands;

    public Armor(String name,int armorClass, int maxDurability, String type) {
        super(name, maxDurability);
        this.armorBonus = armorClass;
         if (type.equalsIgnoreCase("helm")) {
            this.isHelm = true;
        }
        else if (type.equalsIgnoreCase("chest")) {
            this.isChest = true;
        }
        else if (type.equalsIgnoreCase("arms")) {
            this.isArms = true;
        }
        else if (type.equalsIgnoreCase("legs")) {
            this.isLegs = true;
        }
        else if (type.equalsIgnoreCase("boots")) {
            this.isBoots = true;
        }
        else if (type.equalsIgnoreCase("hands")) {
            this.isHands = true;
        }
    }
    @Override
    public void makeEmpty(){
        this.isEmpty = true;
        this.armorBonus = 0;
        this.name = "empty";
    }
}
