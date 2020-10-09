Feature: Change user login after login

  Scenario: Change user birthday date, gender and sign up for a newsletter1
    Given User is logged in to CodersLab shop1
    When User goes to UserInformationPage1
    And User signs up for our newsletter1
    And User saves information1
    Then User sees1 "Information successfully updated."