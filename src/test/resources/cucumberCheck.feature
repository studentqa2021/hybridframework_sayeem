
@HybridFramework
Feature: HybridFramework
  

  @Filling_form
  Scenario: checking automation-practice-form
    Given Open browser
    And Go to URL
    When put first name
    And put last name
    And put email
    And select gender
    And put mobile number
    And put DateOfBirth
    And put subjects
    And put hobbies
    And select picture
    And put current address
    And select state
    And select city
    Then click submit
    And teardown browser