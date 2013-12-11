/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.entities.items;

import be.vdab.entities.Item;
import be.vdab.entities.acties.LegNeer;
import be.vdab.entities.acties.RaapOp;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author jens.bouwen
 */
@Entity
@Table(name = "boek")
public class Boek extends Item {
    
    public Boek(){
       //When creating an action, the parrent will be bound to the action. 
       new RaapOp(this);
       new LegNeer(this);
    }
    
    @Override
    public String getOmschrijving() {
        return "een boek";
    }
    
}
