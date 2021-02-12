package com.framework.core;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/*This call will be serve as Parent class and will be dedicated to initialize framework*/
public class Base {

    private static List<WebDriver> driverpool = new ArrayList<WebDriver>();

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Properties config = new Properties();
    public FileInputStream fis;
    //public Logger log = Logger.getLogger(Base.class);
    public static HashMap<String, String> TestData;

    //@Before
    public void initializeFramework(){

        //read properties file
        try{
            fis = new FileInputStream("src/test/resources/config/Config.properties");
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.out.println("Config File not found");
        }

        //load config file
        try {
            config.load(fis);
            System.out.println("Configuration file loaded...!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }


        //if driver is not initialized then initialize the driver
        if((driver == null || driver.toString().contains("null")) )
        {
            driver = Browser.getBrowser(BrowserType.valueOf(config.getProperty("Browser").toUpperCase()));

            wait = new WebDriverWait(driver, Long.parseLong(Base.config.getProperty("WebDriverWait")));

            driverpool.add(driver);
        }


    }

    public void configureLogger(){
        //configure config file

    }




    /*//override getDriver method
    WebDriver getDriver(BrowserType browserType)
    {
        driver = Browser.getBrowsser(browserType);

        driverpool.add(driver);

        return driver;
    }*/

   // @After
    public void quitDrivers(){

        for (WebDriver driver:driverpool)
        {
            driver.quit();
            driver=null;
        }

    }
}
