package eventPlaner;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class EventManagement {

    public static List<Event> eventsRequest;
    public static List<Event> eventsEdition;
    public static boolean addFlag;
    public static boolean editDateFlag = false;
    public static boolean editTimeFlag = false;
    public static boolean editLocationFlag = false;
    public static boolean editThemeFlag = false;
    public static boolean editDescriptionFlag = false;
    public static boolean deletFlag = false;

    public static boolean setCategoryFlag;

    public EventManagement(){

        eventsRequest = new ArrayList<>();
        eventsEdition = new ArrayList<>();
    }

    public void AddEvent(Event event){

        eventsRequest.add(event);
        addFlag=true;

    }

    public static boolean hasConflict(Event event) {

        for(Event existingEvent : eventsRequest){

            return existingEvent.getDate().equals(event.getDate()) &&
                    existingEvent.getTime().equals(event.getTime());

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


    public void EditDate(int eventNumber,Date d) {

        for(Event existingEvent : eventsRequest){

            if (existingEvent.getEventNumber() == eventNumber) {

                Event E = new Event(eventNumber, d, null, null, null, null, null);
                eventsEdition.add(E);
                editDateFlag = true;
            }
        }

    }

    public void EditTime(int eventNumber, Time t) {

        for(Event existingEvent : eventsRequest){

            if(existingEvent.getEventNumber() == eventNumber) {

                Event E = new Event(eventNumber,null,t,null,null,null,null);
                eventsEdition.add(E);
                editTimeFlag = true;
            }
        }

    }

    public void EditLocation(int eventNumber, String location) {

        for(Event existingEvent : eventsRequest){

            if(existingEvent.getEventNumber() == eventNumber) {

                Event E = new Event(eventNumber,null,null,location,null,null,null);
                eventsEdition.add(E);
                editLocationFlag = true;
            }

        }

    }

    public void EditTheme(int eventNumber, String theme) {

        for(Event existingEvent : eventsRequest){

            if(existingEvent.getEventNumber() == eventNumber) {

                Event E = new Event(eventNumber,null,null,null,theme,null,null);
                eventsEdition.add(E);
                editThemeFlag = true;
            }
        }

    }

    public void EditDescription(int eventNumber, String description) {

        for(Event existingEvent : eventsRequest){

            if(existingEvent.getEventNumber() == eventNumber) {

                Event E = new Event(eventNumber,null,null,null,null,description,null);
                eventsEdition.add(E);
                editDescriptionFlag = true;
            }

        }

    }

    public void DeletEvent(int eventNumber) {

        for(Event existingEvent : eventsRequest){

            if(existingEvent.getEventNumber() == eventNumber) {

                Event E = new Event(eventNumber,null,null,null,null,null,null);
                eventsEdition.add(E);
                deletFlag = true;
            }
        }

    }

    public void SelectCategory(int eventNumber,int category) {

        List<String>Category = new ArrayList<>();
        Category.add(0,"Birthday");
        Category.add(1,"Wedding");
        Category.add(2,"Workshop");
        Category.add(3,"Graduation");
        Category.add(4,"Seminar");

        for(Event existingEvent : eventsRequest){

            if(existingEvent.getEventNumber() == eventNumber) {

                existingEvent.setCategory(Category.get(category));
                setCategoryFlag = true;
            }

        }

    }


}