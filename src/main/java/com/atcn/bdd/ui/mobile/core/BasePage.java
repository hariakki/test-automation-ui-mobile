package com.atcn.bdd.ui.mobile.core;

import com.atcn.bdd.ui.mobile.core.helpers.WaitHelper;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends WaitHelper {

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
