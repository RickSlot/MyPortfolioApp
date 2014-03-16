package nl.rickslot.app.service;

import nl.rickslot.app.model.Account;
import nl.rickslot.app.model.Biography;
import nl.rickslot.app.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Rick Slot
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ProjectService projectService;

    @Override
    public boolean save(Account account) {
        if (!accountRepository.accountExists(account.getUsername())) {
            account.setPassword(passwordEncoder.encode(account.getPassword()));
            accountRepository.save(account);
            return true;
        }
        return false;

    }

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public ModelAndView createViewForAccount(String username) {
        ModelAndView view = new ModelAndView();
        Account account = findByUsername(username);
        view.addObject("account", account);
        view.addObject("projects", projectService.findProjectsOfAccount(username));
        view.addObject("categories", projectService.findProjectCategoriesOfAccount(username));

        Biography biography = new Biography();
        biography.setText("This is my first portfolio. i would like to thank everyone for making this" +
                "biography possible. without the help of ruby i couldnt have achieved this! Chase your dreams," +
                "to the stars and beyond");
        view.addObject("biography", biography);
        view.setViewName("account");
        return view;
    }
}
