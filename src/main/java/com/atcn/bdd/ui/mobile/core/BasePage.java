package com.atcn.bdd.ui.mobile.core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public abstract class BasePage {

    protected AndroidDriver androidDriver = Driver.launchAndroidDriver();

    protected IOSDriver iOSDriver = Driver.launchIOSDriver();

    protected WebDriver webDriver = Driver.launchWebDriver();

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected BasePage() {
        logger.info("Running automation type is: " + Driver.getAutomationType());
        if (Driver.getAutomationType().equalsIgnoreCase("Android")) {
            logger.info("Android Capabilities are: \n" + Driver.getAndroidDriver().getCapabilities().toString());
            PageFactory.initElements(new AppiumFieldDecorator(this.androidDriver), this);

        } else if (Driver.getAutomationType().equalsIgnoreCase("IOS")) {
            logger.info("IOS Capabilities are: \n" + Driver.getIosDriver().getCapabilities().toString());
            PageFactory.initElements(new AppiumFieldDecorator(this.iOSDriver), this);

        } else if (Driver.getAutomationType().equalsIgnoreCase("Web")) {
            /**
             * Use AppiumFieldDecorator for better compatible with multiple types of elements
             *
             * If not import the appium-io package, then use below PO init way without AppiumFieldDecorator
             * PageFactory.initElements(this.webDriver, this);
             */
            PageFactory.initElements(new AppiumFieldDecorator(this.webDriver), this);

        } else {
            logger.error("No matching any automation type");
        }
    }

    protected void waitFluentVisibilityOfElm(WebElement element) {
        logger.debug("Fluent wait element: " + element);
        if (androidDriver != null) {
            Wait wait = new FluentWait(androidDriver)
                    .withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofSeconds(1))
                    .ignoring(Exception.class);
            wait.until(ExpectedConditions.visibilityOf(element));
        } else if(iOSDriver != null) {
            Wait wait = new FluentWait(iOSDriver)
                    .withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofSeconds(1))
                    .ignoring(Exception.class);
            wait.until(ExpectedConditions.visibilityOf(element));
        } else if (webDriver != null) {
            Wait wait = new FluentWait(webDriver)
                    .withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofSeconds(1))
                    .ignoring(Exception.class);
            wait.until(ExpectedConditions.visibilityOf(element));
        }

    }

}
