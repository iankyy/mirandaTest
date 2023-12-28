## Endpoints

### Car

| Método |         Endpoint         |               Descrição                        |
|:------:|:------------------------:|:----------------------------------------------:|
|  GET   | "/api/v1/carros"           | Retorna todos os carros de forma paginada      |
|  GET   | "/api/v1/carros/{id}"      | Retorna o carro com o id informado             |
|  POST  | "/api/v1/carros"           | Cadastra um novo carro                         |
|  PUT   | "/api/v1/carros/{id}"      | Atualiza o carro com o id informado            |
| DELETE | "/api/v1/carros/{id}"      | Deleta o carro com o id informado              |

*Ao atualizar um carro (PUT), os campos que não forem informados serão mantidos.*

## Json de exemplo

Para facilitar o entendimento do projeto, segue abaixo um json de exemplo para cada recurso.

### Carro

```json
{
  "veiculo": "Corolla",
  "marca": "Honda",
  "ano": 2020,
  "descricao": "Parece um foguete",
  "vendido": false,
  "createdAt": "2023-01-01", 
  "updatedAt": null,
  "chassi": "6AGjBYwHE4tAV7923",
   "preco": 100
}
```

* O campo CHASSIS deve ser único

### Banco de dados

O banco de dados utilizado foi o H2, que é um banco de dados em memória. Para acessar o console do banco de dados, basta acessar a url http://localhost:8080/h2-console e inserir as informações abaixo:

|    Campo     |         Valor          |
|:------------:|:----------------------:|
| Driver Class |     org.h2.Driver      |
|   JDBC URL   |     jdbc:h2:~/test    |   
|  User Name   |           sa           |
|   Password   |      {em branco}       |
