/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.web;
    
import be.vdab.entities.Gebruiker;
import be.vdab.services.GebruikerService;
import be.vdab.valueobjects.EmailAdres;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
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
    private final GebruikerService gebruikerService;
    
    @Autowired
    public HoofdMenuController(GebruikerService gebruikerService){
        this.gebruikerService = gebruikerService;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView hoofdmenu(HttpSession session){
        ModelAndView mav = new ModelAndView("hoofdmenu");
        
        Gebruiker gebruiker = (Gebruiker) session.getAttribute("gebruiker");
        if(gebruiker != null){
            mav.addObject("gebruiker", gebruiker);
        }
        else {
            String email = getAuthenticationName();
            if(email != null && !email.isEmpty()){
                EmailAdres emailAdres = new EmailAdres(email);
                Gebruiker g = gebruikerService.findByEmail(emailAdres);
                if(g != null){
                    session.setAttribute("gebruiker", g);
                    mav.addObject("gebruiker", g);
                }
            }
        }
        
        return mav;
    }
    
    public static String getAuthenticationName(){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication auth = securityContext.getAuthentication();
        
        if(auth != null && auth.isAuthenticated()){
            return auth.getName();
        }
        
        return null;
    }
    
}
