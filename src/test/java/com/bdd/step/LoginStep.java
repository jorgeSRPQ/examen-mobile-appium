package com.bdd.step;

import com.bdd.view.LoginView;
import com.mobile.Util;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

/**
 * @author Karla Ccallo
 */
public class LoginStep {

    private LoginView loginSauceView() {
        return new LoginView();
    }

    @Step
    public void clicSeleccionarOpcion(String sMenu) {
        loginSauceView().seleccionarOpcionMenu(sMenu);
    }

    @Step
    public void validarPantalla(String sTitulo) {
        Assert.assertTrue("No mostro pantalla: " + sTitulo, loginSauceView().validarPantalla(sTitulo));
        Util.takeScreenShoot();
    }

    @Step
    public void ingresarUsuario(String sUsername) {
        loginSauceView().typeUserName(sUsername);
    }

    @Step
    public void ingresarPassword(String sUserPass) {
        loginSauceView().typePassword(sUserPass);
    }

    @Step
    public void clicBotonLogin() {
        loginSauceView().clicBotonLogin();
    }


}
