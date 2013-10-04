/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.services;
    
import be.vdab.entities.Actie;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

/**
 *
 * @author tim.vandenlangenberg
 * @version 0.1
 */
@Service
public class ActieServiceImpl implements ActieService {
    private static final Map<Long, Actie> map = new ConcurrentHashMap<>();
    
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
    
    @Override
    public Actie read(long id){
        return map.get(id);
    }
    
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
    
}
