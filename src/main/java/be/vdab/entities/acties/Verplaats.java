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
 * @author Chi.Ng
 */
public class Verplaats extends Actie{
   
    public Verplaats(HeeftActies parent){
        super(parent);
    }
    
    @Override
    public ActionResult doe() {
        //TODO Implements het effectief veranderen van locatie
        return new ActionResult("U heeft de ladder genomen");
    }

    @Override
    public String getOmschrijving() {
        return getParent().getOmschrijving() + " nemen";
    }
    
}
