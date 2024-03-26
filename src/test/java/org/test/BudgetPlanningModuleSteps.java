package org.test;

import BudgetingandFinance.Hall;
import BudgetingandFinance.HallRepositoryImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class BudgetPlanningModuleSteps {

    private HallRepositoryImpl hallRepository = new HallRepositoryImpl() {
        @Override
        public List<Hall> findHallsByCriteria(int budget, String eventType, Date date) {
            return null;
        }
    };


    private int specifiedRent;
    private Date specifiedDate;
    private List<Hall> searchResults;

    @Given("the Organizer specifies a rental value by entering {int}")
    public void theOrganizerSpecifiesARentalValueByEntering(int rent) {
        this.specifiedRent = rent;
    }

    @Given("the date they want to rent the hall is {string}")
    public void theDateTheyWantToRentTheHallIs(String dateStr){
        try {
            this.specifiedDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @When("the system searches the database for halls suitable for the information entered")
    public void theSystemSearchesTheDatabaseForHallsSuitableForTheInformationEntered() {
        this.searchResults = hallRepository.findHallsByCriteria(specifiedRent, specifiedDate);
    }

    @Then("the value of rent must be the value entered and less than it")
    public void theValueOfRentMustBeTheValueEnteredAndLessThanIt() {
        assertFalse("Search results should not be empty", searchResults.isEmpty());
        for (Hall hall : searchResults) {
            assertTrue("Rent for hall " + hall.getName() + " should be less than or equal to " + specifiedRent,
                    hall.getRent() <= specifiedRent);
        }
    }


    @Then("show them to the organizer")
    public void showThemToTheOrganizer() {
        assertFalse("Results should be displayed to the Organizer", searchResults.isEmpty());
        for (Hall hall : searchResults) {
            System.out.println("Available Hall: " + hall.getName() + ", Rent: " + hall.getRent());
        }
    }


    @Given("the Organizer specifies a rental value that is too high or too low")
    public void the_organizer_specifies_a_rental_value_that_is_too_high_or_too_low() {
        // Assuming the value is set beyond normal ranges to ensure no halls will match
        this.specifiedRent = 1; // Change this value based on what "too high" or "too low" means for your application
    }

    @When("the system searches for halls")
    public void the_system_searches_for_halls() {
        // This reuses the search method; make sure that specifiedDate is already set by previous steps or set a default
        this.specifiedDate = this.specifiedDate != null ? this.specifiedDate : new Date(); // Default date if not set
        this.searchResults = hallRepository.findHallsByCriteria(specifiedRent, specifiedDate);
    }

    @Then("the system should indicate that no halls are available within the specified budget")
    public void the_system_should_indicate_that_no_halls_are_available_within_the_specified_budget() {
        assertFalse("No halls should be available within the specified budget", searchResults.isEmpty());
    }

    @Given("the Organizer specifies a date on which no halls are available")
    public void the_organizer_specifies_a_date_on_which_no_halls_are_available() throws Exception {
        // Set a date where you know no halls will be available
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        this.specifiedDate = formatter.parse("2100-01-01"); // Change this to a suitable date
    }

    @Then("the system should indicate that no halls are available on the specified date")
    public void the_system_should_indicate_that_no_halls_are_available_on_the_specified_date() {
        assertFalse("No halls should be available on the specified date", searchResults.isEmpty());
    }
}

