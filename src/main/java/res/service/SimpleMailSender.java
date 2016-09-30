package res.service;

import java.util.List;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import res.domain.Reservation;

@Service
public class SimpleMailSender {
    // sends confirmation emails

    private org.springframework.mail.MailSender mailSender;
    private SimpleMailMessage templateMessage;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setTemplateMessage(SimpleMailMessage templateMessage) {
        this.templateMessage = templateMessage;
    }

    public void sendEmail(List<Reservation> reservations) {
        Reservation reservation = reservations.get(0);
        String all ="\n";
        
        for(Reservation res : reservations) {
            all += res + "\n";
        }
        
        SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
        msg.setTo(reservation.getUserAccount().getEmail());
        msg.setText(
            "Dear " + reservation.getUserAccount().getName()
                + ", thank you for placing order. Your reserved times are: "
                + all);
        try{
            this.mailSender.send(msg);
        }
        catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }

}