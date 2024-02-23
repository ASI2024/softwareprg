package org.test;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.eventPlaner.Admin;
import org.eventPlaner.Service;
import org.eventPlaner.UserService;

import static org.junit.Assert.*;

public class Ref {
    private String registrationStatus;
    private String loginStatus;

    @When("the user fills all in the registration form with valid details")
    public void the_user_fills_all_in_the_registration_form_with_valid_details() {
        registrationStatus = UserService.registerUser("Abdelrahman@gmail.com", "Abdelrahman", "Jenin", "0548739226", "123456");

    }

    @Then("the user should be successfully registered")
    public void the_user_should_be_successfully_registered() {
        // Write code here that turns the phrase above into concrete actions
        assertEquals("User registered successfully", registrationStatus);

    }

    @When("the user Not fills all in the registration form")
    public void the_user_not_fills_all_in_the_registration_form() {
        // Write code here that turns the phrase above into concrete actions
        registrationStatus = UserService.registerUser("Abdelrahman@gmail.com", "", "Jenin", "0548739226", "123456");
    }

    @Then("should show please fill all informations")
    public void should_show_please_fill_all_informations() {
        // Write code here that turns the phrase above into concrete actions
        assertEquals("User registered successfully", registrationStatus);
    }

    @When("the user enters their email and password Valid {string},{string}")
    public void the_user_enters_their_email_and_password_valid(String email, String password) {
        UserService userService = new UserService();
         loginStatus = userService.login(email, password);
    }


    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        // Write code here that turns the phrase above into concrete actions
        assertEquals("User logged in successfully", loginStatus);
    }

    @When("the user enters their email or password notValid")
    public void the_user_enters_their_email_or_password_not_valid() {
        loginStatus = UserService.login("Abdelrahman@gmail.com", "1234");

    }

    @Then("check the email or password is notValid")
    public void check_the_email_or_password_is_not_valid() {
        assertEquals("User logged in successfully", loginStatus);
    }

    @When("the admin fills in the registration form with valid details")
    public void the_admin_fills_in_the_registration_form_with_valid_details() {
        registrationStatus = Admin.registerAdmin("admin@admin.com","admin","nablus","123456");

    }

    @Then("the admin should be successfully registered")
    public void the_admin_should_be_successfully_registered() {
        assertEquals("Admin registered successfully", registrationStatus);
    }

    @When("the admin Not fills all valid details")
    public void the_admin_not_fills_all_valid_details() {
        registrationStatus = Admin.registerAdmin("","admin","nablus","123456");
    }


    @When("the admin enters their username and password {string},{string}")
    public void the_admin_enters_their_username_and_password(String emailAdmin, String adminPassword) {
        loginStatus = Admin.login("admin@admin.com ","123456");
    }

    @Then("the admin should be logged in successfully")
    public void the_admin_should_be_logged_in_successfully() {
        assertEquals("Admin logged in successfully", loginStatus);
    }


    @When("the admin enters NotValid username and password")
    public void the_admin_enters_not_valid_username_and_password() {
        loginStatus = UserService.login("A@gmail.com", "123456");
    }

    @Then("show please check your email and password")
    public void show_please_check_your_email_and_password() {
        assertEquals("Admin logged in successfully", loginStatus);
    }

    @When("the service fills all field form with valid details")
    public void the_service_fills_all_field_form_with_valid_details() {
        registrationStatus = Service.registerService(" Abd@gm.com" ,     "Abd "     , "Jenin" ,  "kharobah" ,"flowerDesigner", "0548739226" ,"123456");

    }

    @Then("the service should be successfully Registration")
    public void the_service_should_be_successfully_registration() {
        assertEquals("Service registered successfully", registrationStatus);
    }


    @When("the service Not fills all field form")
    public void the_service_not_fills_all_field_form() {
        registrationStatus = Service.registerService(" Abd@gm.com" ,     " "     , "" ,  "kharobah" ,"flowerDesigner", "0548739226" ,"123456");

    }



    @When("the service enters their username and password {string},{string}")
    public void the_service_enters_their_username_and_password(String email, String password) {
        loginStatus = Service.login(email,password);
    }

    @Then("the service should be logged in successfully")
    public void the_service_should_be_logged_in_successfully() {
        assertEquals("Service logged in successfully", loginStatus);
    }


    @When("the service enters NotValid username and password")
    public void the_service_enters_not_valid_username_and_password() {
        loginStatus = Service.login("A@gmail.com", "123456");

    }




}
