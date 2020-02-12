Feature: ExcelTry
  Verify if user is able to Login in to the site

  @SmokeTest @Excsel
  Scenario Outline: Go to MyWishlist
    Given CollectDataFromExcel refer "<TestCase>"
    And user is on homepage
    When user navigates to Login Page
    And user enters username and Password
    Then success message is displayed
    And Click on My WishLists
    Then LogoutApplication

    Examples: 
      | TestCase                |
      | LoginWithCorrectID_1    |
      | LoginWithIncCorrectID_1 |
      | LoginWithCorrectID_3    |
	@Excel
  Scenario Outline: Go To My Address
    Given CollectDataFromExcel refer "<TestCase>"
    And user is on homepage
    When user navigates to Login Page
    And user enters username and Password
    Then success message is displayed
    And Click on My Addresses
    Then LogoutApplication

    Examples: 
      | TestCase      |
      | GoToMyAddress |
