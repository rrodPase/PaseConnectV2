package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Logs;

import java.time.Duration;

public class PageObject {

    public static WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
    }

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

    public WebElement find(By locator) {
        waitItems(30, locator);
        return driver.findElement(locator);
    }
}
