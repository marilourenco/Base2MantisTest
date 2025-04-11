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
    public void deveGerenciarMinhaVisaoComSucesso() {
        criarTarefaPage.abrirTelaCriarTarefa();
        minhaVisaoPage.colapsarNaoAtribuidos();
        minhaVisaoPage.clicarRelatadosPorMim();
        minhaVisaoPage.clicarVerTarefas();
        minhaVisaoPage.validarTarefaCriadaVisivel();
        assertTrue(minhaVisaoPage.validarTarefaCriadaVisivel(), "A tarefa criada está visível na tela Minha Visão.");
    }
}