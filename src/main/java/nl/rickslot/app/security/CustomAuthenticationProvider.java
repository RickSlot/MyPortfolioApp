package nl.rickslot.app.security;

import nl.rickslot.app.model.Account;
import nl.rickslot.app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rick Slot
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

    @Autowired
    AccountService accountService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Account  account = accountService.findByUsername(authentication.getName());
        if(account.getPassword().equals(authentication.getCredentials().toString())){
            Authentication auth = new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword(), account.getAuthorities());
            return auth;
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
