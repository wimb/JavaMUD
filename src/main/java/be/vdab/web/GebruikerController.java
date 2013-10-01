package be.vdab.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Gebruiker;
import be.vdab.exceptions.GebruikerNaamAlInGebruikException;
import be.vdab.services.GebruikerService;

@Controller
@RequestMapping("/gebruiker")
public class GebruikerController {

	private final GebruikerService gebruikerService;

	@Autowired
	public GebruikerController(GebruikerService gebruikerService) {
		this.gebruikerService = gebruikerService;
	}

	@RequestMapping(value = "toevoegen", method = RequestMethod.GET)
	public ModelAndView createForm() {
		return new ModelAndView("gebruikers/toevoegen", "gebruiker", new Gebruiker());
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid Gebruiker gebruiker, BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			try {
				gebruikerService.create(gebruiker);
				return "redirect:/gebruikers/toegevoegd";
			} catch (Exception e) {
				bindingResult.rejectValue("gebruikerNaam",
						"GebruikerNaamAlInGebruikException");
			}
		}
		return "gebruikers/toevoegen";
	}

}
