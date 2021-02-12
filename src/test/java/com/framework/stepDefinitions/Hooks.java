package com.framework.stepDefinitions;

import com.framework.core.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Base {

    public static Scenario scenario;

    @Before
    public void setupTestExecution()
    {
        System.out.println("In Before");

        new Base().initializeFramework();

    }


    @After
    public void closeTestExecution()
    {
        System.out.println("In After");

        new Base().quitDrivers();

    }


}
