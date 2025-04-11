package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class CriarTarefaPage {

    private WebDriver driver;

    private By botaoNovaTarefa = By.xpath("//*[@id=\"sidebar\"]/ul/li[3]/a/span");
    private By abaNovaTarefa = By.className("menu-text");
    private By campoCategoria = By.id("category_id");
    private By selecionarOpcao2 = By.xpath("//*[@id=\"category_id\"]/option[2]");
    private By campoFrequencia = By.id("reproducibility");
    private By selecionarOpcao3 = By.xpath("//*[@id=\"reproducibility\"]/option[3]");
    private By resumo = By.xpath("//*[@id=\"summary\"]");
    private By descricao = By.xpath("//*[@id=\"description\"]");
    private By botaoCriarNovaTarefa = By.xpath("//*[@id=\"report_bug_form\"]/div/div[2]/div[2]/input");
    private By mensagemSucesso = By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[1]/h4");
    private By checkboxPublica = By.xpath("//*[@id=\"report_bug_form\"]/div/div[2]/div[1]/div/table/tbody/tr[12]/td/label[1]/span");
    private By campoGravidade = By.xpath("//*[@id=\"severity\"]");
    private By selecionarOpcao5 = By.xpath("//*[@id=\"severity\"]/option[5]");
    private By campoPrioridade = By.xpath("//*[@id=\"priority\"]");
    private By selecionarPrioridade4 = By.xpath("//*[@id=\"priority\"]/option[4]");
    private By campoSelecionarPerfil = By.xpath("//*[@id=\"profile_id\"]");
    private By selecionarPerfil2 = By.xpath("//*[@id=\"profile_id\"]/option[2]");
    private By passosParaReproduzir = By.xpath("//*[@id=\"steps_to_reproduce\"]");
    private By informacoesAdicionais = By.xpath("//*[@id=\"additional_info\"]");
    private By aplicarMarcadores = By.xpath("//*[@id=\"tag_select\"]");
    private By selecionarOpcaoMarcador56 = By.xpath("//*[@id=\"tag_select\"]/option[56]");
    private By arquivoUpload = By.xpath("//*[@id=\"report_bug_form\"]/div/div[2]/div[1]/div/table/tbody/tr[11]/td/div[2]");
    private By checkboxPrivado = By.xpath("//*[@id=\"report_bug_form\"]/div/div[2]/div[1]/div/table/tbody/tr[12]/td/label[2]/span");
    private String resumoTarefa = "Criando uma nova tarefa preenchendo todos os campos obrigatórios";
    private String descricaoTarefa = "Esta é uma tarefa criada através de um teste automatizado";
    private String passosTarefa = "Passo 1: Digitar alguma coisa";
    private String informacoesTarefa = "Esta tarefa é relacionada a testes automatizados";


    public CriarTarefaPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Abrir tela de criação de tarefa")
    public void abrirTelaCriarTarefa() {
        driver.findElement(botaoNovaTarefa).click();
    }

    @Step("Preencher campos obrigatórios")
    public void preencherCamposObrigatorios() {
        driver.findElement(campoCategoria).click();
        driver.findElement(selecionarOpcao2).click();
        driver.findElement(resumo).sendKeys(resumoTarefa);
        driver.findElement(descricao).sendKeys(descricaoTarefa);
    }

    @Step("Preencher todos os campos")
    public void preencherCamposOpcionais() {
        driver.findElement(campoCategoria).click();
        driver.findElement(selecionarOpcao2).click();
        driver.findElement(campoFrequencia).click();
        driver.findElement(selecionarOpcao3).click();
        driver.findElement(campoGravidade).click();
        driver.findElement(selecionarOpcao5).click();
        driver.findElement(campoPrioridade).click();
        driver.findElement(selecionarPrioridade4).click();
        driver.findElement(campoSelecionarPerfil).click();
        driver.findElement(selecionarPerfil2).click();
        driver.findElement(resumo).sendKeys(resumoTarefa);
        driver.findElement(descricao).sendKeys(descricaoTarefa);
        driver.findElement(passosParaReproduzir).sendKeys(passosTarefa);
        driver.findElement(informacoesAdicionais).sendKeys(informacoesTarefa);
        driver.findElement(aplicarMarcadores).click();
        driver.findElement(selecionarOpcaoMarcador56).click();
        //WebElement inputArquivo = driver.findElement(arquivoUpload); não implementado pois apesar da aplicação dizer que criou corretamente a tarefa, ela não havia adicionado o arquivo
        //inputArquivo.sendKeys( "src/main/resources/files/arquivo.txt");

    }

    @Step("Marcar tarefa como pública")
    public void marcarPublica() {
        driver.findElement(checkboxPublica).click();
    }

    @Step("Marcar tarefa como pública")
    public void marcarPrivado() {
        driver.findElement(checkboxPrivado).click();
    }

    @Step("Submeter tarefa")
    public void criarNovaTarefa() {
        driver.findElement(botaoCriarNovaTarefa).click();
    }

    @Step("Validar criação da tarefa")
    public boolean validarCriacaoTarefa() {
        return driver.findElement(mensagemSucesso).isDisplayed();
    }

}