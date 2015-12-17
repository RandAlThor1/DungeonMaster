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
        int attack = 0;
        int attack1 = 0;
        int attack2 = 0;
        if (opposingDefence.equalsIgnoreCase("AC")) {
            defence = enemy.gear.totalArmorClass; // again, useless unless i add other defences. just adding it for now.
        }
        else if (opposingDefence.equalsIgnoreCase("REFLEX")) {
            
        }
        else if (opposingDefence.equalsIgnoreCase("FORTITUDE")) {
            
        }
        else if (opposingDefence.equalsIgnoreCase("WILL")) {
            
        }
        else {
            defence = enemy.gear.totalArmorClass;
        }
        if (!(player.gear.mainHand.isEmpty) && player.gear.offHand.isEmpty) { 
            bonus = player.gear.mainHand.bonus + 2;
            attack = attackRoll(bonus, player.stats.getStatMod(player.gear.mainHand.getStatModBonus()));
            //still need to right the defence code'
            System.out.println("attack roll: " + attack);
            System.out.println("Enemy defence: " + defence);
            System.out.println(!(dodged(enemy.stats.dodgeChance)));
            if (attack >= defence){
                 if (((dodged(enemy.stats.dodgeChance)))) {
                int damage = damageDone(player.gear.mainHand.maxDam, player.gear.mainHand.minDam);
                enemy.stats.health -= damage;
                System.out.println("Enemy health: " + enemy.stats.health);
                }
            }
        }
        else if (!(player.gear.mainHand.isEmpty) && !(player.gear.offHand.isEmpty)) {
            int bonus2 = player.gear.offHand.bonus;
            bonus = player.gear.mainHand.bonus;
            attack1 = attackRoll(bonus, player.stats.getStatMod(player.gear.mainHand.getStatModBonus()));
            attack2 = attackRoll(bonus2, player.stats.getStatMod(player.gear.offHand.getStatModBonus()));
            System.out.println("atack1 roll" + attack1);
            System.out.println("Enemy defence: " + defence);
            if (attack1 >= defence){
                int damage = damageDone(player.gear.mainHand.maxDam, player.gear.mainHand.minDam);
                enemy.stats.health -= damage;
            }
            System.out.println("atack2 roll" + attack2);
            System.out.println("Enemy defence: " + defence);
            if (attack2 >= defence) {
                int damage = damageDone(player.gear.offHand.maxDam, player.gear.offHand.minDam);
                enemy.stats.health -= damage;
            }
        }
        else if (player.gear.mainHand.isEmpty && player.gear.offHand.isEmpty) {
            bonus = 0;
            attack = attackRoll(bonus, player.stats.getStatMod(player.gear.mainHand.getStatModBonus()));
            System.out.println("atack roll: " + attack);
            System.out.println("Enemy defence: " + defence);
            if (attack >= defence) {
                int damage = damageDone(player.gear.offHand.maxDam, player.gear.offHand.minDam);
                enemy.stats.health -= damage;
                System.out.println("Enemy health: " + enemy.stats.health);
            }
        } 
    }
    public static int attackRoll( int bonus, int statModToUse){
        int toHitBonus = bonus + statModToUse;
        int high = 20;
        int low = 1;
        //int roll = (int) ((20) * (Math.random() + 1));
        int result = (int) (Math.random() * high -  low) + low;
        result += toHitBonus;
        return result;
    }
    public static int damageDone(int maxDam, int minDam){
        int damage = (int) (Math.random() * maxDam -  minDam) + minDam;
        System.out.println("Damage roll: " + damage);
        return damage;
    }
    public static boolean dodged(int dodgeChance){
        int high = 100;
        int low = 1;
        boolean isDodged = false;
        int result = (int) (Math.random() * high -  low) + low;
        System.out.println("dodge result: " + result);
        if (result <= dodgeChance) {
            isDodged = true;
            System.out.println("Enemy was to slow");
        }
        //isDodged = result <= dodgeChance;
        else if (result > dodgeChance) {
            System.out.println("enemy was to fast");
        }
        return isDodged;
    }

}