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
public class Lokatie implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private long lokatieId;
    private String beschrijving;
    private List<Item> items;
    private List<Karakter> karakters;
    
    protected Lokatie(){
        beschrijving = "";
        items = new ArrayList<>();
        karakters = new ArrayList<>();
    }
    
    public Lokatie(String beschrijving){
        this();
        setBeschrijving(beschrijving);
    }
    
    public Lokatie(String beschrijving, List<Item> items, List<Karakter> karakters){
        this(beschrijving);
        setItems(items);
        setKarakters(karakters);
    }
    
    public Lokatie(long lokatieId, String beschrijving, List<Item> items, 
            List<Karakter> karakters){
        this(beschrijving, items, karakters);
        setId(lokatieId);
    }
    
    public void setId(long lokatieId){
        this.lokatieId = lokatieId;
    }
    
    public void setBeschrijving(String beschrijving){
        this.beschrijving = beschrijving;
    }
    
    public void setItems(List<Item> items){
        this.items = items;
    }
    
    public void setKarakters(List<Karakter> karakters){
        this.karakters = karakters;
    }
    
    public long getId(){
        return lokatieId;
    }
    
    public String getBeschrijving(){
        return beschrijving;
    }
    
    public List<Item> getItems(){
        return items;
    }
    
    public List<Karakter> getKarakters(){
        return karakters;
    }
    
    public void addItem(Item item){
        items.add(item);
    }
    
    public void removeItem(Item item){
        items.remove(item);
    }
    
    public boolean hasItem(Item item){
        return items.contains(item);
    }
    
    public int getItemCount(){
        return items.size();
    }
    
    public void addKarakter(Karakter karakter){
        karakters.add(karakter);
    }
    
    public void removeKarakter(Karakter karakter){
        karakters.remove(karakter);
    }
    
    public boolean hasKarakter(Karakter karakter){
        return karakters.contains(karakter);
    }
    
    public int getKarakterCount(){
        return karakters.size();
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Lokatie){
            Lokatie lok = (Lokatie) o;
            if(this.lokatieId > 0){
                return this.lokatieId == lok.getId();
            }
            else {
                return this.beschrijving.equals(lok.getBeschrijving()) && 
                        this.items.equals(lok.getItems()) && 
                        this.karakters.equals(lok.getKarakters());
            }
        }
        return false;
    }
    
    @Override
    public int hashCode(){
        if(lokatieId > 0){
            return (int) lokatieId;
        }
        else {
            String hashString = beschrijving + items.toString() + karakters.toString();
            return hashString.hashCode();
        }
    }
    
}
