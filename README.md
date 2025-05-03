# User Task App - Java

## Status do Projeto

**Este projeto está em desenvolvimento.** A aplicação já conta com uma implementação funcional da classe `main`, permitindo o cadastro de usuários e criação de tarefas via console. No entanto, ainda existem funcionalidades a serem refinadas e implementadas, como listagem de tarefas, melhorias no fluxo de navegação e persistência de dados.

### Funcionalidades implementadas até o momento:
- Cadastro de usuários:
  - **Gerente**
  - **Desenvolvedor** (com múltiplas especialidades)
  - **Analista** (com múltiplas especialidades)
- Associação de usuários a tarefas.
- Criação de tarefas com:
  - Título
  - Descrição
  - Prioridade (Urgente, Alta, Média, Baixa)
  - Vinculação a usuários já existentes ou recém-criados
- Menu interativo via console

### O que falta:
- Implementação da funcionalidade **"Listar tarefas"** no menu principal.
- Persistência de dados (arquivo ou banco de dados).
- Melhorias na modularização e reaproveitamento de código.
- Validações mais robustas (ex: evitar `NullPointerException`, validar inputs).
- Melhor experiência de usuário na linha de comando (ex: menus mais claros, evitar repetições de entrada).

### Aviso:
O projeto já possui fluxo funcional, mas ainda está **em fase de testes** e pode gerar comportamentos inesperados em determinados fluxos de execução. Novas atualizações serão feitas para estabilizar o código e refinar as funcionalidades.

## Como rodar

### Pré-requisitos:
- Java 8 ou superior instalado

### Passos:
1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/UserTaskApp.git
