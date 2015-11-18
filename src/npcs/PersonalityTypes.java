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
public class PersonalityTypes {
    boolean isExtroverted;
    boolean isIntuitive;
    boolean isThinking;
    boolean isJudging;
    boolean isAssertive;
    
    final int ANALYST = 1;
    final int DIPLOMAT = 2;
    final int SENTINEL = 3;
    final int EXPLORER= 4;
    

    public PersonalityTypes(int type) {
             if (type == ANALYST) {
            isExtroverted = false;
            isIntuitive = true;
            isThinking = true;
            isJudging = true;
            isAssertive = true;
        }
        else if (type == DIPLOMAT) {
            isExtroverted = false;
            isIntuitive = true;
            isThinking = false;
            isJudging = false;
            isAssertive = false;
        }
        else if (type == SENTINEL) {
            isExtroverted = false;
            isIntuitive = true;
            isThinking = true;
            isJudging = true;
            isAssertive = true;
        }
        else if (type == EXPLORER) {
            isExtroverted = false;
            isIntuitive = false;
            isThinking = false;
            isJudging = false;
            isAssertive = false;
        }
        else{
            System.out.println("you are a square");
        }
    }
    
}
