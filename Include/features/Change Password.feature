@change_password
Feature: All scenario for change password

  @failed_change_password
  Scenario Outline: User failed to change password with invalid data
    Given User is on App Settings page
    When User input <old_password>, <new_password> and <confirmation_password> for change password
    And User save password settings
    Then User failed to change password
    
    Examples: 
      | old_password  | new_password | confirmation_password  | 
      | a 						|     a 			 | a 											| 
      | sehatq123			|     a 			 | a 											|	
      | sehatq123			|  sehatq1234	 | a											|	
      | sehatq123			|  sehatq1234	 | sehatq123							|	
      
	@success_change_password
  Scenario Outline: User success to change password
    Given User is on App Settings page
    When User input <old_password>, <new_password> and <confirmation_password> for change password
    And User save password settings
    Then User success to change password
    
    Examples: 
      | old_password  | new_password | confirmation_password  | 
      | sehatq123			| sehatq123		 | sehatq123							| 