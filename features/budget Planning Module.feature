Feature: Budget Planning Module




  Scenario: Organizer finds halls within the budget
    Given the Organizer specifies a rental value by entering 3000
    And the date they want to rent the hall is "2024-01-01"
    When the system searches the database for halls suitable for the information entered
    Then the value of rent must be the value entered and less than it
    And show them to the organizer

  Scenario: Organizer searches for a hall with an unavailable rental value
    Given the Organizer specifies a rental value that is too high or too low
    When the system searches for halls
    Then the system should indicate that no halls are available within the specified budget

  Scenario: Organizer searches for a hall on an unavailable date
    Given the Organizer specifies a date on which no halls are available
    When the system searches for halls
    Then the system should indicate that no halls are available on the specified date
