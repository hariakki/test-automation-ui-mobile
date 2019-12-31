package com.atcn.bdd.ui.mobile.runners;

import com.atcn.bdd.ui.mobile.core.Driver;
import com.atcn.bdd.ui.mobile.core.reporting.GenCucumberReport;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//    dryRun = true,
//    monochrome = true,
        tags = {"@App-AOS"},
        features = {"src/test/resources/features"},
        glue = {"com.atcn.bdd.ui.mobile.steps", "com.atcn.bdd.ui.mobile.core.hooks"},
        plugin = {
                "pretty",
                "json:target/cucumber-report-json/cucumber-report.json",
                "rerun:target/rerun.txt"
        }
)
public class App_AOS_Runner {

    @AfterClass
    public static void afterClass() {
        Driver.destroyDriver();
        GenCucumberReport.generateReport();
    }
}
