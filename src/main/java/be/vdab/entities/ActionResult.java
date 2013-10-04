/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.entities;
    
/**
 *
 * @author tim.vandenlangenberg
 * @version 
 */
public class ActionResult {
    
    private String omschrijving;
    
    public ActionResult(String omschrijving){
        this.omschrijving = omschrijving;    
    }
    
    @Override
    public String toString(){
        return omschrijving;
    }
    
}
