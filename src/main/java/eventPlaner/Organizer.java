package eventPlaner;

import java.util.List;
public class Organizer {
    private String username;
    private String password;

    private EventManagement eventManagement;
    public Organizer(String username, String password) {
        this.username = username;
        this.password = password;
        this.eventManagement = new EventManagement();
    }
    public void addEvent(Event event) {
        eventManagement.AddEvent(event);
    }


}
