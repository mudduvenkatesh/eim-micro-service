Feature: EIM Rest Access Tests
  Scenario: client makes call to GET /repositories
    When the client calls /repositories
    Then the client receives status code of 200
    And the client receives server repository list at least 1
    And there is a repository by name "System"