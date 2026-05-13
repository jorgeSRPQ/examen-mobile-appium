package com.bdd.runner;

import com.mobile.Util;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 * @author Jorge Rivas Roque
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"json:target/build/cucumber.json"},
        publish = true,
        glue = "com.bdd.glue",
        features = "src/test/resources/features",
        stepNotifications = true,
        tags = "@carrito",
        monochrome = true
)
public class RunnerTest {
    @BeforeClass
    public static void beforeExecution() {
        Util.logger(RunnerTest.class).info("BEFORE >>>");
    }

    @AfterClass
    public static void afterExecution() {
        Util.logger(RunnerTest.class).info("AFTER >>>");
    }
}
