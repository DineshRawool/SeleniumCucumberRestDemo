package com.framework.pages;

import com.framework.core.Base;
import com.framework.core.BasePage;
import io.cucumber.plugin.event.Node;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class AutoQuotePage extends BasePage {

    Select select;

    @FindBy(how = How.ID, using = "quick-link:jump-menu")
    WebElement selectService;

    @FindBy(how = How.XPATH, using = "//h1[text()='Automobile Instant Quote']")
    WebElement autoQuoteTitle;

    @FindBy(how = How.ID, using = "autoquote:zipcode")
    WebElement autocotezipcode;

    @FindBy(how = How.ID, using = "autoquote:e-mail")
    WebElement autocotemail;

    @FindBy(how = How.ID, using = "autoquote:vehicle:0")
    WebElement autocoteVehicle;

    @FindBy(how = How.ID, using = "autoquote:next")
    WebElement btnutocoteNext;

    @FindBy(how = How.ID, using = "autoquote:age")
    WebElement autocoteAge;

    @FindBy(how = How.ID, using = "autoquote:gender:0")
    WebElement autocoteGender;

    @FindBy(how = How.ID, using = "autoquote:type:0")
    WebElement autocoteDrivingRecord;

    @FindBy(how = How.ID, using = "autoquote:year")
    WebElement autocoteYear;

    @FindBy(how = How.ID, using = "ext-gen4")
    WebElement autocoteMakeArrow;

    @FindBy(how = How.ID, using = "ext-gen8")
    WebElement autocoteMakeList;

    @FindBy(how = How.ID, using = "ext-gen6")
    WebElement autocoteModelArrow;

    @FindBy(how = How.ID, using = "ext-gen12")
    WebElement autocoteModelList;

    @FindBy(how = How.ID, using = "autoquote:finInfo:0")
    WebElement autocoteFinancialInfo;

    @FindBy(how = How.XPATH, using = "//*[@id='quote-result']/h1[2]")
    WebElement quoteResult;




    public void setSelectService(String option){

        select = new Select(selectService);

        select.selectByVisibleText(option);

    }

    public Boolean isAutoQuotePageDisplayed()
    {
        Boolean isSuccess = false;
        try {
            wait.until(ExpectedConditions.visibilityOf(autoQuoteTitle));

            if (autoQuoteTitle.isDisplayed()) {
                isSuccess = true;
            }
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }

        return isSuccess;
    }

    public void applyInstantAutoQuote() throws InterruptedException {

        //select details
        autocotezipcode.sendKeys(Base.TestData.get("autocotezipcode"));

        autocotemail.sendKeys(Base.TestData.get("autocotemail"));

        //select Car
        autocoteVehicle.click();

        //click on Next
        btnutocoteNext.click();

        wait.until(ExpectedConditions.visibilityOf(autocoteAge));

        autocoteAge.clear();

        autocoteAge.sendKeys(Base.TestData.get("autocoteAge"));

        //click on mail
        autocoteGender.click();

        //driving record excellent
        autocoteDrivingRecord.click();

        //click on next
        btnutocoteNext.click();

        wait.until(ExpectedConditions.visibilityOf(autocoteYear));

        autocoteYear.sendKeys(Base.TestData.get("autocoteYear"));

        //select Make
        autocoteMakeArrow.click();

        wait.until(ExpectedConditions.visibilityOf(autocoteMakeList));

        autocoteMakeList.findElement(By.xpath("div[text()='"+Base.TestData.get("autocoteMake")+"']")).click();

        Thread.sleep(2000);

        //select Model
        autocoteModelArrow.click();

        wait.until(ExpectedConditions.visibilityOf( autocoteModelList));

        autocoteModelList.findElement(By.xpath("div[text()='"+Base.TestData.get("autocoteModel")+"']")).click();

        //own
        autocoteFinancialInfo.click();

        //next
        btnutocoteNext.click();

    }

    public void verifyAutoQuote(){

        wait.until(ExpectedConditions.visibilityOf(quoteResult));

        System.out.println("Final Quote is: "+quoteResult.getText());


    }




}
