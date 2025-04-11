package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerTarefasPage {

    private final WebDriver driver;

    private By botaoVerTarefas = By.xpath("//*[@id=\"sidebar\"]/ul/li[2]/a/i");
    private By linkMonitoradoPor = By.xpath("//*[@id=\"user_monitor_filter\"]");
    private By dropMonitoradoPor = By.xpath("//*[@id=\"user_monitor_filter_target\"]/select");
    private By selecionarOpcaoMonitoradoPor = By.xpath("//*[@id=\"user_monitor_filter_target\"]/select/option[3]");
    private By linkMarcadores = By.xpath("//*[@id=\"tag_string_filter\"]");
    private By dropMarcadores = By.xpath("//*[@id=\"tag_select\"]");
    private By selecionarOpcaoMarcadores = By.xpath("//*[@id=\"tag_select\"]/option[56]");
    private By linkEstado = By.xpath("//*[@id=\"show_status_filter\"]");
    private By dropEstado = By.xpath("//*[@id=\"show_status_filter_target\"]/select");
    private By selecionarOpcaoEstado = By.xpath("//*[@id=\"show_status_filter_target\"]/select/option[6]");
    private By botaoAplicarFiltro = By.xpath("//*[@id=\"filters_form_open\"]/div[2]/div/div/input[2]");
    private By botaoRedefinir = By.xpath("//*[@id=\"filter\"]/div[2]/div/div/div/div/a");

    public VerTarefasPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Acessar Tela Ver Tarefas")
    public void acessarVerTarefas() {
        driver.findElement(botaoVerTarefas).click();
    }
    @Step("Filtrar por monitorado por")
    public void filtrarPorMonitoradoPor() {
        driver.findElement(linkMonitoradoPor).click();
        driver.findElement(dropMonitoradoPor).click();
        driver.findElement(selecionarOpcaoMonitoradoPor).click();
    }

    @Step("Filtrar por marcadores")
    public void filtrarPorMarcadores() {
        driver.findElement(linkMarcadores).click();
        driver.findElement(dropMarcadores).click();
        driver.findElement(selecionarOpcaoMarcadores).click();
    }

    @Step("Filtrar por estado")
    public void filtrarPorEstado() {
        driver.findElement(linkEstado).click();
        driver.findElement(dropEstado).click();
        driver.findElement(selecionarOpcaoEstado).click();
    }

    @Step("Aplicar Filtros")
    public void aplicarFiltros() {
        driver.findElement(botaoAplicarFiltro).click();
    }

    @Step("Redefinir Filtros")
    public void redefinirFiltros() {
        driver.findElement(botaoRedefinir).click();
    }

}