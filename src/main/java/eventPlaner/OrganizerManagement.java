package eventPlaner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static eventPlaner.EventManagement.eventsEdition;
import static eventPlaner.EventManagement.eventsRequest;
import static eventPlaner.EventManagement.hasConflict;

public class OrganizerManagement {
public static final String EVENT_NOT_FOUND = "Event Not Found";
 private static final String EVENT_NUMBER_PREFIX = "Event Number: ";
    private static final String UPDATE_SUCCESS = "The Update Was Accepted Successfully";
    private static final Logger logger = LogManager.getLogger(OrganizerManagement.class);

    public static List<Event> eventsList;
    public HashMap<Integer, String> reasonRejection;

    public OrganizerManagement() {
        eventsList = new ArrayList<>();
        this.reasonRejection = new HashMap<>();
    }

   public void reviewsThePendingEventAddition() {
        int i = 0;
        for (Event existingEvent : eventsRequest) {
            String statement = i + ")" + EVENT_NUMBER_PREFIX + existingEvent.getEventNumber() +
                               " Event Date: " + existingEvent.getDate() +
                               " Event Time: " + existingEvent.getTime() +
                               " Event Location: " + existingEvent.getLocation() +
                               " Event Theme: " + existingEvent.getTheme() +
                               " Event Description: " + existingEvent.getDescription() +
                               " Event Category: " + existingEvent.getCategory();
            logger.info(statement);
            i++;
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
        return EVENT_NOT_FOUND;
    }

    public String rejectAddEvent(int eventNumber, String reason) {
        for (Event existingEvent : eventsRequest) {
            if (existingEvent.getEventNumber() == eventNumber) {
                reasonRejection.put(eventNumber, reason);
                return "The Event Was Rejected Successfully";
            }
        }
        return EVENT_NOT_FOUND;
    }

    public String acceptModification(int eventNumber) {
        for (Event existingEvent : eventsList) {
            for (Event existingEvent1 : eventsEdition) {
                if (existingEvent.getEventNumber() == eventNumber &&
                        existingEvent1.getEventNumber() == eventNumber &&
                        existingEvent1.getDate() != null) {
                    existingEvent.setDate(existingEvent1.getDate());
                    eventsEdition.remove(existingEvent1);
                    return UPDATE_SUCCESS;
                } else if (existingEvent.getEventNumber() == eventNumber &&
                        existingEvent1.getEventNumber() == eventNumber &&
                        existingEvent1.getTime() != null) {
                    existingEvent.setTime(existingEvent1.getTime());
                    eventsEdition.remove(existingEvent1);
                    return UPDATE_SUCCESS;
                } else if (existingEvent.getEventNumber() == eventNumber &&
                        existingEvent1.getEventNumber() == eventNumber &&
                        existingEvent1.getLocation() != null) {
                    existingEvent.setLocation(existingEvent1.getLocation());
                    eventsEdition.remove(existingEvent1);
                    return UPDATE_SUCCESS;
                } else if (existingEvent.getEventNumber() == eventNumber &&
                        existingEvent1.getEventNumber() == eventNumber &&
                        existingEvent1.getTheme() != null) {
                    existingEvent.setTheme(existingEvent1.getTheme());
                    eventsEdition.remove(existingEvent1);
                    return UPDATE_SUCCESS;
                } else if (existingEvent.getEventNumber() == eventNumber &&
                        existingEvent1.getEventNumber() == eventNumber &&
                        existingEvent1.getDescription() != null) {
                    existingEvent.setDescription(existingEvent1.getDescription());
                    eventsEdition.remove(existingEvent1);
                    return UPDATE_SUCCESS;
                }
            }
        }
        return EVENT_NOT_FOUND;
    }

    public String rejectModification(int eventNumber, String reason) {
        for (Event existingEvent : eventsEdition) {
            if (existingEvent.getEventNumber() == eventNumber) {
                reasonRejection.put(eventNumber, reason);
                return "Modification Was Rejected Successfully";
            }
        }
        return EVENT_NOT_FOUND;
    }

    public void reviewsThePendingModification() {
        for (Event existingEvent : eventsEdition) {
            if (existingEvent.getDate() != null) {
                String statement = EVENT_NUMBER_PREFIX + existingEvent.getEventNumber() +
                        " Request To Change The Date To " + existingEvent.getDate();
                logger.info(statement);
            } else if (existingEvent.getTime() != null) {
                String statement = EVENT_NUMBER_PREFIX + existingEvent.getEventNumber() +
                        " Request To Change The Time To " + existingEvent.getTime();
                logger.info(statement);
            } else if (existingEvent.getLocation() != null) {
                String statement = EVENT_NUMBER_PREFIX + existingEvent.getEventNumber() +
                        " Request To Change The Location To " + existingEvent.getLocation();
                logger.info(statement);
            } else if (existingEvent.getTheme() != null) {
                String statement = EVENT_NUMBER_PREFIX + existingEvent.getEventNumber() +
                        " Request To Change The Theme To " + existingEvent.getTheme();
                logger.info(statement);
            } else if (existingEvent.getDescription() != null) {
                String statement = EVENT_NUMBER_PREFIX + existingEvent.getEventNumber() +
                        " Request To Change The Description To " + existingEvent.getDescription();
                logger.info(statement);
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
                String statement = EVENT_NUMBER_PREFIX + existingEvent.getEventNumber() +
                                   " Request To Delete The Event";
                logger.info(statement); 
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
        return EVENT_NOT_FOUND;
    }

 public static void ShowEventList() {
    int i = 1;
   
    if (logger.isLoggable(Level.INFO)) {
        for (Event existingEvent : eventsList) {
            StringBuilder statement = new StringBuilder();
            statement.append(i).append(")").append(EVENT_NUMBER_PREFIX).append(existingEvent.getEventNumber())
                     .append(" Event Date: ").append(existingEvent.getDate())
                     .append(" Event Time: ").append(existingEvent.getTime())
                     .append(" Event Location: ").append(existingEvent.getLocation())
                     .append(" Event Theme: ").append(existingEvent.getTheme())
                     .append(" Event Description: ").append(existingEvent.getDescription())
                     .append(" Event Category: ").append(existingEvent.getCategory());
            logger.info(statement.toString());
            i++;
        }
    }
}

}
