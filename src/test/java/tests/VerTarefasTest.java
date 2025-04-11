package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.VerTarefasPage;

public class VerTarefasTest extends BaseTest {

    protected VerTarefasPage verTarefasPage;

    @BeforeMethod
    public void setupVerTarefasPage() {
        verTarefasPage = new VerTarefasPage(driver);
        verTarefasPage.acessarVerTarefas();
    }

    @Test(description = "Deve filtrar por 'Monitorado Por','Estado' e 'Marcadores' com sucesso")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Ver Tarefas")
    @Story("Usuário gerencia as tarefas da tela Ver Telas, utilizando filtros para buscar tarefas específicas")
    @Description("Este teste valida que o usuário consegue aplicar filtros com sucesso.")
    public void deveFiltrarComSucesso() {
        verTarefasPage.filtrarPorMonitoradoPor();
        verTarefasPage.filtrarPorEstado();
        verTarefasPage.filtrarPorMarcadores();
        verTarefasPage.aplicarFiltros();
    }

    @Test(description = "Deve redefinir os filtros por padrão - todos como 'qualquer' com sucesso")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Ver Tarefas")
    @Story("Usuário gerencia as tarefas da tela Ver Telas, utilizando o botão redefinir para voltar aos filtros padrão")
    @Description("Este teste valida que o usuário consegue redefinir filtros com sucesso.")
    public void deveRedefinirFiltrosComSucesso() {
        verTarefasPage.filtrarPorEstado();
        verTarefasPage.redefinirFiltros();
    }

    @Test(description = "Deve clicar no botão Gerar Aqquivo Excel e salvar no Chrome")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Ver Tarefas")
    @Story("Usuário gerencia as tarefas da tela Ver Telas, clicando no botão Gerar Arquivo Excel")
    @Description("Este teste valida que o usuário consegue clicar no botão Gerar Arquivo Excel e ver ele sendo gerado com sucesso.")
    public void deveGerarExecl() {
        verTarefasPage.gerarExcel();
    }
}