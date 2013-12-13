/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.web;

import be.vdab.entities.Item;
import be.vdab.entities.Karakter;
import be.vdab.entities.Lokatie;
import be.vdab.entities.items.*;
import be.vdab.services.ItemService;
import be.vdab.services.KarakterService;
import be.vdab.services.LokatieService;
import java.util.LinkedList;
import java.util.List;
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
    public AdminController(ItemService itemService, LokatieService lokatieService, KarakterService karakterService) {
        this.itemService = itemService;
        this.lokatieService = lokatieService;
        this.karakterService = karakterService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView adminpagina() {
        ModelAndView mav = new ModelAndView("adminpagina");
        List<Lokatie> lokaties = lokatieService.findAllLokaties();
        List<String> items = itemService.findAllDifferentItems();
        
        List<Karakter> karakters = karakterService.findAllKarakters();

        mav.addObject("karakters", karakters);
        mav.addObject("items", items);
        mav.addObject("lokaties", lokaties);
        return mav;
    }

    @RequestMapping(value="itemToevoegen", method = RequestMethod.POST)
    public String toevoegen(@RequestParam Long lokatiesCombo, @RequestParam String itemsCombo) {
        Item newItem = null;
        //Nog verzetten naar nieuwe Util
        switch (itemsCombo) {
            case "Boek":
                newItem = new Boek();
                break;
            case "Ladder":
                newItem = new Ladder();
                break;
            case "Knuppel":
                newItem = new Knuppel();
                break;
            default:
                System.out.println("Geen item gevonden");
        }

        newItem.addEigenaar(lokatieService.read(lokatiesCombo));
        itemService.create(newItem);
        return "redirect:/adminpagina";          
    }
    
    @RequestMapping(value="karakterVerplaatsen", method = RequestMethod.POST)
    public String verplaatsen(@RequestParam Long karLokCombo, @RequestParam Long karakterCombo){
        Karakter kar = karakterService.read(karakterCombo);
        Lokatie lok = lokatieService.read(karLokCombo);
        kar.setLokatie(lok);
        karakterService.update(kar);
        return "redirect:/adminpagina";        
    }
}

