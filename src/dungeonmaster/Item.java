/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dungeonmaster;

/**
 * Project:
 * @author Davin
 * Date: 02/10/2015 
 * Teacher: Mr. Wachs 
 */
interface Item {

    @Override
    public boolean equals(Object obj);
    
    public void eat(Actor actor);
    public void equip(Actor actor);
    public void drop();
    public void take(Actor actor); 
}
