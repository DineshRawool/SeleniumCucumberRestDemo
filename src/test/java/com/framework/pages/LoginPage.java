package com.framework.pages;

import com.framework.core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(how = How.ID, using = "login-form:email")
    WebElement txtEmail;

    @FindBy(how = How.ID, using = "login-form:password")
    WebElement txtPassword;

    @FindBy(how = How.ID, using = "login-form:login")
    WebElement btnLogin;

    @FindBy(how = How.ID, using = "logout-form:logout")
    WebElement btnLogOut;

    @FindBy(how = How.ID, using = "logout-form:details")
    WebElement btnDetails;


    //login application
    public void LoginToApplication(String userName, String passWord)
    {
        txtEmail.sendKeys(userName);
        txtPassword.sendKeys(passWord);
        btnLogin.click();
        System.out.println("User logged in to Application");


    }

    public Boolean isLoginSuccessful()
    {
        Boolean isSuccess = false;
        try {
            wait.until(ExpectedConditions.visibilityOf(btnDetails));

            if (btnDetails.isDisplayed()) {
                isSuccess = true;
            }
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }

        return isSuccess;
    }

    //logout application
    public void logOutApplication(){

        try {
            wait.until(ExpectedConditions.visibilityOf(btnLogOut));
            btnLogOut.click();
            System.out.println("User is logged out");

        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }

    }

    public void clickonDetails()
    {
        btnDetails.click();

    }


}
