package steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import utilities.DriveFactory;
import utilities.FileManager;


public class finalSteps {

    private DriveFactory driverFactory = new DriveFactory();

    @After
    public void quitDriver(Scenario scenario) {
        switch (scenario.getStatus()) {
            case SKIPPED, FAILED -> {
                FileManager.deletePreviousEvidence();
                FileManager.getScreenshot(scenario.getName());
                FileManager.getPageSource(scenario.getName());
                FileManager.attachScreenshot(scenario);
                FileManager.attachPageSource(scenario);
            }
        }
        //driverFactory.destroyDriver();
    }
}
