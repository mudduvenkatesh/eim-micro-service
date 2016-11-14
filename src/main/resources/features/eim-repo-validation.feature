Feature: EIM Repo Validation Tests
  Scenario: After Initial Boot of EIM Server
    When EIM Server is booted up and ready
    Then there should be a repository named "EIM"
