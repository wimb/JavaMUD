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
 * @author tim.vandenlangenberg (tmtvl) 
 * @author stijnva
 * @version 
 */
@Entity
@Table(name = "knuppel")
public class Knuppel extends Item {
    
    public Knuppel(){
       //When creating an action, the parrent will be bound to the action. 
       new RaapOp(this);
       new LegNeer(this);
       super.setOmschrijving("Knuppel");
    }
    
    @Override
    public String getOmschrijving() {
        return "knuppel";
    }

}
