package com.framework.stepDefinitions;

import com.framework.pages.HomePage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class HomePageStep {

    HomePage homePage = new HomePage();

    @Then("Verify application displays validation error")
    public void verify_application_displays_validation_error() {

        Assert.assertTrue("Validation Error Message No Displayed", homePage.validateError());


    }

    @Then("Verify User navigate to Home Screen")
    public void verify_User_navigate_to_Home_Screen() {

        if(homePage.isUserOnHomeScreen()){
            System.out.println("User Successfully Navigated to Home Screen");
        }
        else
        {
            System.out.println("Contact Us Querry Submission failed");
        }

    }

}
