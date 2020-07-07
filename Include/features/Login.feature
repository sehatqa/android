@login
Feature: All scenario for login

  @success_login
  Scenario Outline: User success login with valid credentials
    Given User is on login page
    When User input <email> and <password> for login
    Then User success login

    Examples: 
      | email                     | password  |
      | testangga21+and@gmail.com | sehatq123 |

  @failed_login
  Scenario Outline: User success login with invalid credentials
    Given User is on login page
    When User input <email> and <password> for login
    Then User failed to login and <error_message> will displayed

    Examples: 
      | email                     | password | error_message                        |
      |                           |          | Masukkan email yang valid            |
      | testangga21               |          | Masukkan email yang valid            |
      | testangga21+and@gmail.com |          | Password must be filled in correctly |
      | testangga21+and@gmail.com | a        | Password minimal 6 karakter          |
