package be.vdab.web;

import be.vdab.entities.Karakter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Lokatie;
import be.vdab.exceptions.KarakterNaamAlInGebruikException;
import be.vdab.services.KarakterService;
import be.vdab.services.LokatieService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/karakter")
public class KarakterController {
	private final KarakterService karakterService;
	private final LokatieService lokatieService;
	
        @Autowired
	public KarakterController(KarakterService karakterService, LokatieService lokatieService) {
		this.karakterService = karakterService;
		this.lokatieService = lokatieService;
	}
	
        @RequestMapping(method = RequestMethod.POST)
        public String create(@Valid Karakter karakter, BindingResult bindingResult){
            if(!bindingResult.hasErrors()){
                try {
                    karakterService.create(karakter);
                    return "redirect:/";
                }
                catch(KarakterNaamAlInGebruikException knaige){
                    bindingResult.rejectValue("naam", "{KarakterNaamBestaatAlException}");
                }
            }
            return "karakters/karaktergeneratie";
        }
        
        @RequestMapping(value = "nieuw", method = RequestMethod.GET)
        public ModelAndView createForm(){
            return new ModelAndView("karakters/karaktergeneratie.jsp", 
                    "karakter", new Karakter());
        }

	@RequestMapping(value="/karakters", method = RequestMethod.GET)
	public ModelAndView findAllKaraktersInLokatie(@RequestParam long lokatieId) {
		ModelAndView mav = new ModelAndView("karakters");
		Lokatie lokatie = lokatieService.read(lokatieId);
		mav.addObject("karakters/karaktersInLokatie", karakterService.findByLokatie(lokatie));
		return mav;
	}
	
	@RequestMapping(value="eigenschappen", method = RequestMethod.GET)
	public ModelAndView findKarakter(@RequestParam long karakterId) {
		ModelAndView mav = new ModelAndView("karakters");
		mav.addObject("karakter/eigenschappen", karakterService.read(karakterId));
		return mav;
	}
	
	
}
