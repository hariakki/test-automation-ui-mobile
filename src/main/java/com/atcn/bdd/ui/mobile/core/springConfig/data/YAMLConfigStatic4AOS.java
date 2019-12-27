package com.atcn.bdd.ui.mobile.core.springConfig.data;

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

    /**
     * Setter - NONE static
     */
    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public void setNoReset(boolean noReset) {
        this.noReset = noReset;
    }

    public void setFullReset(boolean fullReset) {
        this.fullReset = fullReset;
    }

    public void setNewCMDTimeout(long newCMDTimeout) {
        this.newCMDTimeout = newCMDTimeout;
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
}
