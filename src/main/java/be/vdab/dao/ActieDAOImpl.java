/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.dao;
    
import be.vdab.entities.Actie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tim Van den Langenbergh (tmtvl)
 * @version 0.1: 01-10-2013 (tmtvl): Initial version.
 */
@Repository
public class ActieDAOImpl implements ActieDAO {
    private EntityManager entityManager;
    
    public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    @Override
    public void create(Actie actie){
        try {
            entityManager.persist(actie);
        }
        catch(RuntimeException re){
            entityManager.clear();
            throw re;
        }
    }
    
    @Override
    public Actie read(long actieId){
        return entityManager.find(Actie.class, actieId);
    }
    
    @Override
    public void update(Actie actie){
        try {
            entityManager.merge(actie);
            entityManager.flush();
        }
        catch(RuntimeException re){
            entityManager.clear();
            throw re;
        }
    }
    
    @Override
    public void delete(long actieId){
        Actie actie = entityManager.find(Actie.class, actieId);
        if(actie != null){
            entityManager.remove(actie);
            entityManager.flush();
        }
    }
    
    @Override
    public List<Actie> findByClassString(String classString){
        TypedQuery<Actie> query = 
                entityManager.createNamedQuery("findActiesByClassString", Actie.class);
        query.setParameter("classString", classString);
        return query.getResultList();
    }
    
}
