package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MailTmClient extends PageObject {
    String TMpestaña;
    Set <String> HadlesAntes;


    private final By usericon = By.xpath("//*[@id=\"reka-dropdown-menu-trigger-v-1-4\"]/span");
    private final By btnInicioSesion = By.xpath("//*[@id=\"reka-dropdown-menu-content-v-1-9\"]/div/div[2]/button[2]/span[2]");
    private final By inputCorreo = By.name("address");
    private final By inputPass = By.name("password");
    private final By btnLogin = By.xpath("//button[normalize-space(text())='Iniciar sesión']");
    private final By SelectEmail = By.xpath("//*[@id=\"__nuxt\"]/div/div[2]/main/div[2]/div[2]/ul/li[1]/a/div/div");
    private final By codigoVeri = By.xpath("/html/body/table[1]/tbody/tr[4]/td");
    private final By campoCodigo = By.xpath("//*[@id=\":r3:\"]");
    private final By correoMAILTM = By.xpath("//*[@id=\"Dont_use_WEB_use_API_OK\"]");
    public MailTmClient(WebDriver driver) {
        super(driver);
    }

    public void IngresarTMail(String correo, String password) throws InterruptedException {
        HadlesAntes = driver.getWindowHandles();
        ((JavascriptExecutor) driver).executeScript("window.open('', '_blank');");
        Set<String> handlesDespues = driver.getWindowHandles();
        List<String> pestana = new ArrayList<>(handlesDespues);
        handlesDespues.removeAll(HadlesAntes);
        TMpestaña = handlesDespues.iterator().next();
        driver.switchTo().window(TMpestaña);
        driver.get("https://mail.tm/es/");

        if ("Nocorreo".equals(correo)) {
            ObtenerCorreo(pestana);
        } else {
            FillDataTM(correo, password, pestana);
        }
    }

    public void ObtenerCorreo (List<String> pestana){
        System.out.println("hola");
        WebElement CorreoTM = find(correoMAILTM);
        System.out.println(CorreoTM.getText());

    }

    private void FillDataTM(String correo, String password, List<String> pestana) throws InterruptedException {
        find(usericon).click();
        find(btnInicioSesion).click();
        find(inputCorreo).sendKeys(correo);
        find(inputPass).sendKeys(password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        WebElement botonIniciarSesion = wait.until(
                ExpectedConditions.elementToBeClickable(btnLogin)
        );
        Thread.sleep(5000);
        botonIniciarSesion.click();
        ObtenerCodigo(pestana);
    }

    private void ObtenerCodigo(List<String> pestana) {
            find(SelectEmail).click();
            driver.switchTo().frame("iFrameResizer0");
            WebElement Codigo = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(codigoVeri));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Codigo);
            String textoCodigo = Codigo.getText();
            System.out.println("Código obtenido: " + textoCodigo);
            driver.switchTo().defaultContent();
            driver.switchTo().window(pestana.get(0));
            find(campoCodigo).sendKeys(textoCodigo);

    }
}
