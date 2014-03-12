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

    @RequestMapping(value = {"", "home"})
    public String home(Principal principal){
        if(principal != null){
            return "redirect:/account";
        }
        return "home";
    }

    @RequestMapping(value = "signup")
    public String signup(RedirectAttributes attributes){
        return "signup";
    }

    @RequestMapping(value = "login")
    public String login(Principal principal){
        if(principal == null){
            return "login";
        }
        return "redirect:/account";

    }

    @RequestMapping(value = "logout")
    public String logout(){
        return "redirect:/j_spring_security_logout";
    }
}
