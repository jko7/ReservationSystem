package res.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import res.domain.Reservation;
import res.repository.AccountRepository;
import res.repository.ReservationRepository;
import res.service.DateSetup;
import res.service.SimpleMailSender;
import res.service.UserNameService;

@Controller
public class PageController {
    // models pages with dates and personal info

    @Autowired
    private DateSetup dateSetup;

    @Autowired
    UserNameService userNameService;
    // provides username and name as needed

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    SimpleMailSender mailSender;

    public static int offset;

    public PageController() {
        this.offset = 0;
    }

    @RequestMapping("/default")
    public String defaultPage(Model model) {
        
        List<SimpleDateFormat> allDates = new ArrayList<>();
        allDates = dateSetup.giveDates(offset);
        model.addAttribute("name", userNameService.giveName(userNameService.giveUsername()));
        model.addAttribute("today", dateSetup.giveToday());
        model.addAttribute("thisWeek", dateSetup.giveThisWeek());
        model.addAttribute("weeks", dateSetup.giveWeeks(offset));
        model.addAttribute("dateOnMonday", allDates.get(0));
        model.addAttribute("dateOnThuesday", allDates.get(1));
        model.addAttribute("dateOnWednesday", allDates.get(2));
        model.addAttribute("dateOnThursday", allDates.get(3));
        model.addAttribute("dateOnFriday", allDates.get(4));
        
        return "index";
    }

    @RequestMapping(value = "/next", method = RequestMethod.GET)
    public String nextPage() {
        offset += 7;
        return "redirect:/default";
    }

    @RequestMapping(value = "/back", method = RequestMethod.GET)
    public String previousPage() {
        offset -= 7;
        return "redirect:/default";
    }

    @RequestMapping(value = "/reset", method = RequestMethod.GET)
    public String reset() {
        offset = 0;
        return "redirect:/default";
    }

    public int giveOffset() {
        return offset;
    }

    @RequestMapping(value = "/personal", method = RequestMethod.GET)
    public String personalInfo(Model model) {
        model.addAttribute("name", userNameService.giveName(userNameService.giveUsername()));
        model.addAttribute("account", accountRepository.findByUsername(userNameService.giveUsername()));
        model.addAttribute("reservations", reservationRepository.findByUsername(userNameService.giveUsername()));
        return "personalPage";
    }

    @RequestMapping(value = "/mail", method = RequestMethod.GET)
    @ResponseBody
    public String sendMail() {
        List<Reservation> reservations = reservationRepository.findByUsername(userNameService.giveUsername());
        //mailSender.sendEmail(reservations);
        return "This functionality is not in use yet, sorry";
    }
    
   
    

}
