Feature: This feature is used to test different REST API actions and validate response

  @RegressionTest
  @TC_APITest_01
    Scenario Outline: POST Action > REGISTER > SUCCESSFUL
    Given User ensures prerequisite "API" test set up with test data is ready "<TC ID>"
    When User Post request to register
    Then Verify response status code is "200"
    And Verify response
    And Verify user register successful

    Examples:
    |TC ID|
    |TC_APITest_01|


