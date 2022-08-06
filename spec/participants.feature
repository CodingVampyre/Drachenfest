Feature: managing tickets as participant

  Scenario: creating an account
    Given provided email address is not already taken
    When providing email address and password
    Then a new account should be created

  Scenario: buying a ticket
    Given an account with mail address participant@example exists
    And ticket type Kontingent1 exists
    When the participant submits a buy request
    Then a new ticket should be bound to the participant