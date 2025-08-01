package utilities;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private static DriveFactory driverFactory = new DriveFactory();

    private static final String screenshotPath = "src/test/resources/screenshots";
    private static final String pageSourcePath = "src/test/resources/pageStructure";

    public static void getScreenshot(String screenshotName) {
        WebDriver driver = driverFactory.getDriver();

        Logs.debug("Tomando Screenshot");

        final var screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        final var path = String.format("%s/%s.png", screenshotPath, screenshotName);

        try {
            FileUtils.copyFile(screenshotFile, new File(path));
        } catch (IOException e) {
            Logs.error("Error al Tomar Screenshot: %s", e.getLocalizedMessage());
        }
    }

    public static void getPageSource(String fileName) {
        WebDriver driver = driverFactory.getDriver();

        Logs.debug("Tomando Page Sorce");

        final var path = String.format("%s/%s.xml", pageSourcePath, fileName);

        try {
            Logs.debug("Creando directorios");
            final var file = new File(path);

            if (file.getParentFile().mkdirs()) {
                final var fileWriter = new FileWriter(file);
                final var pageSource = driver.getPageSource();

                if (pageSource != null) {
                    fileWriter.write(Jsoup.parse(pageSource).toString());
                }
                fileWriter.close();
            }

        } catch (IOException e) {
            Logs.error("error al tomar info:", e.getLocalizedMessage());
        }
    }


    public static void deletePreviousEvidence() {
        try {
            Logs.debug("Borrando Carpeta");
            FileUtils.deleteDirectory(new File(screenshotPath));
            FileUtils.deleteDirectory(new File(pageSourcePath));
        } catch (IOException f) {
            Logs.error("Eliminando evidencias: %s", f.getLocalizedMessage());
        }
    }

    public static void attachScreenshot(Scenario scenario) {
        WebDriver driver = driverFactory.getDriver();

        final var screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        scenario.attach(screenshotFile, "image/png", scenario.getName());
    }

    public static void attachPageSource(Scenario scenario) {
        WebDriver driver = driverFactory.getDriver();

        final var pageSource = driver.getPageSource();
        final var parsedPageSource = Jsoup.parse(pageSource).toString();

        scenario.attach(parsedPageSource, "text/plain", scenario.getName());

    }
}
