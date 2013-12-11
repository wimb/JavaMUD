/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.entities.items;

import be.vdab.entities.Item;
import be.vdab.entities.acties.RaapOp;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Chi.Ng
 */
@Entity
@Table(name = "boek")
public class Boek extends Item{
    
    public Boek(){
      new RaapOp(this);
    }
    
    @Override
    public String getOmschrijving() {
        return "een boek";
    }
    
}
