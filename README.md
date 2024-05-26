# Todo List

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.0-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-8.0-orange)
![PRs](https://img.shields.io/badge/PRs-welcome-brightgreen)

## Descrição

O projeto Todo List é uma aplicação simples para gerenciamento de tarefas (to-do). Foi construída com Java e utiliza o Spring Boot para facilitar o desenvolvimento web e a persistência de dados. A aplicação armazena as tarefas em um banco de dados MySQL e oferece uma API REST para criar, atualizar, listar e deletar tarefas.

### Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.3.0**
- **MySQL**
- **H2 Database (para testes)**
- **Spring Data JPA**
- **Spring Web**
- **Spring Validation**
- **Lombok**
- **SpringDoc OpenAPI (Swagger)**

## Instruções de Instalação

### Pré-requisitos

- Java 17
- Maven
- MySQL

### Passo a Passo

1. Clone o repositório:
    ```bash
    git clone https://github.com/seuusuario/todolist.git
    cd todolist
    ```

2. Configure o banco de dados MySQL:
    ```sql
    CREATE DATABASE todolist;
    CREATE USER 'root'@'localhost' IDENTIFIED BY 'root';
    GRANT ALL PRIVILEGES ON todolist.* TO 'root'@'localhost';
    FLUSH PRIVILEGES;
    ```

3. Configure o arquivo `application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/todolist
    spring.datasource.username=root
    spring.datasource.password=root
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.jpa.hibernate.ddl-auto=update
    ```

4. Compile e execute a aplicação:
    ```bash
    mvn spring-boot:run
    ```

## Como Utilizar

### API Endpoints

- **Criar Tarefa**
    ```http
    POST /todos
    Content-Type: application/json

    {
        "nome": "Estudar Java",
        "descricao": "Revisar conceitos de Streams",
        "realizada": false,
        "prioridade": 1
    }
    ```

- **Atualizar Tarefa**
    ```http
    PUT /todos
    Content-Type: application/json

    {
        "id": 1,
        "nome": "Estudar Spring Boot",
        "descricao": "Aprender sobre Spring Data JPA",
        "realizada": false,
        "prioridade": 2
    }
    ```

- **Listar Tarefas**
    ```http
    GET /todos
    ```

- **Deletar Tarefa**
    ```http
    DELETE /todos/{id}
    ```

### Exemplos de Requisições

#### Criar Tarefa
```bash
curl -X POST http://localhost:8080/todos -H "Content-Type: application/json" -d '{
    "nome": "Estudar Java",
    "descricao": "Revisar conceitos de Streams",
    "realizada": false,
    "prioridade": 1
}'
 ```

#### Listar Tarefas
```bash
curl -X GET http://localhost:8080/todos
 ```

### Atualizar Tarefa
```bash
curl -X PUT http://localhost:8080/todos -H "Content-Type: application/json" -d '{
    "id": 1,
    "nome": "Estudar Spring Boot",
    "descricao": "Aprender sobre Spring Data JPA",
    "realizada": false,
    "prioridade": 2
}'
```

### Deletar Tarefa
```bash
curl -X DELETE http://localhost:8080/todos/1
```

### Contribuição
```bash
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.

Fork o repositório.
Crie uma nova branch: git checkout -b minha-nova-funcionalidade
Faça suas modificações e commite: git commit -m 'Adiciona nova funcionalidade'
Envie para o repositório original: git push origin minha-nova-funcionalidade
Crie um pull request.
```

### Documentação
A aplicação possui uma documentação interativa dos endpoints utilizando Swagger. Para acessá-la, execute a aplicação e navegue até:
```bash
http://localhost:8080/swagger-ui.html
```


