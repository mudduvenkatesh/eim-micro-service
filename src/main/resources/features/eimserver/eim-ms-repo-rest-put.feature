Feature: EIM Rest Put Test for new Repository
Scenario: client makes call to POST /createRepository
    When the client calls POST /createRepository with "TEST1" and "Test Repository"
    And  there is a new repository by name "TEST1"