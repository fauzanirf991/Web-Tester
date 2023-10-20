@tag1
Feature: Login Functionality
  Scenario: Successful login attempt
    Given User on the login page
    And user fill in the User Name as "standard_user"
    And user fill in the Password as "secret_sauce"
    When user click on the Log In button
    Then user should be redirected to the dashboard page


  Scenario: unsuccessful login attempt
    Given User on the login page
    And user fill in the User Name as "locked_out_user"
    And user fill in the Password as "secret_sauce"
    When user click on the Log In button
    Then user get a message "Epic sadface: Sorry, this user has been locked out."