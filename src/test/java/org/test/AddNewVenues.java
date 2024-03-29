package org.test;

import eventPlaner.OrganizerLogin;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import newvenues.VenueSystem;
import newvenues.Venues;

import static org.junit.Assert.assertEquals;

public class AddNewVenues {
    public Venues venueSystem = new Venues();
    public VenueSystem venueS=new VenueSystem();
    private String responseMessage;
    OrganizerLogin organizerLogin = new OrganizerLogin();
    @Given("I am logged in as an organizer")
    public void iAmLoggedInAsAnOrganizer() {
        organizerLogin.Login("example@gmail.com","123456");
    }

    @When("I navigate to the “Add New Venue” page")
    public void iNavigateToTheAddNewVenuePage() {

    }

    @And("I enter {string} in the venue name field")
    public void iEnterVenueNameInTheVenueNameField(String S) {
        venueSystem.setName(S);
    }

    @And("I enter {string} in the location field")
    public void iEnterLocationInTheLocationField(String S) {
        venueSystem.setLocation(S);
    }

    @And("I enter {string} in the capacity field")
    public void iEnterCapacityInTheCapacityField(String S) {
        venueSystem.setCapacity(Integer.parseInt(S));
    }

    @And("I select {string} from the amenities options")
    public void iSelectAmenitiesFromTheAmenitiesOptions(String S) {
        venueSystem.setAmenities(S);
    }

    @And("I enter {string} in the pricing field")
    public void iEnterPricingInThePricingField(String S) {
        venueSystem.setPricing(Double.parseDouble(S));
    }

    @And("When I click on the Submit button")
    public void iClickOnTheSubmitButton() {
        responseMessage= venueS.addVenue("","",0,"",0.0);
    }

    @Then("I should see a message {string}")
    public void iShouldSeeAMessageVenueSuccessfullyAdded(String S) {
        assertEquals(S,responseMessage);
    }



}