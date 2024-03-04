package newvenues;

import java.util.List;

public class Venues {
    private String name;
    private String location;
    private int capacity;
    private String amenities;
    private double pricing;

    // Constructor
    public Venues(String name, String location, int capacity, String amenities, double pricing) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.amenities = amenities;
        this.pricing = pricing;
    }

    public Venues() {

    }

    // Getter methods

    public void setName(String name) {

        this.name =name;
    }
    public String getName() {
        return name;
    }
    public void setlocation(String location) {

        this.location =location;
    }

    public String getLocation() {
        return location;
    }
    public void setcapacity(int capacity) {

        this.capacity =capacity;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setamenities(String amenities) {

        this.amenities=amenities;
    }

    public String getAmenities() {
        return amenities;
    }
    public void setpricing(double pricing) {

        this.pricing =pricing;
    }

    public double getPricing() {
        return pricing;
    }


}