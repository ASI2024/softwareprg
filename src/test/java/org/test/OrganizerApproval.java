package org.test;

import eventPlaner.OrganizerLogin;
import eventPlaner.OrganizerManagement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class OrganizerApproval {
    OrganizerManagement organizerManagement = new OrganizerManagement();
    OrganizerLogin organizerLogin = new OrganizerLogin();

    @Given("the organizer is logged in")
    public void the_organizer_is_logged_in() {

        organizerLogin.Login("example@gmail.com","123456");
    }

    @When("the organizer navigates to the dashboard")
    public void the_organizer_navigates_to_the_dashboard() {

    }

    @When("the organizer reviews the pending event addition")
    public void the_organizer_reviews_the_pending_event_addition() {

        organizerManagement.reviewsThePendingEventAddition();

    }

    @When("the organizer approves the addition of the event")
    public void the_organizer_approves_the_addition_of_the_event() {

        organizerManagement.acceptAddEvent(123456);
    }

    @Then("the event should be added to the event list")
    public void the_event_should_be_added_to_the_event_list() {

assertEquals("The Event Was Added Successfully", organizerManagement.acceptAddEvent(123456));
    }

    @Then("the event creator should be notified of acceptance")
    public void the_event_creator_should_be_notified_of_acceptance() {

assertEquals("The Event Was Added Successfully", organizerManagement.acceptAddEvent(123456));

    }

    @When("the organizer rejects the addition of the event")
    public void the_organizer_rejects_the_addition_of_the_event() {

        organizerManagement.rejectAddEvent(123456,"The Location Entered is Incorrect");
    }

    @Then("the event should not be added to the event list")
    public void the_event_should_not_be_added_to_the_event_list() {

assertEquals("The Event Was Rejected Successfully", organizerManagement.rejectAddEvent(123456, "The Location Entered is Incorrect"));
    }

    @Then("the event creator should be notified of the rejection and reason")
    public void the_event_creator_should_be_notified_of_the_rejection_and_reason() {
assertEquals("The Event Was Rejected Successfully", organizerManagement.rejectAddEvent(123456, "The Location Entered is Incorrect"));

    }

    @When("the organizer reviews the pending modification")
    public void the_organizer_reviews_the_pending_modification() {

        organizerManagement.reviewsThePendingModification();
    }

    @When("the organizer approves the modification")
    public void the_organizer_approves_the_modification() {

        organizerManagement.acceptModification(123456);
    }

    @Then("the event should be updated with the new details")
    public void the_event_should_be_updated_with_the_new_details() {

assertEquals("The Update Was Accepted Successfully", organizerManagement.acceptModification(123456));
    }

    @Then("the organizer should receive a notification of the approval")
    public void the_organizer_should_receive_a_notification_of_the_approval() {

assertEquals("The Update Was Accepted Successfully", organizerManagement.acceptModification(123456));
    }

    @When("the organizer rejects the modification with reason")
    public void the_organizer_rejects_the_modification_with_reason() {

        organizerManagement.rejectModification(123456,"The Theme Entered is Incorrect");
    }

    @Then("the event should remain unchanged")
    public void the_event_should_remain_unchanged() {

assertEquals("Modification Was Rejected Successfully", organizerManagement.rejectModification(123456, "The Theme Entered is Incorrect"));
    }

    @When("the organizer reviews the pending deletion")
    public void the_organizer_reviews_the_pending_deletion() {

        organizerManagement.reviewsThePendingDeletion();

    }

    @When("the organizer approves the deletion")
    public void the_organizer_approves_the_deletion() {

        organizerManagement.acceptDeletEvent(123456);
    }

    @Then("the event should be deleted from the event list")
    public void the_event_should_be_deleted_from_the_event_list() {
        assertEquals("The Event Was Deleted Successfully", organizerManagement.acceptDeletEvent(123456));
    }

    @Then("the organizer should receive a notification of the deletion")
    public void the_organizer_should_receive_a_notification_of_the_deletion() {

      assertEquals("The Event Was Deleted Successfully", organizerManagement.acceptDeletEvent(123456));

    }

}
