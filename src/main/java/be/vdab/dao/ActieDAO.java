/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.dao;
    
import be.vdab.entities.Actie;
import java.util.List;

/**
 *
 * @author Tim Van den Langenbergh (tmtvl)
 * @version 0.1: 01-10-2013 (tmtvl): Initial version.
 */
public interface ActieDAO {
    void create(Actie actie);
    Actie read(long actieId);
    void update(Actie actie);
    void delete(long actieId);
    List<Actie> findByClassString(String classString);
}
