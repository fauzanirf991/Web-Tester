Feature: Login Functionality
  Scenario: Successful login attempt
    Given User on the login page
    And user fill in the User Name as "standar-user"
    And user fill in the Password as "secret_sauce"
    When user click on the Log In button
    Then user get a message "Login Success"


  Scenario: unsuccessful login attempt
    Given User on the login page
    And user fill in the User Name as "locked_out_user"
    And user fill in the Password as "secret_sauce"
    When user click on the Log In button
    Then user get a message "Invalid username/password"