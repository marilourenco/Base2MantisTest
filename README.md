# Base2 Mantis Automation Project

Este projeto tem como objetivo automatizar fluxos do site [Mantis Prova Base2](https://mantis-prova.base2.com.br) utilizando Selenium WebDriver com Java, TestNG e Allure para geração de relatórios. Foi criado do zero, com boas práticas de automação, como reuso de código, arquitetura em camadas (base/switch), utilização de Page Object Model e testes data-driven.

---

## 📚 Tech Stack

- **Java** — Linguagem principal
- **Maven** — Gerenciador de dependências e build
- **Selenium WebDriver** — Framework de automação web
- **WebDriver Manager** — Gerenciamento automático de drivers (Chrome/Firefox)
- **TestNG** — Organização de testes (anotações, asserções, execuções paralelas)
- **Allure Reports** — Geração de relatórios ricos e visuais
- **Page Object Model (POM)** — Organização do projeto em camadas
- **Drivers** — ChromeDriver e GeckoDriver
- **GitHub** — Repositório e CI/CD

---

## 📂 Estrutura do Projeto

- `src/main/java/base/` — Classes bases (configurações de driver, basePage)
- `src/main/java/pages/` — Mapeamento e ações das páginas
- `src/test/java/tests/` — Casos de teste
- `src/test/resources/` — Massa de dados, evidências e configurações
- `pom.xml` — Configurações e dependências do Maven

---

## 🏁 Como Executar

### Rodar Testes e Gerar Relatório
```bash
mvn clean test io.qameta.allure:allure-maven:report
```

### Acessar Relatório
Após execução:
```
.../Base2MantisTest/target/site/allure-maven-plugin/index.html
```
Basta clicar no arquivo e abrir no navegador de sua preferência.

---

## 🧪 Fluxos de Teste Priorizados

1. **Criar Tarefa Completa**
    - Preenche todos os campos, anexa arquivo, marca como pública e valida criação.

2. **Criar Tarefa com Erro**
    - Deixa campos obrigatórios vazios e valida mensagens de erro.

3. **Minha Visão**
    - Acessa "Relatados por mim", navega para "Ver tarefas" e valida se a tarefa aparece.

4. **Ver Tarefas - Filtrar e Redefinir**
    - Aplica filtros, valida listagem e redefine filtros.

5. **Ver Tarefas - Exportar CSV**
    - Exporta tarefas para CSV e valida o download.

---

## 🔧 Data Driven

Foi utilizado o recurso `@DataProvider` do TestNG na classe `CriarTarefaTest` para parametrizar os testes de forma prática e flexível, melhorando o reuso de código e a cobertura de diferentes cenários.

---

## ⚠️ Desafios Encontrados

- Utilização de XPathno projeto (entendo como má prática reconhecida).
- Após execução dos testes via `mvn clean test`, uma aba do navegador permanece aberta mesmo com sucesso nos testes e modo headless configurado.

---

## 🐞 Bugs Encontrados na Aplicação

- Ao criar automaticamente uma tarefa com upload de arquivo, a aplicação confirma sucesso mesmo quando ocorre falha no upload, a tarefa é criada sem o arquivo.

---

## 💡 Observações

- Como o projeto foi desenvolvido individualmente, **não fiz uso de branchs ou pull requests**.
- O projeto foi focado em **boa estruturação, reuso de código, modularidade e geração de relatórios** para facilitar manutenção e escalabilidade futura.

---

Feito com 💻 e ☕ por Marilene Lourenço.
