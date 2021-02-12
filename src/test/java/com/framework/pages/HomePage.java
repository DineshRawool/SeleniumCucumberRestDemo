package com.framework.pages;

import com.framework.core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(how = How.XPATH, using = "//tr[@class='message-error']")
    WebElement errorMsg;

    @FindBy(how = How.ID, using = "logout-form:logout")
    WebElement btnLogOut;


    //validate error message
    public Boolean validateError()
    {
        Boolean isSuccess = false;
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMsg));

            if (errorMsg.isDisplayed()) {
                isSuccess = true;

                System.out.println("Validation Error Message: "+errorMsg.getText());
            }
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }

        return isSuccess;
    }


    public Boolean isUserOnHomeScreen()
    {
        Boolean isSuccess = false;
        try {
            wait.until(ExpectedConditions.visibilityOf(btnLogOut));

            if (btnLogOut.isDisplayed()) {
                isSuccess = true;


            }
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }

        return isSuccess;
    }

}
