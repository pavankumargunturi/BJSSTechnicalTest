
Feature: HappyPath, Purchase 2 Items

  Background: login into automation practice
    Given login into automation practice

  Scenario: REVIEW PREVIOUS ORDERS AND ADD A MESSAGE
    And   View previous orders
    When  Select an item from your previous order (there will be others – confirm this by date/time) and add a comment
    Then  Confirm that the comment appears under ‘messages’
