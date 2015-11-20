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
    
    final int ANALYST = 1;
    final int DIPLOMAT = 2;
    final int SENTINEL = 3;
    final int EXPLORER= 4;
    
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
        else{
            System.out.println("you are a square");
        }
    }
    
}
