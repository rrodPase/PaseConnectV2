package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import utilities.Logs;

import java.time.Duration;
import java.util.List;

public class PageObject {

    public static WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
    }
    private final Faker faker = new Faker();


    String businessName = faker.company().name();
    String rfc = faker.regexify("[A-Z]{4}851212[A-Z]{2}[0-9]{1}");
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
}
