/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.services;
    
import be.vdab.dao.ItemDAO;
import be.vdab.entities.HeeftItems;
import be.vdab.entities.Item;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Tim Van den Langenbergh (tmtvl)
 * @version 1.0: 01-10-2013 (tmtvl): initial version.
 */
@Service
public class ItemServiceImpl implements ItemService {
    private final ItemDAO itemDAO;
    
    @Autowired
    public ItemServiceImpl(ItemDAO itemDAO){
        this.itemDAO = itemDAO;
    }
    
    @Override
    @Transactional(readOnly = false)
    public void create(Item item){
        itemDAO.create(item);
    }
    
    @Override
    public Item read(long id){
        return itemDAO.read(id);
    }
    
    @Override
    @Transactional(readOnly = false)
    public void update(Item item){
        itemDAO.update(item);
    }
    
    @Override
    @Transactional(readOnly = false)
    public void delete(long id){
        itemDAO.delete(id);
    }
    
    @Override
    public List<Item> findByEigenaar(HeeftItems eigenaar){
        return itemDAO.findByEigenaar(eigenaar);
    }     

    @Override
    public List<String> findAllDifferentItems() {
        return itemDAO.findAllDifferentItems();
    }

}
