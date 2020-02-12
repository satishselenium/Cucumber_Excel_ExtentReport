Feature: Logindups Feature
  Verify if user is able to Login in to the site
	
	
	@SmokeTest 
  Scenario Outline: Login as valid user
    Given user is  on homepage
    When user navigates to Login Page
    And user enters username as "<USER_NAME>" and Password as "<PASSWORD>"
    Then success message is displayed
    Then LogoutApplication

    Examples: 
      | USER_NAME            | PASSWORD |
      | satish.ceb@gmail.com |    12345 |
