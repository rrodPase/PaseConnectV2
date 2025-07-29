package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistroPage extends PageObject {

    public RegistroPage(WebDriver driver) {
        super(driver);
    }


    private final By emailUser = By.xpath("//*[@id=\"single-spa-application:@pase-connect/login-front\"]/div[1]/div[2]/main/div[1]/div/h2/strong/button");
    private final By FormVerifiy = By.xpath("//*[@id=\"single-spa-application:@pase-connect/login-front\"]/div[1]/div[2]/main/div[1]/form");
    private final By inputPerfil = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-z4muo5']");
    private final By inputConinuarRegis = By.xpath("//button[@type='submit']");
    private final By businesName = By.xpath("//input[@name='businessName']");
    private final By TIN = By.xpath("//input[@name='TIN']");
    private final By personType = By.xpath("//select//option[normalize-space(text())='Persona Física']");
    private final By commercialAcronyms = By.xpath("//select//option[normalize-space(text())='Persona física con actividad empresarial']");
    private final By businessType = By.xpath("//select//option[normalize-space(text())='Comercio']");
    private final By postalCode = By.xpath("//input[@name='postalCode']");
    private final By firstName = By.xpath("//input[@name='firstName']");
    private final By lastName = By.xpath("//input[@name='lastName']");
    private final By middleName = By.xpath("//input[@name='middleName']");
    private final By position = By.xpath("//input[@name='position']");
    private final By phone = By.xpath("//input[@name='phone']");
    private final By extension = By.xpath("//input[@name='extension']");
    private final By cellPhone = By.xpath("//input[@name='cellPhone']");
    private final By numberUnits = By.xpath("//input[@name='numberUnits']");
    private final By unitsType = By.xpath("//select//option[normalize-space(text())='Autobús Camión 2 Ejes']");
    private final By message = By.xpath("//textarea[@name='message']");
    private final By iAgreeTerms = By.xpath("//input[@name='iAgreeTerms']");


    public void IngresoRegistro() {
        find(emailUser).click();
        find(FormVerifiy);
    }

    public void SelectPerfil(String ClienteCorp) {
        find(inputPerfil).click();
        Selected(inputPerfil, ClienteCorp);
        find(inputConinuarRegis).click();
    }

    public void CompletarRegistro() {
        find(businesName).sendKeys(businessName);
        find(TIN).sendKeys(rfc);
        find(personType).click();
        find(commercialAcronyms).click();
        find(businessType).click();
        find(postalCode).sendKeys(postalCodes);
        find(firstName).sendKeys(firstNames);
        find(lastName).sendKeys(lastNames);
        find(middleName).sendKeys(middleNames);
        find(position).sendKeys(positions);
        find(phone).sendKeys(phones);
        find(extension).sendKeys(extensions);
        find(cellPhone).sendKeys(cellPhones);
        find(numberUnits).sendKeys(numberUnit);
        find(unitsType).click();
        find(message).sendKeys(messages);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement inputButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"single-spa-application:@pase-connect/login-front\"]/div[1]/div[2]/main/div/div[2]/div/form/div[5]/div/input")
        ));

        inputButton.click();
    }
}
