package com.atcn.bdd.ui.mobile.core.hooks;

import com.atcn.bdd.ui.mobile.core.Driver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScenarioHook {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before
    public void setup(Scenario scenario) {
        logger.info("Scenario before hook starting...");
    }

    @After()
    public void teardown(Scenario scenario) {
        logger.info("Scenario after hook starting...");

        if (Driver.getAutomationType().equalsIgnoreCase("Web")) {

            if (scenario.isFailed()) {
                scenario.write("Current URL is: \n" + Driver.getWebDriver().getCurrentUrl());
            }

            logger.info("Capturing Web screenshot...");
            final byte[] screenshot = ((TakesScreenshot) Driver.getWebDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");

            logger.info("Web Driver quiting...");
            Driver.getWebDriver().quit();

        } else if (Driver.getAutomationType().equalsIgnoreCase("Android")
                || Driver.getAutomationType().equalsIgnoreCase("IOS")) {

            logger.info("Capturing Mobile screenshot...");
            final byte[] screenshot = Driver.getAppiumDriver().getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
    }
}
