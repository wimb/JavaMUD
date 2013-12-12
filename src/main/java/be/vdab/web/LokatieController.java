/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.web;
    
import be.vdab.entities.Actie;
import be.vdab.entities.ActionResult;
import be.vdab.entities.Item;
import be.vdab.entities.Karakter;
import be.vdab.entities.Lokatie;
import be.vdab.entities.acties.RaapOp;
import be.vdab.entities.items.Boek;
import be.vdab.entities.items.Knuppel;
import be.vdab.services.ActieService;
import be.vdab.services.ItemService;
import be.vdab.services.KarakterService;
import be.vdab.services.LokatieService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

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
@SessionAttributes("karakter")
public class LokatieController {
    private final ActieService actieService;
    private final ItemService itemService;
    private final LokatieService lokatieService;
    private final KarakterService karakterService;
    
    @Autowired
    public LokatieController(ActieService actieService, ItemService itemService, LokatieService lokatieService, 
            KarakterService karakterService){
        this.actieService = actieService;
        this.itemService = itemService;
        this.lokatieService = lokatieService;
        this.karakterService = karakterService;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView findKarakterLokatie(@RequestParam long karakterId){
        ModelAndView mav = new ModelAndView("lokatie");
        Karakter karakter = karakterService.read(karakterId);
        
        if(karakter != null){
            Lokatie lok = karakter.getLokatie();
            List<Item> items = itemService.findByEigenaar(lok);
                    
            
            mav.addObject("items", items);
            mav.addObject("lokatie", karakter.getLokatie());
            mav.addObject("karakter", karakter);
        }
        else {
            return new ModelAndView("redirect:/hoofdmenu");
        }
        
        return mav;
    }

    
    @RequestMapping(value = "/hoofdmenu", method = RequestMethod.GET)
    public String stopSpel(SessionStatus sessionStatus, 
            @ModelAttribute Karakter karakter){
        karakterService.update(karakter);
        lokatieService.update(karakter.getLokatie());
        sessionStatus.setComplete();
        return "redirect:/hoofdmenu";
    }
    
    @RequestMapping(value = "/afmelden", method = RequestMethod.POST)
    public String afmelden(SessionStatus sessionStatus, 
            @ModelAttribute Karakter karakter){
        karakterService.update(karakter);
        lokatieService.update(karakter.getLokatie());
        sessionStatus.setComplete();
        return "redirect:/j_spring_security_logout";
    }
    
    @RequestMapping(value = "/actie", method = RequestMethod.POST)
    public ModelAndView actie(@RequestParam long karakterid,long itemId, String actie) throws Exception{
         //op welke item (itemid) wordt welke actie (actie) gedaan
        //Zoek de juiste actie en voer ze uit:
        Actie deActie = actieService.read(itemId,actie);
        ActionResult actieomschrijving = deActie.doe();
        
        //laad vernieuwde mav met meegegeven karakterid
        ModelAndView mav = findKarakterLokatie(karakterid); 
        
        //toon de boodschap van de actie:
        mav.addObject("message", actieomschrijving.toString());
        
        return mav;
    }
    
}
