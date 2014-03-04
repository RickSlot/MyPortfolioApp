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
    public ModelAndView home(RedirectAttributes attributes){

        ModelAndView view = new ModelAndView();
        view.addObject("message", "Welcome back!");
        view.setViewName("home");
        return view;
    }
}
