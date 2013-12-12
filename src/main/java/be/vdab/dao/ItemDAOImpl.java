/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.dao;

import be.vdab.entities.HeeftItems;
import be.vdab.entities.Item;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tim Van den Langenbergh (tmtvl)
 * @version 1.0: 01-10-2013 (tmtvl): Initial version.
 */
@Repository
public class ItemDAOImpl implements ItemDAO {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(Item item) {
        try {
            entityManager.persist(item);
        } catch (RuntimeException re) {
            entityManager.clear();
            throw re;
        }
    }

    @Override
    public Item read(long id) {
        return entityManager.find(Item.class, id);
    }

    @Override
    public void update(Item item) {
        try {
            entityManager.merge(item);
            entityManager.flush();
        } catch (RuntimeException re) {
            entityManager.clear();
            throw re;
        }
    }

    @Override
    public void delete(long id) {
        Item item = entityManager.find(Item.class, id);
        if (item != null) {
            entityManager.remove(item);
            entityManager.flush();
        }
    }

    @Override
    public List<Item> findByEigenaar(HeeftItems eigenaar) {
        TypedQuery<Item> query = entityManager.createNamedQuery("findItemsByEigenaar", Item.class);
        query.setParameter("eigenaar", eigenaar);
        return query.getResultList();
    }

    @Override
    public List<String> findAllDifferentItems() {
        TypedQuery<String> query = entityManager.createNamedQuery("findAllDifferentItems", String.class);
        return query.getResultList();
    }
}
