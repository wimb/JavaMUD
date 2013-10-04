/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.entities.items;
    
import be.vdab.entities.Item;
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
        this.addActie(new RaapOp(this));
    }
    
    @Override
    public String getOmschrijving() {
        return "een knuppel";
    }
    
}
