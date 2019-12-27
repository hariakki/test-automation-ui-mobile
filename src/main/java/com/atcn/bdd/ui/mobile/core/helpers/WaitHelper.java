package com.atcn.bdd.ui.mobile.core.helpers;

import com.atcn.bdd.ui.mobile.core.Driver;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public abstract class WaitHelper {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected AppiumDriver driver = Driver.launchDriver();

    protected void waitFluentVisibilityOfElm(WebElement element) {
        org.openqa.selenium.support.ui.Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(Exception.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
