/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.entities;
    
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Tim Van den Langenbergh (tmtvl)
 * @version 1.0: 01-10-2013 (tmtvl): Complete version.
 *          0.1: 30-09-2013 (tmtvl): Initial version.
 */
@Entity
@Table(name = "item")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Item extends HeeftActies implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private long id;
    
    @ManyToMany
    @JoinTable(name = "iseigenaarvan", 
            joinColumns = @JoinColumn(name = "itemID"), 
            inverseJoinColumns = @JoinColumn(name = "eigenaarID"))
    public Set<HeeftItems> eigenaars;
    
    private String omschrijving;
    
    public Item(){
        eigenaars = new LinkedHashSet<>();     
    }
    
    public Item(long id, Set<HeeftItems> eigenaars){
        setId(id);
        setEigenaars(eigenaars);
    }
    
    
    public void setId(long id){
        this.id = id;
    }
    
    public void setEigenaars(Set<HeeftItems> eigenaars){
        this.eigenaars = eigenaars;
    }
    
    public long getId(){
        return id;
    }
    
    public Set<HeeftItems> getEigenaars(){
        return eigenaars;
    }

    @Override
    public String getOmschrijving() {
        return omschrijving;
    }   
    

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }
    
    public void addEigenaar(HeeftItems eigenaar){
        eigenaars.add(eigenaar);
        if(!eigenaar.hasItem(this)){
            eigenaar.addItem(this);
        }
    }
    
    public void removeEigenaar(HeeftItems eigenaar){
        eigenaars.remove(eigenaar);
        if(eigenaar.hasItem(this)){
            eigenaar.removeItem(this);
        }
    }
    
    public int getEigenaarCount(){
        return eigenaars.size();
    }
    
    public boolean hasEigenaar(HeeftItems eigenaar){
        return eigenaars.contains(eigenaar);
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Item){
            Item item = (Item) obj;
            if(this.id != 0){
                return item.getId() == this.id;
            }
            else {
                if(this.eigenaars == null){
                    return item.getEigenaars() == null;
                }
                else {
                    return this.eigenaars.equals(item.getEigenaars());
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 83 * hash + Objects.hashCode(this.eigenaars);
        return hash;
    }

    
}
