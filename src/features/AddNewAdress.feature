Feature: Add new address

  Scenario: Add another address to user's account
    Given User is logged in to My Store Shop
    When User goes to AddressPage
    And User click to create new address
    And User fill in alias, address, city, zip/postal code/country/phone
    And User saves information
    Then User sees "Address successfully added!"
    Then User check if address is added

#
#    Examples:
#    |alias| address| city| zip/postal code|country|phone|