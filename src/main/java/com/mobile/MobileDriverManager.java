package com.mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import lombok.Getter;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MobileDriverManager {

    @Getter
    private static AppiumDriver<MobileElement> driver;

    public static DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    public static String appiumHub = "http://127.0.0.1:4723";

    public static void setMobileDriver() {

        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "12");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("udid", "emulator-5554");
        desiredCapabilities.setCapability(
                "app",
                System.getProperty("user.dir") + "/src/test/resources/app/mda-2.0.2-23.apk"
        );

        desiredCapabilities.setCapability("noReset", false);

        System.out.println("url server:" + appiumHub);

        try {

            String os = desiredCapabilities.getCapability("platformName").toString();

            switch (os.toUpperCase(Locale.ROOT)) {

                case "ANDROID":

                    desiredCapabilities.setCapability(
                            "appium:appPackage",
                            "com.saucelabs.mydemoapp.android"
                    );

                    desiredCapabilities.setCapability(
                            "appium:appActivity",
                            "com.saucelabs.mydemoapp.android.view.activities.SplashActivity"
                    );

                    driver = new AndroidDriver<>(new URL(appiumHub), desiredCapabilities);
                    setDriver(driver);

                    break;

                case "IOS":

                    desiredCapabilities.setCapability(
                            "appium:bundleId",
                            "com.saucelabs.mydemoapp.android"
                    );

                    driver = new IOSDriver<>(new URL(appiumHub), desiredCapabilities);
                    setDriver(driver);

                    break;

                default:

                    Logger.getLogger(MobileDriverManager.class.getName())
                            .log(Level.WARNING,
                                    "Sistema operativo mobile no soportado >>> {0}",
                                    os);
            }

            if (driver != null) {
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            }

        } catch (MalformedURLException malformedURLException) {

            Logger.getLogger(MobileDriverManager.class.getName())
                    .log(Level.WARNING,
                            "Ocurrio un error con la URL del servidor de Appium");
        }
    }

    public static void setDriver(AppiumDriver<MobileElement> driver) {
        MobileDriverManager.driver = driver;
    }

    public static void quitDriver() {

        if (driver != null) {

            Logger.getLogger(MobileDriverManager.class.getName())
                    .log(Level.WARNING, "Deteniendo el Driver.");

            MobileDriverManager.getDriver()
                    .terminateApp("com.saucelabs.mydemoapp.android");

            driver.quit();
            driver = null;
        }
    }
}