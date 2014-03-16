package nl.rickslot.app.controller;

import nl.rickslot.app.model.Account;
import nl.rickslot.app.model.Biography;
import nl.rickslot.app.service.AccountService;
import nl.rickslot.app.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

/**
 * @author Rick Slot
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView showAccountPage(Principal principal) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(principal != null){
            return accountService.createViewForAccount(auth.getName());
        }
        ModelAndView view = new ModelAndView();
        view.setViewName("redirect:/");
        return view;
    }

    @RequestMapping(value = "/{username:.+}", method = RequestMethod.GET)
    public ModelAndView schowPageForUsername(@PathVariable("username") String username) {
        Account account = accountService.findByUsername(username);
        if(account != null){
            return accountService.createViewForAccount(username) ;
        }
        ModelAndView view = new ModelAndView();
        view.setViewName("/pageNotFound");
        return view;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView createAccount(Account account, RedirectAttributes redirectAttributes) {
        ModelAndView view = new ModelAndView();

        if(accountService.save(account)){
            redirectAttributes.addFlashAttribute("message_succes", "Account is created!");
            view.setViewName("redirect:/");
            return view;
        }
        redirectAttributes.addFlashAttribute("message_error", "Username already exists!");
        view.setViewName("redirect:/signup");
        return view;
    }

}
