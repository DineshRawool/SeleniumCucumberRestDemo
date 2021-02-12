package com.framework.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends Base {

    public BasePage() {

        PageFactory.initElements(driver, this);
    }
}
