/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.services;
    
import be.vdab.dao.ActieDAO;
import be.vdab.entities.Actie;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tim Van den Langenbergh (tmtvl)
 * @version 1.0: 01-10-2013 (tmtvl): Initial version.
 */
@Service
public class ActieServiceImpl implements ActieService {
    private final ActieDAO actieDAO;
    
    @Autowired
    public ActieServiceImpl(ActieDAO actieDAO){
        this.actieDAO = actieDAO;
    }
    
    @Override
    public void create(Actie actie){
        actieDAO.create(actie);
    }
    
    @Override
    public Actie read(long actieId){
        return actieDAO.read(actieId);
    }
    
    @Override
    public void update(Actie actie){
        actieDAO.update(actie);
    }
    
    @Override
    public void delete(long actieId){
        actieDAO.delete(actieId);
    }
    
    @Override
    public List<Actie> findByClassString(String classString){
        return actieDAO.findByClassString(classString);
    }
    
}
