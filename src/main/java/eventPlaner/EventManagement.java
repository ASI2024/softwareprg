package eventPlaner;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class EventManagement {

    public List<Event>events;
    public static boolean addFlag;
    public static boolean editDateFlag = false;
    public static boolean editTimeFlag = false;
    public static boolean editLocationFlag = false;
    public static boolean editThemeFlag = false;
    public static boolean editDescriptionFlag = false;
    public static boolean deletFlag = false;

    public static boolean setCategoryFlag;

    public EventManagement(){

        this.events = new ArrayList<>();
    }

    public void AddEvent(Event event){

        if(!hasConflict(event)){

            events.add(event);
            addFlag=true;

        }else{

            addFlag=false;
        }

    }

    private boolean hasConflict(Event event) {

        for(Event existingEvent : events){

            return existingEvent.getDate().equals(event.getDate()) &&
                    existingEvent.getTime().equals(event.getTime());

        }
        return false;
    }


    public boolean SearchEvent(int eventNumber){

        for (Event existingEvent : events){

            if( existingEvent.getEventNumber() == eventNumber)
                return true;

        }

        return false;
    }


    public void EditDate(int eventNumber,Date d) {

        for(Event existingEvent : events){

            if(existingEvent.getEventNumber() == eventNumber) {

                existingEvent.setDate(d);
                editDateFlag = true;
            }
        }

    }

    public void EditTime(int eventNumber, Time t) {

        for(Event existingEvent : events){

            if(existingEvent.getEventNumber() == eventNumber) {

                existingEvent.setTime(t);
                editTimeFlag = true;
            }
        }

    }

    public void EditLocation(int eventNumber, String location) {

        for(Event existingEvent : events){

            if(existingEvent.getEventNumber() == eventNumber) {

                existingEvent.setLocation(location);
                editLocationFlag = true;
            }

        }

    }

    public void EditTheme(int eventNumber, String theme) {

        for(Event existingEvent : events){

            if(existingEvent.getEventNumber() == eventNumber) {

                existingEvent.setTheme(theme);
                editThemeFlag = true;
            }
        }

    }

    public void EditDescription(int eventNumber, String description) {

        for(Event existingEvent : events){

            if(existingEvent.getEventNumber() == eventNumber) {

                existingEvent.setDescription(description);
                editDescriptionFlag = true;
            }

        }

    }

    public void DeletEvent(int eventNumber) {

        for(Event existingEvent : events){

            if(existingEvent.getEventNumber() == eventNumber) {

                events.remove(existingEvent);
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
        Category.add(5,"Condolences");

        for(Event existingEvent : events){

            if(existingEvent.getEventNumber() == eventNumber) {

                existingEvent.setCategory(Category.get(category));
                setCategoryFlag = true;
            }

        }

    }


}



