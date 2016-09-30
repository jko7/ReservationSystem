package res.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Reservation extends AbstractPersistable<Long> {

    @Id
    private Long id;

    private String username;
    @ManyToOne
    private Account userAccount;
    private String reservationWeek;
    private String reserevationWeekDay;
    private String reservationDate;
    private String reservedHour;

    public Reservation() {
    }

    public Reservation(String username, Account userAccount, String reservationWeek, String reservationWeekDay, 
            String reservationDate, String reservedHour) {
        this.username = username;
        this.userAccount = userAccount;
        this.reservationWeek = reservationWeek;
        this.reserevationWeekDay = reservationWeekDay;
        this.reservationDate = reservationDate;
        this.reservedHour = reservedHour;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public Account getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(Account userAccount) {
        this.userAccount = userAccount;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getReservedHour() {
        return reservedHour;
    }

    public void setReservedHour(String reservedHour) {
        this.reservedHour = reservedHour;
    }

    public String getReserevationWeekDay() {
        return reserevationWeekDay;
    }

    public void setReserevationWeekDay(String reserevationWeekDay) {
        this.reserevationWeekDay = reserevationWeekDay;
    }

    public String getReservationWeek() {
        return reservationWeek;
    }

    public void setReservationWeek(String reservationWeek) {
        this.reservationWeek = reservationWeek;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return reservedHour + "," + reserevationWeekDay + "," + reservationDate;
    }

}
