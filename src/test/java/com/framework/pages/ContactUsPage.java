package com.framework.pages;

import com.framework.core.Base;
import com.framework.core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactUsPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//*[@id='contact']/a")
    WebElement btnContactUs;

    @FindBy(how = How.XPATH, using = "//*[@id='content-main']/h1")
    WebElement formContactUs;

    @FindBy(how = How.ID, using = "autoquote:f1")
    WebElement Title;

    @FindBy(how = How.ID, using = "autoquote:f2")
    WebElement FirstName;

    @FindBy(how = How.ID, using = "autoquote:f3")
    WebElement LastName;

    @FindBy(how = How.ID, using = "autoquote:f5")
    WebElement Address;

    @FindBy(how = How.ID, using = "autoquote:f7")
    WebElement City;

    @FindBy(how = How.ID, using = "autoquote:f8")
    WebElement State;

    @FindBy(how = How.ID, using = "autoquote:f9")
    WebElement PostalCode;

    @FindBy(how = How.ID, using = "autoquote:f10")
    WebElement Telephone;

    @FindBy(how = How.ID, using = "autoquote:f11")
    WebElement ContactEmail;

    @FindBy(how = How.ID, using = "autoquote:f12")
    WebElement Comment;

    @FindBy(how = How.XPATH, using = "//*[@id='autoquote']/fieldset/div[11]/a")
    WebElement btnSubmit;



    //validate error message
    public Boolean isContactUsBtnPresent()
    {
        Boolean isSuccess = false;
        try {
            wait.until(ExpectedConditions.visibilityOf(btnContactUs));

            if (btnContactUs.isDisplayed()) {
                isSuccess = true;

                System.out.println("Contact Us Button Displayed ");
            }
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }

        return isSuccess;
    }

    public void clickonContactUsBtn()
    {
        btnContactUs.click();
    }
    public void updateContactUsQuerry(){

        wait.until(ExpectedConditions.visibilityOf(formContactUs));

        //enter querry form
        Title.sendKeys(Base.TestData.get("Title"));
        FirstName.sendKeys(Base.TestData.get("FirstName"));
        LastName.sendKeys(Base.TestData.get("LastName"));
        Address.sendKeys(Base.TestData.get("Address"));
        City.sendKeys(Base.TestData.get("City"));
        State.sendKeys(Base.TestData.get("State"));
        PostalCode.sendKeys(Base.TestData.get("PostalCode"));
        Telephone.sendKeys(Base.TestData.get("Telephone"));
        ContactEmail.sendKeys(Base.TestData.get("ContactEmail"));
        Comment.sendKeys(Base.TestData.get("Comment"));



    }

    public void submitquerry(){

        //click on submit button

        btnSubmit.click();

        //verify user navigate to home screen

    }

}
