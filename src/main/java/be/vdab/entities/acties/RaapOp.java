/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.entities.acties;
    
import be.vdab.entities.Actie;
import be.vdab.entities.ActionResult;
import be.vdab.entities.HeeftActies;

/**
 *
 * @author tim.vandenlangenberg
 * @version 
 */
public class RaapOp extends Actie {
    
    public RaapOp(HeeftActies parent){
        super(parent);       
    }
    
    @Override
    public ActionResult doe() {
        //TODO Implements het effectief veranderen van eigenaar
        return new ActionResult(getParent().getOmschrijving() + " is opgeraapt");
    }

    @Override
    public String getOmschrijving() {
        return "Het oprapen van " + getParent().getOmschrijving();
    }
    
    
    
}
