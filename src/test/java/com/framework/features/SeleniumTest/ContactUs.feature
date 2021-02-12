Feature: This feature will verify Contact US Screen functionality for Insurance Application


  @RegressionTest
  @TC_ContactUs_01
    Scenario Outline: USer Verify Contact Us Screen Functionality
    Given User ensures prerequisite "UI" test set up with test data is ready "<TC ID>"
    When User launch application
    And User login to application with userid and password
    Then Verify user logged in to application successfully
    When User Click on Details Button
    And User Click on Contact Button
    Then User Enters contact details to send message
    Then User submit querry
    Then Verify User navigate to Home Screen


    Examples:
    |TC ID|
    |  TC_ContactUs_01   |




