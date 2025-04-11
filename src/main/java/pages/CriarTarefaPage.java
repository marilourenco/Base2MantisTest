package pages;

import org.openqa.selenium.By;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CriarTarefaPage extends BasePage {

    private By botaoNovaTarefa = By.xpath("//*[@id=\"sidebar\"]/ul/li[3]/a/span");
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
    private By checkboxPrivado = By.xpath("//*[@id=\"report_bug_form\"]/div/div[2]/div[1]/div/table/tbody/tr[12]/td/label[2]/span");

    private String resumoTarefa = "resumoTarefa";
    private String descricaoTarefa = "descricaoTarefa";
    private String passosTarefa = "Passo 1: Digitar alguma coisa";
    private String informacoesTarefa = "Esta tarefa é relacionada a testes automatizados";

    public CriarTarefaPage(WebDriver driver) {
        super(driver);
    }

    @Step("Abrir tela de criação de tarefa")
    public void abrirTelaCriarTarefa() {
        click(botaoNovaTarefa);
    }

    @Step("Preencher campos obrigatórios")
    public void preencherCamposObrigatorios(String resumoTarefa, String descricaoTarefa) {
        click(campoCategoria);
        click(selecionarOpcao2);

        clear(resumo);
        sendKeys(resumo, resumoTarefa);

        clear(descricao);
        sendKeys(descricao, descricaoTarefa);
    }

    @Step("Preencher todos os campos")
    public void preencherCamposOpcionais() {
        click(campoCategoria);
        click(selecionarOpcao2);
        click(campoFrequencia);
        click(selecionarOpcao3);
        click(campoGravidade);
        click(selecionarOpcao5);
        click(campoPrioridade);
        click(selecionarPrioridade4);
        click(campoSelecionarPerfil);
        click(selecionarPerfil2);

        sendKeys(resumo, resumoTarefa);
        sendKeys(descricao, descricaoTarefa);
        sendKeys(passosParaReproduzir, passosTarefa);
        sendKeys(informacoesAdicionais, informacoesTarefa);

        click(aplicarMarcadores);
        click(selecionarOpcaoMarcador56);

        // Upload de arquivo não implementado
    }

    @Step("Marcar tarefa como pública")
    public void marcarPublica() {
        click(checkboxPublica);
    }

    @Step("Marcar tarefa como privada")
    public void marcarPrivado() {
        click(checkboxPrivado);
    }

    @Step("Submeter tarefa")
    public void criarNovaTarefa() {
        click(botaoCriarNovaTarefa);
    }

    @Step("Validar criação da tarefa")
    public boolean validarCriacaoTarefa() {
        return isDisplayed(mensagemSucesso);
        }
    }