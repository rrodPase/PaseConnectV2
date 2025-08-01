package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CreCodiDespage;
import pages.LoginPage;
import utilities.DriveFactory;
import utilities.MailTmClient;

import static java.sql.DriverManager.getDriver;

public class CreCodiDesSteps extends DriveFactory {

    private LoginPage login = new LoginPage(getDriver());
    private MailTmClient mt = new MailTmClient(getDriver());
    private CreCodiDespage codides = new CreCodiDespage(getDriver());


    //Membresias
    @And("Navega a la sección \"Membresías\"")
    public void ingresa_a_membresias() {
        codides.clicmenumembre();

    }
    //Configuración de códigos y mensajería
    @Then("Ingresa a \"Configuración de códigos y mensajería\"")
    public void ingresa_a_Configuración_de_códigos_y_mensajería() {
        DriveFactory factory = new DriveFactory();
        factory.scroll();
        codides.cliccodigoymensa();

    }

    //Membresias
    @And("Da clic en \"Crear código de descuento\"")
    public void ingresa_a_crear_codigo_descuento() {
        codides.cliccreacioncodigo();

    }
    //Frecuencia de pago
    @Then("El usuario accede a la opción \"Frecuencia de Pago\"")
    public void ingresa_a_la_opcion_de_Frecuencia_de_Pago() {
        codides.clicfrecuendiapago();
    }

    //boton abandonar
    @And("Da clic en el botón \"Abandonar\"")
    public void Dar_click_boton_abandonar() {
        codides.clicbtnabandonar();
    }
    @And("Ingresa el texto {string} en el campo Nombre del Código")
    public void ingresaTextoEnCampoNombre(String nombreCodigo) {
        codides.ingresarNombreCodigo(nombreCodigo);
    }
    @And("Selecciona la opción {string} en el menú Frecuencia de Pago")
    public void seleccionaOpcionFrecuencia(String opcion) {
        codides.seleccionarFrecuenciaPago(opcion);
    }
    @And("Ingrese la cantidad de codigos {string}")
    public void cantidaddecodigos(String cantidaddecodigos) {
        codides.ingresarCantidaCodigo(cantidaddecodigos);
    }
    ingresarDescuentomembresíao

    @And("Ingrese Descuento membresias {string}")
    public void descmembre(String descuentoMembresia) {
        codides.ingresarDescuentomembresíao(descuentoMembresia);
    }


}
