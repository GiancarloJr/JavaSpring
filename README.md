# JavaSpring
ProjectForTest

Link Swagger: http://localhost:8080/swagger-ui.html


1. O teste de API consiste em criar um CRUD das entidades abaixo:
Entidade Pessoa
- Id *
- CPF *
- Nome *
- E-mail *
- CEP
- Logradouro
- Complemento
- Bairro
- UF
- Lista<Contato> contatos

Entidade Contato
- Pessoa *
- Nome *
- Telefone *
- Celular *
Obs: Os campos marcados com * são obrigatórios na hora de cadastrar uma pessoa/contato. 
Tecnologias:
- A API deve ser desenvolvida em Java Spring Boot.
- O banco de dados fica a seu critério.
- É obrigatório o uso do Spring Data JPA para realizar os CRUDS.
O que será avaliado?
- Estrutura do projeto, boas práticas e o uso do Spring Data JPA.
- Commits no github.
O que será diferencial, mas não obrigatório?
- Criação de testes unitário para cada operação
