package com.cdp.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static AndroidDriver driver = null;

    public static AndroidDriver getDriver(DriversType driversType) {
        switch (driversType) {
            case HYBRID:
                return getHybridDriver();
            case ANDROID:
                return getAndroidDriver();
            case BROWSER:
                return getChromeDriver();

        }
        return null;
    }

    private static AndroidDriver getChromeDriver() {
        if (driver == null) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.VERSION, 8);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Sony F8332");
            URL remoteUrl = null;
            try {
                remoteUrl = new URL("http://0.0.0.0:4723/wd/hub");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            driver = new AndroidDriver<>(remoteUrl, desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        }
        return driver;
    }

    private static AndroidDriver getAndroidDriver() {
        if (driver == null) {

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.APP,
                    "D:\\WorkSpace\\appium\\src\\main\\resources\\app-debug.apk");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            desiredCapabilities.setCapability(MobileCapabilityType.VERSION, 8);
            desiredCapabilities.setCapability("appActivity", "MainActivity");
            desiredCapabilities.setCapability("appPackage", "com.example.rizon.filemanagerv04");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Sony F8332");

            URL remoteUrl = null;
            try {
                remoteUrl = new URL("http://0.0.0.0:4723/wd/hub");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            driver = new AndroidDriver<>(remoteUrl, desiredCapabilities);
        }
        return driver;
    }

    private static AndroidDriver getHybridDriver() {
        if (driver == null) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.APP,
                    "D:\\WorkSpace\\appium\\src\\main\\resources\\app-debugHybrid.apk");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            desiredCapabilities.setCapability(MobileCapabilityType.VERSION, 8);
            desiredCapabilities.setCapability("appActivity", "MainActivity");
            desiredCapabilities.setCapability("appPackage", "com.example.volodymyr_oleksa.hybridapp");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Sony F8332");

            URL remoteUrl = null;
            try {
                remoteUrl = new URL("http://0.0.0.0:4723/wd/hub");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            driver = new AndroidDriver<>(remoteUrl, desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        }
        return driver;
    }

    public static void close(){
        driver.close();
    }
}
