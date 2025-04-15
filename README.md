# Base2 Mantis Test Automation

Projeto de automação para o site [Mantis Base2](https://mantis-prova.base2.com.br/), utilizando **Java**, **Selenium WebDriver**, **TestNG** **Github Actions** e **Allure** para geração de relatórios de testes.

**Foram exploradas práticas como reuso, testes rodando headless, camadas base e swich, datadriven e page objects.**

## :rocket: Tech Stack

- **Java** — Linguagem principal
- **Maven** — Gerenciador de dependências e build
- **Selenium WebDriver** — Core da automação web
- **WebDriverManager** — Gerenciamento automático de drivers
- **TestNG** — Organização e execução de testes (anotações, assertions, paralelismo)
- **Allure Reports** — Geração de relatórios de execução
- **Page Object Model (POM)** — Separação de camadas (páginas, ações, testes)
- **ChromeDriver** — Suporte a Chrome
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
---

Claro! Já reescrevi pra refletir que agora **só rodamos os testes**, sem relatórios Allure:  

---

## :construction_worker: GitHub Actions - CI Pipeline

O projeto conta com automação de execução dos testes via GitHub Actions:

| Etapa | O que faz |
|:---|:---|
| Checkout | Baixa o código da branch (PR ou push) |
| Setup Java 11 | Instala o Java 11 (Temurin) |
| Cache Maven | Usa cache para as dependências do Maven |
| Build e Testes | Executa `mvn clean test` para compilar e rodar os testes |

---

## :warning: Problemas Conhecidos

- Uso de **XPath** em alguns localizadores (melhoria futura seria migrar para CSS Selectors mais robustos).
- Ao rodar `mvn clean test`, ocasionalmente sobra uma aba aberta no navegador (problema de encerramento de sessão).

## :bug: Bugs Identificados no Sistema

- Ao criar tarefas com upload de arquivos, a aplicação informa sucesso, mas a tarefa é criada sem o arquivo.

---

## :bulb: Possíveis Melhorias

- **Melhorar os localizadores**: Refatorar o uso de **XPath** para **CSS Selectors** onde for possível, aumentando a performance e estabilidade dos testes.
- **Implementar testes de exceções**: Adicionar cenários negativos e de validação de erros (ex.: campos obrigatórios não preenchidos, permissões inválidas).
- **Suporte a múltiplos browsers**: Ampliar a execução para browsers como **Firefox** e **Edge**, garantindo maior cobertura cross-browser.
- **Parallel Testing**: Configurar o **TestNG** para executar os testes em paralelo e reduzir o tempo de execução.
- **Ambientes Dinâmicos**: Permitir rodar testes apontando para diferentes ambientes (desenvolvimento, homologação, produção) usando parâmetros no Maven ou arquivos de configuração.
- **Pipeline de CI aprimorado**: Incluir etapas de:
  - Geração automática do relatório Allure após execução.
  - Upload automático dos relatórios para repositórios de artefatos ou integração com ferramentas como Slack/Teams.
- **Inclusão de testes visuais**: Integrar alguma ferramenta de comparação visual para validar layout e aparência (ex.: **Applitools**, **Percy**).
- **Gerenciamento de dados de teste**: Centralizar e versionar os dados de entrada dos testes de forma mais estruturada (ex.: arquivos `.csv`, `.json` ou banco de dados de teste).
---

**Feito com :heart: por Marilene Lourenço**

Abril/2025
