/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.services;
    
import be.vdab.dao.GebruikerDAO;
import be.vdab.entities.Gebruiker;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tim Van den Langenbergh (tmtvl)
 * @version 1.0: 30-09-2013 (tmtvl): Initial version.
 */
@Service
public class GebruikerServiceImpl implements GebruikerService {
    private final GebruikerDAO gebruikerDAO;
    
    public GebruikerServiceImpl(GebruikerDAO gebruikerDAO){
        this.gebruikerDAO = gebruikerDAO;
    }
    
    @Override
    public void create(Gebruiker gebruiker){
        gebruikerDAO.create(gebruiker);
    }
    
    @Override
    public Gebruiker read(long id){
        return gebruikerDAO.read(id);
    }
    
    @Override
    public void update(Gebruiker gebruiker){
        gebruikerDAO.update(gebruiker);
    }
    
    @Override
    public void delete(long id){
        gebruikerDAO.delete(id);
    }
    
    @Override
    public Gebruiker findByEmail(String email){
        return gebruikerDAO.findByEmail(email);
    }
    
}
