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
