Feature: validate left navigate items of docuport

#  @US# @B2G1-225 @B2G1-226
#  Scenario: Login and validate the left navigation items for all user types

#    Then validate the left navigation items for each user type
#      | client     | [Home, Received docs, My uploads, Invitations]                                                                 |
#      | supervisor | [Home, Received docs, My uploads, Clients, Users, Leads, Bookkeeping, 1099 Form, Reconciliations]              |
#      | advisor    | [Home, Received docs, My uploads, Clients, Invitations, Users, Leads, Bookkeeping, 1099 Form, Reconciliations] |
#      | employee   | [Home, Received docs, My uploads, Clients, Users, Bookkeeping, 1099 Form, Reconciliations]                     |


  @US# @B2G1-225 @B2G1-226 @docuport @ui
  Scenario Outline: Login and validate the left navigation items
    When user logs into "<userType>"
    Then user validates expected navigation items "<ExpectedLeftNavigation>"
    Then logout
    Examples:
      | userType   | ExpectedLeftNavigation                                                                                         |
      | client     | [Home, Received docs, My uploads, Invitations]                                                      |
      | supervisor | [Home, Received docs, My uploads, Clients, Users, Leads, Bookkeeping, 1099 Form, Reconciliations]              |
      | advisor    | [Home, Received docs, My uploads, Clients, Invitations, Users, Leads, Bookkeeping, 1099 Form, Reconciliations] |
      | employee   | [Home, Received docs, My uploads, Clients, Users, Bookkeeping, 1099 Form, Reconciliations]                     |