package eventPlaner;


import java.time.LocalDate;
import java.time.LocalTime;

public class Event {

    private int eventNumber;
    private LocalDate date;
    private LocalTime time;
    private String location;
    private String theme;
    private String description;
    private String category;


    public Event(int eventNumber, LocalDate date, LocalTime time, String location, String theme, String description, String category) {

        this.eventNumber = eventNumber;
        this.date = date;
        this.time = time;
        this.location = location;
        this.theme = theme;
        this.description = description;
        this.category = category;


    }

    public Event() {

    }

    public void setEventNumber(int eventNumber) {

        this.eventNumber = eventNumber;
    }

    public int getEventNumber() {

        return eventNumber;
    }

    public void setDate(LocalDate date) {

        this.date = date;
    }

    public LocalDate getDate() {

        return date;
    }

    public void setTime(LocalTime time) {

        this.time = time;
    }

    public LocalTime getTime() {

        return time;
    }

    public void setLocation(String location) {

        this.location = location;
    }

    public String getLocation() {

        return location;
    }

    public void setTheme(String theme) {

        this.theme = theme;
    }

    public String getTheme() {

        return theme;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public String getDescription() {

        return description;
    }

    public void setCategory(String category) {

        this.category = category;
    }

    public String getCategory() {

        return category;
    }

}