package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MinhaVisaoPage;
import pages.VerTarefasPage;

import static org.testng.Assert.assertTrue;


public class MinhaVisaoTest extends BaseTest {

    protected MinhaVisaoPage minhaVisaoPage;

    @BeforeMethod
    public void setupVerTarefasPage() {
        minhaVisaoPage = new MinhaVisaoPage(driver);
    }

    @Test(description = "Deve gerenciar a tela Minha Visão com sucesso")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Minha Visão")
    @Story("Usuário gerencia o dashboard Minha Visão")
    @Description("Este teste valida que o usuário gerenciar os relatórios na tela, abrindo tarefas, navegando entre páginas.")
    public void deveGerenciarMinhaVisaoComSucesso() {
        criarTarefaPage.abrirTelaCriarTarefa();
        minhaVisaoPage.colapsarNaoAtribuidos();
        minhaVisaoPage.validarTarefaCriadaVisivel();
        assertTrue(minhaVisaoPage.validarTarefaCriadaVisivel(), "A tarefa criada está visível na tela Minha Visão.");
    }
}