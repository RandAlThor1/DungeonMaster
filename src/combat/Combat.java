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
    private static final int UNARMED_MAX_DAMAGE = 4;
    private static final int UNARMED_MIN_DAMAGE = 1;
    public Runnable Attack = new Runnable() { //I dont think that this needs to be a runnable -  ben

        @Override
        public void run() {
            //defaultAttack(null, null);
        }
    };
    /**
     * @param player
     * @param enemy
     * @param opposingDefence
     * @see <b> the default attack method. Will use proper weapons </b>
     */
    public static void defaultAttack(Actor player, Actor enemy, String opposingDefence){//no offHand only attack
        int bonus = 0;
        int defence = 0;
        int attack = 0;
        int attack1 = 0;
        int attack2 = 0;
        if (opposingDefence.equalsIgnoreCase("AC")) {
            defence = enemy.gear.totalArmorClass; // again, useless unless i add other defences. just adding it for now.
        }
        else if (opposingDefence.equalsIgnoreCase("REFLEX")) {
            defence = enemy.stats.reflex;
        }
        else if (opposingDefence.equalsIgnoreCase("FORTITUDE")) {
            defence =  enemy.stats.fortitude;
        }
        else if (opposingDefence.equalsIgnoreCase("WILL")) {
            defence = enemy.stats.will;
        }
        else {
            defence = enemy.gear.totalArmorClass;
        }
        if (!(player.gear.mainHand.isEmpty) && player.gear.offHand.isEmpty) { 
            bonus = player.gear.mainHand.bonus + 2;
            attack = attackRoll(bonus, player.stats.getStatMod(player.gear.mainHand.getStatModBonus()));
            //still need to right the defence code'
            System.out.println("Combat: Attack roll: " + attack);
            System.out.println("Combat: Enemy defence: " + defence);
            if (attack >= defence){
                if (dodged(enemy.stats.dodgeChance)) {
                    int damage = damageDone(player.gear.mainHand.maxDam, player.gear.mainHand.minDam);
                    enemy.stats.health -= damage;
                    System.out.println("Combat: Enemy health: " + enemy.stats.health);
                }
            }
        }
        else if (!(player.gear.mainHand.isEmpty) && !(player.gear.offHand.isEmpty)) {
            if (player.gear.mainHand.isTwoHand) {
                bonus = player.gear.mainHand.bonus;
                attack = attackRoll(bonus, player.stats.getStatMod(player.gear.mainHand.getStatModBonus()));
                System.out.println("Combat: Attack roll: " + attack);
                System.out.println("Combat: Enemy defence: " + defence);
                if (attack >= defence) {
                    if (((dodged(enemy.stats.dodgeChance)))) {
                        int damage = damageDone(player.gear.mainHand.maxDam, player.gear.mainHand.minDam);
                        enemy.stats.health -= damage;
                        System.out.println("Combat: Enemy health: " + enemy.stats.health);
                    }
                }
            }
            else {
                int bonus2 = player.gear.offHand.bonus;
                bonus = player.gear.mainHand.bonus;
                attack1 = attackRoll(bonus, player.stats.getStatMod(player.gear.mainHand.getStatModBonus()));
                attack2 = attackRoll(bonus2, player.stats.getStatMod(player.gear.offHand.getStatModBonus()));
                System.out.println("Combat: Attack roll: " + attack1);
                System.out.println("Combat: Enemy defence: " + defence);
                if (attack1 >= defence){
                    if (((dodged(enemy.stats.dodgeChance)))) {
                        int damage = damageDone(player.gear.mainHand.maxDam, player.gear.mainHand.minDam);
                        enemy.stats.health -= damage;
                        System.out.println("Combat: Enemy health: " + enemy.stats.health+"\n");
                    }
                }
                System.out.println("Combat: Attack roll: " + attack2);
                System.out.println("Combat: Enemy defence: " + defence);
                if (attack2 >= defence) {
                    if (((dodged(enemy.stats.dodgeChance)))) {
                        int damage = damageDone(player.gear.offHand.maxDam, player.gear.offHand.minDam);
                        enemy.stats.health -= damage;
                        System.out.println("Combat: Enemy health:  " + enemy.stats.health);
                    }
                }
            }
        }
        else if (player.gear.mainHand.isEmpty && player.gear.offHand.isEmpty) {
            bonus = 0;
            attack = attackRoll(bonus, player.stats.getStatMod(player.gear.mainHand.getStatModBonus()));
            System.out.println("Combat: Attack roll: " + attack);
            System.out.println("Combat: Enemy defence: " + defence);
            if (attack >= defence) {
                if (((dodged(enemy.stats.dodgeChance)))) {
                    int damage = damageDone(UNARMED_MAX_DAMAGE, UNARMED_MIN_DAMAGE);
                    enemy.stats.health -= damage;
                    System.out.println("Combat: Enemy health:  " + enemy.stats.health);
                }
            }
        }
    }
    /**
     * 
     * @param bonus
     * @param statModToUse
     * @return the attack roll as an int
     */
    public static int attackRoll( int bonus, int statModToUse){
        int toHitBonus = bonus + statModToUse;
        int high = 20;
        int low = 1;
        //int roll = (int) ((20) * (Math.random() + 1));
        int result = (int) (Math.random() * high -  low) + low;
        result += toHitBonus;
        return result;
    }
    /**
     * 
     * @param maxDam
     * @param minDam
     * @return damage done as an int
     */
    public static int damageDone(int maxDam, int minDam){
        int damage = (int) (Math.random() * maxDam -  minDam) + minDam;
        System.out.println("Combat: Damage roll: " + damage);
        return damage;
    }
    /**
     * 
     * @param dodgeChance
     * @return a boolean if the attack hit or not
     */
    public static boolean dodged(int dodgeChance){
        int high = 100;
        int low = 1;
        boolean isDodged = false;
        int result = (int) (Math.random() * high -  low) + low;
        System.out.println("Combat: Dodge result: " + result);
        if (result >= dodgeChance) {
            isDodged = true;
            System.out.println("Combat: Enemy was hit");
        }
        //isDodged = result <= dodgeChance;
        else if (result < dodgeChance) {
            System.out.println("Combat: Enemy was missed");
        }
        return isDodged;
    }
}