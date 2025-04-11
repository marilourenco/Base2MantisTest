package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CSVUtils;

public class CriarTarefaTest extends BaseTest {

    @DataProvider(name = "tarefasObrigatorias")
    public Object[][] tarefasObrigatorias() {
        return CSVUtils.readCSV("/data/VerTarefasTest.csv");
    }

    @Test(
            description = "Deve criar uma tarefa preenchendo apenas os campos obrigatórios com sucesso",
            dataProvider = "tarefasObrigatorias"
    )
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Criar Tarefas")
    @Story("Usuário cria tarefa preenchendo apenas campos obrigatórios")
    @Description("Este teste valida que o usuário consegue criar uma tarefa preenchendo apenas os campos obrigatórios.")
    public void deveCriarTarefaComCamposObrigatoriosPreenchidosComSucesso(String campoIgnorado, String resumoTarefa, String descricaoTarefa) {
        criarTarefaPage.abrirTelaCriarTarefa();
        criarTarefaPage.preencherCamposObrigatorios(resumoTarefa, descricaoTarefa);
        criarTarefaPage.marcarPublica();
        criarTarefaPage.criarNovaTarefa();
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
        Assert.assertTrue(criarTarefaPage.validarCriacaoTarefa(), "Ver Detalhes da Tarefa");
    }
}
