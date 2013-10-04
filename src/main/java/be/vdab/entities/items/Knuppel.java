/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.entities.items;
    
import be.vdab.entities.Item;
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
    
    @Override
    public String getOmschrijving() {
        return "een knuppel";
    }
    
}
