/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.entities;
    
import java.util.Objects;

/**
 *
 * @author tim.vandenlangenberg
 * @version 0.1
 */
public abstract class Actie {
    private long id;
    private HeeftActies parent;
    
    protected Actie(){
        
    }
    
    public Actie(HeeftActies parent){
        setParent(parent);
    }
    
    public Actie(long id, HeeftActies parent){
        this(parent);
        setId(id);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public void setParent(HeeftActies parent){
        if(this.parent != null && this.parent.hasActie(this)){
            this.parent.removeActie(this);
        }
        this.parent = parent;
        if(parent != null && !parent.hasActie(this)){
            parent.addActie(this);
        }
    }
    
    public HeeftActies getParent(){
        return parent;
    }
    
    abstract public ActionResult doe();
    abstract public String getOmschrijving();
    
   
}
