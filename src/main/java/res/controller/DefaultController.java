package res.controller;

import java.util.Arrays;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.crypto.password.PasswordEncoder;
import res.auth.CustomUserDetailsService;
import res.repository.AccountRepository;
import res.domain.Account;

@Controller
public class DefaultController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CustomUserDetailsService userDetailsService;

    @RequestMapping({"*", "/start"})
    public String handleDefault() {

        return "redirect:/default";
    }

    @PostConstruct
    public void init() {
        // creating tester users
        /*
        if (accountRepository.findByUsername("test") != null || accountRepository.findByUsername("test2") != null) {
            return;
        }
         */
        Account tester1 = new Account();
        tester1.setUsername("test");
        tester1.setPassword("test");
        tester1.setEmail("test1@test.com");
        tester1.setName("Teppo Alias Testaaja 1");
        tester1.setAuthorities(Arrays.asList("USER"));

        Account tester2 = new Account();
        tester2.setUsername("test2");
        tester2.setPassword("test");
        tester2.setEmail("test2@test.com");
        tester2.setName("Teppo Alias Testaaja 2");
        tester2.setAuthorities(Arrays.asList("USER"));

        Account admin = new Account();
        admin.setUsername("admin");
        admin.setPassword("nimda");
        admin.setEmail("admin@test.com");
        admin.setName("admin");
        admin.setAuthorities(Arrays.asList("ADMIN"));
        
        accountRepository.save(tester1);
        userDetailsService.loadUserByUsername("test");

        accountRepository.save(tester2);
        userDetailsService.loadUserByUsername("test2");

        accountRepository.save(admin);
        userDetailsService.loadUserByUsername("admin");
    }
}
