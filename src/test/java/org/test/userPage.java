package org.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.eventPlaner.Order;
import org.eventPlaner.User;

import java.util.List;

import static org.junit.Assert.*;

public class userPage {
    User user;
    boolean loggedIn = false;
    @Given("that the customer is logged in")
    public void thatTheCustomerIsLoggedIn() {

        User user=new User();
        this.loggedIn = true;
        assertNotNull( user);
    }
    @When("he select to see his orders")
    public void heSelectToSeeHisOrders() {
        assertTrue( loggedIn);
        System.out.println("Retrieving user orders...");
        assertNotNull( user);
    }
    @Then("his orders will be printed")
    public void hisOrdersWillBePrinted() {
        assertNotNull(user.getOrders());
        assertFalse("Orders list should be fetched, even if empty", user.getOrders().isEmpty());
        System.out.println("Orders displayed: " + user.getOrders());
    }

    @When("he select to add order")
    public void heSelectToAddOrder() {
        assertTrue(loggedIn);
        System.out.println("Adding a new order...");
        Order newOrder = new Order();
        user.addOrder((List) newOrder);
    }
    @Then("the order will added")
    public void theOrderWillAdded() {
        assertTrue( user.getOrders().contains(new Order()));


    }

}
