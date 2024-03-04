package org.test;

import eventPlaner.Organizer;
import eventPlaner.OrganizerLogin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OrganizerLoginAndRegistration {

    Organizer organizer;
    OrganizerLogin organizerLogin;

    @Given("the user is on the registration page")
    public void the_user_is_on_the_registration_page() {


    }

    @When("the user fills in the registration form with valid information")
    public void the_user_fills_in_the_registration_form_with_valid_information() {

       organizer = new Organizer("example987@gmail.com","os12112","osama","nablus","123456789","Waiting");

    }

    @When("the user submits the registration form")
    public void the_user_submits_the_registration_form() {

        organizerLogin.Registration("example987@gmail.com","os12112","osama","nablus","123456789","Waiting");


    }

    @Then("the user should be registered successfully")
    public void the_user_should_be_registered_successfully() {

        assertTrue(organizerLogin.RegistrationFlag);

    }

    @Given("the organizer is on the login page")
    public void the_organizer_is_on_the_login_page() {


    }

    @Given("there is an existing organizer with the email  and password")
    public void there_is_an_existing_organizer_with_the_email_and_password() {



    }

    @When("the organizer enters valid information and submits the login form")
    public void the_organizer_enters_valid_information_and_submits_the_login_form() {

        organizerLogin.Login("example987@gmail.com","os12112");

    }

    @Then("the organizer should be redirected to the dashboard")
    public void the_organizer_should_be_redirected_to_the_dashboard() {

        assertTrue(organizerLogin.Login("example987@gmail.com","os12112"));

    }


    @Given("there is no existing organizer with the email")
    public void there_is_no_existing_organizer_with_the_email() {


    }

    @When("the organizer enters invalid email or password")
    public void the_organizer_enters_invalid_email_or_password() {

        organizerLogin.Login("example@gmail.com","os12112");

    }

    @Then("the user should see an error message indicating invalid email or password")
    public void the_user_should_see_an_error_message_indicating_invalid_email_or_password() {

        assertFalse(organizerLogin.Login("example987@gmail.com","os12112"));

    }


}
