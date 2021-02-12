Feature: This feature will verify login functionality for Insurance Application


  @RegressionTest
  @TC_Login_01
    Scenario Outline: login application with valid credentials
    Given User ensures prerequisite "UI" test set up with test data is ready "<TC ID>"
    When User launch application
    And User login to application with userid and password
    Then Verify user logged in to application successfully
    Then User logout application

    Examples:
    |TC ID|
    |  TC_Login_01   |




  @RegressionTest
  @TC_Login_02
  Scenario Outline: login application with invalid credentials
    Given User ensures prerequisite "UI" test set up with test data is ready "<TC ID>"
    When User launch application
    And User login to application with userid and password
    Then Verify application displays validation error


    Examples:
      |TC ID|
      #Invalid Password
      |  TC_Login_02   |
    #Invalid Email id
      |  TC_Login_03   |
    #Black Email and Password
      |  TC_Login_04   |


