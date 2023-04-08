Feature: Login feature
  Background:
    Given User is on the Login page

  # The first example has two steps
  @login
  Scenario: User can't be logging using invalid password
    Given User enter valid username "01881234568"
    When User enter invalid password "pass"
    And user click on the log in button
    Then User should see the error message "Incorrect username or password."
    And User should be in the login page

  @sanity
  Scenario: User can't be logging using invalid username
    Given User enter invalid username "018812345682"
    When User enter valid password "pass1234"
    And user click on the log in button
    Then User should see the error message "Please enter a valid phone number."
    And User should be in the login page

  @login
  Scenario Outline:  User can't be logging using invalid credentials
    When User enter username <username>
    And User enter password <password>
    And user click on the log in button
    Then User should see the error message <error_message>
    And User should be in the login page
    Examples:
      | username       |password|error_message                       |
      |"01811111111"   |"pass1"  |"Incorrect username or password."   |
      |"01888888888888"|"pass12"  |"Please enter a valid phone number."|
      |"018666"        |"pass31"  |"Please enter a valid phone number."|
      |"0189999999999" |"pass14"  |"Please enter a valid phone number."|

