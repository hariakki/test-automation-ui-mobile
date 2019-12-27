package com.atcn.bdd.ui.mobile.runners;

import com.atcn.bdd.ui.mobile.core.Driver;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

//        dryRun = true,

        tags = {"@Mobile-1"},
        features = {"src/test/resources/features"},
        glue = {"com.atcn.bdd.ui.mobile.steps", "com.atcn.bdd.ui.mobile.core.hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber",
                "json:target/cucumber-report-json/cucumber-report.json"
        }
)
public class MobileRunner {

    @AfterClass
    public static void afterClass() {
        Driver.destroyDriver();
    }
}
