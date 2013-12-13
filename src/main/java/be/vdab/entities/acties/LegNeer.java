/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.entities.acties;

import be.vdab.dao.ItemDAO;
import be.vdab.dao.ItemDAOImpl;
import be.vdab.entities.Actie;
import be.vdab.entities.ActionContext;
import be.vdab.entities.ActionResult;
import be.vdab.entities.HeeftActies;
import be.vdab.entities.HeeftItems;
import be.vdab.entities.Item;
import be.vdab.entities.Karakter;
import be.vdab.entities.Lokatie;
import be.vdab.entities.items.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author Kamil.Laga
 */
public class LegNeer extends Actie {

    public LegNeer(HeeftActies parent) {
        super(parent);

    }

    @Override
    public ActionResult doe(ActionContext ac) {
        Item item = (Item) getParent();
        Set<HeeftItems> eigenaar = new LinkedHashSet<>();
        eigenaar.add(ac.getHuidigeLokatie());
        item.setEigenaars(eigenaar);
        ac.getItemService().update(item);

        return new ActionResult(getParent().getOmschrijving() + " is neergelegd");
    }

    @Override
    public String getOmschrijving() {
        return getParent().getOmschrijving() + " neerleggen";
    }

    
    @Override
    public String toString(){
        return "Leg neer";
    }
}
