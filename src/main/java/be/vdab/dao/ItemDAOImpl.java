/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.dao;
    
import be.vdab.entities.Item;
import be.vdab.entities.Karakter;
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
 * @version 1.0: 01-10-2013 (tmtvl): Initial version.
 */
@Repository
public class ItemDAOImpl implements ItemDAO {
    private static final Map<Long, Item> items = new ConcurrentHashMap<>();
    private EntityManager entityManager;
    
    public ItemDAOImpl(){
        // TODO: Add items.
    }
    
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    @Override
    public void create(Item item){
        try {
            entityManager.persist(item);
        }
        catch(RuntimeException re){
            entityManager.clear();
            throw re;
        }
    }
    
    @Override
    public Item read(long id){
        return entityManager.find(Item.class, id);
    }
    
    @Override
    public void update(Item item){
        try {
            entityManager.merge(item);
            entityManager.flush();
        }
        catch(RuntimeException re){
            entityManager.clear();
            throw re;
        }
    }
    
    @Override
    public void delete(long id){
        Item item = entityManager.find(Item.class, id);
        if(item != null){
            entityManager.remove(item);
            entityManager.flush();
        }
    }
    
    @Override
    public List<Item> findByKarakter(Karakter karakter){
        List<Item> result = new ArrayList<>();
        
        for(Item item : items.values()){
            if(karakter.equals(item.getEigenaar())){
                result.add(item);
            }
        }
        
        return result;
    }
    
    @Override
    public List<Item> findByLokatie(Lokatie lokatie){
        List<Item> result = new ArrayList<>();
        
        for(Item item : items.values()){
            if(lokatie.equals(item.getPositie())){
                result.add(item);
            }
        }
        
        return result;
    }
    
}
