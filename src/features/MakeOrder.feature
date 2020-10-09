Feature: Make order

  Scenario: Add 5 sweaters to cart and make a order
    Given User is logged in to Store Shop
    When User click into sweater
    And Select size "L"
    And Select quantity, add to cart and proceed to checkout "5"
    Then Take the order screenshot





