package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Logs;

public class LoginPage extends PageObject {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By emailUser = By.xpath("//*[@id=\"email\"]");
    private final By passwordUser = By.xpath("//*[@id=\"password\"]");
    private final By btnLogin = By.xpath("//*[@id=\"single-spa-application:@pase-connect/login-front\"]/div[1]/div[2]/main/div[1]/form/div/div[4]/div/button");
    private final By body = By.tagName("body");
    private final By nombreUser = By.xpath("//*[@id=\"onboarding-app-root\"]/div[1]/main/div/div/div/div[1]/p[1]");
    private final By campoCodigo = By.xpath("//*[@id=\":r3:\"]");

    public void fillDataLogin(String usuario, String contraseña) {
        find(emailUser).sendKeys(usuario);
        find(passwordUser).sendKeys(contraseña);
    }

    public void InicioSesion() {
        find(body).click();
        find(btnLogin).click();
    }

    public void validaInicio() {
        WebElement nombre = find(nombreUser);
        Logs.info("Se inicio sesion con: "+nombre);
    }

    public void validatwofactor() {
        find(campoCodigo);
    }
}
