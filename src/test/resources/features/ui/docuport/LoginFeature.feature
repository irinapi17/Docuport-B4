@B2G1-184 @B2G1-136 @B2G1-137 @B2G1-185
Feature: Docuport Login Logout Feature

  Background:
    Given user is on Docuport login page

  @regression @docuport @ui @smoke
  Scenario Outline: Login and out
    When user enters username for "<userType>"
    And user enters password for "<userType>"
    And user clicks "login" button
    Then user should see the home page for "<userType>"
    When user clicks "user icon" button
    And user clicks "logout" button
    Then the user return to the login page
    Examples:
      | userType   |
      | client     |
      | supervisor |
      | advisor    |
      | employee   |


  @regression @docuport @ui @smoke
  Scenario: Login and out as client
    When user enters username for "client"
    And user enters password for "client"
    And user clicks "login" button
    Then user should see the home page for "client"
    When user clicks "user icon" button
    And user clicks "logout" button
    Then the user return to the login page



#  @smoke @regression
#  Scenario: Login and out as employee
#    When user enters username for "employee"
#    And user enters password for "employee"
#    And user clicks login button
#    Then user should see the home page for "employee"
#    When user clicks the user logo
#    And the user clicks Log out
#    Then the user return to the login page
#
#  @smoke @regression
#  Scenario: Login and out as supervisor
#    When user enters username for "supervisor"
#    And user enters password for "supervisor"
#    And user clicks login button
#    Then user should see the home page for "supervisor"
#    When user clicks the user logo
#    And the user clicks Log out
#    Then the user return to the login page
#
#  @smoke @regression
#  Scenario: Login and out as advisor
#    When user enters username for "advisor"
#    And user enters password for "advisor"
#    And user clicks login button
#    Then user should see the home page for "advisor"
#    When user clicks the user logo
#    And the user clicks Log out
#    Then the user return to the login page
#
#  @datatablemap
#  Scenario: Login as a client map practice
#    When user enter credentials
#      | username | b1g1_client@gmail.com |
#      | password | Group1                |
#    Then user should see the home page



