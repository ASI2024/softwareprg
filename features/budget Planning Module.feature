Feature: Budget Planning Module

  Scenario: Organizer estimates expenses for an event
    Given the organizer is on the budget planning page
    When the organizer enters the estimated expenses for various categories such as venue, catering, decorations, marketing, etc.
    Then the system calculates the total estimated expenses for the event

  Scenario: Organizer tracks actual expenses for an event
    Given the organizer is on the budget planning page
    When the organizer enters the actual expenses for various categories such as venue, catering, decorations, marketing, etc.
    Then the system calculates the total actual expenses for the event
    And displays the variance between the estimated and actual expenses

  Scenario: Organizer adjusts budget based on actual expenses
    Given the organizer is on the budget planning page
    When the organizer compares the estimated and actual expenses for various categories
    Then the system provides options to adjust the budget for categories where actual expenses exceed the estimates

  Scenario: Organizer views budget summary
    Given the organizer is on the budget planning page
    When the organizer selects the view budget summary option
    Then the system displays a summary of estimated and actual expenses for each category
    And provides the total estimated and actual expenses for the event

  Scenario: Organizer exports budget report
    Given the organizer is on the budget planning page
    When the organizer selects the export budget report option
    Then the system generates a detailed budget report including estimated and actual expenses for each category
    And provides options to download or email the report
