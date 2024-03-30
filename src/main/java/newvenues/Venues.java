package newvenues;

public class Venues {
    private String name;
    private String location;
    private int capacity;
    private String amenities;
    private double pricing;


    public Venues(String name, String location, int capacity, String amenities, double pricing) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.amenities = amenities;
        this.pricing = pricing;
    }

    public Venues() {

    }


    public void setName(String name) {

        this.name =name;
    }
    public String getName() {
        return name;
    }
    public void setLocation(String location) {

        this.location =location;
    }

    public String getLocation() {
        return location;
    }
    public void setCapacity(int capacity) {

        this.capacity =capacity;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setAmenities(String amenities) {

        this.amenities=amenities;
    }

    public String getAmenities() {
        return amenities;
    }
    public void setPricing(double pricing) {

        this.pricing =pricing;
    }

    public double getPricing() {
        return pricing;
    }


}