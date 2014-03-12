package nl.rickslot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Rick Slot
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(value = "")
    public ModelAndView home(RedirectAttributes attributes, ModelAndView view){
        view.setViewName("home");
        return view;
    }

    @RequestMapping(value = "signup")
    public String signup(RedirectAttributes attributes){
        return "signup";
    }

    @RequestMapping(value = "login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "logout")
    public String logout(){
        return "redirect:/j_spring_security_logout";
    }
}
