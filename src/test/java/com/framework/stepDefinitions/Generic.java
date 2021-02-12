package com.framework.stepDefinitions;

import com.framework.core.Base;

public class Generic extends Base {

    public static void launchApplication(String url)
    {
        driver.get(url);
        System.out.println("USer launch application...!!!");
    }
}
