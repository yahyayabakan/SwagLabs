Feature: Testing API Calls
  In this feature API CRUD will be tested

  Scenario: User calls web service to get all persons
    When user retrieves the all persons
    Then all persons status code should be 200
    And all persons response includes the total 12

  Scenario: User calls web service to get one person
    When user retrieves one person id 1
    Then one person status code should be 200
    And one person response includes firstName "George", lastName "Bluth"

  Scenario: User calls web service to get invalid person
    When user retrieves one person id 23
    Then one person status code should be 404
