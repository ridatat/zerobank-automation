
Feature: Navigating to specific accounts in Accounts Activity

  Scenario Outline: Account redirect
    Given the user is logged in
    When the user clicks on "<link>" link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have "<option>" selected

    Examples:
    |link       |option     |
    |Savings    |Savings    |
    |Brokerage  |Brokerage  |
    |Checking   |Checking   |
    |Credit Card|Credit Card|
    |Loan       |Loan       |


