package nl.rickslot.app.controller;

import nl.rickslot.app.model.Account;
import nl.rickslot.app.service.AccountService;
import nl.rickslot.app.service.MD5Util;
import nl.rickslot.app.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
        if (principal != null) {
            return accountService.createViewForAccount(auth.getName());
        }
        ModelAndView view = new ModelAndView();
        view.setViewName("redirect:/");
        return view;
    }

    @RequestMapping(value = "/{username:.+}", method = RequestMethod.GET)
    public ModelAndView schowPageForUsername(@PathVariable("username") String username) {
        Account account = accountService.findByUsername(username);
        if (account != null) {
            return accountService.createViewForAccount(username);
        }
        ModelAndView view = new ModelAndView();
        view.setViewName("/pageNotFound");
        return view;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView createAccount(Account account, RedirectAttributes redirectAttributes) {
        ModelAndView view = new ModelAndView();

        if (accountService.save(account)) {
            redirectAttributes.addFlashAttribute("message_succes", "Account is created!");
            view.setViewName("redirect:/");
            return view;
        }
        redirectAttributes.addFlashAttribute("message_error", "Username already exists!");
        view.setViewName("redirect:/signup");
        return view;
    }

    @RequestMapping(value = "editProfile", method = RequestMethod.GET)
    public ModelAndView showEditProfilePage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Account account = accountService.findByUsername(auth.getName());
        ModelAndView view = new ModelAndView();
        if (account != null) {
            view.addObject("account", account);
            view.setViewName("editProfile");
            return view;
        }
        view.setViewName("redirect:/");
        return view;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editAccount(Account account, RedirectAttributes redirectAttributes) {
        ModelAndView view = new ModelAndView();
        if (accountService.edit(account)) {
            redirectAttributes.addFlashAttribute("message_succes", "Account is succesfully updated!");
            view.setViewName("redirect:/");
            return view;
        }
        redirectAttributes.addFlashAttribute("message_error", "Something went wrong updating your account!");
        view.setViewName("redirect:/account/editProfile");
        return view;
    }

    @RequestMapping(value = "/md5", method = RequestMethod.GET)
    @ResponseBody
    public String getMd5Hash() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return MD5Util.md5Hex(auth.getName());
    }

}
