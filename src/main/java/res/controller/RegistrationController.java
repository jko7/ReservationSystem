package res.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import res.auth.CustomUserDetailsService;
import res.domain.*;
import res.repository.AccountRepository;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    CustomUserDetailsService grantPermission;

    @ModelAttribute
    private Account getAccount() {
        return new Account();
    }

    // registration form
    @RequestMapping(method = RequestMethod.GET)
    public String view() {
        return "form";
    }

    // form error checking and registration
    @RequestMapping(method = RequestMethod.POST)
    public String register(@Valid
            @ModelAttribute Account account,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        accountRepository.save(account);
        grantPermission.loadUserByUsername(account.getUsername());
        return "redirect:/registration/info/" + account.getUsername();
    }

    //user not yet logged in, can't use userNameService
    @RequestMapping(value = "/info/{username}")
    public String showPersonalInfo(Model model, @PathVariable String username) {
        model.addAttribute("account", accountRepository.findByUsername(username));
        return "accountDetails";
    }

}
