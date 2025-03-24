# Projeto: Sistema de Empréstimos de Livros

Este projeto é um sistema de gerenciamento de empréstimos de livros, desenvolvido com Spring Boot e Java, com funcionalidades para controle de usuários, livros e empréstimos.

## Estrutura do Projeto

- **controllers/**: Contém os controladores responsáveis por gerenciar as requisições HTTP.
  - EmprestimoController.java
  - LivroController.java
  - UsuarioController.java
- **Dto/**: Contém classes de transferência de dados.
- **entidades/**: Contém as classes que representam as entidades do sistema.
- **repositories/**: Contém as interfaces para acesso ao banco de dados.
- **resources/**: Utilizado para configurações, como o arquivo `application.properties`.
- **DemoApplication.java**: Classe principal para execução da aplicação.
- **NotificacaoEmail.java**: Responsável por enviar notificações por e-mail relacionadas a empréstimos e devoluções.

## Tecnologias Utilizadas
- Java
- Spring Boot
- Maven

## Configuração do Projeto
1. Clone o repositório:
    ```bash
    git clone https://github.com/seu-usuario/seu-repositorio.git
    ```
2. Configure o arquivo `application.properties` dentro de `src/main/resources/`:
    ```properties
    spring.mail.host=smtp.example.com
    spring.mail.port=587
    spring.mail.username=seu_email
    spring.mail.password=sua_senha
    ```
3. Execute o projeto com o comando:
    ```bash
    ./mvnw spring-boot:run
    ```
Obs.: Pode-se usar a interface da IDE para compilar e executar o código.

## Endpoints Principais
- **/usuarios**: Gerenciamento de usuários
- **/livros**: Gerenciamento de livros
- **/emprestimos**: Controle de empréstimos e devoluções

## Autor
Desenvolvido por [Christian David Teotônio Santos e Gabriel de Sousa Filho].

