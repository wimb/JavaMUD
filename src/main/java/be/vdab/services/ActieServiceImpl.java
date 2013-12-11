/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.services;
    
import be.vdab.dao.ItemDAO;
import be.vdab.entities.Actie;
import be.vdab.entities.HeeftActies;
import be.vdab.entities.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tim.vandenlangenberg
 * @version 0.1
 */
@Service
public class ActieServiceImpl implements ActieService {
    
    private final ItemDAO itemDAO;

	@Autowired
	public ActieServiceImpl(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}
   
    /*
    @Override
    public void create(Actie actie){
        long newId = 0;
        for(Long l : map.keySet()){
            newId = l > newId ? l : newId;
        }
        newId++;
        actie.setId(newId);
        map.put(newId, actie);
    }
    */
    
    @Override
    public Actie read(long parentId, String readableIdentifier) throws Exception{
        
        Item parent = itemDAO.read(parentId);
        
        return parent.getActieByName(readableIdentifier);
    }
    
    /*
    @Override
    public void update(Actie actie){
        map.put(actie.getId(), actie);
    }
    
    @Override
    public void delete(long id){
        map.remove(id);
    }
    
    @Override
    public List<Actie> getAll(){
        List<Actie> result = new ArrayList<>();
        result.addAll(map.values());
        return result;
    }
    */    
}
