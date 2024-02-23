package eventPlaner;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class EventManagement {

    public List<Event>events;
    public static boolean addFlag;
    public static boolean editDateFlag;
    public static boolean editTimeFlag;
    public static boolean editLocationFlag;
    public static boolean editThemeFlag;
    public static boolean editDescriptionFlag;
    public static boolean deletFlag;

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
            }else{

                editDateFlag = false;
            }
        }

    }

    public void EditTime(int eventNumber, Time t) {

        for(Event existingEvent : events){

            if(existingEvent.getEventNumber() == eventNumber) {

                existingEvent.setTime(t);
                editTimeFlag = true;
            }else{

                editTimeFlag = false;
            }

        }

    }

    public void EditLocation(int eventNumber, String location) {

        for(Event existingEvent : events){

            if(existingEvent.getEventNumber() == eventNumber) {

                existingEvent.setLocation(location);
                editLocationFlag = true;
            }else{

                editLocationFlag = false;
            }

        }

    }

    public void EditTheme(int eventNumber, String theme) {

        for(Event existingEvent : events){

            if(existingEvent.getEventNumber() == eventNumber) {

                existingEvent.setTheme(theme);
                editThemeFlag = true;
            }else{

                editThemeFlag = false;
            }

        }

    }

    public void EditDescription(int eventNumber, String description) {

        for(Event existingEvent : events){

            if(existingEvent.getEventNumber() == eventNumber) {

                existingEvent.setDescription(description);
                editDescriptionFlag = true;
            }else{

                editDescriptionFlag = false;
            }

        }

    }

    public void DeletEvent(int eventNumber) {

        for(Event existingEvent : events){

            if(existingEvent.getEventNumber() == eventNumber) {

                events.remove(existingEvent);
                deletFlag = true;
            }else{

                deletFlag = false;
            }
        }

    }

    public void SelectCategory(int eventNumber,int category) {

        List<String>Category = new ArrayList<>();
        Category.add(1,"Birthday");
        Category.add(2,"Wedding");
        Category.add(3,"Workshop");
        Category.add(4,"Graduation");
        Category.add(5,"Seminar");
        Category.add(6,"Condolences");

        for(Event existingEvent : events){

            if(existingEvent.getEventNumber() == eventNumber) {

                existingEvent.setCategory(Category.get(category));
                setCategoryFlag = true;
            }else{

                setCategoryFlag = false;

            }

        }

    }


}



