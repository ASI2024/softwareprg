package eventPlaner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static eventPlaner.OrganizerManagement.eventsList;

public class ShowCalendar {
  private static final Logger logger = LogManager.getLogger(ShowCalendar.class);
    ArrayList<LocalDate> Dates = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public ShowCalendar(){

        for (Event existingEvent : eventsList){

            Dates.add(existingEvent.getDate());

        }
    }
public void PrintCalender(int month, int year) {
    month--;
    Calendar calendar = new GregorianCalendar(year, month, 1);
   
    if (logger.isInfoEnabled()) {
        String header = String.format("%nCalendar for %s %d%n", calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, java.util.Locale.US), year);
        logger.info(header);
        logger.info("Sun Mon Tue Wed Thu Fri Sat");
        
        StringBuilder sb = new StringBuilder();
        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        for (int i = Calendar.SUNDAY; i < firstDayOfWeek; i++) {
            sb.append("    ");
        }
        
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int day = 1, dayOfWeek = firstDayOfWeek; day <= daysInMonth; day++) {
            String currentDateString = String.format("%d-%02d-%02d", year, month + 1, day);
            boolean isSpecialDate = Dates.stream().anyMatch(d -> sdf.format(d).equals(currentDateString));
            
            if (isSpecialDate) {
                sb.append(String.format("**%3d** ", day));
            } else {
                sb.append(String.format("%3d ", day));
            }
            
            if (dayOfWeek == Calendar.SATURDAY) {
                sb.append(String.format("%n"));
                
            }
           
            dayOfWeek = (dayOfWeek == Calendar.SATURDAY) ? Calendar.SUNDAY : dayOfWeek + 1;
        }
        
        logger.info(sb.toString());
    }
}



}
