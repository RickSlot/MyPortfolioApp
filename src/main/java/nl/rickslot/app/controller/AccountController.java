package nl.rickslot.app.controller;

import nl.rickslot.app.model.Account;
import nl.rickslot.app.model.Biography;
import nl.rickslot.app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Rick Slot
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView createAccount(@RequestBody Account account) {
        ModelAndView view = new ModelAndView();

        if(accountService.save(account)){
            view.addObject("message", "account is created!");
            view.setViewName("home");
            return view;
        }
        view.addObject("message", "Something went wrong creating the account!");
        view.setViewName("/account");
        return view;
    }

    @RequestMapping(value = "/find")
    public ModelAndView findAccount() {
        ModelAndView view = new ModelAndView();
        Account account = new Account();
        account.setFirstName("RickaG");
        account.setLastName("SlotaG");
        account.setUsername("rickslot@live.nl");
        view.addObject("account", account);
        view.setViewName("account");
        return view;
    }

    @RequestMapping(value = "/rick")
    public ModelAndView showAccountHomePage() {
        ModelAndView view = new ModelAndView();

        Account account = new Account();
        account.setFirstName("RickaG");
        account.setLastName("SlotaG");
        account.setUsername("rickslot@live.nl");

        Biography biography = new Biography();
        biography.setText("This is my first portfolio. i would like to thank everyone for making this" +
                "biography possible. without the help of ruby i couldnt have achieved this! Chase your dreams," +
                "to the stars and beyond");
        view.addObject("biography", biography);
        view.addObject("account", account);

        view.setViewName("account");
        return view;
    }
}
