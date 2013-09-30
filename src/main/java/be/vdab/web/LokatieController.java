/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.web;
    
import be.vdab.services.LokatieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * LokatieController.java.
 * 
 * Spring controller voor navigatie van de lokaties.
 * 
 * @author Tim Van den Langenbergh (tmtvl)
 * @version 1.0: 30-09-2013 (tmtvl): initial version.
 */
@Controller
@RequestMapping("/lokatie")
public class LokatieController {
    private final LokatieService lokatieService;
    
    @Autowired
    public LokatieController(LokatieService lokatieService){
        this.lokatieService = lokatieService;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView findAll(@RequestParam long lokatieId){
        ModelAndView mav = new ModelAndView("lokatie");
        mav.addObject("lokatie", lokatieService.read(lokatieId));
        return mav;
    }
    
}
