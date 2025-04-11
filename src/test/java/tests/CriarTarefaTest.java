package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CSVUtils;

@Epic("Gestão de Tarefas")
@Feature("Criar Tarefas")
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
    @Story("Usuário cria tarefa preenchendo apenas campos obrigatórios")
    @Description("Este teste valida que o usuário consegue criar uma tarefa preenchendo apenas os campos obrigatórios.")
    public void deveCriarTarefaComCamposObrigatoriosPreenchidosComSucesso(String campoIgnorado, String resumoTarefa, String descricaoTarefa) {
        Allure.step("Abrir tela de criação de tarefa");
        criarTarefaPage.abrirTelaCriarTarefa();

        Allure.step("Preencher campos obrigatórios");
        criarTarefaPage.preencherCamposObrigatorios(resumoTarefa, descricaoTarefa);

        Allure.step("Marcar tarefa como pública");
        criarTarefaPage.marcarPublica();

        Allure.step("Submeter criação da tarefa");
        criarTarefaPage.criarNovaTarefa();

        Allure.step("Validar se a tarefa foi criada com sucesso");
        Assert.assertTrue(criarTarefaPage.validarCriacaoTarefa(), "A tarefa não foi criada corretamente!");
    }

    @Test(description = "Deve criar uma tarefa preenchendo todos os campos com sucesso")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Usuário cria tarefa preenchendo todos os campos")
    @Description("Este teste valida que o usuário consegue criar uma tarefa preenchendo todos os campos disponíveis.")
    public void deveCriarTarefaComTodosOsCamposPreenchidosComSucesso() {
        Allure.step("Abrir tela de criação de tarefa");
        criarTarefaPage.abrirTelaCriarTarefa();

        Allure.step("Preencher todos os campos da tarefa");
        criarTarefaPage.preencherCamposOpcionais();

        Allure.step("Marcar tarefa como privada");
        criarTarefaPage.marcarPrivado();

        Allure.step("Submeter criação da tarefa");
        criarTarefaPage.criarNovaTarefa();

        Allure.step("Validar se a tarefa foi criada com sucesso");
        Assert.assertTrue(criarTarefaPage.validarCriacaoTarefa(), "A tarefa não foi criada corretamente!");
    }
}
