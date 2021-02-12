package com.framework.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = {"src/test/java/com/framework/features/"},
            glue = {"com.framework.stepDefinitions"},
            tags =  "@TC_Login_01",
            dryRun = false
    )

    public class TestRunner {
}
