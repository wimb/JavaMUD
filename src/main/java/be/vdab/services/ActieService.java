/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.services;
    
import be.vdab.entities.Actie;
import java.util.List;

/**
 *
 * @author Tim Van den Langenbergh (tmtvl)
 * @version 1.0: 01-10-2013 (tmtvl): Initial version.
 */
public interface ActieService {
    void create(Actie actie);
    Actie read(long actieId);
    void update(Actie actie);
    void delete(long actieId);
    List<Actie> findByClassString(String classString);
}
