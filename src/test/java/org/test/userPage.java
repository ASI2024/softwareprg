package org.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.eventPlaner.User;

import java.util.List;

import static org.junit.Assert.*;

public class userPage {
    User user;
    boolean loggedIn = false;
    @Given("that the user is logged in")
    public void thatTheuserIsLoggedIn() {

        User user=new User();
        this.loggedIn = true;
        assertNotNull( user);
    }
    @When("he select to see his event")
    public void heSelectToSeeHisevent() {
        assertTrue( loggedIn);
        System.out.println("Retrieving user orders...");
        assertNotNull( user);
    }
    @Then("his event will be printed")
    public void hiseventWillBePrinted() {

    }

    @When("he select to add event")
    public void heSelectToAddevent() {

    }
    @Then("the event will added")
    public void theeventWillAdded() {


    }

}
