Feature: User Profiles for Event Management and Registration

Scenario: Organizer creates an event
Given the organizer is logged in
And on the "Manage Events" page
When they choose to "Create New Event"
And fill in the event details
And submit the event creation form
Then the event should be created
And visible in the list of events they manage

Scenario: Organizer views participants for an event
Given an event is created by the organizer
And participants have registered for the event
When the organizer selects the event from their "Events" list
And navigates to the "Participants" section
Then they should see a list of participants who have registered

Scenario: Participant registers for an event
Given the participant is logged in
And on the "Event Listings" page
When they find an event they want to attend
And click on the "Register" button for that event
Then they should be registered for the event
And receive confirmation of their registration

Scenario: Participant views registered events
Given a participant is registered for an event
When they navigate to their "Registered Events" page
Then they should see the event listed
And have options to view event details or unregister