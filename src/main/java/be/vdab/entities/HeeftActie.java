/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.entities;
    
import java.io.Serializable;

/**
 *
 * @author Tim Van den Langenbergh (tmtvl)
 * @version 1.0: 01-10-2013 (tmtvl): Initial version.
 */
public abstract class HeeftActie implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private long id;
    
    protected HeeftActie(long id){
        setId(id);
    }
    
    public void setId(long id){
        this.id = id;
    }
    
    public long getId(){
        return id;
    }
    
    public abstract void doeActie();
}
