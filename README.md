# JavaSpring
Projeto API Java

Java com Spring Boot 2.7.6

Link Swagger: http://localhost:8080/swagger-ui.html

Banco de dados principal: h2 database
Banco de dados opcional: PostGress (Script no importsql ou configurar migration com flyway)

Validação de campos obrigatórios.
Metodo para Validação de CPF e Email.

Testes de Estrutura de Entidades
Testes dos metodos findById, DeleteById e Exceptions

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

2. Para os testes abaixo, pode-se criar uma aplicação console mesmo, e em um único arquivo, 
desde que seja criado dois métodos diferentes.

2.1 Escreva um método que calcule o fatorial de um número dado. O número deve ser maior
ou igual à zero. Utilizar recursão.

Exemplos:
factorial(2)
- resultado: 2 (2 * 1)

factorial(5)
- resultado: 120 (5 * 4 * 3 * 2 * 1)

2.2 Dado um array de strings, remova as letras duplicadas em sequência de cada palavra.
Exemplos: 

duplicates(["abracadabra","allottee","assessee"])
- resultado: ["abracadabra","alote","asese"] 

duplicates(["kelless","keenness","Alfalggo"])
- resultado: ["keles","kenes","Alfalgo"]
