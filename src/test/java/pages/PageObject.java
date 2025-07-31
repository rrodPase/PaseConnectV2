package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import utilities.SingletonData;
import utilities.Logs;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class PageObject {

    public static WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
    }
    private final Faker faker = new Faker();

    String businessName = faker.company().name();
    String rfc = faker.regexify("[A-Z]{4}851212[A-Z]{2}[0-9]{1}");
    String password = faker.regexify("[A-Z]{3}[a-z]{1}[0-9]{2}[.]");
    String postalCodes = "26400";
    String firstNames = faker.name().firstName();
    String lastNames = faker.name().lastName();
    String middleNames = faker.name().lastName();
    String positions = faker.job().position();
    String phones = faker.phoneNumber().cellPhone();
    String extensions = faker.number().digits(3);
    String cellPhones = faker.phoneNumber().cellPhone();
    String numberUnit = String.valueOf(faker.number().numberBetween(1, 100));
    String messages = faker.lorem().sentence();

    public void waitItems(int timeMS, By element) {
        Logs.info("Validando visualidad: " + element);
        try {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(timeMS))
                    .pollingEvery(Duration.ofSeconds(timeMS))
                    .ignoring(NoSuchElementException.class);
            wait.until(driver -> driver.findElement(element));
        } catch (Exception e) {
            Logs.error("Item " + element + " NO es visible:");
        }
    }

    public void esperaSecunds(){
        long inicio = System.currentTimeMillis();
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(driver1 -> {
            long ahora = System.currentTimeMillis();
            return (ahora - inicio) >= 15000;
        });
    }

    public void Selected(By inputPerfil, String clienteCorp) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> Perfiles = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(inputPerfil));
        for (WebElement Perfil : Perfiles){
            String opcion = Perfil.getText().trim();
            if (opcion.equalsIgnoreCase(clienteCorp)){
                Perfil.click();
                break;
            }
        }
    }

    public WebElement find(By locator) {
        waitItems(30, locator);
        return driver.findElement(locator);
    }

    public String abrirNuevaPestanaConUrl(String url) {
        Set<String> handlesAntes = driver.getWindowHandles();
        ((JavascriptExecutor) driver).executeScript("window.open('about:blank', '_blank');");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(d -> d.getWindowHandles().size() > handlesAntes.size());
        Set<String> handlesDespues = driver.getWindowHandles();
        handlesDespues.removeAll(handlesAntes);
        String nuevaPestanaHandle = handlesDespues.iterator().next();
        SingletonData.get().setVentanaTemporal(nuevaPestanaHandle);
        SingletonData.get().setVentanaPrincipal(handlesAntes.iterator().next());
        driver.switchTo().window(nuevaPestanaHandle);
        driver.get(url);
        return nuevaPestanaHandle;
    }

    public void cambiarAVentanaTMP() {
        String tmp = SingletonData.get().getVentanaTemporal();
        driver.switchTo().window(tmp);
    }

    public void cambiarAVentanaPrincipal() {
        driver.switchTo().window(SingletonData.get().getVentanaPrincipal());
    }
}
