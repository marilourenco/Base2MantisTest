package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MinhaVisaoPage {

    private WebDriver driver;

    private By botaoMinhaVisao = By.xpath("/html/body/div[2]/div[1]/ul/li[1]/a/i");
    private By botaoNaoAtribuidos = By.xpath("//*[@id=\"unassigned\"]/div[1]/div[1]/a/i");
    private By linkVerTarefas = By.xpath("//*[@id=\"reported\"]/div[1]/div[2]/div/a");
    private String tarefaCriada = "Criando uma nova tarefa preenchendo todos os campos obrigatórios";

    public MinhaVisaoPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Colapsar 'Não Atribuídos'")
    public void colapsarNaoAtribuidos() {
        driver.findElement(botaoMinhaVisao).click();
        driver.findElement(botaoNaoAtribuidos).click();
    }

    @Step("Clicar no link 'Ver Tarefas'")
    public void clicarVerTarefas() {
        driver.findElement(linkVerTarefas).click();
        driver.findElement(botaoMinhaVisao).click();
    }

    @Step("Validar se a tarefa criada está visível na listagem")
    public boolean validarTarefaCriadaVisivel() {
        return driver.getPageSource().contains(tarefaCriada);
    }
}