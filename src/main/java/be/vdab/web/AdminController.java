/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.web;

import be.vdab.entities.Item;
import be.vdab.entities.Karakter;
import be.vdab.entities.Lokatie;
import be.vdab.entities.items.*;
import be.vdab.entities.Lokatie;
import be.vdab.services.ItemService;
import be.vdab.services.KarakterService;
import be.vdab.services.LokatieService;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jens.bouwen
 */
@Controller
@RequestMapping("/adminpagina")
public class AdminController {
    private final ItemService itemService;
    private final LokatieService lokatieService;
    private final KarakterService karakterService;
    
    @Autowired
    public AdminController(ItemService itemService, LokatieService lokatieService, KarakterService karakterService){
        this.itemService = itemService;
        this.lokatieService = lokatieService;        
        this.karakterService = karakterService;
    }
    
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView adminpagina(){
        ModelAndView mav = new ModelAndView("adminpagina");
        List<Lokatie> lokaties = lokatieService.findAllLokaties();
        List<Item> items = new LinkedList<>();
        for (Lokatie l: lokaties){
            List<Item> lokItems = itemService.findByEigenaar(l);
            for(Item i: lokItems){
                items.add(i);
            }
        }
        mav.addObject("items", items);
        mav.addObject("lokaties", lokaties);        
        return mav;        
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String toevoegen(){
        System.out.println("Check!!!");
        return "adminpagina";               
    }
    
    @RequestMapping(value = "/afmelden", method = RequestMethod.GET)
    public static String afmelden(HttpSession session){
        session.removeAttribute("gebruiker");
        return "redirect:/hoofdmenu";
        }
    
}
