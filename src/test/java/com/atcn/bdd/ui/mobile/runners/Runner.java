package com.atcn.bdd.ui.mobile.runners;

import com.atcn.bdd.ui.mobile.core.Driver;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

//        dryRun = true,

        tags = {"@AndroidNative-1"},
        features = {"src/test/resources/features"},
        glue = {"com.atcn.bdd.ui.mobile.steps", "com.atcn.bdd.ui.mobile.core.hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber",
                "json:target/cucumber-report-json/cucumber-report.json"
        }
)
public class Runner {

    @AfterClass
    public static void afterClass() {
        System.out.println("++++++++++++++++++++++++++++++++ AfterClass Destroying Driver...");
        Driver.destroyDriver();
    }
}