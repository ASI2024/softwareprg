package eventPlaner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static eventPlaner.EventManagement.eventsEdition;
import static eventPlaner.EventManagement.eventsRequest;
import static eventPlaner.EventManagement.hasConflict;

public class OrganizerManagement {

    public static List<Event> eventsList;
    public HashMap<Integer, String> reasonRejection;

    public OrganizerManagement() {
        this.eventsList = new ArrayList<>();
        this.reasonRejection = new HashMap<>();
    }

    public void reviewsThePendingEventAddition() {
        for (Event existingEvent : eventsRequest) {
            String statement = "Event Number: " + existingEvent.getEventNumber() +
                    "Event Date: " + existingEvent.getDate() +
                    "Event Time: " + existingEvent.getTime() +
                    "Event Location: " + existingEvent.getLocation() +
                    "Event Theme: " + existingEvent.getTheme() +
                    "Event Description: " + existingEvent.getDescription() +
                    "Event Category: " + existingEvent.getCategory();
            System.out.println(statement);
        }
    }

    public String acceptAddEvent(int eventNumber) {
        for (Event existingEvent : eventsRequest) {
            if (existingEvent.getEventNumber() == eventNumber && !hasConflict(existingEvent)) {
                eventsList.add(existingEvent);
                eventsRequest.remove(existingEvent);
                return "The Event Was Added Successfully";
            } else if (existingEvent.getEventNumber() == eventNumber && hasConflict(existingEvent)) {
                String s = "There is a Appointment Conflict With Another Event";
                reasonRejection.put(eventNumber, "There is a Appointment Conflict With Another Event,Please Choose Another Appointment");
                return s;
            }
        }
        return "Event Not Found";
    }

    public String rejectAddEvent(int eventNumber, String reason) {
        for (Event existingEvent : eventsRequest) {
            if (existingEvent.getEventNumber() == eventNumber) {
                reasonRejection.put(eventNumber, reason);
                return "The Event Was Rejected Successfully";
            }
        }
        return "Event Not Found";
    }

    public String acceptModification(int eventNumber) {
        for (Event existingEvent : eventsList) {
            for (Event existingEvent1 : eventsEdition) {
                if (existingEvent.getEventNumber() == eventNumber &&
                        existingEvent1.getEventNumber() == eventNumber &&
                        existingEvent1.getDate() != null) {
                    existingEvent.setDate(existingEvent1.getDate());
                    eventsEdition.remove(existingEvent1);
                    return "The Update Was Accepted Successfully";
                } else if (existingEvent.getEventNumber() == eventNumber &&
                        existingEvent1.getEventNumber() == eventNumber &&
                        existingEvent1.getTime() != null) {
                    existingEvent.setTime(existingEvent1.getTime());
                    eventsEdition.remove(existingEvent1);
                    return "The Update Was Accepted Successfully";
                } else if (existingEvent.getEventNumber() == eventNumber &&
                        existingEvent1.getEventNumber() == eventNumber &&
                        existingEvent1.getLocation() != null) {
                    existingEvent.setLocation(existingEvent1.getLocation());
                    eventsEdition.remove(existingEvent1);
                    return "The Update Was Accepted Successfully";
                } else if (existingEvent.getEventNumber() == eventNumber &&
                        existingEvent1.getEventNumber() == eventNumber &&
                        existingEvent1.getTheme() != null) {
                    existingEvent.setTheme(existingEvent1.getTheme());
                    eventsEdition.remove(existingEvent1);
                    return "The Update Was Accepted Successfully";
                } else if (existingEvent.getEventNumber() == eventNumber &&
                        existingEvent1.getEventNumber() == eventNumber &&
                        existingEvent1.getDescription() != null) {
                    existingEvent.setDescription(existingEvent1.getDescription());
                    eventsEdition.remove(existingEvent1);
                    return "The Update Was Accepted Successfully";
                }
            }
        }
        return "Event Not Found";
    }

    public String rejectModification(int eventNumber, String reason) {
        for (Event existingEvent : eventsEdition) {
            if (existingEvent.getEventNumber() == eventNumber) {
                reasonRejection.put(eventNumber, reason);
                return "Modification Was Rejected Successfully";
            }
        }
        return "Event Not Found";
    }

    public void reviewsThePendingModification() {
        for (Event existingEvent : eventsEdition) {
            if (existingEvent.getDate() != null) {
                String statement = "Event Number: " + existingEvent.getEventNumber() +
                        "Request To Change The Date To " + existingEvent.getDate();
                System.out.println(statement);
            } else if (existingEvent.getTime() != null) {
                String statement = "Event Number: " + existingEvent.getEventNumber() +
                        "Request To Change The Time To " + existingEvent.getTime();
                System.out.println(statement);
            } else if (existingEvent.getLocation() != null) {
                String statement = "Event Number: " + existingEvent.getEventNumber() +
                        "Request To Change The Location To " + existingEvent.getLocation();
                System.out.println(statement);
            } else if (existingEvent.getTheme() != null) {
                String statement = "Event Number: " + existingEvent.getEventNumber() +
                        "Request To Change The Theme To " + existingEvent.getTheme();
                System.out.println(statement);
            } else if (existingEvent.getDescription() != null) {
                String statement = "Event Number: " + existingEvent.getEventNumber() +
                        "Request To Change The Description To " + existingEvent.getDescription();
                System.out.println(statement);
            }
        }
    }

    public void reviewsThePendingDeletion() {
        for (Event existingEvent : eventsEdition) {
            if (existingEvent.getDate() == null &&
                    existingEvent.getTime() == null &&
                    existingEvent.getLocation() == null &&
                    existingEvent.getTheme() == null &&
                    existingEvent.getDescription() == null) {
                String statement = "Event Number: " + existingEvent.getEventNumber() +
                        "Request To Delete The Event";
                System.out.println(statement);
            }
        }
    }

    public String acceptDeletEvent(int eventNumber) {
        for (Event existingEvent : eventsList) {
            if (existingEvent.getEventNumber() == eventNumber) {
                eventsList.remove(existingEvent);
                return "The Event Was Deleted Successfully";
            }
        }
        return "Event Not Found";
    }
}