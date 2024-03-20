Feature: Event Creation and Management

  Scenario: Organizers can create a new event
    Given  organizer is logged in
    When they navigate to the event creation page
    And they fill in the required details including date, time, location, theme, and description
    Then the event should be successfully created

  Scenario: Organizers can edit an existing event
    Given the organizer is logged in
    When the organizer search for an event
    Then the event is exist
    When the organizer selects the date event to edit
    Then the date event should be successfully updated
    When the organizer selects the time event to edit
    Then the time event should be successfully updated
    When the organizer selects the location event to edit
    Then the location event should be successfully updated
    When the organizer selects the theme event to edit
    Then the theme event should be successfully updated
    When the organizer selects the description event to edit
    Then the description event should be successfully updated


  Scenario: Organizers can delete an existing event
    Given the organizer is logged in
    And there exists an event
    When the organizer selects the event to delete
    Then the event should be successfully deleted

  Scenario: Events have different categories with specific fields
    Given the organizer is logged in
    When they navigate to the event creation page
    And they select a category such as party or workshop
    Then specific fields tailored to the selected category should be displayed