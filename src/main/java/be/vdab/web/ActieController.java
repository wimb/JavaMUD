/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.web;
    
import be.vdab.entities.Actie;
import be.vdab.services.ActieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Tim Van den Langenbergh (tmtvl)
 * @version 0.1: 01-10-2013 (tmtvl): Initial version.
 */
@Controller
@RequestMapping("actie")
public class ActieController {
    private final ActieService actieService;
    
    @Autowired
    public ActieController(ActieService actieService){
        this.actieService = actieService;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String doeActie(@RequestParam long actieId){
        Actie actie = actieService.read(actieId);
        actie.doe();
        // TODO: Code voor de verschillende soorten acties
        return "redirect:/";
    }
    
}
