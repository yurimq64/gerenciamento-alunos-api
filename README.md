# API REST para Gerenciamento de Alunos com Spring Boot

Este projeto é uma API REST desenvolvida em Java com o framework Spring Boot, criada como parte dos estudos da minha disciplina de desenvolvimento de plataformas web. A aplicação implementa um CRUD para o gerenciamento de alunos.

## Tecnologias Utilizadas

* **Java 24**
* **Spring Boot 3.5.4**
* **Spring Web**: Para a construção de endpoints REST.
* **Spring Data JPA**: Para a camada de persistência de dados.
* **Hibernate**: Como implementação da JPA para o mapeamento objeto-relacional (ORM).
* **H2 Database**: Banco de dados em memória para desenvolvimento e testes.
* **Maven**: Para o gerenciamento de dependências e build do projeto.

## Funcionalidades

A API oferece as seguintes funcionalidades para a entidade `Aluno`:

* **Buscar todos os alunos**
* **Buscar um aluno por ID**
* **Cadastrar um novo aluno**
* **Atualizar os dados de um aluno existente**
* **Excluir um aluno**

## Endpoints da API

| Método HTTP | Rota          | Descrição                                         |
| :---------- | :------------ | :------------------------------------------------ |
| `GET`       | `/aluno`      | Retorna a lista de todos os alunos cadastrados.   |
| `GET`       | `/aluno/{id}` | Busca um aluno específico pelo seu ID.            |
| `POST`      | `/aluno`      | Cadastra um novo aluno no sistema.                |
| `PUT`       | `/aluno/{id}` | Atualiza as informações de um aluno existente.    |
| `DELETE`    | `/aluno/{id}` | Exclui um aluno do sistema pelo seu ID.           |

### Exemplo de corpo da requisição (POST/PUT)

```json
{
    "nome": "João da Silva",
    "dataNascimento": "2000-01-15T00:00:00.000+00:00",
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
