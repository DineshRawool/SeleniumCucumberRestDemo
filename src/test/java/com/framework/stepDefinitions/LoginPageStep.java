package com.framework.stepDefinitions;

import com.framework.core.Base;
import com.framework.pages.LoginPage;
import com.framework.utilities.ExcelUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;

public class LoginPageStep {

    LoginPage login = new LoginPage();

    ExcelUtil excelUtil;


    @Given("User ensures prerequisite test set up with test data is ready {string}")
    public void user_ensures_prerequisite_test_set_up_with_test_data_is_ready(String testCase) throws IOException {

        //read test data
        String TestDataPath = Base.config.getProperty("InsuranceTestData");

        excelUtil = new ExcelUtil(TestDataPath);

        Base.TestData = excelUtil.getExcelData("Insurance", testCase);


    }

    @Given("User ensures prerequisite {string} test set up with test data is ready {string}")
    public void user_ensures_prerequisite_test_set_up_with_test_data_is_ready(String testType, String testCase) throws IOException {

        //read test data
        String TestDataPath = null;

        if(testType.equalsIgnoreCase("UI")) {

            TestDataPath = Base.config.getProperty("InsuranceTestData");

            excelUtil = new ExcelUtil(TestDataPath);

            Base.TestData = excelUtil.getExcelData("Insurance", testCase);
        }
        else if(testType.equalsIgnoreCase("API"))
        {
            TestDataPath = Base.config.getProperty("APITestData");

            excelUtil = new ExcelUtil(TestDataPath);

            Base.TestData = excelUtil.getExcelData("API", testCase);
        }

    }

    @When("User launch application")
    public void user_launch_application() {

        Generic.launchApplication(Base.config.getProperty("AppURL"));

    }

    @When("User login to application with userid and password")
    public void user_login_to_application_with_userid_and_password() {
        login.LoginToApplication(Base.TestData.get("Email"), Base.TestData.get("PWD"));

    }

    @Then("Verify user logged in to application successfully")
    public void verify_user_logged_in_to_application_successfully() {

        Assert.assertTrue("User log in failed", login.isLoginSuccessful());

       /* if (login.isLoginSuccessful())
        {
            System.out.println("User logged in to application successfully");
        }
        else
        {
            System.out.println("User log in failed");
        }*/

    }


    @Then("User logout application")
    public void user_logout_application() {
        login.logOutApplication();
    }



}
