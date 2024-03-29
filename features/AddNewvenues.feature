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

