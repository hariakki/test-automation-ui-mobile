package com.atcn.bdd.ui.mobile.core;

import com.atcn.bdd.ui.mobile.core.springConfig.data.YAMLConfigStatic4AOS;
import com.atcn.bdd.ui.mobile.core.springConfig.data.YAMLConfigStatic4IOS;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.concurrent.TimeUnit;

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

    @Value("${webUrl}")
    public void setWebUrl(String webUrl) {
        Driver.webUrl = webUrl;
    }

    @Value("${driverPath}")
    public void setDriverPath(String driverPath) {
        Driver.driverPath = driverPath;
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

    @Value("${capability.web.browserType}")
    public void setWebBrowserType(String browserType) {
        Driver.webBrowserType = browserType;
    }

    @Value("${capability.web.remote}")
    public void isRemote(boolean remote) {
        Driver.webRemote = remote;
    }

    private static String appPackage;
    private static String appActivity;

    private static String webUrl;
    private static String driverPath;

    private static String automationType;
    private static String automamationAppiumUrl;
    private static String automationSeleniumGridUrl;

    private static String webBrowserType;
    private static boolean webRemote;

    private static AppiumDriver appiumDriver;
    private static WebDriver webDriver;

    private static final Logger LOGGER = LoggerFactory.getLogger(Driver.class);

    public static AppiumDriver launchAppiumDriver() {

        if (appiumDriver == null) {
            if (automationType.equalsIgnoreCase("Android")) {
                LOGGER.info("Null Driver. Creating Android Driver...");
                Driver.initAndroidDriver();
            } else if (automationType.equalsIgnoreCase("ios")) {
                LOGGER.info("Null Driver. Creating IOS Driver...");
                Driver.initIOSDriver();
            } else {
                LOGGER.info("Not Mobile Automation. AppiumDriver return null...");
                return null;
            }
        } else {
            LOGGER.info("Driver Existed. Return exist...");
        }

        return appiumDriver;
    }

    public static WebDriver launchWebDriver() {
        if (webDriver == null) {
            if (automationType.equalsIgnoreCase("Web") && webBrowserType.equalsIgnoreCase("chrome")) {
                LOGGER.info("Null Driver. Creating Web Driver of Chrome...");
                Driver.initWebChromeDriver();
            } else if (automationType.equalsIgnoreCase("Web") && webBrowserType.equalsIgnoreCase("firefox")) {
                LOGGER.info("Null Driver. Creating Web Driver of Firefox...");
                Driver.initWebFirefoxDriver();
            } else {
                LOGGER.info("Not Web Automation. WebDriver return null...");
                return null;
            }
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            webDriver.navigate().to(webUrl);
        }

        return webDriver;
    }

    public static void initAndroidDriver() {

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

            appiumDriver = new AppiumDriver(server, cap);

        } catch (Exception e) {
            System.out.println("Exception cause:" + e.getCause());
            System.out.println("Exception message:" + e.getMessage());
        }

    }

    public static void initIOSDriver() {
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

            appiumDriver = new AppiumDriver(server, cap);

        } catch (Exception e) {
            System.out.println("Exception cause:" + e.getCause());
            System.out.println("Exception message:" + e.getMessage());
        }

    }

    public static void initWebChromeDriver() {
        ChromeOptions opts = new ChromeOptions();
        opts.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        opts.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        opts.addArguments("--disable-extensions-except");
        opts.addArguments("--disable-popup-blocking");

        if (webRemote) {
            Driver.startRemoteDriver(new DesiredCapabilities(opts));
        } else {
            System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver");
            webDriver = new ChromeDriver(opts);
        }
    }

    public static void initWebFirefoxDriver() {
        FirefoxOptions opts = new FirefoxOptions();
        opts.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        opts.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        /**
         * Option 2: Below setting is to read "default" firefox profile -- local browser more faster
         */
//        ProfilesIni profilesIni = new ProfilesIni();
//        FirefoxProfile defaultProfile = profilesIni.getProfile("default");
//        opts.setProfile(defaultProfile);

        if (webRemote) {
            Driver.startRemoteDriver(new DesiredCapabilities(opts));
        } else {
            System.setProperty("webdriver.gecko.driver", driverPath + "/geckodriver");
            webDriver = new FirefoxDriver(opts);
        }
    }

    public static void startRemoteDriver(DesiredCapabilities caps) {
        try {
            webDriver = new RemoteWebDriver(new URL(automationSeleniumGridUrl), caps);
        } catch (Exception e) {
            System.out.println("Exception cause:" + e.getCause());
            System.out.println("Exception message:" + e.getMessage());
        }
    }

    public static void destroyDriver() {
        if (automationType.equalsIgnoreCase("Android")
                || automationType.equalsIgnoreCase("IOS")) {
            LOGGER.info("Destroying Appium Driver...");
            appiumDriver.quit();

        } else if (automationType.equalsIgnoreCase("Web")) {
            LOGGER.info("Destroying Web Driver...");
            webDriver.quit();
        }
    }

    public static AppiumDriver getAppiumDriver() {
        return appiumDriver;
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

}
