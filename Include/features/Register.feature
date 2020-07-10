@register
Feature: All scenario for register by email
  I want to use this template for my feature file

  @success_register
  Scenario Outline: User success register with valid credential
    Given User is on register page
    When User input <name>, <email> and <password> for register
    And check term & condition
    And click on lanjutkan button
    Then User success register
    
    Examples: 
      | name  | email												| password  |
      | tikay |	tikay_aut_1@mailinator.com	| sehatq123 |
      
      
  @failed_register
  Scenario Outline: User failed register with invalid credentials
    Given User is on register page
    When User input <name>, <email> and <password> for register
    And check term & condition
    And click on lanjutkan button
    Then User failed to register and <error_message> will displayed

    Examples: 		
			|name		| email                    	 	| password | error_message                       			|
      |				|                          	 	|          | Name must be filled in correct       		|
      |	tikay	|               							|          | Masukkan email yang valid           			|
      |	tikay	| tikay												|          | Masukkan email yang valid								|
      |	tikay	| tikay_auth_1@mmailinator.com| 	       | Password must be filled in correctly 		|
      |	tikay	| tikay_auth_1@mmailinator.com| 	  1    | Password minimal 6 karatakter 						|
      |	tikay	| tika@sehatq.com							|test123   | Email sudah ada, mohon gunakan eamil lain|
  