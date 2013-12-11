/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.services;

import be.vdab.entities.Actie;
import java.util.List;

/**
 *
 * @author tim.vandenlangenberg
 * @version 0.1
 */
public interface ActieService {
    //void create(Actie actie);
    Actie read(long id, String s) throws Exception;
    //void update(Actie actie);
    //void delete(long id);
    //List<Actie> getAll();
}
