Feature: Login
#  Background: Login page
#    Given user trying to login


    Scenario Outline: successful Login
      When user name and password are right '<userName>' '<password>'
      Then Login

        Examples:
          |userName| password|
          |abboushi| 123 |
          |osama| 5 |
