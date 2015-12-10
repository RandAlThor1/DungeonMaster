/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combat;

import Interactable.Actor;
import java.util.Random;

/**
 *
 * @author b.allen
 */
public class Combat {
    public Runnable Attack = new Runnable() {

        @Override
        public void run() {
            defaultAttack(null, null);
        }
    };
    public static void defaultAttack(Actor player, Actor enemy){
        int maxDam = player.equippedWeaponMainHand.maxDam;
        int minDam = player.equippedWeaponMainHand.minDam;
        int damage = damageDone(maxDam,minDam);
        int armor = enemy.gear.totalArmorClass;
        enemy.stats.health -= damage - armor;
        player.equippedWeaponMainHand.loseDurability(0);
        Random equipRoll = new Random();
        enemy.gear.armorArray[equipRoll.nextInt(enemy.gear.armorArray.length)].loseDurability(0);//you can tell davin wrote this //also NullPointerExeptions 
    }
    public static int AttackRoll(Actor attacker, Actor defender, int statModToUse){
        int toHitBonus = attacker.equippedWeaponMainHand.bonus + statModToUse;
        return 0;
    }
    public static int damageDone(int maxDam, int minDam){
        int result = (int) ((maxDam - minDam + 1) * (Math.random() + 1));
        return result;
    }
   
}
