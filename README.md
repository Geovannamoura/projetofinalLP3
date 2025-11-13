# 🏫 Sistema Acadêmico

O **Sistema Acadêmico** é um projeto desenvolvido em **Java com Spring Boot**, que permite o gerenciamento de **usuários, turmas e avaliações**.  
Ele pode ser executado de **duas formas**:  
- **Modo Mock (Terminal)** — simulado, sem necessidade de banco de dados  
- **Modo Real (REST)** — com conexão a um banco de dados relacional  

---

## 🚀 Funcionalidades

- Cadastro e login de usuários (aluno, docente e admin)  
- Criação e listagem de turmas e avaliações  
- Login/logout de usuários  
- Execução em modo terminal (para testes rápidos)  
- Execução via API REST (com banco configurado)

---

## ⚙️ Como Executar

### 🖥️ Modo Terminal (Mock)

Este modo roda o sistema direto no console, **sem banco de dados**.

**Passos:**
1. Abra o projeto na IDE de sua preferência.  
2. Localize o arquivo `MockApp.java`.  
3. Execute a classe (`Run MockApp.main()`).  
4. O menu aparecerá no terminal, permitindo:  
   - Cadastrar usuários  
   - Fazer login e logout  
   - Gerenciar e listar avaliações  

---

### 🌐 Modo Real (com Banco de Dados)

Este modo roda a aplicação com **Spring Boot e banco de dados**.

**Passos:**
1. Configure o `application.properties` com as credenciais do seu banco (pode usar H2, MySQL, etc.).  
2. Execute a classe principal `SistemaAcademicoApplication.java`.  
3. A aplicação iniciará em:  http://localhost:8080
4. Você poderá acessar os endpoints REST da aplicação, como:
- `/alunos`
- `/docentes`
- `/avaliacoes`

---

## 🧠 Tecnologias Utilizadas

- Java 17+  
- Spring Boot  
- Spring Data JPA  
- H2 / MySQL  
- Lombok  
- REST API  

---

## ✨ Observações

- O **modo mock** é independente do banco e ideal para testes locais.  
- O **modo real** requer configuração de banco de dados.  
- Ambos os modos podem coexistir no mesmo projeto sem conflitos.  

---
