package steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import utilities.DriveFactory;
import utilities.Logs;


public class StartSteps {
    private WebDriver driver;
    String pestañaPrincipal;

    @Before
    public void setupDriver(Scenario s) {
        Logs.info("Executing" + s.getName());
        DriveFactory driveFactory = new DriveFactory();
        driver = driveFactory.getDriver();
    }

    @Given("Usuario ingresa a la pagina de login")
    public void usuario_ingresa_a_la_pagina_de_login() {

        driver.get("https://staging.paseconnect.com/auth/login");
        pestañaPrincipal = driver.getWindowHandle();
    }
}
