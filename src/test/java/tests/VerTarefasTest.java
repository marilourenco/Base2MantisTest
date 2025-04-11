package tests;

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
    public void deveFiltrarComSucesso() {
        verTarefasPage.filtrarPorMonitoradoPor();
        verTarefasPage.filtrarPorEstado();
        verTarefasPage.filtrarPorMarcadores();
        verTarefasPage.aplicarFiltros();
    }

    @Test(description = "Deve redefinir os filtros por padrão - todos como 'qualquer' com sucesso")
    public void deveRedefinirFiltrosComSucesso() {
        verTarefasPage.filtrarPorEstado();
        verTarefasPage.redefinirFiltros();
    }
}