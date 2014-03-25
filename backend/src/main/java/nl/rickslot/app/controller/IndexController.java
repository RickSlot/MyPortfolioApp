package nl.rickslot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

/**
 * @author Rick Slot
 */
@Controller
@RequestMapping("/")
public class IndexController {

    /**
     * Returns the homepage, checks if user is logged in or not
     * @param principal the logged in user, is null when not logged in
     * @return the desired homepage
     */
    @RequestMapping(value = {"", "home"})
    public String home(Principal principal){
        if(principal != null){
            return "redirect:/account";
        }
        return "home";
    }

    /**
     * Shows the signup page
     * @return the signup page
     */
    @RequestMapping(value = "signup")
    public String signup(){
        return "signup";
    }

    /**
     * returns the login page if not logged in, else redirect to homepage
     * @param principal the logged in user, is null when not logged in
     * @return the desired page
     */
    @RequestMapping(value = "login")
    public String login(Principal principal){
        if(principal == null){
            return "login";
        }
        return "redirect:/account";

    }

    /**
     * function used to logout
     * @return a redirect to the standard spring logout page.
     */
    @RequestMapping(value = "logout")
    public String logout(){
        return "redirect:/j_spring_security_logout";
    }
}
