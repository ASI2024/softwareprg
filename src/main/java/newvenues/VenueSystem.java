package newvenues;

import java.util.List;
public class VenueSystem {
    public List<Venues> venues;


    public String addVenue(String name, String location, int capacity, String amenities, double pricing) {
        if (name.isEmpty() || location.isEmpty() || capacity == 0 || amenities.isEmpty() || pricing == 0.0) {
            return "All fields are required";
        }

        for(Venues existingVenue :venues) {
            if (existingVenue.getName().equals(name)&&existingVenue.getLocation().equals(location)) {
                return "Venue name already exists";
            }
        }

        venues.add(new Venues(name, location,capacity, amenities,pricing));
        return "Venue successfully added";
    }

    public boolean deletVenue(String name, String location){

        for(Venues existingVenue :venues) {
            if (existingVenue.getName().equals(name)&&existingVenue.getLocation().equals(location)) {
                venues.remove(existingVenue);
                return true;
            }
        }
        return false;
    }




}