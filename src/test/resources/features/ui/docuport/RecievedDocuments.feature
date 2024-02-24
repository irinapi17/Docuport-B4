Feature: Received Docs and My Uploads Feature

  @B2G1-245 @B2G1-246 @docuport @ui @smoke
  Scenario Outline: Validate Received Documents and My Uploads for all userTypes
    When user logs into "<userType>"
    And user navigates to "Received docs"
    Then assert search button, download button, and "Received docs" is displayed
    When user navigates to "My uploads"
    Then assert search button, download button, and "My uploads" is displayed
    Examples:
      | userType   |
      | client     |
      | supervisor |
      | advisor    |
      | employee   |

  @B2G1-245 @B2G1-246 @docuport @ui @smoke
  Scenario Outline: Validate Received Documents and My Uploads for all userTypes (CONVERSION)
    When user logs into "<userType>"
#    And the user navigates to "Received docs"
    And user clicks "Received docs" button
#    Then assert search button, download button, and "Received docs" is displayed
    Then user validates "Search" text is displayed
    Then user validates "Download" text is displayed
    Then user assert "Received docs" header text
#    When the user navigates to "My uploads"
    And user clicks "My uploads" button
#    Then assert search button, download button, and "My uploads" is displayed
    Then user validates "Search" text is displayed
    Then user validates "Download" text is displayed
    Then user assert "My uploads" header text
    Examples:
      | userType   |
      | client     |
      | supervisor |
      | advisor    |
      | employee   |