# API REST para Gerenciamento de Universidade com Spring Boot

Este projeto é uma API REST desenvolvida em Java com o framework Spring Boot. A aplicação implementa um CRUD para o gerenciamento de alunos e seus endereços, além de outras entidades relacionadas ao ambiente universitário.

## Tecnologias Utilizadas

* **Java 24**
* **Spring Boot 3.5.4**
* **Spring Web**: Para a construção de endpoints REST.
* **Spring Data JPA**: Para a camada de persistência de dados.
* **Hibernate**: Como implementação da JPA para o mapeamento objeto-relacional (ORM).
* **H2 Database**: Banco de dados em memória para desenvolvimento e testes.
* **Maven**: Para o gerenciamento de dependências e build do projeto.

## Relacionamento entre Entidades

O modelo de dados da aplicação possui as seguintes entidades e relacionamentos:

* **Aluno e Endereco**: Relacionamento **Um-para-Um** (`@OneToOne`). Cada aluno possui apenas um endereço.
* **Aluno e Curso**: Relacionamento **Muitos-para-Muitos** (`@ManyToMany`). Um aluno pode estar matriculado em vários cursos, e um curso pode ter vários alunos.
* **Curso e Centro**: Relacionamento **Muitos-para-Um** (`@ManyToOne`). Muitos cursos podem pertencer a um único centro acadêmico.
* **Centro e Curso**: Relacionamento **Um-para-Muitos** (`@OneToMany`). Um centro acadêmico pode abrigar vários cursos.

## Funcionalidades

A API oferece as seguintes funcionalidades para as entidades `Aluno` e `Endereco`:

### Aluno

* **Buscar todos os alunos**
* **Buscar um aluno por ID**
* **Cadastrar um novo aluno**
* **Atualizar os dados de um aluno existente**
* **Excluir um aluno**

### Endereço

* **Listar todos os endereços**
* **Salvar um endereço para um aluno**

## Endpoints da API

| Método HTTP | Rota | Descrição |
| :--- | :--- | :--- |
| `GET` | `/aluno` | Retorna a lista de todos os alunos cadastrados. |
| `GET` | `/aluno/{id}` | Busca um aluno específico pelo seu ID. |
| `POST` | `/aluno` | Cadastra um novo aluno no sistema. |
| `PUT` | `/aluno/{id}` | Atualiza as informações de um aluno existente. |
| `DELETE` | `/aluno/{id}` | Exclui um aluno do sistema pelo seu ID. |
| `GET` | `/endereco` | Retorna a lista de todos os endereços cadastrados. |
| `POST` | `/endereco/{id}` | Salva um novo endereço para o aluno com o ID especificado. |

### Exemplo de corpo da requisição (POST/PUT para `/aluno`)

```json
{
    "nome": "João da Silva",
    "dataNascimento": "2000-01-15",
    "email": "joao.silva@example.com",
    "senha": "umaSenhaForte123"
}
```

## ⚙️ Como Executar o Projeto

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina:
* [JDK](https://www.oracle.com/java/technologies/downloads/) (versão 24 ou superior)
* [Maven](https://maven.apache.org/download.cgi) (ou pode usar o Maven Wrapper incluso)

### Rodando a Aplicação

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/api-rest-gerenciamento-alunos-spring-boot.git](https://github.com/seu-usuario/api-rest-gerenciamento-alunos-spring-boot.git)
    ```

2.  **Acesse o diretório do projeto:**
    ```bash
    cd api-rest-gerenciamento-alunos-spring-boot
    ```

3.  **Execute a aplicação usando o Maven Wrapper:**
    * No Linux ou macOS:
        ```bash
        ./mvnw spring-boot:run
        ```
    * No Windows:
        ```bash
        ./mvnw.cmd spring-boot:run
        ```

A aplicação estará disponível em `http://localhost:8080`.

## 🗄️ Acessando o Banco de Dados

O projeto utiliza o banco de dados em memória H2. Para acessá-lo:

1.  Com a aplicação rodando, acesse o seguinte endereço no seu navegador:
    `http://localhost:8080/h2-console`

2.  Utilize as seguintes credenciais para conectar:
    * **Driver Class**: `org.h2.Driver`
    * **JDBC URL**: `jdbc:h2:~/test`
    * **User Name**: `sa`
    * **Password**: (deixe em branco)
