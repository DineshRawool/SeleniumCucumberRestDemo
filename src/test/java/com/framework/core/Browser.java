package com.framework.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class Browser {


    public static WebDriver getBrowser(BrowserType browserType){

            WebDriver driver = null;
            DesiredCapabilities capabilities;

            switch (browserType) {
                case CHROME:
                        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\driversetup\\chromedriver.exe");
                        //set Chrome Capabilities
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("start-maximized");
                        //options.addArguments("--headless");

                        capabilities = DesiredCapabilities.chrome();
                        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

                        options.merge(capabilities);

                        driver = new ChromeDriver(options);
                        break;

                case FIREFOX:
                        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\driversetup\\geckodriver.exe");

                        FirefoxProfile profile = new FirefoxProfile();
                        profile.setPreference("javascript.enabled", true);

                        capabilities = DesiredCapabilities.firefox();
                        capabilities.setCapability("marionette", true);
                        capabilities.setCapability(FirefoxDriver.PROFILE, profile);

                        FirefoxOptions fxoptions = new FirefoxOptions();
                        fxoptions.merge(capabilities);

                        driver = new FirefoxDriver(fxoptions);
                        break;

            }

            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Long.parseLong(Base.config.getProperty("impliciteWaitTime")), TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(Long.parseLong(Base.config.getProperty("pageLoadTWaitTime")), TimeUnit.SECONDS);
            driver.manage().window().maximize();

            return driver;
        }

    }

