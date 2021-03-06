/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dungeonmaster;
import Interactable.*;
import Visuals.Map;
import combat.*;
import dungeonmaster.*;
import java.awt.Point;
import npcs.*;
/**
 * Project:
 * @author Davin
 * Date: 02/10/2015 
 * Teacher: Mr. Wachs 
 */
public class Story {

    public Story() {
        Scene throneRoom = new Scene("Throne Room");
        String throneMap = new String("src\\Maps\\ThroneRoom.txt");
        Map map = new Map(throneMap);
        
        DungeonMaster.player.equipNewWeapon(new Weapon("Dagger", -1, "AC", "MH", 100, 100, 1));
        
        Objects throne = new Objects("Throne", new Point(5, 10), throneRoom);
        
        NPC king = new NPC(new PersonalityType(1), "King Bob", new Point(5, 10), throneRoom, new Stats(10, 10, 11, 14, 12, 17));
        NPC messenger = new NPC (new PersonalityType(2), "Messenger", new Point(4, 7), throneRoom, new Stats(8, 10, 12, 10, 10, 13));
        NPC guard1 = new NPC (new PersonalityType(2), "Guard", new Point(6, 7), throneRoom, new Stats(17, 17, 14, 7, 10, 6));
        NPC guard2 = new NPC (new PersonalityType(2), "Guard", new Point(6, 9), throneRoom, new Stats(17, 17, 14, 7, 10, 6));
        NPC guard3 = new NPC (new PersonalityType(2), "Guard", new Point(4, 9), throneRoom, new Stats(17, 17, 14, 7, 10, 6));
        Armor crown = new Armor("Crown", 5, -1, "Helm", 1);
        king.invenAdd(crown);
        
        DungeonMaster.player.scene = throneRoom;
    }

}
