Feature: managing the Drachenfest

  Scenario: creating a ticket type
    Given an organization account exists
    When a new ticket type is submitted
    Then the new ticket type should be listed
