Feature: Login Feature
  Verify if user is able to Login in to the site

 Background:
    Given user is  on homepage
    When user navigates to Login Page
  
  @SmokeTest  
  Scenario Outline: Go to MyWishlist
  And user enters username as "<USER_NAME>" and Password as "<PASSWORD>"
    Then success message is displayed
    And Click on My WishLists
    Then LogoutApplication
    Examples: 
      | USER_NAME            | PASSWORD |
      | satish.ceb@gmail.com |    12345 |
      | satish.ceb@gmail.com |    123456 |
      | satish.ceb@gmail.com |    12345 |

@RegressionTest @LoginFuctionality
  Scenario Outline: Go To My Address 2nd
  And user enters username as "<USER_NAME>" and Password as "<PASSWORD>"
    Then success message is displayed
    And Click on My Addresses
    Then LogoutApplication

    Examples: 
      | USER_NAME            | PASSWORD |
      | satish.ceb@gmail.com |    12345 |	