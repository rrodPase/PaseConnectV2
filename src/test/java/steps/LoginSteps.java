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

    @Given("Ingresa con las siguientes credenciales {string} y {string}")
    public void ingresaConLasSiguientesCredencialesY(String user, String password) {
        Login.fillDataLogin(user,password);
    }

    @Given("Da clic en iniciar sesion")
    public void da_clic_en_iniciar_sesion() {
        Login.InicioSesion();
    }

    @Then("Usuario ingresa a su cuenta correctamente")
    public void usuario_ingresa_a_su_cuenta_correctamente() {
        Login.validaInicio();
    }

    //ADMINS
    @Then("Se valida ingreso a twofactor")
    public void seValidaIngresoATwofactor() {
        Login.validatwofactor();
    }

    @When("Ingresa a TMail {string} y {string}")
    public void ingresaATMailY(String Correo, String password) throws InterruptedException {
        MT.IngresarTMail(Correo, password);
    }
}