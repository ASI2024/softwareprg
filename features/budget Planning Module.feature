Feature: Budget Planning Module


  Scenario: Organizer search about hall for rent
    When Organizer enter the value of hall rent
    And the date want to rent the hell
    Then the system search in database about hell that suitable for the information enter
    And the value of rent must be between the value enter that decrease about 999 or increase about 999 only
    And show them for the organizer

  Scenario: Organizer searches for a hall with an unavailable rental value
    Given the Organizer specifies a rental value that is too high or too low
    When the system searches for halls
    Then the system should indicate that no halls are available within the specified budget

  Scenario: Organizer searches for a hall on an unavailable date
    Given the Organizer specifies a date on which no halls are available
    When the system searches for halls
    Then the system should indicate that no halls are available on the specified date
