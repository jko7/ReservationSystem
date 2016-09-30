package res.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import res.repository.*;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ReservationRepository reservationRepository;


 @RequestMapping(method = RequestMethod.GET)
    public String adminInfo(Model model) {
        model.addAttribute("accounts", accountRepository.findAll());
        model.addAttribute("reservations", reservationRepository.findAll());
        return "adminPage";
    }
    
@RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String Maintenance(Model model) {
        //accountRepository.deleteAll();
        //reservationRepository.deleteAll();
        return "redirect:/adminpage";
    }
}



