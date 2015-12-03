/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combat;

import Interactable.Actor;

/**
 *
 * @author b.allen
 */
public class AttackRolls {
   public static void defaultAttack(Actor player, Actor enemy){
       
    }
    public int AttackRoll(Actor attacker, Actor defender, int statModToUse){
        int toHitBonus = attacker.equippedWeapon.bonus + statModToUse;
        return 0;
    }
    public int damageDone(int maxDam, int minDam){
        int result = (int) ((maxDam - minDam + 1) * (Math.random() + 1));
        return result;
    }
   
}
