/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.entities;
    
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Transient;

/**
 *
 * @author tim.vandenlangenberg
 * @version 0.1
 */
public abstract class HeeftActies implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Transient
    private List<Actie> acties;
    
    protected HeeftActies(){
        acties = new ArrayList<>();
    }
    
    public List<Actie> getActies(){
        return acties;
    }
    
    public void addActie(Actie actie){
        acties.add(actie);
        if(!this.equals(actie.getParent())){
            actie.setParent(this);
        }
    }
    
    protected void removeActie(Actie actie){
        acties.remove(actie);
        if(this.equals(actie.getParent())){
            actie.setParent(null);
        }
    }
    
    public boolean hasActie(Actie actie){
        return acties.contains(actie);
    }
    
    public int getActieCount(){
        return acties.size();
    }
    
    @Transient
    public abstract String getOmschrijving();
    
     public Actie getActieByName(String readableIdentifier) throws Exception {
         for(Actie a : acties){
             if((a.getReadableIdentifier().equals(readableIdentifier))){
                 return a;
             }
         }        
         throw new Exception("Action not found.");
     }
}
