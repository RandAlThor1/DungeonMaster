/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visuals;

/**
 *
 * @author b.allen
 */
public class DisplayHandleing {
    Display display;

    static void leftPressed() {
        if (rightOff != 0){
            rightOff--;
                }
    }

    static void rightPressed() {
    }

    static void downPressed() {
    }

    static void upPressed() {
    }

    static void escapePressed() {
    }
    public void createMainDisplay(){
        display = new Display();
    }
    
}
