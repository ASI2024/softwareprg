package org.test;

import BudgetingandFinance.Hall;
import BudgetingandFinance.HallRepositoryImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

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

    @When("Organizer enter the value of hall rent")
    public void organizerEnterTheValueOfHallRent() {
        this.specifiedRent =2000;
    }
    @When("the date want to rent the hell")
    public void theDateWantToRentTheHell(){
        try {
            this.specifiedDate = new SimpleDateFormat("yyyy-MM-dd").parse("2024-01-01"); // Default or predefined date
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Then("the system search in database about hell that suitable for the information enter")
    public void theSystemSearchInDatabaseAboutHellThatSuitableForTheInformationEnter() {
        this.searchResults = hallRepository.findHallsByCriteria(specifiedRent, specifiedDate);
    }

    @Then("the value of rent must be between the value enter that decrease about {int} or increase about {int} only")
    public void the_value_of_rent_must_be_between_the_value_enter_that_decrease_about_or_increase_about_only(Integer int1, Integer int2) {
        assertTrue("Search results should not be empty", !searchResults.isEmpty());
        for (Hall hall : searchResults) {
            assertTrue("Rent should be within the specified range",
                    hall.getRent() >= (specifiedRent - int1) && hall.getRent() <= (specifiedRent + int2));
        }
    }

    @Then("show them for the organizer")
    public void show_them_for_the_organizer() {
        assertFalse("Results should be displayed to the Organizer", searchResults.isEmpty());
        // You might print out hall details here for real application scenarios or handle UI interactions.
        for (Hall hall : searchResults) {
            System.out.println("Available Hall: " + hall.getName() + ", Rent: " + hall.getRent());
        }
    }

    @Then("the halls should be available on the specified date")
    public void the_halls_should_be_available_on_the_specified_date() {
        for (Hall hall : searchResults) {
            Assert.assertEquals("Hall should be available on the specified date",
                    specifiedDate, hall.getAvailableDate());
        }
    }

    @Then("the results should be displayed to the Organizer")
    public void the_results_should_be_displayed_to_the_organizer() {
        Assert.assertNotNull("Results should not be null", searchResults);
        assertFalse("Results should not be empty", searchResults.isEmpty());
        // Here you could add more detailed checks, like logging each hall's details
    }

    @Given("the Organizer specifies a rental value that is too high or too low")
    public void the_organizer_specifies_a_rental_value_that_is_too_high_or_too_low() {
        // Assuming the value is set beyond normal ranges to ensure no halls will match
        this.specifiedRent = 100000; // Change this value based on what "too high" or "too low" means for your application
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

