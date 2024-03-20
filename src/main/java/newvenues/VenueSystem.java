package newvenues;
import java.util.ArrayList;
import java.util.List;
public class VenueSystem {
    private List<Venues> venues;
    private Venues tempVenue;
    public VenueSystem (){
        this.venues= new ArrayList<>();
        this.tempVenue=new Venues();
    }
    public void setName(String name) {

        tempVenue.setName(name);
    }
    public void setlocation(String location) {

        tempVenue.setlocation(location);

    }
    public void setcapacity(int capacity) {

        tempVenue.setcapacity(capacity);
    }
    public void setamenities(String amenities) {

        tempVenue.setamenities(amenities);
    }
    public void setpricing(double pricing) {

        tempVenue.setpricing(pricing);
    }
    public String addVenue() {
        if (tempVenue.getName() == null || tempVenue.getLocation() == null || tempVenue.getCapacity() == 0 || tempVenue.getAmenities() == null || tempVenue.getPricing() == 0.0) {
            return "All fields are required";
        }

        if (venues.stream().anyMatch(v -> v.getName().equals(tempVenue.getName()))) {
            return "Venue name already exists";
        }

        venues.add(new Venues(tempVenue.getName(), tempVenue.getLocation(), tempVenue.getCapacity(), tempVenue.getAmenities(), tempVenue.getPricing()));
        return "Venue successfully added";
    }
    public void addExistingVenue(String name) {

        Venues existingVenue = new Venues(name, "Default Location", 100, "Default Amenities", 1000.0);
        venues.add(existingVenue);
    }
    // Reset the tempVenue to clear previous data
    public void resetTempVenue() {
        tempVenue = new Venues();
    }




}