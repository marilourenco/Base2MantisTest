package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CriarTarefaTest extends BaseTest {


    @Test(description = "Deve criar uma tarefa com todos os campos obrigatórios com sucesso")
    public void deveCriarTarefaComCamposObrigatoriosPreenchidosComSucesso() {
        criarTarefaPage.abrirTelaCriarTarefa();
        criarTarefaPage.preencherCamposObrigatorios();
        criarTarefaPage.marcarPublica();
        criarTarefaPage.criarNovaTarefa();
        criarTarefaPage.validarCriacaoTarefa();
        Assert.assertTrue(criarTarefaPage.validarCriacaoTarefa(), "Ver Detalhes da Tarefa");

    }
    @Test(description = "Deve criar uma tarefa com todos os campos preenchidos sucesso")
    public void deveCriarTarefaComTodosOsCamposPreenchidosComSucesso() {
        criarTarefaPage.abrirTelaCriarTarefa();
        criarTarefaPage.preencherCamposOpcionais();
        criarTarefaPage.marcarPrivado();
        criarTarefaPage.criarNovaTarefa();
        criarTarefaPage.validarCriacaoTarefa();
        Assert.assertTrue(criarTarefaPage.validarCriacaoTarefa(), "Ver Detalhes da Tarefa");
    }
}