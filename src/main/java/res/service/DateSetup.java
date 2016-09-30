package res.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.springframework.stereotype.Service;

@Service
public class DateSetup {
    //provides dates and times on views etc

    public List giveDates(int offset) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf;
        List<String> allDates = new ArrayList<>();
        int days = 5;
        
        calendar.add(Calendar.DAY_OF_MONTH, offset);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        while (dayOfWeek != 1) {
            calendar.add(Calendar.DATE, -1);
            dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        }
        
        for (int i = 0; i < days;) {

            calendar.add(Calendar.DATE, 1);
            if (calendar.get(Calendar.DAY_OF_WEEK) <= 6 && (calendar.get(Calendar.DAY_OF_WEEK) > 1)) {
                i++;
                date = calendar.getTime();
                sdf = new SimpleDateFormat("dd.MM. EEE (w)", Locale.UK);
                allDates.add(sdf.format(date));
            }
        }
        return allDates;
    }

    public String giveWeeks(int offset) {
        Date week = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, offset);
        week = calendar.getTime();
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("w");
        return sdf.format(week);
    }

    public String giveThisWeek() {
        Date week = new Date();
        Calendar calendar = Calendar.getInstance();
        week = calendar.getTime();
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("w");
        return sdf.format(week);
    }

    public String giveToday() {
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        today = calendar.getTime();
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("EEEEE d. MMMMM yyyy", Locale.UK);
        return sdf.format(today);
    }
    
}
