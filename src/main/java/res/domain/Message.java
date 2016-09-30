package res.domain;
 
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.jpa.domain.AbstractPersistable;
import res.domain.Account;
 
@Entity
public class Message extends AbstractPersistable<Long> {
 
    @Temporal(TemporalType.TIMESTAMP)
    private Date messageDate;
    private Account account;
    private String message;
 
    public Message() {
        this.messageDate = new Date();
    }
 
    public Date getMessageDate() {
        return messageDate;
    }
 
    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }
 
    public Account getAccount() {
        return account;
    }
 
    public void setAccount(Account account) {
        this.account = account;
    }
 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
}