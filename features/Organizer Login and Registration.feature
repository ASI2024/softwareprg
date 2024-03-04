Feature: Organizer Login and Registration

  Scenario: User registers for a new organizer account
    Given the user is on the registration page
    When the user fills in the registration form with valid information
    And the user submits the registration form
    Then the user should be registered successfully

  Scenario: organizer logs in with valid email and password
    Given the organizer is on the login page
    And there is an existing organizer with the email  and password
    When the organizer enters valid information and submits the login form
    Then the organizer should be redirected to the dashboard


  Scenario: organizer logs in with invalid email or password
    Given the organizer is on the login page
    And there is no existing organizer with the email
    When the organizer enters invalid email or password
    Then the user should see an error message indicating invalid email or password