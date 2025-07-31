package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageObject;
import java.time.Duration;


public class MailTmClient extends PageObject {
    private final By usericon = By.xpath("//*[@id=\"reka-dropdown-menu-trigger-v-1-4\"]/span");
    private final By btnInicioSesion = By.xpath("//*[@id=\"reka-dropdown-menu-content-v-1-9\"]/div/div[2]/button[2]/span[2]");
    private final By inputCorreo = By.name("address");
    private final By inputPass = By.name("password");
    private final By btnLogin = By.xpath("//button[normalize-space(text())='Iniciar sesión']");
    private final By SelectEmail = By.xpath("//*[@id=\"__nuxt\"]/div/div[2]/main/div[2]/div[2]/ul/li[1]/a/div/div");
    private final By codigoVeri = By.xpath("/html/body/table[1]/tbody/tr[4]/td");
    private final By campoCodigo = By.xpath("//*[@id=\":r3:\"]");
    private final By correoMAILTM = By.xpath("//input[@id='Dont_use_WEB_use_API_OK']");
    private final By inputCorreoForm = By.xpath("//input[@name='email']");
    private final By linkPassword = By.xpath("/html/body/table[1]/tbody/tr[3]/td/a");

    public MailTmClient(WebDriver driver) {
        super(driver);
    }

    public void IngresarTMail(String correo, String password) {
        abrirNuevaPestanaConUrl("https://mail.tm/es/");
        if ("Registro".equals(correo)) {
            ObtenerCorreo();
        } else {
            FillDataTM(correo, password);
        }
    }

    public void ObtenerCorreo () {
        esperaSecunds();
        WebElement correoEle = find(correoMAILTM);
        String ValorCorreo = correoEle.getAttribute("value");
        cambiarAVentanaPrincipal();
        find(inputCorreoForm).sendKeys(ValorCorreo);
    }

    private void FillDataTM(String correo, String password) {
        find(usericon).click();
        find(btnInicioSesion).click();
        find(inputCorreo).sendKeys(correo);
        find(inputPass).sendKeys(password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        WebElement botonIniciarSesion = wait.until(
                ExpectedConditions.elementToBeClickable(btnLogin)
        );
        esperaSecunds();
        botonIniciarSesion.click();
        ObtenerCodigo();
    }

    private void ObtenerCodigo() {
            find(SelectEmail).click();
            driver.switchTo().frame("iFrameResizer0");
            WebElement Codigo = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(codigoVeri));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Codigo);
            String textoCodigo = Codigo.getText();
            cambiarAVentanaPrincipal();
            find(campoCodigo).sendKeys(textoCodigo);
    }

    public void ObtenerContraseña() {
        cambiarAVentanaTMP();
        driver.navigate().refresh();
        esperaSecunds();
        find(SelectEmail).click();


        WebElement linkCPassword = find(linkPassword);
        WebElement contenedorScroll = find(By.id("scrollContainer"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[1].offsetTop;", contenedorScroll,linkCPassword);
        linkCPassword = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(linkPassword));
        linkCPassword.click();
    }
}
