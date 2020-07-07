Feature: All scenario for logout

  Scenario: User success logout
    Given User is on App Settings page
    When User tap logout button
    And User confirm to logout
    Then User success logout
