Feature: Service Provider (Organizer/Vendor) Management

  Scenario  Viewing a database of vendors
    Given the organizer is logged in
    And the organizer wants to find vendors for their event
    When the organizer navigates to the "Vendors" section
    Then they should see a list of vendors
    And each vendor should be categorized by type and service


  Scenario: Searching and filtering vendors
    Given the organizer is logged in
    And the organizer is on the "Vendors" section
    When the organizer applies filters based on location, availability, pricing, and reviews
    Then they should see a list of vendors that match the criteria

  Scenario: Requesting a package from a vendor
    Given the organizer is logged in
    And the organizer has found a preferred vendor
    When they select the vendor and choose to "Request Package"
    Then they should be able to specify their needs and send a request to the vendor

  Scenario: Negotiating contracts with a vendor
    Given the organizer is logged in
    And the organizer has requested a package from a vendor
    And the vendor has responded with an offer
    When the organizer chooses to "Negotiate Contract"
    Then they should be able to communicate with the vendor to discuss terms

  Scenario: Managing vendor bookings
    Given the organizer is logged in
    And the organizer has finalized a contract with a vendor
    When they navigate to the "My Bookings" section
    Then they should see their booked vendors
    And they should be able to manage these bookings, including updating or cancelling