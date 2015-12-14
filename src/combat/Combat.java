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
    private static final String DEFAULT_DEFENCE_TO_ATTACK = "AC"; //only one at the moment might implement reflex, will, and fortitude later. mabey
    public Runnable Attack = new Runnable() {

        @Override
        public void run() {
            //defaultAttack(null, null);
        }
    };
    public static void defaultAttack(Actor player, Actor enemy, String opposingDefence){
        int bonus = 0;
        int defence = 0;
        if (opposingDefence.equalsIgnoreCase("AC")) {
            defence = enemy.gear.totalArmorClass; // again, useless unless i add other defences. just adding it for now.
        }
        else {
            defence = enemy.gear.totalArmorClass;
        }
        if (!(player.gear.mainHand.isEmpty) && player.gear.offHand.isEmpty) { 
            bonus = player.gear.mainHand.bonus + 2;
            int attack = attackRoll(bonus, player.stats.getStatMod(player.gear.mainHand.getStatModBonus()));
            //still need to right the defence code
            if (((dodged(enemy.stats.dodgeChance)))) {
                int damage = damageDone(player.gear.mainHand.maxDam, player.gear.mainHand.minDam);
                enemy.stats.health -= damage;
                //enemy.gear.DamageAllArmor(-1);
                System.out.println(enemy.stats.health);
                
            }
        }
        else if (!(player.gear.mainHand.isEmpty) && !(player.gear.offHand.isEmpty)) {
            int bonus2 = player.gear.offHand.bonus;
            bonus = player.gear.mainHand.bonus;
            int attack1 = attackRoll(bonus, player.stats.getStatMod(player.gear.mainHand.getStatModBonus()));
            int attack2 = attackRoll(bonus2, player.stats.getStatMod(player.gear.offHand.getStatModBonus()));
        }
        else if (player.gear.mainHand.isMainHand && player.gear.offHand.isEmpty) {
            bonus = 0;
            int attack = attackRoll(bonus, player.stats.getStatMod(player.gear.mainHand.getStatModBonus()));;
            int damage = damageDone(player.gear.mainHand.maxDam, player.gear.mainHand.minDam);
            enemy.stats.health -= damage;
        }
//        int maxDam = player.equippedWeaponMainHand.maxDam;
//        int minDam = player.equippedWeaponMainHand.minDam;
//        int damage = damageDone(maxDam,minDam);
//        int armor = enemy.gear.totalArmorClass;
//        enemy.stats.health -= damage - armor;
//        player.equippedWeaponMainHand.loseDurability(0);
//        Random equipRoll = new Random();
//        
    }
    public static int attackRoll( int bonus, int statModToUse){
        int toHitBonus = bonus + statModToUse;
        int roll = (int) ((20) * (Math.random() + 1));
        int result = roll + toHitBonus;
        return result;
    }
    public static int damageDone(int maxDam, int minDam){
        int damage = (int) ((maxDam - minDam + 1) * (Math.random() + 1));
        return damage;
    }
    public static int dualWieldAttack(Actor player){ // meh
        return 0;
        
    }
    public static int twoHandedAttack(Actor player){ // meh
        return 0;
        
    
    }
    public static int magicAttack(){ // meh
        return 0;
        
    }
    public static int rangedAttack(){ // meh
        return 0;
        
    }
    public static boolean dodged(int dodgeChance){
        boolean isDodged = false;
        int result = 0;
        int reuslt = (int) (Math.random() * 100) + 1;
        isDodged = result <= dodgeChance;
        if (result > dodgeChance) {
            System.out.println("to fast");
        }
        return isDodged;
    }

}