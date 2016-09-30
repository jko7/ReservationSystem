package res.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import res.domain.Account;
import res.repository.AccountRepository;

@Service
public class UserNameService {
    // provides logged in user's username and name as needed

    @Autowired
    AccountRepository accountRepository;

    public String giveUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            return currentUserName;
        }
        return "0";
    }

    public String giveName(String username) {

        Account account = accountRepository.findByUsername(username);

        return account.getUsername();
    }
}
