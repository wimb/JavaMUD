/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.entities;
    
import be.vdab.interfaces.HeeftActie;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Tim Van den Langenbergh (tmtvl)
 * @version 0.1: 01-10-2013 (tmtvl): Initial version.
 */
public class Actie implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private long actieId;
    private HeeftActie actieObject;
    
    public Actie(){
        actieObject = null;
    }
    
    public Actie(HeeftActie actieObject){
        setActieObject(actieObject);
    }
    
    public Actie(HeeftActie actieObject, long actieId){
        this(actieObject);
        setId(actieId);
    }
    
    public void setId(long actieId){
        this.actieId = actieId;
    }
    
    public void setActieObject(HeeftActie actieObject){
        this.actieObject = actieObject;
    }
    
    public long getId(){
        return actieId;
    }
    
    public HeeftActie getActieObject(){
        return actieObject;
    }
    
    public void doe(){
        actieObject.doeActie();
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Actie){
            Actie actie = (Actie) o;
            if(this.actieId > 0){
                return this.actieId == actie.getId();
            }
            else {
                return this.actieObject.equals(actie.getActieObject());
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (int) (this.actieId ^ (this.actieId >>> 32));
        hash = 41 * hash + Objects.hashCode(this.actieObject);
        return hash;
    }
    
}
