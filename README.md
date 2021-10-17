# cities-api-dio

## Sobre 📰

Este é um desafio de projeto realizado na digitalinnovation.one.

O objetivo desta aplicação é desenvolver uma api Rest, de busca de paises / estados brasileiros / cidades brasileiras

------

## Tecnologias & bibliotecas utilizadas 💻

- Spring-boot
- Java
- Docker
- Postgresql
- Gradle
- Lombok
- Swagger

## Como baixar e executar o projeto 💡

### BACK-END
```bash

# Primeiramente clone o repositorio
$ git clone https://github.com/Joaquimlagos/cities-api-dio.git

# Agora, verifique se você tem o gradle instalado em uma versão superior a 4.6
$ gradle -v

# Antes de rodar o projeto configure o banco de dados

# Agora digite o seguinte comando para aplicação rodar
$ gradle bootRun 
```
------
### Banco De Dados

```bash

# A parte do banco de dados foi desenvolvida no Docker, verifique se você tem instalado essa ferramenta:

$ docker -v

# Após você ter o docker no seu computador crie a imagem postgresql

$ docker run --name cities-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user_city -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=cities postgres

# Agora você precisa clonar o repositorio que vamos usar como base de dados 

$ git clone https://github.com/chinnonsantos/sql-paises-estados-cidades.git

# Após clonar o repositio na sua maquina caminhe entre as pasta e vá até a pasta PostgreSQL:

$ cd ~/workspace/sql-paises-estados-cidades/PostgreSQL

# Dentro da pasta PostgeSQL insira este comando:

$ docker run -it --rm --net=host -v $PWD:/tmp postgres /bin/bash

# Agora rode estes 3 comandos:
$ psql -h localhost -U postgres_user_city cities -f /tmp/pais.sql
$ psql -h localhost -U postgres_user_city cities -f /tmp/estado.sql
$ psql -h localhost -U postgres_user_city cities -f /tmp/cidade.sql

# Agora entre dentro do banco de dados:

$ psql -h localhost -U postgres_user_city cities

# E rode os seguintes comandos:

$ CREATE EXTENSION cube; 
$ CREATE EXTENSION earthdistance;

# Se tudo deu certo, seu banco de dados já está pronto !!!
```

### Testar a aplicação

```bash
# Após o programa estar rodando, ele já estara disponível no seguinte endereço:
$ localhost:8080

# Para você ver e testar todas as rotas e mais informações da api insira essa url no console:
$ http://localhost:8080/swagger-ui.html

# E para rodar os testes unitarios da aplicação isira o comando:

$ gradle test

```
