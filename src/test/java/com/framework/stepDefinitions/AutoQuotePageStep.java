package com.framework.stepDefinitions;

import com.framework.pages.AutoQuotePage;
import com.framework.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AutoQuotePageStep {

    AutoQuotePage autoQuotePage = new AutoQuotePage();


    @When("User selects {string} from the select service menu")
    public void user_selects_from_the_select_service_menu(String menu) {

        autoQuotePage.setSelectService(menu);

        autoQuotePage.isAutoQuotePageDisplayed();

    }



    @Then("User apply for instant auto quote")
    public void user_apply_for_instant_auto_quote() throws InterruptedException {
        autoQuotePage.applyInstantAutoQuote();
    }

    @Then("User Verify the auto quote received")
    public void user_Verify_the_auto_quote_received() throws InterruptedException {
        autoQuotePage.verifyAutoQuote();
    }

}
