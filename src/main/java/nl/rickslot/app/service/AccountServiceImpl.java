package nl.rickslot.app.service;

import nl.rickslot.app.model.Account;
import nl.rickslot.app.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Rick Slot
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public boolean save(Account account) {
        if(!accountRepository.accountExists(account.getUsername())){
            accountRepository.save(account);
            return true;
        }
        return false;

    }
}
