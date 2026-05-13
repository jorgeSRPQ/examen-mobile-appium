package com.bdd.view;

import com.mobile.MobileBase;
import com.mobile.Util;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.logging.Level;

/**
 * @author Jorge Rivas Roque
 */
public class LoginView extends MobileBase {

    @AndroidFindBy(accessibility = "View menu")
    @iOSXCUITFindBy(accessibility = "tab bar option menu")
    private WebElement btnMenu;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
    @iOSXCUITFindBy(accessibility = "Username input field")
    private WebElement txtUserName;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/passwordET")
    @iOSXCUITFindBy(accessibility = "Password input field")
    private WebElement txtPass;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/loginBtn")
    @iOSXCUITFindBy(accessibility = "Login button")
    private WebElement btnLogin;

    public void seleccionarOpcionMenu(String sMenu) {
        explicitWaiting(5000, driver -> ExpectedConditions.visibilityOf(btnMenu));
        Util.takeScreenShoot();
        clickElement(waitUntilVisibilityElement(10, btnMenu));
        Util.takeScreenShoot();

        String sXpath = "//android.widget.TextView[@text='%s']";
        WebElement option = getMobileElementByXPath(String.format(sXpath, sMenu));
        clickElement(option);
    }

    public boolean validarPantalla(String sTitulo) {
        String sXPath = "//android.widget.TextView[@text='%s']";
        return isObjectVisibleBySeconds(
                getMobileElementByXPath(String.format(sXPath, sTitulo)), 4);
    }

    public void typeUserName(String email) {
        explicitWaiting(4000, driver -> ExpectedConditions.visibilityOf(txtUserName));
        Util.logger(this.getClass()).log(Level.WARNING, "Ingresando email: " + email);
        sendKey(txtUserName, email);
    }

    public void typePassword(String password) {
        explicitWaiting(2000, driver -> ExpectedConditions.visibilityOf(txtPass));
        Util.logger(this.getClass()).log(Level.WARNING, "Ingresando password: " + password);
        sendKey(txtPass, password);

        String sXPath = "//android.widget.TextView[@text='%s']";
        WebElement elementTitleLogin = getMobileElementByXPath(String.format(sXPath, "Login"));
        clickElement(elementTitleLogin);
    }

    public void clicBotonLogin() {
        explicitWaiting(2000, driver -> ExpectedConditions.elementToBeClickable(btnLogin));
        Util.logger(this.getClass()).log(Level.WARNING, "clic Login");
        Util.takeScreenShoot();
        clickElement(btnLogin);
    }
}