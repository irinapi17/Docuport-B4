@docuport @B2G1-253 @B2G1-254 @ui @smoke
Feature: Validate Rows Per Page

  Scenario Outline: Change and Validate Rows Per Page on Leads and Users for Supervisor and Advisor
    Given user logs into "<userType>"
    When user clicks "Leads" button
    Then validate Rows Per Page shows "10"
    When user changes Rows Per Page to "5"
    Then validate Rows Per Page shows "5"
    When user clicks "Users" button
    Then validate Rows Per Page shows "10"
    When user changes Rows Per Page to "15"
    Then validate Rows Per Page shows "15"
    Examples:
      | userType   |
      | advisor    |
      | supervisor |

  Scenario: Change and Validate Rows Per Page on Clients and Users for Employee
    Given user logs into "employee"
    When user clicks "Clients" button
    Then validate Rows Per Page shows "10"
    When user changes Rows Per Page to "5"
    Then validate Rows Per Page shows "5"
    When user clicks "Users" button
    Then validate Rows Per Page shows "10"
    When user changes Rows Per Page to "50"
    Then validate Rows Per Page shows "50"




