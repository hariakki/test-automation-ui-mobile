package com.atcn.bdd.ui.mobile.core;

import com.atcn.bdd.ui.mobile.core.springConfig.data.YAMLConfigStatic4AOS;
import com.atcn.bdd.ui.mobile.core.springConfig.data.YAMLConfigStatic4IOS;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
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
    // Additional getter for other usage
    public static String getAutomationType() {
        return automationType;
    }

    @Value("${automation.mobileBrowserToggle}")
    public void setAutomationMobileBrowserToggle(boolean mobileBrowserToggle) {
        Driver.automationMobileBrowserToggle = mobileBrowserToggle;
    }
    // Additional getter for other usage
    public static boolean isAutomationMobileBrowserToggle() {
        return automationMobileBrowserToggle;
    }

    @Value("${automation.appiumServer}")
    public void setAutomamationAppiumUrl(String automamationAppiumUrl) {
        Driver.automationAppiumUrl = automamationAppiumUrl;
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
    private static boolean automationMobileBrowserToggle;
    private static String automationAppiumUrl;
    private static String automationSeleniumGridUrl;

    private static String webBrowserType;
    private static boolean webRemote;

    private static AndroidDriver androidDriver;
    private static IOSDriver iosDriver;
    private static WebDriver webDriver;

    private static final Logger LOGGER = LoggerFactory.getLogger(Driver.class);

    public static AndroidDriver launchAndroidDriver() {
        if (androidDriver == null) {
            if (automationType.equalsIgnoreCase("Android")) {
                Driver.initAndroidDriver();
            } else {
                LOGGER.info("Not ANDROID Automation. AndroidDriver return null...");
                return null;
            }
        }
        return androidDriver;
    }

    public static IOSDriver launchIOSDriver() {
        if (iosDriver == null) {
            if (automationType.equalsIgnoreCase("IOS")) {
                Driver.initIOSDriver();
            } else {
                LOGGER.info("Not IOS Automation. IOSDriver return null...");
                return null;
            }
        }
        return iosDriver;
    }

    public static WebDriver launchWebDriver() {
        if (webDriver == null) {
            if (automationType.equalsIgnoreCase("Web") && webBrowserType.equalsIgnoreCase("chrome")) {
                LOGGER.info("Setting up Web browser driver...");
                LOGGER.info("Setting up Web browser is: Chrome");
                Driver.initWebChromeDriver();
            } else if (automationType.equalsIgnoreCase("Web") && webBrowserType.equalsIgnoreCase("firefox")) {
                LOGGER.info("Setting up Web browser driver...");
                LOGGER.info("Setting up Web browser is: Firefox");
                Driver.initWebFirefoxDriver();
            } else {
                LOGGER.info("Not WEB Automation. IOSDriver return null...");
                return null;
            }
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
            if (Driver.isAutomationMobileBrowserToggle()) {
                LOGGER.info("Setting up Android browser...");
                cap.setCapability(MobileCapabilityType.BROWSER_NAME, YAMLConfigStatic4AOS.getBrowserName());
                LOGGER.info("Setting up Android browser is: " + YAMLConfigStatic4AOS.getBrowserName());
                androidDriver = new AndroidDriver(new URL(automationAppiumUrl), cap);
                androidDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                androidDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                androidDriver.navigate().to(webUrl);

            } else {
                LOGGER.info("Setting up Android app...");
                cap.setCapability("appPackage", appPackage);
                cap.setCapability("appActivity", appActivity);
                androidDriver = new AndroidDriver(new URL(automationAppiumUrl), cap);
            }
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
            if (Driver.isAutomationMobileBrowserToggle()) {
                LOGGER.info("Setting up IOS browser...");
                cap.setCapability(MobileCapabilityType.BROWSER_NAME, YAMLConfigStatic4IOS.getBrowserName());
                LOGGER.info("Setting up IOS browser is: " + YAMLConfigStatic4IOS.getBrowserName());
                iosDriver = new IOSDriver(new URL(automationAppiumUrl), cap);
                iosDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                iosDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                iosDriver.navigate().to(webUrl);
            } else {
                LOGGER.info("Setting up IOS app...");
                cap.setCapability("appPackage", appPackage);
                cap.setCapability("appActivity", appActivity);
                iosDriver = new IOSDriver(new URL(automationAppiumUrl), cap);
            }
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
        if (automationType.equalsIgnoreCase("Android")) {
            androidDriver.quit();
            LOGGER.info("Android Driver destroyed.");

        } else if(automationType.equalsIgnoreCase("IOS")) {
            iosDriver.quit();
            LOGGER.info("IOS Driver destroyed.");

        } else if (automationType.equalsIgnoreCase("Web")) {
            webDriver.quit();
            LOGGER.info("Web Driver destroyed.");
        }
    }

    public static AndroidDriver getAndroidDriver() {
        return androidDriver;
    }

    public static IOSDriver getIosDriver() {
        return iosDriver;
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

}
