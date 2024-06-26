# Projeto All Project Gym

## 1. Sobre o Projeto

O All Project Gym é uma aplicação desenvolvida para gerenciar e acompanhar fichas de treino, estabelecendo uma relação eficiente entre alunos, exercícios e anamneses. Este projeto visa implementar e aprimorar técnicas de programação utilizando tecnologias modernas. Com uma estrutura flexível, com o decorrer do projeto, pretendo criar novos modulos, afim de tornar o sistema mais robusto.

## 2. Tecnologias Utilizadas

O desenvolvimento do All Project Gym envolveu o uso de diversas tecnologias e ferramentas de ponta:

- **Linguagens de Programação**:
  - Java
  - TypeScript
  - JavaScript

- **Frameworks**:
  - Angular (Frontend)
  - React Native (Mobile)
  - Spring Boot (Backend)

- **Banco de Dados**:
  - PostgreSQL

## 3. Instalação e Uso

### Pré-requisitos

Certifique-se de ter os seguintes pré-requisitos instalados em sua máquina:

- Node.js
- Angular CLI (para executar o frontend Angular)
- PostgreSQL

### Passo a Passo de Instalação

1. Clone o repositório:
   - ```
     git clone https://github.com/lucasff21/allProjectGym.git
     ```
## 4. Configurações

### Configuração do Backend

No arquivo application.properties do backend (Spring Boot), configure as variáveis spring.datasource.username e spring.datasource.password com suas credenciais de banco de dados PostgreSQL local.
Certifique-se de ter criado um banco de dados localmente com o nome allProject.

### 5. Iniciando a Aplicação

Para iniciar a aplicação, siga os passos abaixo:

#### Iniciando o Backend (Spring Boot)

1. Abra sua IDE (IntelliJ IDEA, Eclipse, Spring Tool Suite, etc.).
2. Importe o projeto backend.
3. Inicie o servidor Spring Boot.

#### Frontend Angular

- Abra o Visual Studio Code.
- Navegue até o diretório do projeto frontend (`cd allProjectGym/frontend`).
- Instale as dependências:
   `npm install`
- Inicie o servidor Angular:
   `ng serve --open`

  Isso iniciará o frontend Angular e abrirá automaticamente uma janela do navegador.

#### Aplicativo React Native

- Abra o Visual Studio Code.
- Navegue até o diretório do projeto React Native (`cd allProjectGym/consumeApi-ReactNative`).
- Instale as dependências:
   `npm install`
- Inicie o aplicativo no dispositivo Android conectado ou no emulador:
   `npm run android`

  Isso iniciará o aplicativo React Native no dispositivo Android conectado ou no emulador.



