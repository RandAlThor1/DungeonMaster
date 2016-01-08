package Interactable;

import combat.*;
import java.awt.Point;
import npcs.Stats;

/**
 * Project:
 * @author Davin
 * Date: 02/10/2015 
 * Teacher: Mr. Wachs 
 */
public class Actor extends Objects{

    public Weapon equippedWeaponMainHand;
    public Weapon equippedWeaponOffHand;
    public Stats stats;
    public Gear gear;
    public int gold; 
    public Runnable death = new Runnable() {
        @Override
        public void run() {
            isLootable = true;
            niceName += "(dead)";
        }
    };
    //public Personality personality //use achitypes to make this easyer
    public boolean isLootable;
    
    public Actor(String name, Point location, Scene scene) {
        super(name, location, scene);
        inventory = new Item[20];
        this.scene.addActor(this);
        isLootable = false; 
        stats = new Stats(10, 10, 10, 10, 10, 10);
        Item empty = new Item("empty");
        for (int i = 0; i < inventory.length; i++) {
            inventory[i] = empty;
        }
        gear = new Gear();
    }

    public Actor(String name, Point location, Scene scene, Stats stats) {
        super(name, location, scene);
        inventory = new Item[20];
        this.scene.addActor(this);
        isLootable = false; 
        this.stats = stats;
        for (int i = 0; i < inventory.length; i++) {
            inventory[i] = new Item("empty");
        }
        gear = new Gear();
    }
    
    public void fight(Actor actor){//we need to figure out how combat works; 
        if (this.location.equals(actor.location)) {
            if (actor.stats.health > 0) {
                combat.Combat.defaultAttack(this, actor, "AC");
                if (actor.stats.health <= 0){
                    actor.death.run();
                    int xp = 10;
                    //this.stats.xp += xp; why xp not a thing?
                    System.out.println("System: Fight won! Gained " + xp + "XP.");    
                }
            }
            else System.out.println("System: Your target is dead");   
            
        }
        else System.out.println("System: You can't attack that from here.");
    }

    public void eat(Food food) {
       
        if (food.heal >= 0 && this.stats.health != this.stats.maxHealth){
            System.out.println("System: You recovered "+food.heal+"HP.");
            if (this.stats.health != this.stats.maxHealth) {
                this.stats.health += food.heal;//need maximum
            }
        }
        if (food.heal < 0){
            System.out.println("System: You lost "+food.heal*-1+"HP.");
            this.stats.health += food.heal;
        }
    }
    public void equipNewArmor(Armor newArmor){
        if (newArmor.isArms) {
            if (!(gear.arms.isEmpty)) {
                this.invenAdd(gear.arms);
            }
            gear.arms = newArmor;
        }
        else if (newArmor.isBoots) {
            if (!(gear.boots.isEmpty)) {
                this.invenAdd(gear.boots);
            }
            gear.boots = newArmor;
        }
        else if (newArmor.isChest) {
            if (!(gear.chest.isEmpty)) {
                this.invenAdd(gear.chest);
            }
            gear.chest = newArmor;
        }
        else if (newArmor.isLegs) {
            if (!(gear.legs.isEmpty)) {
                this.invenAdd(gear.legs);
            }
            gear.legs = newArmor;
        }
        else if (newArmor.isHelm) {
            if (!(gear.helm.isEmpty)) {
                this.invenAdd(gear.helm);
            }
            gear.helm = newArmor;
        }
        else if (newArmor.isHands) {
            if (!(gear.hands.isEmpty)) {
                this.invenAdd(gear.hands);
            }
            gear.hands = newArmor;
        }
        else {
            System.out.println("what are you trying to wear?");
        }
        gear.updateEquipment();
    }
    public void equipNewWeapon(Weapon newWeapon){
        if (newWeapon.isTwoHand) {
            if (!(gear.mainHand.isEmpty)) {
                this.invenAdd(gear.mainHand);
            }
            if (!(gear.offHand.isEmpty)) {
                this.invenAdd(gear.offHand);
            }
            gear.mainHand = newWeapon;
            gear.offHand = gear.emptyWeapon;
            gear.mainHand.isTwoHand = true;
            gear.mainHand.isOffHand = false;
            gear.mainHand.isMainHand = false;
            
            gear.mainHand.isEmpty = false;
            gear.offHand.isEmpty = false;
        }
        else if (newWeapon.isMainHand) {
            if (!(gear.mainHand.isEmpty)) {
                this.invenAdd(gear.mainHand);
            }
            gear.mainHand = newWeapon;
            gear.mainHand.isTwoHand = false;
            gear.mainHand.isOffHand = false;
            gear.mainHand.isMainHand = true;
            
            gear.mainHand.isEmpty = false;
        }
        else if (newWeapon.isOffHand) {
            if (!(gear.offHand.isEmpty)) {
                this.invenAdd(gear.offHand);
            }
            gear.offHand = newWeapon;
            gear.mainHand.isTwoHand = false;
            gear.mainHand.isOffHand = true;
            gear.mainHand.isMainHand = false;
            
            gear.offHand.isEmpty = false;
        }
        gear.updateEquipment();
    }
    public void equipMagicItem(MiscGear newMiscGear, String leftOrRight){
        if (newMiscGear.isTrinket) {
            if (leftOrRight.equalsIgnoreCase("R")) {
                if (!(gear.trinketRight.isEmpty)) {
                    this.invenAdd(gear.trinketRight);
                }
                gear.ringRight = newMiscGear;
            }
            else if (leftOrRight.equalsIgnoreCase("L")) {
                if (!(gear.trinketLeft.isEmpty)) {
                    this.invenAdd(gear.trinketLeft);
                }
                gear.ringLeft =  newMiscGear;
            }
        }
        else if (newMiscGear.isRing) {
            if (leftOrRight.equalsIgnoreCase("R")) {
                if (!(gear.ringRight.isEmpty)) {
                    this.invenAdd(gear.ringRight);
                }
                gear.trinketRight = newMiscGear;
            }
            else if (leftOrRight.equalsIgnoreCase("L")) {
                if (!(gear.ringLeft.isEmpty)) {
                    this.invenAdd(gear.ringLeft);
                }
                gear.trinketLeft =  newMiscGear;
            }
        }
        else if (newMiscGear.isNeck) {
            if (!(gear.neck.isEmpty)) {
                this.invenAdd(gear.neck);
            }
            gear.neck = newMiscGear;
        }
        gear.updateEquipment();
    }
    public void unEquipEquipment(Equipment equipment) {
        
        invenAdd(equipment);
    }

    
}
