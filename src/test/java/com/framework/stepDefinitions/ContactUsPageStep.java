package com.framework.stepDefinitions;

import com.framework.pages.AutoQuotePage;
import com.framework.pages.ContactUsPage;
import com.framework.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsPageStep {

    ContactUsPage contactUsPage = new ContactUsPage();
    LoginPage loginPage = new LoginPage();

    @When("User Click on Details Button")
    public void user_click_on_details_button() {

        //click on details
        loginPage.clickonDetails();

        //verify Contact Us button displayed
        contactUsPage.isContactUsBtnPresent();

    }

    @When("User Click on Contact Button")
    public void user_click_on_contact_button() {
        contactUsPage.clickonContactUsBtn();

    }

    @Then("User Enters contact details to send message")
    public void user_enters_contact_details_to_send_message() {

        contactUsPage.updateContactUsQuerry();

    }

    @Then("User submit querry")
    public void user_submit_querry() {
        contactUsPage.submitquerry();


    }


}
