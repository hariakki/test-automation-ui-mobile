package com.atcn.bdd.ui.mobile.core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Value("${capability.android.deviceName}")
    public void setAos_deviceName(String aos_deviceName) {
        Driver.aos_deviceName = aos_deviceName;
    }

    @Value("${capability.android.udid}")
    public void setAos_udid(String aos_udid) {
        Driver.aos_udid = aos_udid;
    }

    @Value("${capability.android.platformName}")
    public void setAos_platformName(String aos_platformName) {
        Driver.aos_platformName = aos_platformName;
    }

    @Value("${capability.android.platformVersion}")
    public void setAos_platformVersion(String aos_platformVersion) {
        Driver.aos_platformVersion = aos_platformVersion;
    }

    @Value("${capability.android.newCMDTimeout}")
    public void setAos_newCMDTimeout(long aos_newCMDTimeout) {
        Driver.aos_newCMDTimeout = aos_newCMDTimeout;
    }

    @Value("${capability.android.noReset}")
    public void setAos_isNoReset(boolean aos_isNoReset) {
        Driver.aos_isNoReset = aos_isNoReset;
    }

    @Value("${capability.android.fullReset}")
    public void setAos_isFullReset(boolean aos_isFullReset) {
        Driver.aos_isFullReset = aos_isFullReset;
    }


    @Value("${capability.ios.deviceName}")
    public void setIos_deviceName(String ios_deviceName) {
        Driver.ios_deviceName = ios_deviceName;
    }

    @Value("${capability.ios.udid}")
    public void setIos_udid(String ios_udid) {
        Driver.ios_udid = ios_udid;
    }

    @Value("${capability.ios.platformName}")
    public void setIos_platformName(String ios_platformName) {
        Driver.ios_platformName = ios_platformName;
    }

    @Value("${capability.ios.platformVersion}")
    public void setIos_platformVersion(String ios_platformVersion) {
        Driver.ios_platformVersion = ios_platformVersion;
    }

    @Value("${capability.ios.newCMDTimeout}")
    public void setIos_newCMDTimeout(long ios_newCMDTimeout) {
        Driver.ios_newCMDTimeout = ios_newCMDTimeout;
    }

    @Value("${capability.ios.noReset}")
    public void setIos_isNoReset(boolean ios_isNoReset) {
        Driver.ios_isNoReset = ios_isNoReset;
    }

    @Value("${capability.ios.fullReset}")
    public void setIos_isFullReset(boolean ios_isFullReset) {
        Driver.ios_isFullReset = ios_isFullReset;
    }

    private static String appPackage;
    private static String appActivity;

    private static String automationType;
    private static String automamationAppiumUrl;
    private static String automationSeleniumGridUrl;


    private static String aos_deviceName;
    private static String aos_udid;
    private static String aos_platformName;
    private static String aos_platformVersion;
    private static long aos_newCMDTimeout;
    private static boolean aos_isNoReset;
    private static boolean aos_isFullReset;

    private static String ios_deviceName;
    private static String ios_udid;
    private static String ios_platformName;
    private static String ios_platformVersion;
    private static long ios_newCMDTimeout;
    private static boolean ios_isNoReset;
    private static boolean ios_isFullReset;

    private static AppiumDriver driver;

    @Autowired
    public static AppiumDriver launchDriver() {

        if (driver == null) {
            System.out.println("++++++++++++++++++++++++++++++++ Null Driver. Creating...");
            if (automationType.equalsIgnoreCase("Android")) {
                Driver.initAndroidDriver();
            } else if (automationType.equalsIgnoreCase("ios")) {
                Driver.initIOSDriver();
            }
        } else {
            System.out.println("++++++++++++++++++++++++++++++++ Driver Existed. Return exist...");
        }

        return driver;
    }

    public static AppiumDriver initAndroidDriver() {

        try {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, aos_deviceName);
            cap.setCapability(MobileCapabilityType.UDID, aos_udid);
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, aos_platformName);
            cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, aos_platformVersion);
            cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, aos_newCMDTimeout);
            cap.setCapability(MobileCapabilityType.NO_RESET, aos_isNoReset);
            cap.setCapability(MobileCapabilityType.FULL_RESET, aos_isFullReset);

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

    public static void initIOSDriver() {
        // To Do
    }

    public static void destroyDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static AppiumDriver getDriver() {
        return driver;
    }

}
