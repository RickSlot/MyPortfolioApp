package nl.rickslot.app.service;

import nl.rickslot.app.model.Account;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Rick Slot
 */
public interface AccountService {

    /**
     * Saves an account
     * @param account
     * @return true if saved, false if not
     */
    boolean save(Account account);

    /**
     * Finds an account by its username
     * @param username username of the account
     * @return the account that is found
     */
    Account findByUsername(String username);

    /**
     * Creates the view that is needed to show the account page properly
     * @param username the username of the account
     * @return ModelAndView object with all necessary objects
     */
    ModelAndView createViewForAccount(String username);

    /**
     * Edits an account
     * @param account the account that is edited
     * @return true if edited, false otherwise
     */
    boolean edit(Account account);
}
