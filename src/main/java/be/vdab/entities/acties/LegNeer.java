/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.entities.acties;

import be.vdab.entities.Actie;
import be.vdab.entities.ActionResult;
import be.vdab.entities.HeeftActies;




/**
 *
 * @author Kamil.Laga
 */
public class LegNeer extends Actie {

     public LegNeer(HeeftActies parent){
        super(parent);
       
        
    }
    
    @Override
    public ActionResult doe() {
        //TODO Implements het effectief veranderen van eigenaar
        return new ActionResult(getParent().getOmschrijving() + " is neergelegd");
    }

    @Override
    public String getOmschrijving() {
        return "Het neerleggen van " + getParent().getOmschrijving();
    }
    
}
