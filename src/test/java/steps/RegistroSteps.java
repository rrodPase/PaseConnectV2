package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegistroPage;
import utilities.DriveFactory;

public class RegistroSteps extends DriveFactory {

    RegistroPage registro = new RegistroPage(getDriver());

    @Given("Ingresa opcion de registro")
    public void ingresa_opcion_de_registro() {
        registro.IngresoRegistro();
    }
    @Given("Selecciona perfil {string}")
    public void selecciona_perfil(String perfil) {
        registro.SelectPerfil(perfil);
    }
    @When("Completa formulario de registro")
    public void completa_formulario_de_registro() {

    }
    @Then("Se registra con exito")
    public void se_registra_con_exito() {

    }

}
