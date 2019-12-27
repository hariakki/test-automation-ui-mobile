package com.atcn.bdd.ui.mobile.core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public abstract class BasePage {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected AppiumDriver driver = Driver.launchDriver();

    protected BasePage() {
        logger.info("++++++++++++++++++++++++++++++++ Running automation type is: " + Driver.getAutomationType());
        if (Driver.getAutomationType().equalsIgnoreCase("Android")
                || Driver.getAutomationType().equalsIgnoreCase("IOS")) {
            PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);

        } else if (Driver.getAutomationType().equalsIgnoreCase("Web")) {
            PageFactory.initElements(this.driver, this);

        } else {
            System.out.println("++++++++++++++++++++++++++++++++ No matching automation type");
        }

    }


}
