package eventPlaner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static eventPlaner.OrganizerManagement.eventsList;

public class ShowCalendar {

    ArrayList<Date> Dates = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public ShowCalendar(){

        for (Event existingEvent : eventsList){

            Dates.add(existingEvent.getDate());

        }
    }
    public void PrintCalender(int month,int year){

        month--;
        Calendar calendar = new GregorianCalendar(year, month, 1);
        System.out.println("\nCalendar for " + calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, java.util.Locale.US) + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        for (int i = Calendar.SUNDAY; i < firstDayOfWeek; i++) {
            System.out.print("    ");
        }

        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int day = 1, dayOfWeek = firstDayOfWeek; day <= daysInMonth; day++, dayOfWeek++) {

            String currentDateString = String.format("%d-%02d-%02d", year, month, day);
            boolean isSpecialDate = Dates.stream()
                    .anyMatch(d -> sdf.format(d).equals(currentDateString));

            if (isSpecialDate) {
                System.err.printf("%3d ", day);
            } else {
                System.out.printf("%3d ", day);
            }

            if (dayOfWeek == Calendar.SATURDAY) {
                System.out.println();
                dayOfWeek = Calendar.SUNDAY - 1;
            }
        }
    }


}
