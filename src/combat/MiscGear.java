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
public class MiscGear extends Equipment {
    public boolean isRing, isTrinket, isNeck;

    public MiscGear(String name, String type, int maxDurability, int weight) {
        super(name, maxDurability, weight);
        this.Type = 'M';
        if (type.equalsIgnoreCase("Ring")) {
            this.isRing = true;
        }
        else if (type.equalsIgnoreCase("Trinket")) {
            this.isTrinket = true;
        }
        else if (type.equalsIgnoreCase("Neck")) {
            this.isNeck = true;
        }
    }
    
}
