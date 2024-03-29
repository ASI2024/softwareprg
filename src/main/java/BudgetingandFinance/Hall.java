package BudgetingandFinance;

import java.util.Date;

public class Hall {
    private int id;
    private String name;
    private int rent;
    private int capacity;
    private Date availableDate;

    // Constructor
    public Hall(int id, String name, int rent, int capacity, Date availableDate) {
        this.id = id;
        this.name = name;
        this.rent = rent;
        this.capacity = capacity;
        this.availableDate = availableDate;
    }

    public Hall() {

    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getRent() { return rent; }
    public int getCapacity() { return capacity; }
    public Date getAvailableDate() { return availableDate; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setRent(int rent) { this.rent = rent; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public void setAvailableDate(Date availableDate) { this.availableDate = availableDate; }

}
