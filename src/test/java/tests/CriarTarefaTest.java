package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CriarTarefaTest extends BaseTest {


    @Test(description = "Deve criar uma tarefa preenchendo apenas os campos obrigatórios com sucesso")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Criar Tarefas")
    @Story("Usuário cria tarefa preenchendo apenas campos obrigatórios")
    @Description("Este teste valida que o usuário consegue criar uma tarefa preenchendo apenas os campos obrigatórios.")
    public void deveCriarTarefaComCamposObrigatoriosPreenchidosComSucesso() {
        criarTarefaPage.abrirTelaCriarTarefa();
        criarTarefaPage.preencherCamposObrigatorios();
        criarTarefaPage.marcarPublica();
        criarTarefaPage.criarNovaTarefa();
        criarTarefaPage.validarCriacaoTarefa();
        Assert.assertTrue(criarTarefaPage.validarCriacaoTarefa(), "Ver Detalhes da Tarefa");

    }

    @Test(description = "Deve criar uma tarefa preenchendo todos os campos com sucesso")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Criar Tarefas")
    @Story("Usuário cria tarefa preenchendo todos os campos")
    @Description("Este teste valida que o usuário consegue criar uma tarefa preenchendo todos os campos disponíveis.")
    public void deveCriarTarefaComTodosOsCamposPreenchidosComSucesso() {
        criarTarefaPage.abrirTelaCriarTarefa();
        criarTarefaPage.preencherCamposOpcionais();
        criarTarefaPage.marcarPrivado();
        criarTarefaPage.criarNovaTarefa();
        criarTarefaPage.validarCriacaoTarefa();
        Assert.assertTrue(criarTarefaPage.validarCriacaoTarefa(), "Ver Detalhes da Tarefa");
    }
}