package com.mobile;


import io.cucumber.java.Scenario;

/**
 * @author Jorge Rivas Roque
 */
public class ManageScenario {

    private static Scenario scenario;

    public static Scenario getScenario() {
        return scenario;
    }

    public static void setScenario(Scenario scenario) {
        ManageScenario.scenario = scenario;
    }
}
