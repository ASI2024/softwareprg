package eventPlaner;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EventManagement {
    public static List<Event> eventsRequest = new ArrayList<>();
    public static List<Event> eventsEdition = new ArrayList<>();
    public static List<String> Category = new ArrayList<>(); 
    public static boolean addFlag;
    public static boolean editDateFlag = false;
    public static boolean editTimeFlag = false;
    public static boolean editLocationFlag = false;
    public static boolean editThemeFlag = false;
    public static boolean editDescriptionFlag = false;
    public static boolean deletFlag = false;
    public static boolean setCategoryFlag;

    public EventManagement() {
       eventsRequest = new ArrayList<>();
        eventsEdition = new ArrayList<>();
    }

    public static void AddEvent(Event event) {
        eventsRequest.add(event);
        addFlag = true;
    }
    
    public static boolean hasConflict(Event event) {
        for(Event existingEvent : eventsRequest) {
            if(existingEvent.getDate().equals(event.getDate()) &&
                    existingEvent.getTime().equals(event.getTime())) {
                return true;
            }
        }
        return false;
    }


    public boolean SearchEvent(int eventNumber){

        for (Event existingEvent : eventsRequest){

            if( existingEvent.getEventNumber() == eventNumber)
                return true;

        }

        return false;
    }


   public static void EditDate(int eventNumber, LocalDate d) {
    for (Event existingEvent : eventsRequest) {
        if (existingEvent.getEventNumber() == eventNumber) {
            Event E = new Event(eventNumber, d, null, null, null, null, null);
            eventsEdition.add(E);
            editDateFlag = true;
        }
    }
}

   public static void EditTime(int eventNumber, LocalTime t) {
    for (Event existingEvent : eventsRequest) {
        if (existingEvent.getEventNumber() == eventNumber) {
            Event E = new Event(eventNumber, null, t, null, null, null, null);
            eventsEdition.add(E);
            editTimeFlag = true;
        }
    }
}


   public static void EditLocation(int eventNumber, String location) {
    for (Event existingEvent : eventsRequest) {
        if (existingEvent.getEventNumber() == eventNumber) {
            Event E = new Event(eventNumber, null, null, location, null, null, null);
            eventsEdition.add(E);
            editLocationFlag = true;
        }
    }
}


  public static void EditTheme(int eventNumber, String theme) {
    for (Event existingEvent : eventsRequest) {
        if (existingEvent.getEventNumber() == eventNumber) {
            Event E = new Event(eventNumber, null, null, null, theme, null, null);
            eventsEdition.add(E);
            editThemeFlag = true;
        }
    }
}


public static void EditDescription(int eventNumber, String description) {
    for (Event existingEvent : eventsRequest) {
        if (existingEvent.getEventNumber() == eventNumber) {
            Event E = new Event(eventNumber, null, null, null, null, description, null);
            eventsEdition.add(E);
            editDescriptionFlag = true;
        }
    }
}


    public static void DeletEvent(int eventNumber) {
    for (Iterator<Event> iterator = eventsRequest.iterator(); iterator.hasNext(); ) {
        Event existingEvent = iterator.next();
        if (existingEvent.getEventNumber() == eventNumber) {
            iterator.remove(); 
       
            Event E = new Event(eventNumber, null, null, null, null, null, null);
            eventsEdition.add(E);
            deletFlag = true;
            break;
        }
    }
}


    public void ShowCategory(){

        Category.add(1,"Birthday");
        Category.add(2,"Wedding");
        Category.add(3,"Workshop");
        Category.add(4,"Graduation");
        Category.add(5,"Seminar");

        for (int i=1;i<=5;i++){
            System.out.println(i+")"+Category.get(i));
        }
    }

    public static void SelectCategory(int eventNumber, int category) {
        for (Event existingEvent : eventsRequest) {
            if (existingEvent.getEventNumber() == eventNumber) {
                existingEvent.setCategory(Category.get(category));
                setCategoryFlag = true;
                break;
            }
        }
    }
}
