/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.services;
    
import be.vdab.dao.GebruikerDAO;
import be.vdab.entities.Gebruiker;
import be.vdab.valueobjects.EmailAdres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Tim Van den Langenbergh (tmtvl)
 * @version 1.0: 30-09-2013 (tmtvl): Initial version.
 */

@Service
@Transactional(readOnly = true)
public class GebruikerServiceImpl implements GebruikerService {
    private final GebruikerDAO gebruikerDAO;
    
    @Autowired
    public GebruikerServiceImpl(GebruikerDAO gebruikerDAO){
        this.gebruikerDAO = gebruikerDAO;
    }
    
    @Override
    @Transactional(readOnly = false)
    public void create(Gebruiker gebruiker){
        gebruikerDAO.create(gebruiker);
    }
    
    @Override
    public Gebruiker read(long id){
        return gebruikerDAO.read(id);
    }
    
    @Override
    @Transactional(readOnly = false)
    public void update(Gebruiker gebruiker){
        gebruikerDAO.update(gebruiker);
    }
    
    @Override
    @Transactional(readOnly = false)
    public void delete(long id){
        gebruikerDAO.delete(id);
    }
    
    @Override
    public Gebruiker findByEmail(EmailAdres email){
        return gebruikerDAO.findByEmail(email);
    }
    
    @Override
	public Gebruiker inloggen(long gebruikerId) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
