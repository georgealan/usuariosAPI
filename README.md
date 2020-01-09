# Teste de API REST com Spring Boot

Aplicação Spring Boot v1.5.21 Database H2 v1.4.199

## Instruções para executar o projeto 
Projeto desenvolvido na IDE IntellijIDEA, basta importar o projeto na sua IDE Intellij, e seguir 
com as importações do Maven.

### Banco de dados H2
O banco de dados está na memória, por isso não é necessário instalar um ambiente de BD para rodar o projeto.
Basta apenas acessar a url path da database:

```
http://localhost:8080/h2/
```
Com isso você vai acessar a interface do H2 Database:
<img src="/docs/h2paineldatabase.JPG" alt="Painel H2 Database"/>

Utilize o JDBC URL:
```
jdbc:h2:mem:testdb
```
User Name: 
```
sa
```
Deixe o Password em branco.
Ao acessar a base de dados você verá esta tela:
<img src="/docs/h2databaseadmin.JPG" alt="Painel H2 Database"/>

### Utilizando Postman ou Insomnia para teste de requisição
Para ver a API funcionando utilizamos o Postman ou o Insomnia, você vai criar as seguintes requisições:

#### Listagem de usuários GET/usuarios/
```
http://localhost:8080/b/5c1172dbf35b3d1274b78786/usuarios
```
#### Adição de usuários POST/usuarios/
```
http://localhost:8080/b/5c1172dbf35b3d1274b78786/usuarios
```
#### Edição de usuários PUT/usuarios/{id}
```
http://localhost:8080/b/5c117316f35b3d1274b7879a/usuarios/{id}
```
#### Exclusão de usuários DELETE/usuarios/{id}
```
http://localhost:8080/b/5c117316f35b3d1274b7879a/usuarios/{id}
```
#### Visualização de usuários GET/usuarios/{id}
```
http://localhost:8080/b/5c117316f35b3d1274b7879a/usuarios/{id}
```
## Testes de repositório e de integração
O projeto conta com testes de repositório e de integração.
