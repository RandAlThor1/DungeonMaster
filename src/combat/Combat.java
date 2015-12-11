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
            //defaultAttack(null, null);
        }
    };
    public static void defaultAttack(Actor player, Actor enemy){
        int bonus = 0;
        if (!(player.equippedWeaponMainHand.isEmpty) && player.equippedWeaponOffHand.isEmpty) { 
            bonus = player.equippedWeaponMainHand.bonus + 2;
            int attack = attackRoll(bonus, player.stats.getStatMod(player.equippedWeaponMainHand.getStatModBonus()));
            //still need to right the defence code
            if (dodged(enemy.stats.dodgeChance)) {
                damageDone(player.equippedWeaponMainHand.maxDam, player.equippedWeaponMainHand.minDam);
            }
        }
        else if (!(player.equippedWeaponMainHand.isEmpty) && !(player.equippedWeaponOffHand.isEmpty)) {
            int bonus2 = player.equippedWeaponOffHand.bonus;
            bonus = player.equippedWeaponMainHand.bonus;
            int attack1 = attackRoll(bonus, player.stats.getStatMod(player.equippedWeaponMainHand.getStatModBonus()));
            int attack2 = attackRoll(bonus2, player.stats.getStatMod(player.equippedWeaponOffHand.getStatModBonus()));
        }
        
//        int maxDam = player.equippedWeaponMainHand.maxDam;
//        int minDam = player.equippedWeaponMainHand.minDam;
//        int damage = damageDone(maxDam,minDam);
//        int armor = enemy.gear.totalArmorClass;
//        enemy.stats.health -= damage - armor;
//        player.equippedWeaponMainHand.loseDurability(0);
//        Random equipRoll = new Random();
//        enemy.gear.armorArray[equipRoll.nextInt(enemy.gear.armorArray.length)].loseDurability(0);//you can tell davin wrote this //also NullPointerExeptions 
    }
    public static int attackRoll( int bonus, int statModToUse){
        int toHitBonus = bonus + statModToUse;
        return 0;
    }
    public static int damageDone(int maxDam, int minDam){
        int result = (int) ((maxDam - minDam + 1) * (Math.random() + 1));
        return result;
    }
    public static int dualWieldAttack(Actor player){
        return 0;
        
    }
    public static int twoHandedAttack(Actor player){
        return 0;
        
    
    }
    public static int magicAttack(){
        return 0;
        
    }
    public static int rangedAttack(){
        return 0;
        
    }
    public static boolean dodged(int dodgeChance){
        boolean isDodged;
        int result = 0;
        int reuslt = (int) (Math.random() * (1 + 100 - 1)) + 1;
        isDodged = result < dodgeChance;
        return isDodged;
    }

}