@tag2
Feature: User add a product to cart
  Scenario: Successful add a product to cart
    Given user on the login page 2
    And user enters valid credentials "standard_user"
    And user click on the Log In button 2
    And inventory page opened
    When user click on add to cart button a product
    Then product added to cart

  Scenario: Unsuccessful add a product to cart
    Given user on the login page 2
    And user enters valid credentials "problem_user"
    And user click on the Log In button 2
    And inventory page opened
    When user click on add to cart button a product
    Then product not added to cart
