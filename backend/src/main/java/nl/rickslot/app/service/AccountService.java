package nl.rickslot.app.service;

import nl.rickslot.app.model.Account;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Rick Slot
 */
public interface AccountService {

    boolean save(Account account);

    Account findByUsername(String username);

    ModelAndView createViewForAccount(String username);

    boolean edit(Account account);
}
