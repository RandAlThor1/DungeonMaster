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
    boolean isRing, isTrinket, isNeck;

    public MiscGear(String name, boolean isRing) {
        super(name);
        this.isRing = isRing;
    }
}
