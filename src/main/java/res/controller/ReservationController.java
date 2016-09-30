package res.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import res.domain.*;
import res.repository.AccountRepository;
import res.repository.ReservationRepository;
import res.service.DateSetup;
import res.service.UserNameService;

@Controller
@RequestMapping(value = "/reservation")
public class ReservationController {
    // handles reservations and reservation views

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    DateSetup dateSetup;

    @Autowired
    UserNameService userNameService;

    //Stores unconfirmed reservations
    private List<Reservation> toBeConfirmed;

    public ReservationController() {
        this.toBeConfirmed = new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showReservation(Model model) {
        model.addAttribute("name", userNameService.giveName(userNameService.giveUsername()));
        model.addAttribute("reservations", toBeConfirmed);
        return "confirmationPage";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addReservation(@RequestParam(required = false) String... times) {

        // if not reservation chosen, return
        if (times == null) {
            return "redirect:/default";
        }

        String username = userNameService.giveUsername();
        Account account = accountRepository.findByUsername(username);
        Reservation reservation = new Reservation();
        
        //gives time information for current week
        List<String> datesOfThisWeek = new ArrayList<>();
        datesOfThisWeek = dateSetup.giveDates(PageController.offset);

        // shows dates and times for debugging purposes
        /*
        for (String date : datesOfThisWeek) {
            System.out.println(datesOfThisWeek);
        }
        for (String time : times) {
            System.out.println(time);
        }
        */

        for (int t = 0; t < times.length; t++) {
            reservation.setReservedHour(times[t].substring(0, 11));
            if (times[t].contains("Monday")) {
                reservation.setReserevationWeekDay("Monday");
                reservation.setReservationDate(datesOfThisWeek.get(0).substring(0, 5));

            } else if (times[t].contains("Thuesday")) {
                reservation.setReserevationWeekDay("Thuesday");
                reservation.setReservationDate(datesOfThisWeek.get(1).substring(0, 5));

            } else if (times[t].contains("Wednesday")) {
                reservation.setReserevationWeekDay("Wednesday");
                reservation.setReservationDate(datesOfThisWeek.get(2).substring(0, 5));

            } else if (times[t].contains("Thursday")) {
                reservation.setReserevationWeekDay("Thursday");
                reservation.setReservationDate(datesOfThisWeek.get(3).substring(0, 5));

            } else if (times[t].contains("Friday")) {
                reservation.setReserevationWeekDay("Friday");
                reservation.setReservationDate(datesOfThisWeek.get(4).substring(0, 5));
            
            }
            reservation.setReservationWeek(datesOfThisWeek.get(0).substring(12, 14));
            reservation.setUserName(username);
            reservation.setUserAccount(account);
            toBeConfirmed.add(reservation);
            reservation = new Reservation();
        }
        return "redirect:/reservation";
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public String confirmReservations() {
        for (Reservation reservation : toBeConfirmed) {
            reservationRepository.save(reservation);
        }
        toBeConfirmed.clear();
        return "redirect:/default";
    }

    @RequestMapping(value = "/cancel", method = RequestMethod.GET)
    public String cancelReservations() {
        toBeConfirmed.clear();
        return "redirect:/default";
    }

    
    //unfinished method, purpose to modify index.html by disabling reserved times with Javascript
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<String> giveAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        List<String> orders = new ArrayList<>();
        String order;
        for (Reservation reservation : reservations) {
            order = "input[value=\"" + reservation.getReservedHour() + " " + reservation.getReserevationWeekDay() + "\"";
            orders.add(order);
            order = "";
        }
        return orders;
    }

}
