package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class DriveFactory {

    private static final Map<String, WebDriver> driverMap = new HashMap();
    private final Logger logger = Logger.getLogger(DriveFactory.class.toString());


    public WebDriver getDriver() {
        String identifier = Thread.currentThread().getName();
        WebDriver driver = driverMap.get(identifier);

        if (driver == null) {
            driver = createNewDriverInstance();
            driverMap.put(identifier, driver);
        }
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver createNewDriverInstance() {
        ChromeOptions capabilities = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        capabilities.addArguments("--incognito");

        final WebDriver driver = new ChromeDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return driver;
    }

    public void destroyDriver() {
        String identifier = Thread.currentThread().getName();
        WebDriver driver = driverMap.get(identifier);

        driverMap.remove(identifier);
        try {
            driver.quit();
        } catch (WebDriverException wde) {
            logger.severe("ERROR AL CERRAR TEST");
        }
    }
}
