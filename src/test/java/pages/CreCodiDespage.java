package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriveFactory;

import java.time.Duration;

public class CreCodiDespage {

    private WebDriver driver;

    // === Localizadores ===
    //private By btnMembresias = By.xpath("//span[normalize-space()='Membresías']");
    private final By btnMembresias = By.xpath("//span[text()='Membresias' and contains(@class,'MuiListItemText-primary')]");
    private final By btncodigoymensa = By.xpath("//span[text()='Configuración de códigos y mensajería' and contains(@class,'MuiListItemText-primary')]");
    private final By btncrearcodigo = By.xpath("//button[text()='Crear nuevo código']");
    private final By btnfrecpago = By.xpath("//button[text()='Frecuencia de Pago']");
    private final By btnabandonar = By.xpath("//button[text()='Abandonar']");
    private final By campoNombre = By.name("nombreMembrecia");
    private By FrecuenciaPago = By.cssSelector("div.MuiSelect-select"); // la lista desplegable es un dropdowb
    private final By campoCodigo = By.name("codigo");
    private final By campoCantiCodigo = By.name("cantidadCodigos");
    private final By campoDescuentoMembresias = By.name("descuentoMembresia");
    // === Constructor ===
    public CreCodiDespage(WebDriver driver) {
        this.driver = driver;
    }

    // === Métodos de acción ===
    public void clicmenumembre() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(btnMembresias)).click();
    }

    public void cliccodigoymensa() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Espera a que el menú sea clickeable
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(btncodigoymensa ));
        menu.click();

        // Espera a que el título aparezca después del clic
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(normalize-space(), 'Códigos')]")));
    }
    //boton creacion codigo descuento
    public void cliccreacioncodigo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(btncrearcodigo)).click();
    }
    //boton Frecuencia de Pago
    public void clicfrecuendiapago() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(btnfrecpago)).click();
    }
    //boton abandonar
    public void clicbtnabandonar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(btnabandonar)).click();
    }

    // ingresar nombre del codigo
    public void ingresarNombreCodigo(String nombre) {
        WebElement input = driver.findElement(campoNombre);
        input.clear();  // Limpia el campo si ya tiene texto
        input.sendKeys(nombre);  // Escribe el texto
    }
    //lista frecuendia de pago
    public void seleccionarFrecuenciaPago(String opcionVisible) {
        // 1. dar click en el menú
        WebElement dropdown = driver.findElement(FrecuenciaPago);
        dropdown.click();

        // 2. Esperar que aparezcan las opciones
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        By opcionLocator = By.xpath("//li[@role='option' and text()='" + opcionVisible + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(opcionLocator));

        // 3. Clic en la opción deseada
        driver.findElement(opcionLocator).click();
    }

    // ingresar codigo
    public void ingresarCodigo(String nombre) {
        WebElement input = driver.findElement(campoCodigo);
        input.clear();  // Limpia el campo si ya tiene texto
        input.sendKeys(nombre);  // Escribe el texto
    }

    // ingresar cantidad de codigos
    public void ingresarCantidaCodigo(String nombre) {
        WebElement input = driver.findElement(campoCantiCodigo);
        input.clear();  // Limpia el campo si ya tiene texto
        input.sendKeys(nombre);  // Escribe el texto
    }

    // ingresar cantidad de codigos
    public void ingresarDescuentomembresíao(String nombre) {
        WebElement input = driver.findElement(campoDescuentoMembresias);
        input.clear();  // Limpia el campo si ya tiene texto
        input.sendKeys(nombre);  // Escribe el texto
    }






}

