package com.atcn.bdd.ui.debug;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DebugTest {

    AppiumDriver appiumDriver;

    @Before
    public void setup() throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus5API26_A80");
        cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
        cap.setCapability(MobileCapabilityType.NO_RESET, true);
        cap.setCapability(MobileCapabilityType.FULL_RESET, false);
        cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

        appiumDriver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
    }

    @Test
    public void test() {

        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        appiumDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        appiumDriver.get("https://cn.bing.com/");

        // Page Factory init elements
        BingSearchCommonPage bingSearchCommonPage = new BingSearchCommonPage(appiumDriver);

        // Elements actions started...
        Wait wait = new WebDriverWait(appiumDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(bingSearchCommonPage.getSearchTextField()));
        bingSearchCommonPage.getSearchTextField().sendKeys("github");

        wait.until(ExpectedConditions.visibilityOf(bingSearchCommonPage.getSearchBTN()));
        bingSearchCommonPage.getSearchBTN().click();

    }

    @After
    public void teardown() {
        appiumDriver.quit();
    }
}
