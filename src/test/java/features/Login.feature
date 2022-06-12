
Feature: TechFios Billing Login Functionality validation
	
	@logintag
  Scenario: 1 User should be able to login with valid credentials 
    Given User is on the TechFios login page
 		When User enters "username" 
    When User enters "password"
    When User clicks signin button
    Then User should land on the dashboard page
    
   