Feature: Add New Venues

  Scenario Outline: Adding a New Venue
    Given I am logged in as an organizer
    When I navigate to the “Add New Venue” page
    And I enter '<Venue Name>' in the venue name field
    And I enter '<Location>' in the location field
    And I enter '<Capacity>' in the capacity field
    And I select '<Amenities>' from the amenities options
    And I enter '<Pricing>' in the pricing field
    And When I click on the Submit button
    Then I should see a message '<Venue successfully added>'

    Examples:
      | Venue Name | Location | Capacity | Amenities          | Pricing |
      | Venue A    | Location A | 100     | Audio System, WiFi | 5000    |
      | Venue B    | Location B | 200     | Parking, Catering  | 8000    |

  Scenario: Attempt to Add New Venue Without Mandatory Fields
    Given I am logged in as an organizer
    When I navigate to the “Add New Venue” page
    And I click on the 'Submit' button without entering any details
    Then I should see an error message 'All fields are required'

  Scenario: Adding a Venue With Duplicate Name
    Given the venue 'Venue A' already exists
    When I try to add another venue with the name 'Venue A'
    Then I should see an error message 'Venue name already exists'