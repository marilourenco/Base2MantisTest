package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.DriversFactory;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        driver = DriversFactory.getDriver();
        driver.get("https://mantis-prova.base2.com.br/");
        loginPage = new LoginPage(driver);
    }

    @Test(description = "Deve realizar login com sucesso")
    public void realizarLoginComSucesso() {
        loginPage.realizarLogin("marilene.lourenco", "Marilene1987@");
    }
}