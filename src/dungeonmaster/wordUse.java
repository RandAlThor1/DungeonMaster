package dungeonmaster;

import javax.swing.JOptionPane;

/**
 * Project:
 * @author Davin
 * Date: 02/10/2015 
 * Teacher: Mr. Wachs 
 */
class wordUse {

    static void playerVerb(String[] command, int index) {
        if (compareWords(command[index], "go")&& compareWords(command[index+1], "to")) {
            Scene curScene = DungeonMaster.player.scene;
            int actorIndex = -1;
            String place = "";
            boolean found = false;
            for (int i = 1; i < 4 && i < command.length-index-1; i++) {
                place += command[index + 1 + i];
                actorIndex = curScene.findActor(place);
                if (actorIndex != -1) found = true;
                if (found) break;
                else place += " ";
            }
            if (found) {
                DungeonMaster.player.location = curScene.actors[actorIndex].location;
                JOptionPane.showMessageDialog(null, "You're new loctaion is: "+DungeonMaster.player.location.x+", "+DungeonMaster.player.location.y);     
            }
            else JOptionPane.showMessageDialog(null, "Location not found");
            DungeonMaster.inputCommand();  
        }
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * compareTo is a pain, so this makes it easier.
     * @param word1: first word
     * @param word2: second word
     * @return if the words are the same;
     */
    static boolean compareWords(String word1, String word2){
        return word1.compareTo(word2) == 0;
    }

}
