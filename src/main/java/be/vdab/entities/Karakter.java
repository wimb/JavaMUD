/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.entities;
    
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tim Van den Langenbergh (tmtvl)
 * @version 0.1: 30-09-2013 (tmtvl): Initial version.
 */
public class Karakter implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private long karakterId;
    private Gebruiker gebruiker;
    private Lokatie lokatie;
    private List<Item> items;
    
    protected Karakter(){
        gebruiker = null;
        lokatie = null;
        items = new ArrayList<>();
    }
    
    public Karakter(Gebruiker gebruiker){
        this();
        setGebruiker(gebruiker);
    }
    
    public Karakter(long karakterId, Gebruiker gebruiker, Lokatie lokatie, 
            List<Item> items){
        this(gebruiker);
        setId(karakterId);
        setLokatie(lokatie);
        setItems(items);
    }
    
    public void setId(long karakterId){
        this.karakterId = karakterId;
    }
    
    public void setGebruiker(Gebruiker gebruiker){
        this.gebruiker = gebruiker;
    }
    
    public void setLokatie(Lokatie lokatie){
        if(this.lokatie != null && this.lokatie.hasKarakter(this)){
            this.lokatie.removeKarakter(this);
        }
        this.lokatie = lokatie;
        if(lokatie != null & !lokatie.hasKarakter(this)){
            lokatie.addKarakter(this);
        }
    }
    
    public void setItems(List<Item> items){
        this.items = items;
    }
    
    public long getId(){
        return karakterId;
    }
    
    public Gebruiker getGebruiker(){
        return gebruiker;
    }
    
    public Lokatie getLokatie(){
        return lokatie;
    }
    
    public List<Item> getItems(){
        return items;
    }
    
    public void addItem(Item item){
        items.add(item);
        if(item != null && !equals(item.getEigenaar())){
            item.setEigenaar(this);
        }
    }
    
    public void removeItem(Item item){
        items.remove(item);
        if(item != null && equals(item.getEigenaar())){
            item.setEigenaar(null);
        }
    }
    
    public boolean hasItem(Item item){
        return items.contains(item);
    }
    
    public int getItemCount(){
        return items.size();
    }
    
    public boolean equals(Object obj){
        if(obj instanceof Karakter){
            Karakter k = (Karakter) obj;
            if(this.karakterId != 0){
                return this.karakterId == k.getId();
            }
            else {
                if(this.lokatie == null){
                    return this.gebruiker.equals(k.getGebruiker()) &&
                            this.items.equals(k.getItems());
                }
                else {
                    return this.gebruiker.equals(k.getGebruiker()) &&
                            this.items.equals(k.getItems()) && 
                            this.lokatie.equals(k.getLokatie());
                }
            }
        }
        return false;
    }
    
}
