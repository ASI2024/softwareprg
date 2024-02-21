package org.test;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.eventPlaner.User;

import static org.junit.Assert.assertTrue;

public class Login {
    User user=new User();
//    @Given("user trying to login")
//    public void user_trying_to_login() {
//osama

//    }
    @When("user name and password are right {string} {string}")
    public void user_name_and_password_are_right(String string, String string2) {
        user.login(string,string2);
    }

    @Then("Login")
    public void login() {
 assertTrue (User.loginFlag);

    }
}
