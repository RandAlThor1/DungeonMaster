/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npcs;

/**
 *
 * @author b.allen
 */
public class Stats {
    public int level;
    
    public int Strength;
    public int Constitution;
    public int Dexterity;
    public int Intelligence;
    public int Wisdom;
    public int Charisma;
    
    public int StrengthMod;
    public int ConstitutionMod;
    public int DexterityMod;
    public int IntelligenceMod;
    public int WisdomMod;
    public int CharismaMod;
    
    public int health;
    public int maxHealth;
    public int speed;
    public int dodgeChance;
    public int armorClass;
    
    Runnable levelUp;

    public Stats(int Strength, int Constitution, int Dexterity, int Intelligence, int Wisdom, int Charisma) {
        this.Strength = Strength;
        this.Constitution = Constitution;
        this.Strength = Strength;
        this.Dexterity = Dexterity;
        this.Intelligence = Intelligence;
        this.Wisdom = Wisdom;
        
        this.StrengthMod =      (int) ((Strength - 10) / 2);
        this.ConstitutionMod =  (int) ((Constitution - 10) / 2);
        this.DexterityMod =     (int) ((Dexterity - 10) / 2);
        this.IntelligenceMod =  (int) ((Intelligence - 10) / 2);
        this.WisdomMod =        (int) ((Wisdom - 10) / 2);
        this.CharismaMod =      (int) ((Charisma - 10) / 2);
        
        this.health = (int) 200 + ((Constitution - 10) / 2) * 50;
        this.maxHealth = health;
        this.speed = (int) 100 + ((Dexterity - 10) / 2) * 25;
        this.dodgeChance = (int) 10 + ((Dexterity - 10) / 2) * 5;
        this.levelUp = new Runnable() {
            
            @Override
            public void run() {
                level++;
            }
        };
    }
    public static void updateStats(){
        this.
    }
}
