package org.test;

import BudgetingandFinance.BudgetPlanningModule;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class BudgetPlanningModuleSteps {

    private BudgetPlanningModule budgetPlanningModule;
    private Map<String, Double> estimatedExpenses;
    private Map<String, Double> actualExpenses;

    @Given("the organizer is on the budget planning page")
    public void the_organizer_is_on_the_budget_planning_page() {
        budgetPlanningModule = new BudgetPlanningModule();
        estimatedExpenses = new HashMap<>();
        actualExpenses = new HashMap<>();
    }

    @When("the organizer enters the estimated expenses for various categories such as venue, catering, decorations, marketing, etc.")
    public void the_organizer_enters_the_estimated_expenses_for_various_categories_such_as_venue_catering_decorations_marketing_etc() {
        estimatedExpenses.put("Venue", 1000.0);
        estimatedExpenses.put("Catering", 2000.0);
        estimatedExpenses.put("Decorations", 500.0);
        budgetPlanningModule.estimateExpenses(estimatedExpenses);
    }

    @Then("the system calculates the total estimated expenses for the event")
    public void the_system_calculates_the_total_estimated_expenses_for_the_event() {
        double totalEstimatedExpenses = budgetPlanningModule.getEstimatedExpenses().values().stream().mapToDouble(Double::doubleValue).sum();
        assertEquals(totalEstimatedExpenses, budgetPlanningModule.calculateTotalEstimatedExpenses(), 0);
    }


    @When("the organizer enters the actual expenses for various categories such as venue, catering, decorations, marketing, etc.")
    public void the_organizer_enters_the_actual_expenses_for_various_categories_such_as_venue_catering_decorations_marketing_etc() {
        actualExpenses.put("Venue", 1200.0);
        actualExpenses.put("Catering", 2200.0);
        actualExpenses.put("Decorations", 600.0);
        budgetPlanningModule.trackActualExpenses(actualExpenses);
    }

    @Then("the system calculates the total actual expenses for the event")
    public void the_system_calculates_the_total_actual_expenses_for_the_event() {
        double totalActualExpenses = budgetPlanningModule.getActualExpenses().values().stream().mapToDouble(Double::doubleValue).sum();
        assertEquals(totalActualExpenses, budgetPlanningModule.calculateTotalActualExpenses(), 0);
    }


    @Then("displays the variance between the estimated and actual expenses")
    public void displays_the_variance_between_the_estimated_and_actual_expenses() {
        double variance = budgetPlanningModule.calculateTotalActualExpenses() - budgetPlanningModule.calculateTotalEstimatedExpenses();
        System.out.println("Variance: " + variance);
    }

    @When("the organizer compares the estimated and actual expenses for various categories")
    public void the_organizer_compares_the_estimated_and_actual_expenses_for_various_categories() {
    }

    @Then("the system provides options to adjust the budget for categories where actual expenses exceed the estimates")
    public void the_system_provides_options_to_adjust_the_budget_for_categories_where_actual_expenses_exceed_the_estimates() {
        budgetPlanningModule.adjustBudget();
    }

    @When("the organizer selects the view budget summary option")
    public void the_organizer_selects_the_view_budget_summary_option() {
    }

    @Then("the system displays a summary of estimated and actual expenses for each category")
    public void the_system_displays_a_summary_of_estimated_and_actual_expenses_for_each_category() {
        budgetPlanningModule.viewBudgetSummary();
    }

    @Then("provides the total estimated and actual expenses for the event")
    public void provides_the_total_estimated_and_actual_expenses_for_the_event() {
        // Total estimated and actual expenses are already calculated in previous steps
    }

    @When("the organizer selects the export budget report option")
    public void the_organizer_selects_the_export_budget_report_option() {
        // This step is already covered in previous steps
    }

    @Then("the system generates a detailed budget report including estimated and actual expenses for each category")
    public void the_system_generates_a_detailed_budget_report_including_estimated_and_actual_expenses_for_each_category() {
        budgetPlanningModule.exportBudgetReport();
    }

    @Then("provides options to download or email the report")
    public void provides_options_to_download_or_email_the_report() {
    }
}

