/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interactable;

import java.awt.Point;

/**
 * Project:
 * @author Davin
 * Date: 02/10/2015 
 * Teacher: Mr. Wachs 
 */
public class Item {
    public int weight;
    public String name;
    public String niceName;
    public Point location;
    public Runnable use = new Runnable() {

        @Override
        public void run() {
            System.out.println("System: You can't use that");
        }
    };
    
    public Item(String name) {
        this.niceName = name;
        this.name = name.toLowerCase();
    }
    public String getNiceName(){
        return this.niceName;
    }
    public String getNameLC(){
        return this.name;
    }
}
