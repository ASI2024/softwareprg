package org.test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import newvenues.Expense;
import newvenues.ExpenseTracker;

import java.util.List;

import static org.junit.Assert.*;
public class ExpenseTrackingandCategorization {
    public ExpenseTracker tracker = new ExpenseTracker();
    private Expense tempExpense;
    private List<String> categories;
    public List<Expense> displayedExpenses;

    @And("I am on the {string} page")
    public void iAmOnThePage(String arg0) {
    }

    @When("I select to add a new expense")
    public void iSelectToAddANewExpense() {
        tempExpense  = new Expense(0, 0, "","");
    }

    @And("I enter the expense details including {string}, {string}, and {string}")
    public void iEnterTheExpenseDetailsIncludingAnd(String amount, String category, String description) {
        tempExpense.setAmount(Double.parseDouble(amount));
        tempExpense.setCategory(category);
        tempExpense.setDescription(description);

    }

    @And("I select {string}")
    public void iSelect(String action) {
        if ("Save Expense".equals(action)) {
            tracker.addExpense( tempExpense.getAmount(),  tempExpense.getCategory(),  tempExpense.getDescription());
        }
    }

    @Then("the new expense should be saved in the system")
    public void theNewExpenseShouldBeSavedInTheSystem() {
        assertFalse(tracker.getExpenses().isEmpty());
    }

    @And("it should be categorized under the selected category")
    public void itShouldBeCategorizedUnderTheSelectedCategory() {
        assertEquals(tempExpense.getCategory(), tracker.getExpenses().get(0).getCategory());

    }

    @And("I have already added expenses in different categories")
    public void iHaveAlreadyAddedExpensesInDifferentCategories() {
        tracker.addExpense(200, "Catering", "Wedding catering");
        tracker.addExpense(500, "Venue", "Wedding venue booking");
        tracker.addExpense(150, "Entertainment", "DJ for wedding");
    }

    @When("I select to view expenses by category")
    public void iSelectToViewExpensesByCategory() {
        categories = tracker.getCategories();
    }

    @Then("I should see a list of categories")
    public void iShouldSeeAListOfCategories() {
        assertNotNull(categories);
        assertFalse(categories.isEmpty());
    }

    @And("selecting a category should display all expenses under that category")
    public void selectingACategoryShouldDisplayAllExpensesUnderThatCategory() {
        displayedExpenses = tracker.getExpensesByCategory("Catering");
        assertFalse(displayedExpenses.isEmpty());
        assertTrue(displayedExpenses.stream().allMatch(expense -> "Catering".equals(expense.getCategory())));

    }

    @When("I select an existing expense to edit")
    public void iSelectAnExistingExpenseToEdit() {
        tracker.addExpense(100, "Venue", "Initial description");
        tempExpense = tracker.getExpenses().get(0);
    }

    @And("I update any of the expense details")
    public void iUpdateAnyOfTheExpenseDetails() {
        tracker.updateExpense(0,150, "Catering", "Updated description");

    }

    @Then("the updated details should be saved in the system")
    public void theUpdatedDetailsShouldBeSavedInTheSystem() {
        Expense updatedExpense = tracker.getExpenses().get(0);
        assertEquals(150, updatedExpense.getAmount(), 0.01);
        assertEquals("Catering", updatedExpense.getCategory());
        assertEquals("Updated description", updatedExpense.getDescription());
    }

    @And("the expense should reflect the updated information")
    public void theExpenseShouldReflectTheUpdatedInformation() {
        Expense updatedExpense = tracker.getExpenses().get(0);
        assertTrue(updatedExpense.getAmount() == 150 && "Catering".equals(updatedExpense.getCategory()) && "Updated description".equals(updatedExpense.getDescription()));

    }

}