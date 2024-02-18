@B2G1-236 @B2G1-237 @docuport @ui @smoke
Feature: Client creation feature

  Scenario: Validate client creation - personal
    Given user logs into "advisor"
    When user clicks "Clients" button
    And create a personal client
      | Elton               |
      | John                |
      | eltonjohn@gmail.com |
      | 5712345432          |
      | Group1              |
    Then verify new client is created
    And logout
    And user logs into "newly created client"
    Then user validates expected navigation items "[Home, Received docs, My uploads, Invitations]"
    And logout
    And Delete user from the database

  Scenario: Validate client creation - business
    Given user logs into "advisor"
    When user clicks "Clients" button
    And create a business client
      | Donald                |
      | Trump                 |
      | donaldtrump@gmail.com |
      | 4049312523            |
      | Group1                |
      | MAGA Inc.             |
    Then verify new client is created
    And logout
    And user logs into "newly created client"
    Then user validates expected navigation items "[Home, Received docs, My uploads, Invitations, 1099 Form]"
    And logout
    And Delete user from the database





