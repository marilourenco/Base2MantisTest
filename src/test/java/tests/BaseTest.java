package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CriarTarefaPage;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.MinhaVisaoPage;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected CriarTarefaPage criarTarefaPage;
    protected MinhaVisaoPage minhaVisaoPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.get("https://mantis-prova.base2.com.br/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.realizarLogin("marilene.lourenco", "Marilene1987@");
        criarTarefaPage = new CriarTarefaPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}