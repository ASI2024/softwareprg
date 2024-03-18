package eventPlaner;

import java.util.HashMap;
import java.util.List;

import static eventPlaner.EventManagement.*;

public class OrganizerManagement {

    public static List<Event> eventsList;

    public HashMap<Integer,String>reasonRejection;

    public void reviewsThePendingEventAddition(){

        for (Event existingEvent : eventsRequest){

            String Statement = "Event Number: "+existingEvent.getEventNumber()
                    +"Event Date: "+existingEvent.getDate()
                    +"Event Time: "+existingEvent.getTime()
                    +"Event Location: "+existingEvent.getLocation()
                    +"Event Theme: "+existingEvent.getTheme()
                    +"Event Description: "+existingEvent.getDescription()
                    +"Event Category: "+existingEvent.getCategory();

            System.out.println(Statement);

        }

    }

    public String acceptAddEvent(int eventNumber){

        for(Event existingEvent : eventsRequest){

            if(existingEvent.getEventNumber() == eventNumber && !hasConflict(existingEvent)){

            eventsList.add(existingEvent);
            eventsRequest.remove(existingEvent);
            return "The Event Was Added Successfully";

            }else if(existingEvent.getEventNumber() == eventNumber && hasConflict(existingEvent)){

                String S = "There is a Appointment Conflict With Another Event";
                reasonRejection.put(eventNumber,"There is a Appointment Conflict With Another Event,Please Choose Another Appointment");
                return S;

            }
        }

        return "Event Not Found";
    }


    public String rejectAddEvent(int eventNumber, String reason) {

        for(Event existingEvent : eventsRequest) {

            if(existingEvent.getEventNumber() == eventNumber) {

                reasonRejection.put(eventNumber, reason);
                return "The Event Was Rejected Successfully";
            }
        }

        return "Event Not Found";
    }

    public String acceptModification(int eventNumber) {

        for(Event existingEvent : eventsList){
            for(Event ExistingEvent : eventsEdition) {

                if (existingEvent.getEventNumber() == eventNumber
                        &&ExistingEvent.getEventNumber() ==eventNumber
                        &&ExistingEvent.getDate() != null) {

                    existingEvent.setDate(ExistingEvent.getDate());
                    eventsEdition.remove(ExistingEvent);
                    return "The Update Was Accepted Successfully";

                }else if (existingEvent.getEventNumber() == eventNumber
                        &&ExistingEvent.getEventNumber() ==eventNumber
                        &&ExistingEvent.getTime() != null) {

                    existingEvent.setTime(ExistingEvent.getTime());
                    eventsEdition.remove(ExistingEvent);
                    return "The Update Was Accepted Successfully";

                }else if (existingEvent.getEventNumber() == eventNumber
                        &&ExistingEvent.getEventNumber() ==eventNumber
                        &&ExistingEvent.getLocation() != null) {

                    existingEvent.setLocation(ExistingEvent.getLocation());
                    eventsEdition.remove(ExistingEvent);
                    return "The Update Was Accepted Successfully";

                }else if (existingEvent.getEventNumber() == eventNumber
                        &&ExistingEvent.getEventNumber() ==eventNumber
                        &&ExistingEvent.getTheme() != null) {

                    existingEvent.setTheme(ExistingEvent.getTheme());
                    eventsEdition.remove(ExistingEvent);
                    return "The Update Was Accepted Successfully";

                }else if (existingEvent.getEventNumber() == eventNumber
                        &&ExistingEvent.getEventNumber() ==eventNumber
                        &&ExistingEvent.getDescription() != null) {

                    existingEvent.setDescription(ExistingEvent.getDescription());
                    eventsEdition.remove(ExistingEvent);
                    return "The Update Was Accepted Successfully";

                }

            }

        }

        return "Event Not Found";
    }

    public String rejectModification(int eventNumber, String reason) {

        for(Event existingEvent : eventsEdition) {

            if(existingEvent.getEventNumber() == eventNumber) {

                reasonRejection.put(eventNumber, reason);
                return "Modification Was Rejected Successfully";
            }
        }

        return "Event Not Found";


    }

    public void reviewsThePendingModification() {

        for(Event existingEvent : eventsEdition){

            if(existingEvent.getDate() !=null){

                    String Statement = "Event Number: " + existingEvent.getEventNumber()
                            + "Request To Change The Date To "+existingEvent.getDate();
                    System.out.println(Statement);
            }else if(existingEvent.getTime() !=null){

                String Statement = "Event Number: " + existingEvent.getEventNumber()
                        + "Request To Change The Time To "+existingEvent.getTime();
                System.out.println(Statement);
            }else if(existingEvent.getLocation() !=null){

                String Statement = "Event Number: " + existingEvent.getEventNumber()
                        + "Request To Change The Location To "+existingEvent.getLocation();
                System.out.println(Statement);
            }else if(existingEvent.getTheme() !=null){

                String Statement = "Event Number: " + existingEvent.getEventNumber()
                        + "Request To Change The Theme To "+existingEvent.getTheme();
                System.out.println(Statement);
            }else if(existingEvent.getDescription() !=null){

                String Statement = "Event Number: " + existingEvent.getEventNumber()
                        + "Request To Change The Description To "+existingEvent.getDescription();
                System.out.println(Statement);
            }

        }
    }

    public void reviewsThePendingDeletion() {

        for (Event existingEvent : eventsEdition){

            if(existingEvent.getDate() == null
            &&existingEvent.getTime() == null
            &&existingEvent.getLocation() == null
            &&existingEvent.getTheme() == null
            &&existingEvent.getDescription() == null){

                String Statement = "Event Number: " + existingEvent.getEventNumber()
                        +"Request To Delet The Event";
                System.out.println(Statement);

            }
        }

    }

    public String acceptDeletEvent(int eventNumber) {

        for(Event existingEvent : eventsList){

            if(existingEvent.getEventNumber() == eventNumber){

                eventsList.remove(existingEvent);
                return "The Event Was Deleted Successfully";
            }
        }
        return "Event Not Found";
    }
}
