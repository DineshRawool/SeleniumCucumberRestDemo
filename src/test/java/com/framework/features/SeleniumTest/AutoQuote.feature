Feature: This feature will verify Auto Quote functionality for Insurance Application


  @RegressionTest
  @TC_AutoQuote_01
    Scenario Outline: User Complete Auto Quote
    Given User ensures prerequisite "UI" test set up with test data is ready "<TC ID>"
    When User launch application
    And User login to application with userid and password
    Then Verify user logged in to application successfully
    When User selects "Auto Quote" from the select service menu
    Then User apply for instant auto quote
    Then User Verify the auto quote received

    Examples:
    |TC ID|
    |  TC_AutoQuote_01   |




