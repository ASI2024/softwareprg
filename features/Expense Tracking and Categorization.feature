Feature: Expense Tracking and Categorization


  Scenario Outline: Categorizing and tracking a new expense
    Given I am logged in as an organizer
    And I am on the "Expense Tracking" page
    When I select to add a new expense
    And I enter the expense details including '<amount>', '<category>', and '<description>'
    And I select "Save Expense"
    Then the new expense should be saved in the system
    And it should be categorized under the selected category
    Examples:
      | amount | category      | description          |
      | 100.50 | Entertainment | DJ for annual party  |
      | 250.00 | Catering      | Food for the meeting |
      | 300.00 | Venue Rental  | Conference hall fee  |

  Scenario: Viewing expenses by category
    Given I am logged in as an organizer
    And I have already added expenses in different categories
    When I select to view expenses by category
    Then I should see a list of categories
    And selecting a category should display all expenses under that category

  Scenario: Updating an expense
    Given I am logged in as an organizer
    And I am on the "Expense Tracking" page
    When I select an existing expense to edit
    And I update any of the expense details
    And I select "Update Expense"
    Then the updated details should be saved in the system
    And the expense should reflect the updated information

  Scenario: Deleting an expense
    Given I am logged in as an organizer
    And I am on the "Expense Tracking" page
    When I select an existing expense to delete
    And I confirm the deletion
    Then the expense should be removed from the system
    And it should no longer appear in any category or list