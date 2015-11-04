/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interactable;

/**
 * Project:
 * @author Davin
 * Date: 02/10/2015 
 * Teacher: Mr. Wachs 
 */
public class Item {

    public String name;
    public Item(String name) {
        this.name = name;
    }
    
    public void eat(Actor actor){}
    public void equip(Actor actor){}
    public void drop(){}
    public void take(Actor actor){}
}
