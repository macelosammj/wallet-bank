# Desafio
Carteira digital de movimentacao

## Aquitetura
Arquitetura utilizada foi MVC

### Entidades
   * Banco - dados bancários
   * Contas - dados da 
   * Movimentacao - Operacoes de transferencia, saque, deposito

## Frameworks/Libs/Ferramentas
   * [Spring Boot](https://www.springbot.com/)
   * [Hibernate](https://hibernate.org/)
   * [Docker](https://docs.docker.com/)
   * [Liquibase](https://www.liquibase.org/)
   * [Gradle](https://gradle.org/)
   * [Lombok](https://projectlombok.org/)
   * [PostgreSQL](https://www.postgresql.org/)
   * [JacksonJSON](https://www.baeldung.com/jackson/)
   * [RabbitMQ](https://www.rabbitmq.com/)

## Como Usar
    Para utilizar a api:
        * com docker:
            * git clone https://github.com/macelosammj/wallet-bank.git
            * Acessar pagina do projeto
            * Com o docker instalado executar docker-compose up
         
## Variáveis de ambiente
   * POSTGRES_DATABASE
   * POSTGRES_DB
   * POSTGRES_USER
   * POSTGRES_PASSWORD

## API REST
Descricao: API sera executada na porta 8080.
 * Banco
    * /api/banco/ [PUT/POST]
    * /api/banco/{id} [GET]
    * /api/banco/{page}/{limit} [GET]
    * /api/banco/{id} [DELETE]
 * Conta
    * /api/conta/ [PUT/POST]
    * /api/conta/{id}/depositar [POST]
    * /api/conta/{id}/sacar [POST]
    * /api/conta/transferir [POST]
    * /api/lancamento/{id}/extrato [POST]

    
   
