Feature: Addition

  # Inputs represented as datatable and are supplied as examples
  Scenario: Sum of two numbers
    #firstNumber | secondNumber |
    # When user executes sum function
    Given I open Facebook URL and create new accounts with below data
      | First Name | Last Name | Phone No   | Password | DOB Day | DOB Month | DOB Year | Gender |
      | Abc FN     | Abc LN    | 0123123123 | Pass1234 |      01 | Jan       |     1990 | Male   |
      | Def FN     | Def LN    | 0456456456 | Abcd1234 |      01 | Feb       |     1990 | Female |
      | Xyz FN     | Xyz LN    | 0789789789 | Pass2018 |      01 | Mar       |     1990 | Female |

  #Examples:
  #| firstNumber | secondNumber | result |
  #| 10          | 20           | 30     |
  #| 50          | 50           | 100    |
  #Scenario Outline: Cucumber Data Table
  #Given Table with example
  #| FirstName  | <FirstName>  |
  #| MiddleName | <MiddleName> |
  #| LastName   | <LastName>   |
  #Examples:
  #| FirstName | MiddleName | LastName |
  #| Priyank   | B          | Shah     |
  #| Mansi     | P          | Shah     |
  Scenario: practice
    Given I fill in some personal data
      | Job  | jp  |
      | Name | skn |
