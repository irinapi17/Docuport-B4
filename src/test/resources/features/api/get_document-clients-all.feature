Feature: Get /api/v1/document/clients/all

  @smoke @api
  Scenario: Get /api/v1/document/clients/all and assert index 0
    Given accept type is Json and adviser sends GET request to "/api/v1/document/clients/all"
    Then status code is "200" and content type is "application/json; charset=utf-8"
    And body index 0 matches data:
      | id         | 1948    |
      | name       | $randomName |
      | clientType | 1     |
      | isActive   | true  |
      | advisor    | null  |