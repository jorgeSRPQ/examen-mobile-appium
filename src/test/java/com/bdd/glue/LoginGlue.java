package com.bdd.glue;


import com.bdd.step.LoginStep;
import com.mobile.ManageScenario;
import com.mobile.MobileDriverManager;
import com.mobile.Util;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.es.*;
import net.thucydides.core.annotations.Steps;

import java.util.logging.Level;

/**
 * @author Jorge Rivas Roque
 */
public class LoginGlue {

    @Steps
    private LoginStep loginStep;

    private Scenario scenario;

    @Before
    public void beforeScenario(Scenario scenario) {
        this.scenario = scenario;
        ManageScenario.setScenario(this.scenario);
    }

    @After
    public void afterScenario() {
        if(this.scenario.isFailed()) {
            Util.takeScreenShoot();
        }
        MobileDriverManager.quitDriver();
    }

    @Given("^que me encuentro en la aplicacion SauceLabsDemo$")
    public void que_me_encuentro_en_la_aplicacion() {
        MobileDriverManager.setMobileDriver();
    }

    @Cuando("ingreso al Menu {string}")
    public void ingresoAlMenu(String sMenu) {
        loginStep.clicSeleccionarOpcion(sMenu);
    }

    @Y("me muestra la pantalla de {string}")
    public void meMuestraLaPantallaDe(String sTitulo) {
        loginStep.validarPantalla(sTitulo);
    }

    @E("ingreso mi usuario {string}")
    public void ingresoMiUsuario(String sUsername) {
        loginStep.ingresarUsuario(sUsername);
    }

    @E("ingreso mi password {string}")
    public void ingresoMiPassword(String sUserPass) {
        loginStep.ingresarPassword(sUserPass);
    }

    @Y("^presiono Login$")
    public void presionoLogin() {
        loginStep.clicBotonLogin();
    }


}
