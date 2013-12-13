/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.entities;

import be.vdab.services.ItemService;

/**
 *
 * @author jens.bouwen
 */
public class ActionContext {
    private Karakter uitvoerder;
    private Lokatie huidigeLokatie;
    private ItemService itemService;

    public ItemService getItemService() {
        return itemService;
    }

    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    public ActionContext() {
        uitvoerder = null;
        huidigeLokatie = null;
    }

    public Lokatie getHuidigeLokatie() {
        return huidigeLokatie;
    }

    public void setHuidigeLokatie(Lokatie huidigeLokatie) {
        this.huidigeLokatie = huidigeLokatie;
    }

    public Karakter getUitvoerder() {
        return uitvoerder;
    }

    public void setUitvoerder(Karakter uitvoerder) {
        this.uitvoerder = uitvoerder;
    }
    
    
    
}
