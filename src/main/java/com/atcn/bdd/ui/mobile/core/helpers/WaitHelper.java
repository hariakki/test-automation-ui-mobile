package com.atcn.bdd.ui.mobile.core.helpers;

import com.atcn.bdd.ui.mobile.core.Driver;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public abstract class WaitHelper {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected AppiumDriver driver = Driver.launchAppiumDriver();

    protected WebDriver webDriver = Driver.launchWebDriver();

    protected void waitFluentVisibilityOfElm(WebElement element) {
        logger.debug("Fluent wait element: " + element);
        if (driver != null) {
            Wait wait = new FluentWait(driver)
                    .withTimeout(Duration.ofSeconds(60))
                    .pollingEvery(Duration.ofSeconds(1))
                    .ignoring(Exception.class);
            wait.until(ExpectedConditions.visibilityOf(element));
        } else if (webDriver != null) {
            Wait wait = new FluentWait(webDriver)
                    .withTimeout(Duration.ofSeconds(60))
                    .pollingEvery(Duration.ofSeconds(1))
                    .ignoring(Exception.class);
            wait.until(ExpectedConditions.visibilityOf(element));
        }

    }
}
