package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegistroPage;
import utilities.DriveFactory;
import utilities.MailTmClient;

public class RegistroSteps extends DriveFactory {

    RegistroPage registro = new RegistroPage(getDriver());
    private MailTmClient MT = new MailTmClient(getDriver());

    @Given("Ingresa opcion de registro")
    public void ingresa_opcion_de_registro() {
        registro.IngresoRegistro();
    }
    @Given("Selecciona perfil {string}")
    public void selecciona_perfil(String perfil) {
        registro.SelectPerfil(perfil);
    }
    @When("Completa formulario de registro")
    public void completa_formulario_de_registro() throws InterruptedException {
        registro.CompletarRegistro();
    }
    @Then("Se registra con exito")
    public void se_registra_con_exito() {

    }

    @When("Ingresa a TM para recibir correo de confirmacion")
    public void ingresaATMParaRecibirCorreoDeConfirmacion() {
        MT.ObtenerContraseña();
    }

    @And("Llena la informacion de contraseña y acepta")
    public void llenaLaInformacionDeContraseñaYAcepta() {
        registro.CompletarPassword();
    }

    @Then("Usuario Registrado Correctamente")
    public void usuarioRegistradoCorrectamente() {
        registro.ValidacionRegistro();
    }
}
