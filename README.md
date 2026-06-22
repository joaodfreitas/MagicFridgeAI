# 🧊 MagicFridge AI ✨

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge\&logo=openjdk\&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.6-6DB33F?style=for-the-badge\&logo=spring-boot\&logoColor=white)
![OpenAI](https://img.shields.io/badge/OpenAI-API-412991?style=for-the-badge\&logo=openai\&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.1-005F0F?style=for-the-badge\&logo=thymeleaf\&logoColor=white)

O **MagicFridge AI** é uma aplicação web fullstack desenvolvida para ajudar no gerenciamento de alimentos e reduzir o desperdício. Através de uma integração com a API da OpenAI, o sistema analisa os ingredientes cadastrados na geladeira e gera receitas personalizadas utilizando apenas os itens disponíveis.

## 🌟 Funcionalidades

* ✅ Cadastro de alimentos
* ✅ Listagem de ingredientes armazenados
* ✅ Atualização de alimentos cadastrados
* ✅ Controle de quantidade e validade
* ✅ Geração automática de receitas utilizando Inteligência Artificial
* ✅ Interface web simples utilizando Thymeleaf

## 🛠️ Tecnologias Utilizadas

### Backend

* Java 17
* Spring Boot
* Spring Data JPA
* Hibernate
* Spring WebFlux
* Maven

### Frontend

* Thymeleaf
* HTML5
* CSS3
* JavaScript

### Integrações

* OpenAI API

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas para facilitar manutenção e escalabilidade.

### Controller Layer

* FoodItemController
* RecipeController
* PageController

### Service Layer

* FoodItemService
* ChatGptService

### Repository Layer

* FoodItemRepository

### Model Layer

* FoodItem
* Categoria

## 🚀 Como Executar o Projeto

### Pré-requisitos

* Java JDK 17 ou superior
* Maven
* Chave da API OpenAI

### 1. Clonar o repositório

```bash
git clone https://github.com/joaodfreitas/MagicFridgeAI.git

cd MagicFridgeAI
```

### 2. Configurar a variável de ambiente

#### Windows (PowerShell)

```powershell
$env:OPENAI_API_KEY="sua_chave_aqui"
```

#### Windows (CMD)

```cmd
set OPENAI_API_KEY=sua_chave_aqui
```

#### Linux/Mac

```bash
export OPENAI_API_KEY=sua_chave_aqui
```

### 3. Executar a aplicação

```bash
mvn spring-boot:run
```

### 4. Acessar no navegador

```text
http://localhost:8080/
```

## 💡 Como Utilizar

1. Acesse a aplicação pelo navegador.
2. Cadastre os alimentos disponíveis na sua geladeira.
3. Visualize todos os ingredientes cadastrados.
4. Atualize os itens quando necessário.
5. Clique em **Gerar Receita**.
6. A IA analisará os ingredientes cadastrados e criará uma receita personalizada.

## 🎯 Objetivo do Projeto

Este projeto foi desenvolvido com o objetivo de praticar conceitos de desenvolvimento Full Stack utilizando Java e Spring Boot, incluindo:

* Desenvolvimento de APIs REST
* Integração com APIs externas
* Persistência de dados com JPA/Hibernate
* Criação de interfaces web com Thymeleaf
* Boas práticas de arquitetura em camadas


