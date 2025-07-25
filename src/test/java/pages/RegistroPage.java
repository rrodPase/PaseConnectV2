package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistroPage extends PageObject {

    public RegistroPage(WebDriver driver) {
        super(driver);
    }

    private final By emailUser = By.xpath("//*[@id=\"single-spa-application:@pase-connect/login-front\"]/div[1]/div[2]/main/div[1]/div/h2/strong/button");
    private final By FormVerifiy = By.xpath("//*[@id=\"single-spa-application:@pase-connect/login-front\"]/div[1]/div[2]/main/div[1]/form");
    private final By inputPerfil = By.name("id");

    public void IngresoRegistro() {
        find(emailUser).click();
        find(FormVerifiy);
    }

    public void SelectPerfil(String perfil) {
        find(inputPerfil);
    }
}
