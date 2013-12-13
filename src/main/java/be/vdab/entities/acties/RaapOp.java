/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.entities.acties;

import be.vdab.dao.ItemDAOImpl;
import be.vdab.entities.Actie;
import be.vdab.entities.ActionContext;
import be.vdab.entities.ActionResult;
import be.vdab.entities.HeeftActies;
import be.vdab.entities.HeeftItems;
import be.vdab.entities.Item;
import be.vdab.entities.Karakter;
import be.vdab.entities.Lokatie;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author tim.vandenlangenberg
 * @version
 */
public class RaapOp extends Actie {

    public RaapOp(HeeftActies parent) {
        super(parent);
    }

    @Override
    public ActionResult doe(ActionContext ac) {
        Item item = (Item)getParent();
        Karakter uitvoerder = ac.getUitvoerder();
        Set<HeeftItems> eigenaar = new LinkedHashSet<>();
        eigenaar.add(uitvoerder);
        item.setEigenaars(eigenaar);
        ac.getItemService().update(item);

        return new ActionResult(getParent().getOmschrijving() + " is opgeraapt");
    }

    @Override
    public String getOmschrijving() {
        return getParent().getOmschrijving() + " oprapen";
    }
    
    @Override
    public String toString(){
        return "Leg neer";
    }
}
