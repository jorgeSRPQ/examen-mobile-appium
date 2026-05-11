package com.mobile;

import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

/**
 * @author Karla Ccallo
 */
public class Util {

    public static void takeScreenShoot(){
        byte[] screenshot = MobileDriverManager.getDriver().getScreenshotAs(OutputType.BYTES);
        ManageScenario.getScenario().attach(screenshot, "image/jpeg", "evidencia");
    }

    public static Logger logger(Class aClass) {
        return Logger.getLogger(aClass.getName());
    }
    public static void explicitWait(int timeOnSeconds) {
        try {
            Thread.sleep((long) (timeOnSeconds * 1000));
        } catch (Exception exec) {
        }
    }
}
