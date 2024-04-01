package org.test;

import eventPlaner.Event;
import eventPlaner.EventManagement;
import eventPlaner.OrganizerLogin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EventSteps {


    EventManagement event = new EventManagement();
    OrganizerLogin organizerLogin = new OrganizerLogin();
    LocalDate d= Date.valueOf("2024-05-14").toLocalDate();
    LocalTime t= Time.valueOf("10:30:35").toLocalTime();
    LocalDate dn= Date.valueOf("2024-11-10").toLocalDate();
    LocalTime tn= Time.valueOf("8:20:00").toLocalTime();
    Event e =new Event(985123,d,t,"nablus","party","DJ",null);
    @Given("organizer is logged in")
    public void organizer_is_logged_in() {

        organizerLogin.Login("example@gmail.com","123456");

    }
    @When("they navigate to the event creation page")
    public void they_navigate_to_the_event_creation_page() {



    }
    @When("they fill in the required details including date, time, location, theme, and description")
    public void they_fill_in_the_required_details_including_date_time_location_theme_and_description() {

        event.AddEvent(e);

    }
    @Then("the event should be successfully created")
    public void the_event_should_be_successfully_created() {

        assertTrue (EventManagement.addFlag);

    }


    @Given("there exists an event")
    public void there_exists_an_event() {

        event.SearchEvent(985123);

    }

    @When("the organizer search for an event")
    public void the_organizer_search_for_an_event() {


        event.SearchEvent(985123);
    }

    @Then("the event is exist")
    public void the_event_is_be_exist() {


        assertTrue (event.SearchEvent(985123));
    }
    @When("the organizer selects the date event to edit")
    public void the_organizer_selects_the_date_event_to_edit() {


        event.EditDate(985123,dn);

    }

    @Then("the date event should be successfully updated")
    public void the_date_event_should_be_successfully_updated() {

        assertTrue (EventManagement.editDateFlag);
    }

    @When("the organizer selects the time event to edit")
    public void the_organizer_selects_the_time_event_to_edit() {


        event.EditTime(985123,tn);

    }

    @Then("the time event should be successfully updated")
    public void the_time_event_should_be_successfully_updated() {

        assertTrue (EventManagement.editTimeFlag);
    }

    @When("the organizer selects the location event to edit")
    public void the_organizer_selects_the_location_event_to_edit() {


        event.EditLocation(985123,"Ramallah");


    }

    @Then("the location event should be successfully updated")
    public void the_location_event_should_be_successfully_updated() {

        assertTrue(EventManagement.editLocationFlag);

    }

    @When("the organizer selects the theme event to edit")
    public void the_organizer_selects_the_theme_event_to_edit() {


        event.EditTheme(985123,"Birthdate");


    }

    @Then("the theme event should be successfully updated")
    public void the_theme_event_should_be_successfully_updated() {

        assertTrue(EventManagement.editLocationFlag);

    }

    @When("the organizer selects the description event to edit")
    public void the_organizer_selects_the_description_event_to_edit() {


        event.EditDescription(985123,"lunch meal");


    }

    @Then("the description event should be successfully updated")
    public void the_description_event_should_be_successfully_updated() {

        assertTrue(EventManagement.editDescriptionFlag);

    }



    @When("the organizer selects the event to delete")
    public void the_organizer_selects_the_event_to_delete() {

        event.DeletEvent(985123);

    }

    @Then("the event should be successfully deleted")
    public void the_event_should_be_successfully_deleted() {

        assertTrue(EventManagement.deletFlag);
    }

    @When("they select a category such as party or workshop")
    public void they_select_a_category_such_as_party_or_workshop() {

        event.SelectCategory(985123,2);

    }

    @Then("specific fields tailored to the selected category should be displayed")
    public void specific_fields_tailored_to_the_selected_category_should_be_displayed() {

        assertFalse(EventManagement.setCategoryFlag);
    }
}
