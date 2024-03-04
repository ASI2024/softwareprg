Feature: Organizer Approval and Management of Events

  Scenario: Organizer accepts the addition of a new event
    Given the organizer is logged in
    When the organizer navigates to the dashboard
    And the organizer reviews the pending event addition
    And the organizer approves the addition of the event
    Then the event should be added to the event list
    And the event creator should be notified of acceptance

  Scenario: Organizer rejects the addition of a new event
    Given the organizer is logged in
    When the organizer navigates to the dashboard
    And the organizer reviews the pending event addition
    And the organizer rejects the addition of the event
    Then the event should not be added to the event list
    And the event creator should be notified of the rejection and reason

  Scenario: Organizer accepts the modification of an existing event
    Given the organizer is logged in
    When the organizer navigates to the dashboard
    And the organizer reviews the pending modification
    And the organizer approves the modification
    Then the event should be updated with the new details
    And the organizer should receive a notification of the approval

  Scenario: Organizer rejects the modification of an existing event
    Given the organizer is logged in
    When the organizer navigates to the dashboard
    And the organizer reviews the pending modification
    And the organizer rejects the modification with reason
    Then the event should remain unchanged
    And the event creator should be notified of the rejection and reason

  Scenario: Organizer accepts the deletion of an event
    Given the organizer is logged in
    When the organizer navigates to the dashboard
    And the organizer reviews the pending deletion
    And the organizer approves the deletion
    Then the event should be deleted from the event list
    And the organizer should receive a notification of the deletion


