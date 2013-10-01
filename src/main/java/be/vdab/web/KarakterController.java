package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Lokatie;
import be.vdab.services.KarakterService;
import be.vdab.services.LokatieService;

@Controller
<<<<<<< HEAD

@RequestMapping("/karakter")

=======
@RequestMapping("/karakter")
>>>>>>> 5ab71bfbf27459e0dbcfdb348ef42b192d08ecbf
public class KarakterController {
	private final KarakterService karakterService;
	private final LokatieService lokatieService;
	
	public KarakterController(KarakterService karakterService, LokatieService lokatieService) {
		this.karakterService = karakterService;
		this.lokatieService = lokatieService;
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
