package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;

public class SwichPage {

    private WebDriver driver;

    // Elementos de navegação
    private By menuTarefas = By.xpath("//*[@id=\"sidebar\"]/ul/li[3]/a/span");
    private By menuDashboard = By.xpath("//*[@id=\"sidebar\"]/ul/li[1]/a/span");
    private By menuPerfil = By.xpath("//*[@id=\"sidebar\"]/ul/li[4]/a/span");
    private By menuSair = By.xpath("//*[@id=\"sidebar\"]/ul/li[5]/a/span");

    public SwichPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ir para a página de Tarefas")
    public void irParaTarefas() {
        driver.findElement(menuTarefas).click();
    }

    @Step("Ir para a Dashboard")
    public void irParaDashboard() {
        driver.findElement(menuDashboard).click();
    }

    @Step("Ir para o Perfil")
    public void irParaPerfil() {
        driver.findElement(menuPerfil).click();
    }

    @Step("Realizar Logout")
    public void realizarLogout() {
        driver.findElement(menuSair).click();
    }
}
