package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By campoUsuario = By.name("username");
    By campoSenha = By.name("password");
    By botaoLogin = By.cssSelector("input[type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Preencher usuário: {0}")
    public void preencherUsuario(String usuario) {
        driver.findElement(campoUsuario).sendKeys(usuario);
        driver.findElement(botaoLogin).click();
    }

    @Step("Preencher senha: {0}")
    public void preencherSenha(String senha) {
        driver.findElement(campoSenha).sendKeys(senha);
        driver.findElement(botaoLogin).click();
    }


    @Step("Realizar Login")
    public void realizarLogin(String usuario, String senha) {
        preencherUsuario(usuario);
        preencherSenha(senha);
    }
}