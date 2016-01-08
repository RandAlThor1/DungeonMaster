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
public class PersonalityType {
    boolean isExtroverted;
    boolean isIntuitive;
    boolean isThinking;
    boolean isJudging;
    boolean isAssertive;
    
    final int SQUARE = -1;
    final int ANALYST = 0;
    final int DIPLOMAT = 1;
    final int SENTINEL = 2;
    final int EXPLORER= 3;
    
    String type;
    

    public PersonalityType(int type) {
             if (type == ANALYST) {
            isExtroverted = false;
            isIntuitive = true;
            isThinking = true;
            isJudging = true;
            isAssertive = true;
            this.type = "ANALYST";
        }
        else if (type == DIPLOMAT) {
            isExtroverted = false;
            isIntuitive = true;
            isThinking = false;
            isJudging = false;
            isAssertive = false;
            this.type = "DIPLOMAT";
        }
        else if (type == SENTINEL) {
            isExtroverted = false;
            isIntuitive = true;
            isThinking = true;
            isJudging = true;
            isAssertive = true;
            this.type = "SETINEL";
        }
        else if (type == EXPLORER) {
            isExtroverted = false;
            isIntuitive = false;
            isThinking = false;
            isJudging = false;
            isAssertive = false;
            this.type = "EXPLORER";
        }
        else if (type == SQUARE) {
            this.type = "SQUARE";
        }
        else{
            System.out.println("you are a square");
        }
    }
    public PersonalityType newPersonType(int type){
            return new PersonalityType(type);
    }
    public PersonalityType newPersonType(String type){
        int Type = -1;
        if (type.equalsIgnoreCase("ANALYST")) {
            return new PersonalityType(ANALYST);
        }
        else if (type.equalsIgnoreCase("DIPLOMAT")) {
            return new PersonalityType(DIPLOMAT);
        }
        else if (type.equalsIgnoreCase("SETINEL")) {
            return new PersonalityType(SENTINEL);
        }
        else if (type.equalsIgnoreCase("EXPLORER")) {
            return new PersonalityType(EXPLORER);
        }
        return new PersonalityType(SQUARE);
    }
    
}
