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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        try {
            boolean entroIframe = false;
            try {
                wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("message-view-iframe")));
                System.out.println("Se cambió al iframe del mensaje.");
                entroIframe = true;
            } catch (Exception e) {
                System.out.println("No se encontró iframe, usando DOM principal.");
            }

            List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
            System.out.println("Cantidad de iframes encontrados: " + iframes.size());

            String hrefFinal = null;
            for (int i = 0; i < iframes.size(); i++) {
                try {
                    driver.switchTo().defaultContent();
                    driver.switchTo().frame(iframes.get(i));
                    List<WebElement> links = driver.findElements(By.tagName("a"));
                    for (WebElement link : links) {
                        String href = link.getAttribute("href");
                        if (href != null && href.contains("sendgrid.net")) {
                            System.out.println("🔗 Enlace encontrado en iframe: " + href);
                            hrefFinal = href;
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("No se pudo acceder al iframe " + i);
                }
                if (hrefFinal != null) break;
            }

            if (hrefFinal == null) {
                driver.switchTo().defaultContent();
                List<WebElement> todosLosLinks = driver.findElements(By.tagName("a"));
                for (WebElement link : todosLosLinks) {
                    String href = link.getAttribute("href");
                    if (href != null && href.contains("sendgrid.net")) {
                        System.out.println("Enlace detectado (NO se abrirá): " + href);
                        hrefFinal = href;
                        break;
                    }
                }
            }

            if (hrefFinal != null) {
                ((JavascriptExecutor) driver).executeScript("window.open(arguments[0], '_blank');", hrefFinal);
                List<String> tabs = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(tabs.get(tabs.size() - 1));

            } else {
                throw new RuntimeException("No se encontró ningún enlace válido de generación de contraseña.");
            }

        } catch (Exception ex) {
            throw new RuntimeException("Error en generación de contraseña: " + ex.getMessage(), ex);
        }
    }
}
