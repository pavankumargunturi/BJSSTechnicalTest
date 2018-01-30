

Feature: HappyPath, Purchase 2 Items

  Background: login into automation practice
    Given login into automation practice

  Scenario: HappyPath, Purchase 2 Items
    And  Quick view an item
    And  Change the size of the item
    And  Add that item to your baske
    And  Continue shopping
    And  Quick view a different item (leave the size at the default
    And  Add that item to your basket
    When View the basket and confirm that the items are of the size you selected, that their prices are correct, that Total Products is the sum of the two items and that ‘Total’ equals the Total Products + Shipping
    Then Proceed through checkout to payment (complete by wire)
    And  Logout from automation practice