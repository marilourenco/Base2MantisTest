# Base2 Mantis Test Automation

Projeto de automação para o site [Mantis Base2](https://mantis-prova.base2.com.br/), utilizando **Java**, **Selenium WebDriver**, **TestNG** e **Allure** para geração de relatórios de testes.

## :rocket: Tech Stack

- **Java** — Linguagem principal
- **Maven** — Gerenciador de dependências e build
- **Selenium WebDriver** — Core da automação web
- **WebDriverManager** — Gerenciamento automático de drivers
- **TestNG** — Organização e execução de testes (anotações, assertions, paralelismo)
- **Allure Reports** — Geração de relatórios de execução
- **Page Object Model (POM)** — Separação de camadas (páginas, ações, testes)
- **ChromeDriver** e **GeckoDriver** — Suporte a Chrome e Firefox
- **GitHub Actions** — Integração contínua (CI)

## :bookmark_tabs: Estrutura do Projeto

- **src/main/java**: Classes utilitárias e configurações base
- **src/test/java**: Casos de testes organizados por páginas
- **pom.xml**: Configuração de dependências, build e plugins
- **testng.xml**: Organização dos testes
- **Allure Config**: Configuração de geração de relatórios no Maven

## :gear: Configuração e Execução Local

Clone o projeto:

```bash
git clone https://github.com/seu-usuario/Base2MantisTest.git
cd Base2MantisTest
```

Execute os testes localmente:

```bash
./mvnw clean test
```

Gere e visualize o relatório Allure:

```bash
mvn clean test io.qameta.allure:allure-maven:report
```

Ou acesse manualmente o relatório gerado em:

```
target/site/allure-maven-plugin/index.html
```

> Basta abrir o arquivo `index.html` no navegador.

## :bar_chart: Data Driven

Este projeto utiliza o recurso **DataProvider** do TestNG na classe **CriarTarefaTest**para execução de testes com múltiplos dados de entrada.

## :clipboard: Funcionalidades e Cenários

### Tela - Minha Visão

- Verificar tarefas:
  - Validar Tarefa Criada
  - Expandir/Comprimir visão

### Tela - Ver Tarefas

- Aplicar filtros
- Redefinir filtros
- Exportar tarefas para Excel

### Tela - Criar Tarefa

- Criar tarefa com todos os campos preenchidos
- Criar tarefa apenas com campos obrigatórios
- Criar tarefa sem campos obrigatórios (cenário de exceção)

---

## :construction_worker: GitHub Actions - CI Pipeline

O projeto conta com automação de execução dos testes via GitHub Actions:

| Etapa | O que faz |
|:---|:---|
| Checkout | Baixa o código da branch (PR ou push) |
| Setup Java 11 | Instala Java 11 Temurin |
| Permissão ao Maven Wrapper | Dá permissão para executar o `mvnw` em Linux |
| Build e Testes | Executa `./mvnw clean test` |
| Gerar Allure Report | Gera o relatório Allure com Maven |
| Upload do Allure | Faz upload da pasta do relatório como artefato |

### :information_source: Após a execução do Workflow:

- Acesse a aba **Actions** no GitHub.
- Você verá um botão chamado **Artifacts**.
- Faça o download do `.zip` do relatório (`allure-report`).
- Extraia o conteúdo e abra o arquivo `index.html` no navegador para visualizar o relatório completo.

---

## :warning: Problemas Conhecidos

- Uso de **XPath** em alguns localizadores (melhoria futura seria migrar para CSS Selectors mais robustos).
- Ao rodar `mvn clean test`, ocasionalmente sobra uma aba aberta no navegador (problema de encerramento de sessão).

## :bug: Bugs Identificados no Sistema

- Ao criar tarefas com upload de arquivos, a aplicação informa sucesso, mas a tarefa é criada sem o arquivo.

---

## :memo: Observações Finais

- Projeto focado em qualidade de código, reuso e boas práticas.
- Como trata-se de um desafio individual, o projeto não contém fluxo completo de branches, code review e pull requests.

---

**Feito com :heart: por Marilene Lourenço**

Abril/2025
