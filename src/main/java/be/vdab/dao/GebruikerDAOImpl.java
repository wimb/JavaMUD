/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import be.vdab.entities.Gebruiker;
import be.vdab.valueobjects.EmailAdres;

/**
 * 
 * @author Tim Van den Langenbergh (tmtvl)
 * @version 1.0: 30-09-2013(tmtvl): Initial version.
 */
@Repository
public class GebruikerDAOImpl implements GebruikerDAO {
<<<<<<< HEAD
    public static List<Gebruiker> gebruikers = new ArrayList<>();
    
<<<<<<< HEAD

    public GebruikerDAOImpl(){
        // TODO: Add gebruikers

=======
>>>>>>> remotes/TimMUD/master
    //EntityManager maken door Xiang
    private EntityManager entityManager;
=======

	private EntityManager entityManager;
>>>>>>> ed7f27fae7e51427dfab34240e6d78123893a378

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
<<<<<<< HEAD
    
    {
        // TODO: add gebruikers.
<<<<<<< HEAD

=======
>>>>>>> remotes/TimMUD/master
    }
    
    @Override
    public void create(Gebruiker gebruiker){
        gebruikers.add(gebruiker);
        //create(gebruiker) gebruikt EntityManager door Xiang
        try {
=======

	@Override
	public void create(Gebruiker gebruiker) {
		try {
>>>>>>> ed7f27fae7e51427dfab34240e6d78123893a378
			entityManager.persist(gebruiker);
		} catch (RuntimeException e) {
			entityManager.clear();
			throw e;
		}
<<<<<<< HEAD
    }
    
    @Override
    public Gebruiker read(long id){
        return null;
    }
    
    @Override
    public void update(Gebruiker gebruiker){
        
    }
    
    @Override
    public void delete(long id){
        
    }
    
    @Override
    public Gebruiker findByEmail(String email){
        return null;
    }
    
    @Override
	public Gebruiker inloggen(long gebruikerId) {
		// TODO Auto-generated method stub
		return null;
	}
=======
	}

	@Override
	public Gebruiker read(long id) {
		TypedQuery<Gebruiker> query = entityManager.createNamedQuery(
				"findGebruikerById", Gebruiker.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public void update(Gebruiker gebruiker) {
		try {
			entityManager.merge(gebruiker);
			entityManager.flush();
		} catch (RuntimeException e) {
			entityManager.clear();
			throw e;
		}
	}

	@Override
	public void delete(long id) {
		Gebruiker gebruiker = entityManager.find(Gebruiker.class, id);
		if (gebruiker != null) {
			entityManager.remove(gebruiker);
			entityManager.flush();
		}
	}

	@Override
	public Gebruiker findByEmail(EmailAdres emailAdres) {
		TypedQuery<Gebruiker> query = entityManager.createNamedQuery(
				"findGebruikerByEmailAdres", Gebruiker.class);
		query.setParameter("emailAdres", emailAdres);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

>>>>>>> ed7f27fae7e51427dfab34240e6d78123893a378
}
