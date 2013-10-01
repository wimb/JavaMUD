/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.entities;
    
import be.vdab.enums.ActieTypes;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Tim Van den Langenbergh (tmtvl)
 * @version 1.0: 01-10-2013 (tmtvl): Initial version.
 */
public class Actie implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private long actieId;
    private long actieObjectId;
    private ActieTypes actieType;
    
    public Actie(){
        actieType = ActieTypes.NULL_TYPE;
    }
    
    public Actie(long actieObjectId, ActieTypes actieType){
        setActieObject(actieObjectId);
        setActieType(actieType);
    }
    
    public Actie(long actieObjectId, ActieTypes actieType, long actieId){
        this(actieObjectId, actieType);
        setId(actieId);
    }
    
    public void setId(long actieId){
        this.actieId = actieId;
    }
    
    public void setActieObject(long actieObjectId){
        this.actieObjectId = actieObjectId;
    }
    
    public void setActieType(ActieTypes actieType){
        this.actieType = actieType;
    }
    
    public long getId(){
        return actieId;
    }
    
    public long getActieObjectId(){
        return actieObjectId;
    }
    
    public ActieTypes getActieType(){
        return actieType;
    }
    
    public void doe(){
        
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Actie){
            Actie actie = (Actie) o;
            if(this.actieType == actie.actieType){
                if(this.actieId > 0){
                    return this.actieId == actie.getId();
                }
                else {
                    return this.actieObjectId == actie.getActieObjectId();
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (int)(this.actieId ^ (this.actieId >>> 32));
        hash = 41 * hash + (int)this.actieObjectId;
        return hash;
    }
    
}
