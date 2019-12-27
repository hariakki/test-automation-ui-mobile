package com.atcn.bdd.ui.mobile.core;

import com.atcn.bdd.ui.mobile.core.springConfig.data.YAMLConfigStatic4AOS;
import com.atcn.bdd.ui.mobile.core.springConfig.data.YAMLConfigStatic4IOS;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URL;

@Component
public class Driver {

    @Value("${appPackage}")
    private void setAppPackage(String appPackage) {
        Driver.appPackage = appPackage;
    }

    @Value("${appActivity}")
    public void setAppActivity(String appActivity) {
        Driver.appActivity = appActivity;
    }


    @Value("${automation.type}")
    public void setAutomationType(String automationType) {
        Driver.automationType = automationType;
    }
    // Additional getter for BasePage usage
    public static String getAutomationType() {
        return automationType;
    }

    @Value("${automation.appiumServer}")
    public void setAutomamationAppiumUrl(String automamationAppiumUrl) {
        Driver.automamationAppiumUrl = automamationAppiumUrl;
    }

    @Value("${automation.seleniumGridServer}")
    public void setAutomationSeleniumGridUrl(String automationSeleniumGridUrl) {
        Driver.automationSeleniumGridUrl = automationSeleniumGridUrl;
    }

    private static String appPackage;
    private static String appActivity;

    private static String automationType;
    private static String automamationAppiumUrl;
    private static String automationSeleniumGridUrl;

    private static AppiumDriver driver;

    private static final Logger logger = LoggerFactory.getLogger(Driver.class);

    public static AppiumDriver launchDriver() {

        if (driver == null) {
            logger.info("++++++++++++++++++++++++++++++++ Null Driver. Creating...");
            if (automationType.equalsIgnoreCase("Android")) {
                Driver.initAndroidDriver();
            } else if (automationType.equalsIgnoreCase("ios")) {
                Driver.initIOSDriver();
            }
        } else {
            logger.info("++++++++++++++++++++++++++++++++ Driver Existed. Return exist...");
        }

        return driver;
    }

    public static AppiumDriver initAndroidDriver() {

        try {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, YAMLConfigStatic4AOS.getDeviceName());
            cap.setCapability(MobileCapabilityType.UDID, YAMLConfigStatic4AOS.getUdid());
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, YAMLConfigStatic4AOS.getPlatformName());
            cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, YAMLConfigStatic4AOS.getPlatformVersion());
            cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, YAMLConfigStatic4AOS.getNewCMDTimeout());
            cap.setCapability(MobileCapabilityType.NO_RESET, YAMLConfigStatic4AOS.isNoReset());
            cap.setCapability(MobileCapabilityType.FULL_RESET, YAMLConfigStatic4AOS.isFullReset());

            cap.setCapability("appPackage", appPackage);
            cap.setCapability("appActivity", appActivity);

            URL server = new URL(automamationAppiumUrl);

            driver = new AppiumDriver(server, cap);

        } catch (Exception e) {
            System.out.println("//////////////////////////////// Exception cause:" + e.getCause());
            System.out.println("//////////////////////////////// Exception message:" + e.getMessage());
        }

        return driver;
    }

    public static AppiumDriver initIOSDriver() {
        try {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, YAMLConfigStatic4IOS.getDeviceName());
            cap.setCapability(MobileCapabilityType.UDID, YAMLConfigStatic4IOS.getUdid());
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, YAMLConfigStatic4IOS.getPlatformName());
            cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, YAMLConfigStatic4IOS.getPlatformVersion());
            cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, YAMLConfigStatic4IOS.getNewCMDTimeout());
            cap.setCapability(MobileCapabilityType.NO_RESET, YAMLConfigStatic4IOS.isNoReset());
            cap.setCapability(MobileCapabilityType.FULL_RESET, YAMLConfigStatic4IOS.isFullReset());

            cap.setCapability("appPackage", appPackage);
            cap.setCapability("appActivity", appActivity);

            URL server = new URL(automamationAppiumUrl);

            driver = new AppiumDriver(server, cap);

        } catch (Exception e) {
            System.out.println("//////////////////////////////// Exception cause:" + e.getCause());
            System.out.println("//////////////////////////////// Exception message:" + e.getMessage());
        }

        return driver;
    }

    public static void destroyDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            logger.info("++++++++++++++++++++++++++++++++ Destroying Driver...");
        }
    }

    public static AppiumDriver getDriver() {
        return driver;
    }

}
