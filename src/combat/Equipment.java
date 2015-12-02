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
    Armor empty = new Armor("empty");
    Weapon empty1 = new Weapon("empty");
    public Armor helm = empty;
    public Armor Chest = empty;
    public Armor Legs = empty;
    public Armor Neck = empty;
    public Armor Boots = empty;
    public Armor Arms = empty;
    public Armor Hands = empty;
    public Weapon mainHand = empty1;
    public Weapon offHand = empty1;
    public Item[] equipArray = {helm, Chest, Legs, Neck, Boots, Arms, Hands, mainHand, offHand};//used for outputing
    
}
