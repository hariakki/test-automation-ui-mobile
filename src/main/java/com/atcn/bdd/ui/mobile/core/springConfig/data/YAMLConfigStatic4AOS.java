package com.atcn.bdd.ui.mobile.core.springConfig.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "capability.android")
public class YAMLConfigStatic4AOS {

    private static String platformName;
    private static String platformVersion;
    private static String deviceName;
    private static String udid;
    private static boolean noReset;
    private static boolean fullReset;
    private static long newCMDTimeout;
    private static String browserName;

    private static final Logger logger = LoggerFactory.getLogger(YAMLConfigStatic4AOS.class);

    /**
     * Setter - NONE static
     */
    public void setPlatformName(String platformName) {
        logger.debug("Injected Android platformName: " + platformName);
        this.platformName = platformName;
    }

    public void setPlatformVersion(String platformVersion) {
        logger.debug("Injected Android platformVersion: " + platformVersion);
        this.platformVersion = platformVersion;
    }

    public void setDeviceName(String deviceName) {
        logger.debug("Injected Android deviceName: " + deviceName);
        this.deviceName = deviceName;
    }

    public void setUdid(String udid) {
        logger.debug("Injected Android udid: " + udid);
        this.udid = udid;
    }

    public void setNoReset(boolean noReset) {
        logger.debug("Injected Android noReset: " + noReset);
        this.noReset = noReset;
    }

    public void setFullReset(boolean fullReset) {
        logger.debug("Injected Android fullReset: " + fullReset);
        this.fullReset = fullReset;
    }

    public void setNewCMDTimeout(long newCMDTimeout) {
        logger.debug("Injected Android newCMDTimeout: " + newCMDTimeout);
        this.newCMDTimeout = newCMDTimeout;
    }

    public void setBrowserName(String browserName) {
        logger.debug("Injected Android browserName: " + browserName);
        this.browserName = browserName;
    }


    /**
     * Getter - static
     */
    public static String getPlatformName() {
        return platformName;
    }

    public static String getPlatformVersion() {
        return platformVersion;
    }

    public static String getDeviceName() {
        return deviceName;
    }

    public static String getUdid() {
        return udid;
    }

    public static boolean isNoReset() {
        return noReset;
    }

    public static boolean isFullReset() {
        return fullReset;
    }

    public static long getNewCMDTimeout() {
        return newCMDTimeout;
    }

    public static String getBrowserName() {
        return browserName;
    }
}
