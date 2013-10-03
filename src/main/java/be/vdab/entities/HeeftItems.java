/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.entities;
    
import java.util.Set;

/**
 *
 * @author Tim Van den Langenbergh (tmtvl)
 * @version 0.1: 01-10-2013 (tmtvl): Initial version.
 */
public interface HeeftItems {
    public long getId();
    public Set<Item> getItems();
    public void addItem(Item item);
    public void removeItem(Item item);
    public int getItemCount();
    public boolean hasItem(Item item);
}
