Feature: Practice soft assertions

  @docuport @ui @smoke
  Scenario: Soft assertions practice
    Given user is on Docuport login page
    Then user validates "Login" text is displayed
    And user validates "Forgot password?" text is displayed
    When user enter credentials
      | username | b1g1_client@gmail.com |
      | password | Group1|
    And user validates "Choose account" text is displayed
    Then user chooses account from drop down
    And user clicks "Continue" button
    And user clicks "Home" button
    And user clicks "Invitations" button
    And assert soft assertions