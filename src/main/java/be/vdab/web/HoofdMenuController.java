/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.web;
    
import be.vdab.entities.Gebruiker;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Tim Van den Langenbergh (tmtvl)
 * @version 0.1: 01-10-2013 (tmtvl): Initial version.
 */
@Controller
@RequestMapping("/hoofdmenu") // Dit wordt "/" wanneer alles klaar is
public class HoofdMenuController {
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView hoofdmenu(HttpSession session){
        ModelAndView mav = new ModelAndView("hoofdmenu");
        
        Gebruiker gebruiker = (Gebruiker) session.getAttribute("gebruiker");
        if(gebruiker != null){
            mav.addObject("gebruiker", gebruiker);
        }
        
        return mav;
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String doLogin(HttpSession session){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        
        // TODO: add user to session.
        
        return "redirect:/hoofdmenu";
    }
    
}
