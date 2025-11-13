# projetofinalLP3

#📘 1. Descrição Geral do Sistema

O Sistema Acadêmico foi desenvolvido com o objetivo de gerenciar informações de usuários, turmas, avaliações e notas em um ambiente acadêmico.
O sistema possui duas formas de execução, permitindo ao desenvolvedor trabalhar tanto sem banco de dados (modo mock, via terminal) quanto com banco de dados real (modo REST com Spring Boot).

Essa flexibilidade facilita o desenvolvimento e os testes iniciais, permitindo simular todas as operações antes de configurar a persistência real.

#⚙️ 2. Estrutura do Projeto
com.sistemaacademico/
│
├── controller/
│   └── real/
│       ├── AvaliacaoController.java
│       ├── UsuarioController.java
│       └── (demais controllers reais)
│
├── repository/
│   ├── AvaliacaoRepository.java
│   ├── UsuarioRepository.java
│   └── (demais repositories JPA)
│
├── mock/
│   ├── MockApp.java                      → Aplicação executável via terminal
│   ├── AvaliacaoMockRepository.java      → Simula o banco de dados em memória
│   ├── UsuarioMockRepository.java        → Simula dados de usuários
│   └── util/
│       └── ConsoleUtils.java             → Utilitário de leitura no console
│
├── model/
│   ├── Usuario.java
│   ├── Avaliacao.java
│   ├── Turma.java
│   ├── Nota.java
│   └── (demais entidades)
│
└── SistemaAcademicoApplication.java      → Classe principal do Spring Boot

#🧩 3. Funcionalidades Principais
#👤 Usuários

Cadastramento de usuários com nome, e-mail, senha e tipo (aluno, docente ou admin).

Login e logout simulados no console.

Listagem de todos os usuários cadastrados.

#📝 Avaliações

Cadastro de avaliações com nome e peso.

Listagem de todas as avaliações cadastradas.

Exclusão de avaliações específicas por ID.

#🔒 Controle de Acesso (modo mock)

Apenas usuários logados podem acessar o menu de avaliações.

O login é feito com e-mail e senha (sem criptografia no modo mock).

#🧮 4. Modo 1 – Execução Mock (Terminal)

O modo mock é executado totalmente em memória, sem necessidade de banco de dados ou servidor.
Ideal para testes rápidos, demonstrações e simulações de fluxo.

#▶️ Como executar no IntelliJ:

Abra o projeto no IntelliJ.

Vá até a classe:

com.sistemaacademico.mock.MockApp

Clique com o botão direito e escolha Run 'MockApp.main()'.

O menu aparecerá no console do IntelliJ, permitindo interação digitando opções numéricas.

#🌐 5. Modo 2 – Execução Real (Spring Boot + REST)

O modo real utiliza o Spring Boot, JPA e Hibernate para persistência em banco de dados.
Cada entidade possui um Repository e Controller REST completo.

▶️ Como executar:

Vá até a classe:

com.sistemaacademico.SistemaAcademicoApplication


Clique com o botão direito e selecione Run 'SistemaAcademicoApplication.main()'.

O servidor iniciará em:

http://localhost:8080

🧪 Como testar (exemplos de endpoints)

Use ferramentas como Postman, Insomnia ou curl:

Criar usuário:
POST http://localhost:8080/usuarios
{
  "nome": "Maria",
  "email": "maria@email.com",
  "senhaHash": "1234",
  "tipo": "docente"
}

Listar usuários:
GET http://localhost:8080/usuarios

Atualizar usuário:
PUT http://localhost:8080/usuarios/1
{
  "nome": "Maria Souza",
  "email": "maria@email.com",
  "senhaHash": "4321",
  "tipo": "admin"
}

Deletar usuário:
DELETE http://localhost:8080/usuarios/1

🔄 6. Alternando entre os modos

# Modo Mock (sem banco):

Executar MockApp.java

Todos os dados são armazenados apenas em memória.

Ideal para testar fluxo de menus e lógica sem dependências externas.

# Modo Real (com banco):

Executar SistemaAcademicoApplication.java

Usa os repositórios JpaRepository e os controllers REST.

Requer configuração de banco no application.properties (por exemplo, H2 ou MySQL).

Os dois modos são independentes e podem coexistir no mesmo projeto sem conflito.

🧠 7. Conclusão

O projeto foi estruturado para permitir tanto desenvolvimento rápido e testes locais (modo mock) quanto execução completa em ambiente web (modo REST).
Essa separação favorece:

Evolução gradual do sistema.

Manutenção facilitada, com camadas bem divididas entre model, repository e controller.
