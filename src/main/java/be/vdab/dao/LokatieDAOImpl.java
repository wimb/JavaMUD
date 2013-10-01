/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.dao;
    
import be.vdab.entities.Lokatie;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tim Van den Langenbergh (tmtvl)
 * @version 1.0: 30-09-2013 (tmtvl): Initial version.
 */
@Repository
public class LokatieDAOImpl implements LokatieDAO {
    private static final Map<Long, Lokatie> lokaties = new ConcurrentHashMap<>();
    private EntityManager entityManager;
    
    public LokatieDAOImpl(){
        Lokatie l = new Lokatie("De eerste lokatie");
        l.setId(1L);
        lokaties.put(1L, l);
    }
    
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    @Override
    public void create(Lokatie lokatie){
        try {
            entityManager.persist(lokatie);
        }
        catch(RuntimeException re){
            entityManager.clear();
            throw re;
        }
    }
    
    @Override
    public Lokatie read(long id){
        return entityManager.find(Lokatie.class, id);
    }
    
    @Override
    public void update(Lokatie lokatie){
        try {
            entityManager.merge(lokatie);
            entityManager.flush();
        }
        catch(RuntimeException re){
            entityManager.clear();
            throw re;
        }
    }
    
    @Override
    public void delete(long id){
        Lokatie lokatie = entityManager.find(Lokatie.class, id);
        if(lokatie != null){
            entityManager.remove(lokatie);
            entityManager.flush();
        }
    }
    
    @Override
    public List<Lokatie> findByBestemming(Lokatie bestemming){
        List<Lokatie> result = new ArrayList<>();
        for(Lokatie lokatie : lokaties.values()){
            if(lokatie.hasBestemming(bestemming)){
                result.add(lokatie);
            }
        }
        return result;
    }
    
}
