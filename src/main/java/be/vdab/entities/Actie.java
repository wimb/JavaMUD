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
    private HeeftActie actieObject;
    private String classString;
    private ActieTypes actieType;
    
    public Actie(){
        actieObject = null;
        classString = "";
    }
    
    public Actie(HeeftActie actieObject, ActieTypes actieType){
        setActieObject(actieObject);
        setActieType(actieType);
    }
    
    public Actie(HeeftActie actieObject, ActieTypes actieType, long actieId, 
            String classString){
        this(actieObject, actieType);
        setId(actieId);
        setClassString(classString);
    }
    
    public void setId(long actieId){
        this.actieId = actieId;
    }
    
    public void setActieObject(HeeftActie actieObject){
        this.actieObject = actieObject;
        classString = actieObject.getClass().getSimpleName();
    }
    
    public void setActieType(ActieTypes actieType){
        this.actieType = actieType;
    }
    
    public void setClassString(String classString){
        this.classString = classString;
    }
    
    public long getId(){
        return actieId;
    }
    
    public HeeftActie getActieObject(){
        return actieObject;
    }
    
    public ActieTypes getActieType(){
        return actieType;
    }
    
    public String getClassString(){
        return classString;
    }
    
    public void doe(){
        actieObject.doeActie();
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
                    return this.actieObject.equals(actie.getActieObject());
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (int) (this.actieId ^ (this.actieId >>> 32));
        hash = 41 * hash + Objects.hashCode(this.actieObject);
        hash = 41 * hash + Objects.hashCode(actieType);
        return hash;
    }
    
}
