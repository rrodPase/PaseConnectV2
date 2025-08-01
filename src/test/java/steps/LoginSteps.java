package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.DriveFactory;
import utilities.MailTmClient;

public class LoginSteps extends DriveFactory {

    private LoginPage Login = new LoginPage(getDriver());
    private MailTmClient MT = new MailTmClient(getDriver());

    @Given("El usuario ingresa con las credenciales {string} y {string}")
    public void ingresaConLasSiguientesCredencialesY(String user, String password) {
        Login.fillDataLogin(user,password);
    }

    @Given("Da clic en el boton \"Iniciar sesión\"")
    public void da_clic_en_iniciar_sesion() {
        Login.InicioSesion();
    }

    @Then("El usuario accede correctamente a su cuenta")
    public void usuario_ingresa_a_su_cuenta_correctamente() {
        Login.validaInicio();
    }

    //ADMINS
    @Then("Se valida el ingreso a la verificación de dos pasos")
    public void seValidaIngresoATwofactor() {
        Login.validatwofactor();
    }

    @When("El usuario accede a TMail e inicia sesión con las credenciales {string} y {string}")
    public void ingresaATMailParaObtenerEIniciaSesionConCredencialesY(String Correo, String password) throws InterruptedException {
        MT.IngresarTMail(Correo, password);
    }

}