package org.test;

import eventPlaner.Event;
import eventPlaner.EventManagement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.Date;
import java.sql.Time;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EventSteps {

    EventManagement event = new EventManagement();

    @Given("the organizer is logged in")
    public void the_organizer_is_logged_in() {
        // Implementation to log in the organizer
    }

    @When("they navigate to the event creation page")
    public void they_navigate_to_the_event_creation_page() {
        // Implementation to navigate to the event creation page
    }

    @When("they fill in the required details including date, time, location, theme, and description")
    public void they_fill_in_the_required_details_including_date_time_location_theme_and_description(Event e) {

        event.AddEvent(e);
    }

    @Then("the event should be successfully created")
    public void the_event_should_be_successfully_created() {

        assertTrue (EventManagement.addFlag);
    }

    @Given("there exists an event")
    public void there_exists_an_event() {


    }

    @When("the organizer search for an event")
    public void the_organizer_search_for_an_event(int eventNumber) {

        event.SearchEvent(eventNumber);
    }

    @Then("the event is exist")
    public void the_event_is_be_exist(int eventNumber) {

        assertTrue (event.SearchEvent(eventNumber));
    }
    @When("the organizer selects the date event to edit")
    public void the_organizer_selects_the_date_event_to_edit(int eventNumber,Date D) {

        event.EditDate(eventNumber,D);

    }

    @Then("the date event should be successfully updated")
    public void the_date_event_should_be_successfully_updated() {

        assertTrue (EventManagement.editDateFlag);
    }

    @When("the organizer selects the time event to edit")
    public void the_organizer_selects_the_time_event_to_edit(int eventNumber,Time T) {

        event.EditTime(eventNumber,T);

    }

    @Then("the time event should be successfully updated")
    public void the_time_event_should_be_successfully_updated() {

        assertTrue (EventManagement.editTimeFlag);
    }

    @When("the organizer selects the location event to edit")
    public void the_organizer_selects_the_location_event_to_edit(int eventNumber,String location) {

        event.EditLocation(eventNumber,location);


    }

    @Then("the location event should be successfully updated")
    public void the_location_event_should_be_successfully_updated() {

        assertTrue(EventManagement.editLocationFlag);

    }

    @When("the organizer selects the theme event to edit")
    public void the_organizer_selects_the_theme_event_to_edit(int eventNumber,String theme) {

        event.EditTheme(eventNumber,theme);


    }

    @Then("the theme event should be successfully updated")
    public void the_theme_event_should_be_successfully_updated() {

        assertTrue(EventManagement.editLocationFlag);

    }

    @When("the organizer selects the description event to edit")
    public void the_organizer_selects_the_description_event_to_edit(int eventNumber,String description) {

        event.EditDescription(eventNumber,description);


    }

    @Then("the description event should be successfully updated")
    public void the_description_event_should_be_successfully_updated() {

        assertTrue(EventManagement.editDescriptionFlag);

    }

    @Then("the event is not exist")
    public void the_event_is_not_exist(int eventNumber) {

        assertFalse(event.SearchEvent(eventNumber));

    }


    @When("the organizer selects the event to delete")
    public void the_organizer_selects_the_event_to_delete(int eventNumber) {

        event.DeletEvent(eventNumber);

    }

    @Then("the event should be successfully deleted")
    public void the_event_should_be_successfully_deleted() {

        assertTrue(EventManagement.deletFlag);
    }

    @When("they select a category such as party or workshop")
    public void they_select_a_category_such_as_party_or_workshop(int eventNumber,int category) {

        event.SelectCategory(eventNumber,category);

    }

    @Then("specific fields tailored to the selected category should be displayed")
    public void specific_fields_tailored_to_the_selected_category_should_be_displayed() {

        assertTrue(EventManagement.setCategoryFlag);
    }
}
