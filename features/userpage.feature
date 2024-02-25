Feature: user logged in and see his page
  Scenario: the user wants to see his orders
    Given that the user is logged in
    When he select to see his event
    Then his event will be printed

  Scenario: the user wants to add new order
    Given that the user is logged in
    When he select to add event
    Then the event will added