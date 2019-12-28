package com.atcn.bdd.ui.mobile.runners;

import com.atcn.bdd.ui.mobile.core.Driver;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//    dryRun = true,
//    monochrome = true,
    features = {"@target/rerun.txt"},
    glue = {"com.atcn.bdd.ui.mobile.steps", "com.atcn.bdd.ui.mobile.core.hooks"},
    plugin = {
            "pretty",
            "html:target/cucumber",
            "json:target/cucumber-report-json/cucumber-report-rerun.json",
            "rerun:target/rerun.txt"
    }
)
public class FailedScenariosRunner {

    @AfterClass
    public static void afterClass() {
        Driver.destroyDriver();
        GenCucumberReport.generateReport();
    }
}
