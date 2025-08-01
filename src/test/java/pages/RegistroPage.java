package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.SingletonData;

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
    private final By btnRegistrarte = By.xpath("//*[@id=\"single-spa-application:@pase-connect/login-front\"]/div[1]/div[2]/main/div/div[2]/div/form/div[7]/div/button");
    private final By NewPassword = By.id("new-password");
    private final By confirmPassword = By.id(":r2:");
    private final By confirmbtnPass = By.xpath("//*[@id=\"single-spa-application:@pase-connect/login-front\"]/div[1]/div[2]/main/div[1]/form/div/div[4]/div/button");
    private final By validarMessageCon =  By.xpath("//*[@id=\"modal-description\"]");
    private final By AceptarRegistro = By.xpath("/html/body/div/div[3]/div[2]/div/button");

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
        WebElement checkbox = driver.findElement(iAgreeTerms);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
        esperaSecunds();
        find(btnRegistrarte).click();
    }

    public void CompletarPassword() {
        String Passwords =  password;
        find(NewPassword).sendKeys(Passwords);
        find(confirmPassword).sendKeys(Passwords);
        SingletonData.get().setPasswordSin(Passwords);
        find(confirmbtnPass).click();
    }

    public void ValidacionRegistro() {
        find(validarMessageCon);
        find(AceptarRegistro).click();
        driver.close();
        SingletonData.get().getVentanaPrincipal();
    }
}
