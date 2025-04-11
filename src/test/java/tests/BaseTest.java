package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

        ChromeOptions options = new ChromeOptions();

        // Aqui a mágica: pega o parâmetro -Dheadless
        String headless = System.getProperty("headless", "true");
        if (headless.equalsIgnoreCase("true")) {
            options.addArguments("--headless=new"); // Usa o modo headless novo do Chrome
        }

        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox"); // Opcional, bom pra rodar em CI
        options.addArguments("--disable-dev-shm-usage"); // Opcional, melhora estabilidade em containers

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://mantis-prova.base2.com.br/");

        loginPage = new LoginPage(driver);
        loginPage.realizarLogin("marilene.lourenco", "Marilene1987@");

        criarTarefaPage = new CriarTarefaPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.out.println("Erro ao fechar o navegador: " + e.getMessage());
            }
        }
    }
}
