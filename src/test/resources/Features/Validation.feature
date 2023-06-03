Feature: Validating the title

  Scenario: Validating the title of Dashboard
    Given Open URL
    And Enter Username
    Then Enter Password
    And Click on login
    Then verify the title
    And close browser
