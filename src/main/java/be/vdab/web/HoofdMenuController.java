/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.web;
    
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
    public ModelAndView hoofdmenu(){
        ModelAndView mav = new ModelAndView("hoofdmenu");
        return mav;
    }
    
}
