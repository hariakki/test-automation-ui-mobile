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
                scenario.write("FAILED URL is: \n" + Driver.getWebDriver().getCurrentUrl());
            }
            logger.info("Capturing Web screenshot...");
            final byte[] screenshot = ((TakesScreenshot) Driver.getWebDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");

            logger.info("Web Driver quiting...");
            Driver.getWebDriver().quit();

        } else if (Driver.getAutomationType().equalsIgnoreCase("Android")
                && Driver.isAutomationMobileBrowserToggle()) {
            if (scenario.isFailed()) {
                scenario.write("FAILED URL is: \n" + Driver.getAndroidDriver().getCurrentUrl());
            }
            logger.info("Capturing Android browser screenshot...");
            final byte[] screenshot = Driver.getAndroidDriver().getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");

            logger.info("Android browser Driver quiting...");
            Driver.getAndroidDriver().quit();

        } else if (Driver.getAutomationType().equalsIgnoreCase("Android")
                && !Driver.isAutomationMobileBrowserToggle()) {
            logger.info("Capturing Android app screenshot...");
            final byte[] screenshot = Driver.getAndroidDriver().getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");

            // None browser driver will be quit on AfterClass.

        } else if (Driver.getAutomationType().equalsIgnoreCase("IOS")
                && Driver.isAutomationMobileBrowserToggle()) {
            if (scenario.isFailed()) {
                scenario.write("FAILED URL is: \n" + Driver.getIosDriver().getCurrentUrl());
            }
            logger.info("Capturing IOS browser screenshot...");
            final byte[] screenshot = Driver.getIosDriver().getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");

            logger.info("IOS browser Driver quiting...");
            Driver.getIosDriver().quit();
        } else if (Driver.getAutomationType().equalsIgnoreCase("IOS")
                && !Driver.isAutomationMobileBrowserToggle()) {
            logger.info("Capturing IOS app screenshot...");
            final byte[] screenshot = Driver.getIosDriver().getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");

            // None browser driver will be quit on AfterClass.
        }
    }
}
