package org.test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;
import newvenues.Venues;
import newvenues.VenueSystem;

public class AddNewVenues {
    private VenueSystem venueSystem = new VenueSystem();
    private String responseMessage;
    @Given("I am logged in as an organizer")
    public void iAmLoggedInAsAnOrganizer() {

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
        venueSystem.setlocation(S);
    }

    @And("I enter {string} in the capacity field")
    public void iEnterCapacityInTheCapacityField(String S) {
        venueSystem.setcapacity(Integer.parseInt(S));
    }

    @And("I select {string} from the amenities options")
    public void iSelectAmenitiesFromTheAmenitiesOptions(String S) {
        venueSystem.setamenities(S);
    }

    @And("I enter {string} in the pricing field")
    public void iEnterPricingInThePricingField(String S) {
        venueSystem.setpricing(Double.parseDouble(S));
    }

    @And("When I click on the Submit button")
    public void iClickOnTheSubmitButton() {
        responseMessage= venueSystem.addVenue();
    }

    @Then("I should see a message {string}")
    public void iShouldSeeAMessageVenueSuccessfullyAdded(String S) {
        assertEquals(S,responseMessage);
    }

    @And("I click on the {string} button without entering any details")
    public void iClickOnTheSubmitButtonWithoutEnteringAnyDetails(String S) {
        venueSystem.resetTempVenue();
        responseMessage = venueSystem.addVenue();
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessageAllFieldsAreRequired(String S) {
        assertEquals(S, responseMessage);
    }

    @Given("the venue {string} already exists")
    public void theVenueVenueAAlreadyExists(String S) {
        venueSystem.addExistingVenue(S);
    }

    @When("I try to add another venue with the name {string}")
    public void iTryToAddAnotherVenueWithTheNameVenueA(String S) {
        venueSystem.resetTempVenue();
        venueSystem.setName(S);
        responseMessage = venueSystem.addVenue();
    }


}