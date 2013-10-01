/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.enums;
    
import be.vdab.entities.Lokatie;

/**
 *
 * @author Tim Van den Langenbergh (tmtvl)
 * @version 0.1: 01-10-2013 (tmtvl): Initial version.
 */
public enum ActieTypes {
    
    MOVE(Lokatie.class.getSimpleName());
    
    private String classString;
    
    private ActieTypes(String classString){
        setClassString(classString);
    }
    
    public void setClassString(String classString){
        this.classString = classString;
    }
    
    public String getClassString(){
        return classString;
    }
    
}
